package edu.ithaca.dturnbull.bank;

abstract class AbstractBankTeller  {
         
    double balance;
    static String transactionHistory;
    String password;
    
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

    public double getBalance(){
        return balance; 
    }

    public void deposit(double amount) throws InsufficientFundsException {
        if(isAmountValid(amount)){
            balance += amount;
            transactionHistory+="Deposit: " + amount + ","; //Add to transaction history
        }
        else{
            throw new IllegalArgumentException("Invalid Deposit Amount");
        }
    }
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount>balance){
            throw new InsufficientFundsException("not enough funds");
        }
        balance -= amount;
        transactionHistory+="Withdraw: " + amount + ","; //Add to transaction history
    }
    public static void transfer(AbstractAccount sender, AbstractAccount receiver, double amount) throws InsufficientFundsException {
        //check if accounts are the same
        if(sender == receiver){
            throw new IllegalArgumentException("Account cannot transfer to itself!");
        }

        if(isAmountValid(amount)){
            sender.withdraw(amount);
            receiver.deposit(amount);
            transactionHistory+="Transfer: " + amount + "from" + sender + "to" + receiver + ","; //Add to transaction history
        }
        else{
            throw new IllegalArgumentException("Invalid Transfer Amount");
        }
    }

    public String checkHistory(){
        return transactionHistory;
    }

    public boolean checkPassword(String passInput){
        if(password == passInput){
            return true;
        }
        return false;
    }
    

}
