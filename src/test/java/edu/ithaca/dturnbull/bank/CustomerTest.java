package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import edu.ithaca.dturnbull.Customer;
import edu.ithaca.dturnbull.bank.InsufficientFundsException;

class CustomerTest {

    @Test
    void checkPasswordTest(){
        Customer person1 = new Customer("hello");
        assertEquals(true, person1.checkPassword("hello")); //password matches
        assertEquals(false, person1.checkPassword("hi"));
        assertEquals(false, person1.checkPassword("hell"));
    }
    }

