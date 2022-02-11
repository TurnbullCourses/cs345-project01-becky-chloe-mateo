package edu.ithaca.dturnbull.bank;

    abstract class Account {
        String password;
        double balance;
        
        public Account(String password, double balance){
            this.password=password;
            this.balance=balance;
        }

        public static boolean isAmountValid(double amount){
            //negative amounts
            if(amount < 0){
                return false;
            }
            //more than two decimals
            int digits;
            double testAmount = amount;
    
            //move left 2 decimals
            testAmount *= 100;
    
            //cut off the rest of the digits
            digits = (int) testAmount;
            testAmount = digits;
            testAmount /= 100;
    
            if(testAmount != amount){
                return false;
            }

            return true;
        }
    
        public void withdraw (double amount)throws InsufficientFundsException{
            if(isAmountValid(amount)){
                if (amount <= balance){
                    balance -= amount;
                }
                else {
                    throw new InsufficientFundsException("Not enough money");
                }
            }
            else{
                throw new IllegalArgumentException("Invalid Withdraw Amount");
            }        
            
        }
        public double checkBalance(){
            return balance;
        }

        public void deposit(double amount)throws InsufficientFundsException{
            if(isAmountValid(amount)){
                balance += amount;
            }
            else{
                throw new IllegalArgumentException("Invalid Deposit Amount");
            }
        }

        public void transfer(Account sender, Account receiver, double amount)throws InsufficientFundsException{
            //check if accounts are the same
        if(sender == receiver){
            throw new IllegalArgumentException("Account cannot transfer to itself!");
        }

        if(isAmountValid(amount)){
            sender.withdraw(amount);
            receiver.deposit(amount);
        }
        else{
            throw new IllegalArgumentException("Invalid Transfer Amount");
        }
    }

        public String getHistory(){
            return getHistory();
        }
        public Boolean checkPassword(String password){
            return null;
         }
    
    public void withdraw(String email, double amount) throws InsufficientFundsException{
        if(amount < balance){
            throw new InsufficientFundsException("Not enough money");
            }
        balance -= amount;
    }
}
