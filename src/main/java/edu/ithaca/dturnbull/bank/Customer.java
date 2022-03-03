package edu.ithaca.dturnbull.bank;

import java.util.HashMap;
import java.util.ArrayList;

public class Customer {
    String email;
    String password;
    private ArrayList<AbstractAccount> accounts;

    public Customer(String email,String password) {
        this.email = email;
        this.password = password;
        AbstractBank.logins.put(email, password);
        accounts = new ArrayList<>();

    }

    //Check Password
    public boolean checkPassword(String passInput){
        if(password == passInput){
            return true;
        }
        return false;
    }
    
    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public String getEmail(){
        return email;
    }

    public ArrayList<AbstractAccount> getAccounts(){
        return accounts;
    }

    public void addAccount(AbstractAccount account){
        accounts.add(account);
    }

}
