package cinema.model;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class CustomerTest {

    private Customer customer;


    @BeforeEach
    void setUp() {
        customer = new Customer(1, "Mehmet Demir", "mehmet@email.com", "05559876543");
    }

    @Test
    void testCustomerCreation() {
        assertEquals(1, customer.getId());
        assertEquals("Mehmet Demir", customer.getName());
        assertEquals("mehmet@email.com", customer.getEmail());
        assertEquals("05559876543", customer.getPhone());
    }

    @Test
    void testSetName() {
        customer.setName("Ali Veli");
        assertEquals("Ali Veli", customer.getName());
    }

    @Test
    void testSetEmail() {
        customer.setEmail("ali@gmail.com");
        assertEquals("ali@gmail.com", customer.getEmail());
    }

    @Test
    void testSetPhone() {
        customer.setPhone("05551112233");
        assertEquals("05551112233", customer.getPhone());
    }
}
//test başarılı