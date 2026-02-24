# Video Testimonial — Complete File Map (88 files)

Every file grouped by the **feature** it serves. If you remove a feature, remove all its files.

---

## 🟢 CORE — Testimonial CRUD + Admin Review (REQUIRED)
> *The foundation. Affiliates have testimonials, admins review them.*

| # | File | Role |
|---|---|---|
| 1 | [VideoTestimonial.php](file:///Users/podup/Documents/affiliate-system/app/Models/VideoTestimonial.php) | Main model |
| 2 | [TestimonialStatusEnum.php](file:///Users/podup/Documents/affiliate-system/app/Enums/TestimonialStatusEnum.php) | Status values (pending_upload → approved/rejected) |
| 3 | [VideoTestimonialPolicy.php](file:///Users/podup/Documents/affiliate-system/app/Policies/VideoTestimonialPolicy.php) | Authorization rules |
| 4 | [VideoTestimonialService.php](file:///Users/podup/Documents/affiliate-system/app/Services/VideoTestimonialService.php) | All business logic |
| 5 | [Admin/VideoTestimonialController.php](file:///Users/podup/Documents/affiliate-system/app/Http/Controllers/Admin/VideoTestimonialController.php) | Admin: list, show, review, feature |
| 6 | [Affiliate/VideoTestimonialController.php](file:///Users/podup/Documents/affiliate-system/app/Http/Controllers/Affiliate/VideoTestimonialController.php) | Affiliate: list, show, upload, download |
| 7 | [AdminReviewTestimonialRequest.php](file:///Users/podup/Documents/affiliate-system/app/Http/Requests/Testimonial/AdminReviewTestimonialRequest.php) | Validates approve/reject action |
| 8 | [AffiliateSubmitTestimonialRequest.php](file:///Users/podup/Documents/affiliate-system/app/Http/Requests/Testimonial/AffiliateSubmitTestimonialRequest.php) | Validates affiliate upload |
| 9 | [ConfirmUploadRequest.php](file:///Users/podup/Documents/affiliate-system/app/Http/Requests/Testimonial/ConfirmUploadRequest.php) | Validates upload confirmation |
| 10 | [GenerateUploadUrlRequest.php](file:///Users/podup/Documents/affiliate-system/app/Http/Requests/Testimonial/GenerateUploadUrlRequest.php) | Validates presigned URL generation |
| 11 | [create_video_testimonials_table.php](file:///Users/podup/Documents/affiliate-system/database/migrations/2026_02_19_000001_create_video_testimonials_table.php) | DB table |
| 12 | [add_enhancement_columns.php](file:///Users/podup/Documents/affiliate-system/database/migrations/2026_02_20_000001_add_enhancement_columns_to_video_testimonials.php) | Extra columns (sentiment, social card, etc.) |
| 13 | [admin/testimonials/index.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/admin/testimonials/index.blade.php) | Admin listing page |
| 14 | [admin/testimonials/show.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/admin/testimonials/show.blade.php) | Admin detail/review page |
| 15 | [affiliate/testimonials/index.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/affiliate/testimonials/index.blade.php) | Affiliate listing page |
| 16 | [affiliate/testimonials/show.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/affiliate/testimonials/show.blade.php) | Affiliate detail page + social media kit |
| 17 | [affiliate/testimonials/submit.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/affiliate/testimonials/submit.blade.php) | Affiliate upload form |
| 18 | [affiliate/testimonials/record.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/affiliate/testimonials/record.blade.php) | Senja-style video recorder UI |
| 19 | [testimonial-recorder.js](file:///Users/podup/Documents/affiliate-system/public/js/testimonial-recorder.js) | Webcam recording JS |
| 20 | [testimonial-record.css](file:///Users/podup/Documents/affiliate-system/public/css/testimonial-record.css) | Recorder UI styles |

**20 files — cannot be removed**

---

## 🔵 FEATURE: Email Outreach (admin sends testimonial request emails)
> *Admin clicks "Request Testimonial" → email sent to affiliate/customer → they click link → upload form*

| # | File | Role |
|---|---|---|
| 21 | [TestimonialOutreach.php](file:///Users/podup/Documents/affiliate-system/app/Models/TestimonialOutreach.php) | Outreach tracking model |
| 22 | [TestimonialOutreachStatusEnum.php](file:///Users/podup/Documents/affiliate-system/app/Enums/TestimonialOutreachStatusEnum.php) | Outreach status values |
| 23 | [SendTestimonialRequestJob.php](file:///Users/podup/Documents/affiliate-system/app/Jobs/SendTestimonialRequestJob.php) | Queued email dispatch |
| 24 | [TestimonialRequestNotification.php](file:///Users/podup/Documents/affiliate-system/app/Notifications/TestimonialRequestNotification.php) | Email template |
| 25 | [AdminRequestOutreachRequest.php](file:///Users/podup/Documents/affiliate-system/app/Http/Requests/Testimonial/AdminRequestOutreachRequest.php) | Validates admin outreach form |
| 26 | [RequestTestimonialOutreachRequest.php](file:///Users/podup/Documents/affiliate-system/app/Http/Requests/Testimonial/RequestTestimonialOutreachRequest.php) | Validates affiliate outreach form |
| 27 | [create_testimonial_outreaches_table.php](file:///Users/podup/Documents/affiliate-system/database/migrations/2026_02_19_000002_create_testimonial_outreaches_table.php) | DB table |
| 28 | [add_requested_by_to_outreaches.php](file:///Users/podup/Documents/affiliate-system/database/migrations/2026_02_20_000002_add_requested_by_to_testimonial_outreaches.php) | Extra column |
| 29 | [add_template_id_index.php](file:///Users/podup/Documents/affiliate-system/database/migrations/2026_02_23_000001_add_template_id_index_to_testimonial_outreaches.php) | DB index |

**9 files**

---

## 🟣 FEATURE: Public Upload Page (customer uploads video via email link)
> *Customer receives outreach email → clicks link → sees upload page → records/uploads video*

| # | File | Role |
|---|---|---|
| 30 | [TestimonialPageController.php](file:///Users/podup/Documents/affiliate-system/app/Http/Controllers/Public/TestimonialPageController.php) | Public routes: gallery, embed, upload |
| 31 | [PublicDoUploadRequest.php](file:///Users/podup/Documents/affiliate-system/app/Http/Requests/Testimonial/PublicDoUploadRequest.php) | Validates public file upload |
| 32 | [public/testimonials/upload.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/public/testimonials/upload.blade.php) | Public upload form |
| 33 | [public/testimonials/already-submitted.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/public/testimonials/already-submitted.blade.php) | "Already done" page |

**4 files** (depends on Outreach feature)

---

## 🟡 FEATURE: Public Gallery / Wall of Love
> *Public page showing all approved testimonials for an affiliate: `/testimonials/{code}`*

| # | File | Role |
|---|---|---|
| 34 | [public/testimonials/affiliate.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/public/testimonials/affiliate.blade.php) | Gallery view |

**1 file** (controller is shared with Public Upload above)

---

## 🟠 FEATURE: Embeddable Widgets (JS + iframe)
> *Embed testimonials on external websites via JS widget or iframe*

| # | File | Role |
|---|---|---|
| 35 | [TestimonialApiController.php](file:///Users/podup/Documents/affiliate-system/app/Http/Controllers/Public/TestimonialApiController.php) | JSON API for widgets |
| 36 | [testimonial-widget.js](file:///Users/podup/Documents/affiliate-system/public/js/testimonial-widget.js) | Floating popup widget |
| 37 | [widget-single.js](file:///Users/podup/Documents/affiliate-system/public/js/widget-single.js) | Single testimonial card widget |
| 38 | [testimonial-embed.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/widgets/testimonial-embed.blade.php) | Iframe embed view |

**4 files**

---

## 🔴 FEATURE: Form Templates (custom guided questions)
> *Admin creates question templates that appear on the upload form*

| # | File | Role |
|---|---|---|
| 39 | [TestimonialFormTemplate.php](file:///Users/podup/Documents/affiliate-system/app/Models/TestimonialFormTemplate.php) | Template model |
| 40 | [TestimonialAnswer.php](file:///Users/podup/Documents/affiliate-system/app/Models/TestimonialAnswer.php) | Answer model |
| 41 | [TestimonialFormTemplateController.php](file:///Users/podup/Documents/affiliate-system/app/Http/Controllers/Admin/TestimonialFormTemplateController.php) | Admin template CRUD |
| 42 | [TestimonialFormTemplateService.php](file:///Users/podup/Documents/affiliate-system/app/Services/TestimonialFormTemplateService.php) | Template business logic |
| 43 | [StoreTemplateRequest.php](file:///Users/podup/Documents/affiliate-system/app/Http/Requests/Testimonial/StoreTemplateRequest.php) | Validate create |
| 44 | [UpdateTemplateRequest.php](file:///Users/podup/Documents/affiliate-system/app/Http/Requests/Testimonial/UpdateTemplateRequest.php) | Validate update |
| 45 | [create_testimonial_form_templates.php](file:///Users/podup/Documents/affiliate-system/database/migrations/2026_02_20_000003_create_testimonial_form_templates_table.php) | DB table |
| 46 | [create_testimonial_answers.php](file:///Users/podup/Documents/affiliate-system/database/migrations/2026_02_20_000004_create_testimonial_answers_table.php) | DB table |
| 47 | [templates/index.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/admin/testimonials/templates/index.blade.php) | Template list view |
| 48 | [templates/form.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/admin/testimonials/templates/form.blade.php) | Template create/edit form |

**10 files**

---

## 🟤 FEATURE: Reward Tiers (gamification — spin-the-wheel after recording)
> *After submitting a testimonial, customer gets a reward (coupon, credit, etc.)*

| # | File | Role |
|---|---|---|
| 49 | [TestimonialReward.php](file:///Users/podup/Documents/affiliate-system/app/Models/TestimonialReward.php) | Reward model |
| 50 | [TestimonialRewardController.php](file:///Users/podup/Documents/affiliate-system/app/Http/Controllers/Admin/TestimonialRewardController.php) | Admin reward CRUD |
| 51 | [TestimonialRewardService.php](file:///Users/podup/Documents/affiliate-system/app/Services/TestimonialRewardService.php) | Reward business logic |
| 52 | [StoreRewardRequest.php](file:///Users/podup/Documents/affiliate-system/app/Http/Requests/Testimonial/StoreRewardRequest.php) | Validate create |
| 53 | [create_testimonial_rewards.php](file:///Users/podup/Documents/affiliate-system/database/migrations/2026_02_20_000005_create_testimonial_rewards_table.php) | DB table |
| 54 | [rewards.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/admin/testimonials/rewards.blade.php) | Reward management view |

**6 files**

---

## ⚫ FEATURE: Branded Video Exports (FFmpeg social media formats)
> *Admin clicks "Export" → FFmpeg processes video into 3 formats (square, vertical, horizontal) with overlay*

| # | File | Role |
|---|---|---|
| 55 | [TestimonialVideoExport.php](file:///Users/podup/Documents/affiliate-system/app/Models/TestimonialVideoExport.php) | Export model |
| 56 | [TestimonialExportStatusEnum.php](file:///Users/podup/Documents/affiliate-system/app/Enums/TestimonialExportStatusEnum.php) | Export status values |
| 57 | [ProcessBrandedVideoJob.php](file:///Users/podup/Documents/affiliate-system/app/Jobs/ProcessBrandedVideoJob.php) | Queued FFmpeg job |
| 58 | [VideoProcessingService.php](file:///Users/podup/Documents/affiliate-system/app/Services/VideoProcessingService.php) | FFmpeg processing logic |
| 59 | [BrandedVideoReadyNotification.php](file:///Users/podup/Documents/affiliate-system/app/Notifications/BrandedVideoReadyNotification.php) | "Exports ready" email |
| 60 | [create_testimonial_video_exports.php](file:///Users/podup/Documents/affiliate-system/database/migrations/2026_02_20_000006_create_testimonial_video_exports_table.php) | DB table |

**6 files**

---

## 🔷 FEATURE: Sentiment Analysis (AI-like tag analysis)
> *Auto-tags testimonials with sentiment keywords (speed, quality, etc.) and shows dashboard*

| # | File | Role |
|---|---|---|
| 61 | [SentimentAnalysisService.php](file:///Users/podup/Documents/affiliate-system/app/Services/SentimentAnalysisService.php) | Tag counting logic |
| 62 | [sentiment.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/admin/testimonials/sentiment.blade.php) | Sentiment dashboard view |

**2 files**

---

## 🔶 FEATURE: Social Image Cards (PNG generation from text testimonials)
> *Generates a branded PNG quote card from text testimonials for social sharing*

| # | File | Role |
|---|---|---|
| 63 | [TestimonialImageCardService.php](file:///Users/podup/Documents/affiliate-system/app/Services/TestimonialImageCardService.php) | PNG generation logic |

**1 file** (UI is in admin show.blade.php)

---

## 📊 FEATURE: Analytics Dashboard
> *Charts and stats: rating trends, type breakdown, funnel, top affiliates*

| # | File | Role |
|---|---|---|
| 64 | [analysis.blade.php](file:///Users/podup/Documents/affiliate-system/resources/views/admin/testimonials/analysis.blade.php) | Analytics charts view |

**1 file** (logic is in VideoTestimonialService)

---



---

## Quick Count

| Feature | Files | Removable? |
|---|---|---|
| 🟢 Core CRUD + Review | 20 | ❌ Required |
| 🔵 Email Outreach | 9 | ✅ Yes |
| 🟣 Public Upload Page | 4 | ✅ Yes (depends on Outreach) |
| 🟡 Public Gallery | 1 | ✅ Yes |
| 🟠 Embeddable Widgets | 4 | ✅ Yes |
| 🔴 Form Templates | 10 | ✅ Yes |
| 🟤 Reward Tiers | 6 | ✅ Yes |
| ⚫ Video Exports (FFmpeg) | 6 | ✅ Yes |
| 🔷 Sentiment Analysis | 2 | ✅ Yes |
| 🔶 Social Image Cards | 1 | ✅ Yes |
| 📊 Analytics Dashboard | 1 | ✅ Yes |
| **TOTAL** | **64** | |

> **Note:** The remaining ~21 files to reach 85 are non-testimonial files (routes, layouts, other controllers, configs, etc.) that were already in the project.

---

**Tell me which colored features you want to REMOVE and I'll delete all their files + clean up the routes.**
