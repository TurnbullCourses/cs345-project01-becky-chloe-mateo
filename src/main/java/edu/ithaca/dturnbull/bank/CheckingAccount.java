package edu.ithaca.dturnbull.bank;
public class CheckingAccount extends AbstractAccount{

    public CheckingAccount(Customer customer, double balance){
        super(balance);
        Customer.accounts.add(this);
        AbstractBank.accounts.add(this);
    }

    public CheckingAccount(double balance){
        super(balance);
    }

    
}