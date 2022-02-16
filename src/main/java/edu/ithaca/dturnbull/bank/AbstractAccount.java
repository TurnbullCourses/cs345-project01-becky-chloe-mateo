package edu.ithaca.dturnbull.bank;

abstract class AbstractAccount {
    String password;
    double balance;
    String transactionHistory;
    public AbstractAccount(String password, double balance) {
        this.password = password;
        this.balance = balance;
    }

    public static boolean isAmountValid(double amount) {
        // negative amounts
        if (amount < 0) {
            return false;
        }
        // more than two decimals
        int digits;
        double testAmount = amount;

        // move left 2 decimals
        testAmount *= 100;

        // cut off the rest of the digits
        digits = (int) testAmount;
        testAmount = digits;
        testAmount /= 100;

        if (testAmount != amount) {
            return false;
        }

        return true;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount>balance){
            throw new InsufficientFundsException("not enough funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InsufficientFundsException {
        
    }

    public void transfer(AbstractAccount sender, AbstractAccount receiver, double amount) throws InsufficientFundsException {

    }

    public String getHistory() {
        return null;
    }

    public Boolean checkPassword(String accountNumber) {
        return null;

    }

}
