package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    @Test
    void suspiciousActivityTest() throws InsufficientFundsException{
        CheckingAccount account1=new CheckingAccount(600); 

        //Suspicious deposit activity

        assertEquals(600, account1.getBalance(), .001);
        account1.deposit(0.01);
        assertEquals(600.01, account1.getBalance(), .001);
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(-100));
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(-0.01)); 

        account1.getSuspiciousActivity();
        assertTrue(account1.getSuspiciousActivity());


        //Suspicious transfer activity
        AbstractAccount bankAccount1 = new CheckingAccount(100);
        AbstractAccount bankAccount2 = new CheckingAccount(0);
        assertThrows(InsufficientFundsException.class,() -> CheckingAccount.transfer(bankAccount1, bankAccount2, 500));
        assertTrue(bankAccount1.getSuspiciousActivity());

        
        //Suspicious withdraw activity
        CheckingAccount checkAcc = new CheckingAccount(0); 
        checkAcc.deposit(100); 

        assertEquals(100, checkAcc.getBalance(), 0.001);
        assertThrows(InsufficientFundsException.class, () -> checkAcc.withdraw(300));
        assertTrue(checkAcc.getSuspiciousActivity());

    }

    
}
