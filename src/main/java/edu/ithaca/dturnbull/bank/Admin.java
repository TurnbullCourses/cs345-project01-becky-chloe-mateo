package edu.ithaca.dturnbull.bank;
public class Admin extends AbstractBank {
    private String accountName;
    private String password;

    public Admin(String accountName, String password){
        this.accountName=accountName;
        this.password=password;
    }

    public String requestReport(AbstractAccount account){
        if(account.getSuspiciousActivity()==true){
            System.out.print("There has been suspicious activity on this account "); 
            return AbstractAccount.transactionHistory;
        }
        return null;
        
    }

    private double checkOverallAmount(){
        return 0;
    }
    private void freezeAccount(){
        
    }

    private void unfreezeAccount(){

    }
}
