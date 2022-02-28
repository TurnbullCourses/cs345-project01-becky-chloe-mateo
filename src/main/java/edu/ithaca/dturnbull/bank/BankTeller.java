package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

public class BankTeller extends AbstractBankTeller {

    static ArrayList<AbstractAccount> accounts;
    private String accountName;
    private String password;

    public BankTeller(String accountName, String password){
        this.accountName=accountName;
        this.password=password;
    }
    
    public static AbstractAccount createAccount(Customer customer, String typeOfAccount, String password,
            double balance, double dailyMax) {
        if (typeOfAccount == "Savings") {
            AbstractAccount savingsAccount = new SavingsAccount(customer, balance, dailyMax);
            return savingsAccount;
        } 
        if(typeOfAccount=="Checking") {
            AbstractAccount checkingAccount = new CheckingAccount(customer, balance);
            return checkingAccount;
        }
        
        else{
            return null;
        }

    }
    public void closeAccount(){

    }

    public double getBalance(AbstractAccount account) {
        return account.getBalance();
    }

    public void deposit(double amount, AbstractAccount account) throws InsufficientFundsException {
        account.deposit(amount);
    }

    public void withdraw(double amount, AbstractAccount account) throws InsufficientFundsException {
        account.withdraw(amount);
    }

    public static void transfer(AbstractAccount sender, AbstractAccount receiver, double amount) throws InsufficientFundsException {
        AbstractAccount.transfer(sender, receiver, amount);
    }

    public String getHistory(AbstractAccount account) {
        return account.getHistory();
    }

    public boolean checkPassword(Customer customer, String password) {
        return customer.checkPassword(password);
    }
}
