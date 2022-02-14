package edu.ithaca.dturnbull.bank;

public class SavingsAccount extends AbstractAccount {

    double dailyMax;

    public SavingsAccount(String password, double balance, double dailyMax) {
        super(password, balance);
        this.dailyMax=dailyMax;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if(amount>dailyMax){
            throw new IllegalArgumentException("exceeds daily maximum");
        }
        balance -= amount;
    }

    public double compoundInterest(double interest,int numOfCompund){
        double principal=balance;
        double compoundedInterest=((principal)*Math.pow((1+interest),numOfCompund)-principal);
        return compoundedInterest;
    }


}

    
