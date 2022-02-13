package edu.ithaca.dturnbull.bank;

public class SavingsAccount extends AbstractAccount {

    public SavingsAccount(String password, double balance) {
        super(password, balance);
        double dailyMax;
        double amount;
        String email;
        //TODO Auto-generated constructor stub
        
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if(amount>dailyMax){
            throw new IllegalArgumentException("exceeds daily maximum");
        }
        balance -= amount;
    }


}

    
