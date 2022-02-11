package edu.ithaca.dturnbull.bank;

    abstract class Account {
        String password;
        int balance;
        
        public Account(String password, int balance){
            this.password=password;
            this.balance=balance;
        }
    
        public void withdraw (double amount){
            balance-=amount;
            
        }
        public float checkBalance(){
            return balance;
        }
        public void deposit(double amount){
            balance+=amount;
        }
        public void transfer(Account sender, Account receiver){
    
        }
        public String getHistory(){
            return getHistory();
        }
        public Boolean checkPassword(){
            return null;
            
        }
    
}
