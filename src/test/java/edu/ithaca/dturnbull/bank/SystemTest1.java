package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SystemTest1 {
    @Test
    void systemTest() throws InsufficientFundsException{
        Customer jim = new Customer("jim123.com","1234");
        Admin adminAccount=new Admin("admin","1234");
        BankTeller bankTeller=new BankTeller("bankTeller","1234");
        assertEquals(jim.getAccounts(),null);
        CheckingAccount jimsAccount=new CheckingAccount(jim, 600); 
        bankTeller.createAccount(jim, "Savings","1234",0,1200);
        
        assertTrue(jim.checkPassword("1234"));
        jimsAccount.deposit(250);
        jimsAccount.withdraw(500);
        assertFalse(jimsAccount.getSuspiciousActivity());

        Customer jam = new Customer("jam123.com","1234");
        SavingsAccount jamsAccount = new SavingsAccount(jam,0,1200);
        assertThrows(InsufficientFundsException.class,() -> CheckingAccount.transfer(jimsAccount, jamsAccount, 500));
        assertTrue(jimsAccount.getSuspiciousActivity());

        assertEquals(adminAccount.requestReport(jimsAccount),"nullDeposit: 250.0, Withdraw: 500.0, ");

    }
}