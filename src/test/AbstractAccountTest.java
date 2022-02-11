import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AbstractAccountTest {
    @Test
    void withdrawTest(){
        CheckingAccount checkAcc = new CheckingAccount("a@b.com", 200); //Checking
        checkAcc.withdraw(100); //Normal Withdraw

        assertEquals(100, checkAcc.getBalance(), 0.001);
        assertThrows(InsufficientFundsException.class, () -> checkAcc.withdraw(300)); //Insufficient Funds

        SavingsAccount savingAcc = new SavingsAccount("a@b.com", 1500); //Savings
        savingAcc.withdraw(100);

        assertEquals(1400, checkAcc.getBalance(), 0.001);
        assertThrows(IllegalArgumentException.class, () -> savingAcc.withdraw(1005)); //Over Max Withdrawal
    }
}
