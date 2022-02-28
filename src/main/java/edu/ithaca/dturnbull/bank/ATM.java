package edu.ithaca.dturnbull.bank;

public class ATM extends AbstractBankTeller {

    public ATM(Customer customer){     
    }
    
    public double getBalance(AbstractAccount account){
        return account.getBalance(); 
    }

    public void deposit(double amount, AbstractAccount account) throws InsufficientFundsException {
        account.deposit(amount);
    }
    public void withdraw(double amount, AbstractAccount account) throws InsufficientFundsException {
        account.withdraw(amount);
    }
    public static void transfer(AbstractAccount sender, AbstractAccount receiver, double amount) throws InsufficientFundsException {
        AbstractAccount.transfer(sender,receiver,amount);
    }

    public String getHistory(AbstractAccount account){
        return account.getHistory();
    }

    public boolean checkPassword(Customer customer, String password){
        return customer.checkPassword(password);
    }
}
