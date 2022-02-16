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

    @Test
    void depositTest() throws InsufficientFundsException{
        CheckingAccount account1=new CheckingAccount("a@b.com",500); //new checking account
        //valid positive amount
        account1.deposit(100); 
        assertEquals(600, account1.getBalance(), .001);

        account1.deposit(0.01);
        assertEquals(600.01, account1.getBalance(), .001);

        //Negative amount
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(-100));
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(-0.01)); 

        //Amount with more than 2 decimals
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(100.23467435));
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(100.234));
    }
}

