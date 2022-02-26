package edu.ithaca.dturnbull.bank;

import java.util.HashMap;
import java.util.ArrayList;

public class Customer {
    String email;
    String password;
    static ArrayList<AbstractAccount> accounts;

    public Customer(String email,String password) {
        this.email = email;
        this.password = password;
        AbstractBank.logins.put(email, password);
        ArrayList<AbstractAccount> accounts = new ArrayList<AbstractAccount>();

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

}
