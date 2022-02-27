package edu.ithaca.dturnbull.bank;

public abstract class AbstractAccount {

    double balance;
    static String transactionHistory;
    static boolean suspiciousActivity=false;


    public AbstractAccount(double balance){
        this.balance = balance;

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

    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount>this.balance){
            suspiciousActivity=true;
            throw new InsufficientFundsException("not enough funds");
            
        }
        if(amount==balance){
            suspiciousActivity=true;
        }
        this.balance -= amount;
        transactionHistory+="Withdraw: " + amount + ", "; //Add to transaction history
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) throws InsufficientFundsException {
        if(isAmountValid(amount)){
            this.balance += amount;
            transactionHistory+="Deposit: " + amount + ", "; //Add to transaction history
        }
        else{
            suspiciousActivity=true;
            throw new IllegalArgumentException("Invalid Deposit Amount");
            
        }
    }

    public static void transfer(AbstractAccount sender, AbstractAccount receiver, double amount) throws InsufficientFundsException {
        //check if accounts are the same
        if(sender == receiver){
            suspiciousActivity=true;
            throw new IllegalArgumentException("Account cannot transfer to itself!");
        }

        if(isAmountValid(amount)){
            sender.withdraw(amount);
            receiver.deposit(amount);
            transactionHistory+="Transfer: " + amount + "from" + sender + "to" + receiver + ", "; //Add to transaction history
        }
        else{
            suspiciousActivity=true;
            throw new IllegalArgumentException("Invalid Transfer Amount");
        }
    }

    public String getHistory() {
        return transactionHistory;
    }

    public boolean getSuspiciousActivity(){
        return suspiciousActivity;
    }

}
