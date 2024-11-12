package java1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest {

    @Test
    public void testToString() {
        Customer customer = new Customer("Поттер", "Гаррі", "123456", "31.07.1980");
        String expected = "Customer{lastName='Поттер', firstName='Гаррі', idDocument='123456', birthDate='31.07.1980'}";
        Assert.assertEquals(customer.toString(), expected);
    }

    @Test
    public void testEquals() {
        Customer customer1 = new Customer("Поттер", "Гаррі", "123456", "31.07.1980");
        Customer customer2 = new Customer("Поттер", "Гаррі", "123456", "31.07.1980");
        Assert.assertEquals(customer1, customer2);
    }

    @Test
    public void testHashCode() {
        Customer customer = new Customer("Поттер", "Гаррі", "123456", "31.07.1980");
        Assert.assertEquals(customer.hashCode(), -736770077);
    }
}
