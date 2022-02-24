package edu.ithaca.dturnbull.bank;

abstract class AbstractBankTeller {
         
    public static AbstractAccount createAccount(String typeOfAccount, String password, double balance, double dailyMax) {
        if (typeOfAccount == "Savings") {
            AbstractAccount savingsAccount = new SavingsAccount(password, balance, dailyMax);
            return savingsAccount;
        }
       else {
                AbstractAccount checkingAccount = new CheckingAccount(password, balance);
                return checkingAccount;
            }
        }
    }
