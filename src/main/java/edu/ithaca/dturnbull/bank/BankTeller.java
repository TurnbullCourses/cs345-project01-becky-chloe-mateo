package edu.ithaca.dturnbull.bank;

public class BankTeller extends AbstractBankTeller {

    public static AbstractAccount createAccount(Customer customer,String typeOfAccount, String password, double balance, double dailyMax) {
        if (typeOfAccount == "Savings") {
            AbstractAccount savingsAccount = new SavingsAccount(customer, balance, dailyMax);
            return savingsAccount;
        } 
        else {
            AbstractAccount checkingAccount = new CheckingAccount(customer, balance);
            return checkingAccount;
        }
    }

    
}
