package statics;

public class Bank {

    // Shared data
    static int totalAccounts = 0;

    // Object data
    int balance = 0;

    // Constructor
    Bank() {
        totalAccounts++;
    }

    // Static method
    static int getTotalAccounts() {
        return totalAccounts;
    }

    // Non-static method
    void deposit(int amount) {
        balance += amount;
    }

    // Static nested utility class
    static class LoanCalculator {
        static double calculateInterest(double amount) {
            return amount * 0.09;  // example 9% interest
        }
    }


    public static void main(String[] args){
        Bank b1 = new Bank();
        Bank b2 = new Bank();

        b1.deposit(1000);
        b2.deposit(2000);

        System.out.println(Bank.getTotalAccounts());
        System.out.println(Bank.LoanCalculator.calculateInterest(6000));
    }
}
