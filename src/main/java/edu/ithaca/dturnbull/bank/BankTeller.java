package edu.ithaca.dturnbull.bank;

public class BankTeller extends AbstractBank {
    public static AbstractAccount createAccount(String typeOfAccount, String password, double balance, double dailyMax) {
        if (typeOfAccount == "Savings") {
            SavingsAccount savingsAccount = new SavingsAccount(password, balance, dailyMax);
            return savingsAccount;
        } else {
            CheckingAccount checkingAccount = new CheckingAccount(password, balance);
            return checkingAccount;
        }
    }
}
