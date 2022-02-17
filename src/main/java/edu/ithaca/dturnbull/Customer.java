package edu.ithaca.dturnbull;

public class Customer {
    String password;
    String listofaccounts;
    public Customer(String password) {
        this.password = password;
    }

    //Check Password
    public boolean checkPassword(String passInput){
        if(password == passInput){
            return true;
        }
        return false;
    }
    
}
