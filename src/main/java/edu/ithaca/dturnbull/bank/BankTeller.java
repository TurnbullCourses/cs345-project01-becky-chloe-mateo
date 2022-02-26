package edu.ithaca.dturnbull.bank;

public class BankTeller extends AbstractBankTeller {

    public static AbstractAccount createAccount(String typeOfAccount, String password, double balance, double dailyMax) {
        if (typeOfAccount == "Savings") {
            AbstractAccount savingsAccount = new SavingsAccount(balance, dailyMax);
            return savingsAccount;
        } else {
            AbstractAccount checkingAccount = new CheckingAccount(balance);
            return checkingAccount;
        }
    }

    
}
