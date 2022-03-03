package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GetHistoryIntegrationTesting {
    @Test
    public void GetHistoryIntegrationTesting() throws InsufficientFundsException{
        Customer customer = new Customer("password", "bts@mail.com");

        SavingsAccount savingsCheck = new SavingsAccount(customer, 100, 1000);
        savingsCheck.deposit(400);
        savingsCheck.withdraw(400);

        assertTrue("Deposit: 400, Withdraw: 400, ", savingsCheck.getHistory());
    }

    private void assertTrue(String string, String history) {
    }
    
}
