package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    @Test
    void suspiciousActivityTest() throws InsufficientFundsException{
        CheckingAccount account1=new CheckingAccount(600); //new checking account
        //valid positive amount 
        assertEquals(600, account1.getBalance(), .001);

        account1.deposit(0.01);
        assertEquals(600.01, account1.getBalance(), .001);

        //Negative amount
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(-100));
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(-0.01)); 

        account1.getSuspiciousActivity();
        assertTrue(account1.getSuspiciousActivity());

    }

    
}
