📘 System Flow Documentation
🏗️ User Registration & Tenant Provisioning Flow
🏗️ Phase 1 — User Registration (happens in show-login)

Admin creates a user in show-login (UserController@store)

⬇️

show-login generates:

tenantId (e.g. 2349)

subDomainName (e.g. "vishalawanafeb")

domainName (e.g. "myplatforms.com")

email, password (plain text, for seeding)

⬇️

JobsService::runRegistationJobs($data) is called

📦 Phase 2 — Queue Jobs Fire (in show-login)

show-login dispatches a chained job to the affiliateQueue:

Bus::chain([
    new CreateTenantJob($data),   // Job 1
    new RegisterUserJob($data),   // Job 2 (runs AFTER Job 1 finishes)
])->onQueue("affiliateQueue")->dispatch();

// Also dispatches separately:
GenerateOauthClientJob::dispatch($data, 'affiliate');  // Job 3


These 3 jobs run inside the affiliate-system's queue worker, not show-login.

⚙️ Phase 3 — Affiliate System Processes the Jobs
🧱 Job 1: CreateTenantJob

Creates a tenant record in the affiliate DB

Creates the domain entry: vishalawanafeb.myplatforms.com

Creates the tenant's dedicated database: podup_affiliate_2349

👤 Job 2: RegisterUserJob

Switches the DB connection to podup_affiliate_2349

Runs DatabaseSeeder → seeds roles & permissions

Creates the admin User record with the email + hashed password

Assigns the Admin role via Spatie

🔐 Job 3: GenerateOauthClientJob

Calls show-login's API (/api/v1/oauth-clients) via OauthClient model

Creates an OAuth client for the tenant's domain in show-login

This is what enables future token-based API calls back to show-login

🔑 Phase 4 — How Login Actually Works

When the admin user visits:

vishalawanafeb.myplatforms.com/login

Flow:

User enters email + password

⬇️

affiliate-system's web.php POST /login

⬇️

Auth::attempt(['email' => ..., 'password' => ...])


⬇️

Checks the TENANT'S DB (podup_affiliate_2349.users)

⬇️

If match → session created → redirect to /affiliate/dashboard

The password was set during Job 2 using the same plain-text password that was originally typed in show-login during registration.

🔗 How affiliate-system calls back to show-login (for data)

When affiliate needs user data from show-login, it uses the ShowLogin / ShowLoginUser model:

// Step 1: Get an OAuth token from show-login
ShowLogin::getToken()
  → POST show-login/oauth/token
  → uses SHOWLOGIN_API_CLIENT_ID + CLIENT_SECRET + USERNAME + PASSWORD from .env

// Step 2: Use the token to call show-login APIs
ShowLoginUser::findByEmail($email)
  → GET show-login/api/v1/users?email=...
  → Bearer token in Authorization header

🗺️ Big Picture Summary
show-login (Central Auth)
    │
    │ 1. User created in show-login
    │ 2. Jobs dispatched to affiliateQueue
    ▼
affiliate-system queue worker
    │
    ├── CreateTenantJob        → creates tenant + DB + domain
    ├── RegisterUserJob        → creates user in tenant DB + assigns Admin role
    └── GenerateOauthClientJob → registers OAuth client in show-login

When user logs in:
    vishalawanafeb.myplatforms.com/login
        → Auth against podup_affiliate_2349.users table
        → Same password as show-login (seeded at registration)

⚠️ Key Insight

The key insight: show-login is the source of truth for registrations. The affiliate system just gets a copy of the user (with the same password) in its own tenant database. There's no live SSO redirect — the credential sync happens at registration time via queued jobs.

🔐 OAuth Client Generation & Usage Flow
🔑 What is GenerateOauthClientJob doing?

This job runs in show-login after CreateTenantJob + RegisterUserJob complete. It creates 2 OAuth clients (Passport oauth_clients table rows) for every tenant, for every app (affiliate, shop, courses, etc.).

It calls OauthClientService::generateOauthClient($data, 'affiliate')

Which does this:

// Client 1 — slug-based redirect URL
$redirectUrl = "https://vishalawanafeb.myplatforms.com/affiliate/laravel-passport/callback";
$oauthClient = $passportClientRepo->create($userId, 'affiliate vishalawanafeb', $redirectUrl);

// Client 2 — subdomain-based redirect URL
$redirectUrl = "https://vishalawanafeb.affiliate.myplatforms.com/laravel-passport/callback";
$oauthClient = $passportClientRepo->create($userId, 'affiliate vishalawanafeb', $redirectUrl);


So 2 rows are inserted into show-login's oauth_clients table per tenant per app.

🗄️ Passport Tables Involved (all in show-login's DB)
Table	What gets stored
oauth_clients	The 2 clients created above — each has a client_id, client_secret, redirect URL, and user_id
oauth_access_tokens	Created when affiliate-system calls POST /oauth/token to get a token
oauth_auth_codes	Created during Authorization Code flow (not used here — see below)
🔄 How affiliate-system uses the OAuth token (for API calls TO show-login)

When affiliate-system needs to call show-login's API (e.g. find a user by email), it uses the Password Grant flow — NOT the authorization code flow:

// ShowLogin::getToken() does this:
POST show-login/oauth/token
Body: {
    grant_type: "password",
    client_id: SHOWLOGIN_API_CLIENT_ID,       // from affiliate .env
    client_secret: SHOWLOGIN_API_CLIENT_SECRET,
    username: SHOWLOGIN_API_USERNAME,          // a service account
    password: SHOWLOGIN_API_PASSWORD,
    scope: ""
}


→ Returns:

{ access_token: "...", token_type: "Bearer", expires_in: ... }


Then uses that token to call:

GET show-login/api/v1/users?email=vishalawana117+192@gmail.com
Authorization: Bearer <access_token>

🔄 When are the 2 Redirect URL clients actually used?

The 2 OAuth clients with redirect URLs are for the Authorization Code flow — this would be used if a tenant's affiliated app frontend wants to log the user in via show-login (like "Login with Show-Login"). The flow would be:

1. affiliate-system frontend redirects browser to:
show-login/oauth/authorize
  ?client_id=<the client_id>
  &redirect_uri=https://vishalawanafeb.myplatforms.com/affiliate/laravel-passport/callback
  &response_type=code
  &scope=

2. show-login's CustomOauthAuthorizationController handles this:

Validates the client_id + redirect_uri match what's in oauth_clients table

Auto-approves (no "Approve?" screen — it's hardcoded to skip it)

Redirects to:

https://vishalawanafeb.myplatforms.com/affiliate/laravel-passport/callback?code=<auth_code>

3. affiliate-system then exchanges the code for a token:
POST show-login/oauth/token
  { grant_type: "authorization_code", code: ..., client_id: ..., client_secret: ... }

4. Gets access_token → can call show-login APIs on behalf of the user
🗺️ Summary: Which flow is used WHERE
Flow	Where Used	Purpose
Password Grant	affiliate-system → show-login (server-to-server)	Get a token to call show-login's /api/v1/users API
Authorization Code	(future/optional) tenant frontend → show-login	User-facing SSO: "Login with show-login"
OAuth clients table	Created by GenerateOauthClientJob	Pre-registers the 2 redirect URLs per tenant
⚠️ Important Note

The redirect URLs are created upfront even if the Authorization Code flow isn't actively used yet — they're there so the system is ready for SSO-style login in the future without needing to create clients on-the-fly.

Final Outcome

This version is:

Structured for GitHub readability

Properly spaced and sectioned

Developer-friendly

Zero content loss

Easier to scan, debug, and onboard engineers