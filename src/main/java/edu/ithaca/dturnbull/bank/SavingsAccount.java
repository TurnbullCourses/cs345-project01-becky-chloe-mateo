package edu.ithaca.dturnbull.bank;

public class SavingsAccount extends AbstractAccount {

    double dailyMax;

    public SavingsAccount(Customer customer, double balance, double dailyMax) {
        super(balance);
        this.dailyMax=dailyMax;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if(amount>balance){
            throw new IllegalArgumentException("not enough funds");
        }
        else if(amount>dailyMax){
            throw new IllegalArgumentException("exceeds daily maximum");
        }
        
        balance -= amount;
        transactionHistory+="Withdraw: " + amount + ", "; //Add to transaction history
    }

    public double compoundInterest(double interest,int numOfCompund){
        double principal=balance;
        double compoundedInterest=((principal)*Math.pow((1+interest),numOfCompund)-principal);
        return compoundedInterest;
    }
    public static boolean isAmountValid(double amount) {
        // negative amounts
        if (amount < 0) {
            return false;
        }
        // more than two decimals
        int digits;
        double testAmount = amount;

        // move left 2 decimals
        testAmount *= 100;

        // cut off the rest of the digits
        digits = (int) testAmount;
        testAmount = digits;
        testAmount /= 100;

        if (testAmount != amount) {
            return false;
        }

        return true;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if(amount>0){
            balance += amount;
            transactionHistory+="Deposit: " + amount + ", "; //Add to transaction history
        }
        else throw new IllegalArgumentException("cannot deposit negative number");
    }

    public static void transfer(AbstractAccount sender, AbstractAccount receiver, double amount) throws InsufficientFundsException {
        //check if accounts are the same
        if(sender == receiver){
            throw new IllegalArgumentException("Account cannot transfer to itself!");
        }

        if(isAmountValid(amount)){
            sender.withdraw(amount);
            receiver.deposit(amount);
            transactionHistory+="Transfer: " + amount + "from" + sender + "to" + receiver + ", "; //Add to transaction history
        }
        else{
            throw new IllegalArgumentException("Invalid Transfer Amount");
        }
    }

    public String getHistory() {
        return transactionHistory;
    }


}

    
