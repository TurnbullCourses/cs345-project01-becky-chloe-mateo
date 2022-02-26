package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import edu.ithaca.dturnbull.bank.InsufficientFundsException;

class AbstractAccountTest {

    @Test
    void withdrawTest() throws InsufficientFundsException{
 
        CheckingAccount checkAcc = new CheckingAccount(0); //Checking
        checkAcc.deposit(100); //Normal deposit

        assertEquals(100, checkAcc.getBalance(), 0.001);
        assertThrows(InsufficientFundsException.class, () -> checkAcc.withdraw(300)); //Insufficient Funds

        SavingsAccount savingAcc = new SavingsAccount(1500, 1000); //Savings
        savingAcc.withdraw(100);

        assertEquals(1400, savingAcc.getBalance(), 0.001);
        assertThrows(IllegalArgumentException.class, () -> savingAcc.withdraw(1005)); //Over Max Withdrawal
    }

    @Test
    void createAccountTest(){
        //Creates a Savings Account
        BankTeller.createAccount("Savings","1234",0,1200);
        
        //Creates a Checking Account
        BankTeller.createAccount("Checking","1234",0,0);

    }

    @Test
    void depositTest() throws InsufficientFundsException{
        CheckingAccount account1=new CheckingAccount(600); //new checking account
        //valid positive amount 
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

    @Test 
    void transferTest() throws InsufficientFundsException{
        AbstractAccount bankAccount1 = new CheckingAccount(100);
        AbstractAccount bankAccount2 = new CheckingAccount(0);


        //Valid non-negative amount and valid sender and receiver
        AbstractAccount.transfer(bankAccount1, bankAccount2, 25);
        assertEquals(75, bankAccount1.getBalance(), .001);
        assertEquals(25, bankAccount2.getBalance(), .001);

        //transferring 0
        CheckingAccount.transfer(bankAccount1, bankAccount2, 0);
        assertEquals(75, bankAccount1.getBalance(), .001); //Border
        assertEquals(25, bankAccount2.getBalance(), .001); //Border

        //transferring all the money from 1 account
        CheckingAccount.transfer(bankAccount2, bankAccount1, 25);
        assertEquals(100, bankAccount1.getBalance(), .001); //Border
        assertEquals(0, bankAccount2.getBalance(), .001); //Border

        //2 decimal transfer
        CheckingAccount.transfer(bankAccount1, bankAccount2, 99.99);
        assertEquals(.01, bankAccount1.getBalance(), .001); //Border
        assertEquals(99.99, bankAccount2.getBalance(), .001); //Border

        //Exceptions
        assertThrows(InsufficientFundsException.class,() -> CheckingAccount.transfer(bankAccount1, bankAccount2, 500));
        assertThrows(InsufficientFundsException.class,() -> CheckingAccount.transfer(bankAccount1, bankAccount2, 729));

        assertThrows(IllegalArgumentException.class,() -> CheckingAccount.transfer(bankAccount1, bankAccount1, 0));

        assertThrows(IllegalArgumentException.class,() -> CheckingAccount.transfer(bankAccount1, bankAccount2, -25));
        assertThrows(IllegalArgumentException.class,() -> CheckingAccount.transfer(bankAccount1, bankAccount2, -9.99)); 

        assertThrows(IllegalArgumentException.class,() -> CheckingAccount.transfer(bankAccount1, bankAccount2, 30.6594));
        assertThrows(IllegalArgumentException.class,() -> CheckingAccount.transfer(bankAccount1, bankAccount1, 12.12901));
    }
    }

