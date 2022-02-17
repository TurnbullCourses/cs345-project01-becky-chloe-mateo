package edu.ithaca.dturnbull;

public class Customer {
    String password;
    double balance;
    public Customer(String password, double balance) {
        this.password = password;
        this.balance = balance;
    }
    public boolean checkPassword(String passInput){
        if(password == passInput){
            return true;
        }
        return false;
    }
    
}
