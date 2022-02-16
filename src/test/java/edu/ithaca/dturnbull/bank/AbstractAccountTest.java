package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import edu.ithaca.dturnbull.bank.InsufficientFundsException;

class AbstractAccountTest {

    @Test
    void withdrawTest() throws InsufficientFundsException{
        CheckingAccount checkAcc = new CheckingAccount("a@b.com", 200); //Checking
        checkAcc.withdraw(100); //Normal Withdraw

        assertEquals(100, checkAcc.getBalance(), 0.001);
        assertThrows(InsufficientFundsException.class, () -> checkAcc.withdraw(300)); //Insufficient Funds

        SavingsAccount savingAcc = new SavingsAccount("a@b.com", 1500, 1000); //Savings
        savingAcc.withdraw(100);

        assertEquals(1400, savingAcc.getBalance(), 0.001);
        assertThrows(IllegalArgumentException.class, () -> savingAcc.withdraw(1005)); //Over Max Withdrawal
    }

    void createAccountTest(){
        //Creates a Savings Account
        BankTeller.createAccount("Savings","1234",0,1200);
        
        //Creates a Checking Account
        BankTeller.createAccount("Checking","1234",0,0);

    }
}

