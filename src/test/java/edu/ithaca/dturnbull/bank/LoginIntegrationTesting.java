package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LoginIntegrationTesting {
    @Test
    public void loginTest(){
        Customer customer = new Customer("password", "bts@mail.com");

        assertTrue(AbstractBank.loginCheck("bts@mail.com", "password"));
        assertFalse(AbstractBank.loginCheck("bts@email.com", "pass"));

        
    }
    
}
