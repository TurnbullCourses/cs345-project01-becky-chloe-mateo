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
    @Test
    void systemTest2() throws InsufficientFundsException{ //written by Becky
        Customer pam = new Customer("pambeesly.com", "abcd");
        Admin adminAccount = new Admin("admin", "abcd");
        BankTeller bankTeller = new BankTeller("bankTeller", "abcd");
        assertEquals(pam.getAccounts(), null);

        CheckingAccount pamsCheck = new CheckingAccount(pam, 100);
        assertEquals(pamsCheck.getHistory(), "");
        assertTrue(pam.checkPassword("abcd"));
        
        SavingsAccount pamsSaving = new SavingsAccount(pam, 500, 1000);
        assertEquals(pamsSaving.getHistory(), "");

        pamsSaving.transfer(pamsSaving, pamsCheck, 100);
        assertEquals(400, pamsSaving.getBalance());
        assertFalse(pamsSaving.getSuspiciousActivity());
    }
}