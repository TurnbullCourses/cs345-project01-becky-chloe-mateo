package edu.ithaca.dturnbull.bank;
import java.util.ArrayList;
import java.util.HashMap;

public class AbstractBank {
    static ArrayList<AbstractAccount> accounts = new ArrayList<AbstractAccount>();
    static ArrayList<AbstractBankTeller> bankTellers = new ArrayList<AbstractBankTeller>();
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    static HashMap<String,String> logins = new HashMap<String,String>();

    public static boolean loginCheck(String email, String password){
        if(logins.get(password) == email){
            return true;
        }else{
            return false;
        }
    }
}
