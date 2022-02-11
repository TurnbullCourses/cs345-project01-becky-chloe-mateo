package edu.ithaca.dturnbull.bank;

public class AbstractAccount {

    private String email;
    private double balance;
    
    public void withdraw(String email, double amount) throws InsufficientFundsException{
        if(amount < balance){
            throw new InsufficientFundsException("Not enough money");
            }
        balance -= amount;
    }
}
