package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SystemTest1 {
    @Test
    void systemTest() throws InsufficientFundsException{
        Customer jim = new Customer("jim123.com","1234");
        Admin adminAccount=new Admin("admin","1234");
        BankTeller bankTeller=new BankTeller("bankTeller","1234");
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

        assertEquals(adminAccount.requestReport(jimsAccount),"Deposit: 250.0, Withdraw: 500.0, ");

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

    @Test //written by Chloe
    void systemTest3() throws InsufficientFundsException{
        Customer bts = new Customer("bts@mail.com","bts");
        Admin adminAccount=new Admin("admin","bts");
        BankTeller bankTeller=new BankTeller("bankTeller3","bts");
        assertEquals(bts.getAccounts(),null);
        assertTrue(bts.checkPassword("bts"));


        CheckingAccount btsAccount=new CheckingAccount(bts, 1500); 
        assertEquals(btsAccount.getHistory(), "");
        
        btsAccount.deposit(250);
        btsAccount.withdraw(500);
        assertFalse(btsAccount.getSuspiciousActivity());

        SavingsAccount btsSavingsAccount = new SavingsAccount(bts,0,1200);
        btsAccount.transfer(btsAccount, btsSavingsAccount, 500);
        assertEquals(500, btsSavingsAccount.getBalance());
    }
}