package edu.ithaca.dturnbull.bank;

public class SavingsAccount extends AbstractAccount {

    double maxWithdraw = 1000;
    
    void withdraw(String email, double amount) throws IllegalArgumentException{
        if(maxWithdraw >amount){
            throw new IllegalArgumentException("exceeds max withdraw");
        }
    }
}
