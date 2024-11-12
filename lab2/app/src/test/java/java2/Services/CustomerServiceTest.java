package java2.Services;

import java2.Customer;
import java2.Services.CustomerService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeClass
    public void setUp() {
        List<Customer> customers = Arrays.asList(
                new Customer("Smith", "John", "ID001", LocalDate.of(1990, 1, 1)),
                new Customer("Doe", "Jane", "ID002", LocalDate.of(1992, 2, 2)),
                new Customer("Brown", "John", "ID003", LocalDate.of(1985, 3, 3)),
                new Customer("Smith", "Emily", "ID004", LocalDate.of(1995, 4, 4))
        );
        customerService = new CustomerService(customers);
    }

    @Test
    public void testFindByBirthDate() {
        List<Customer> result = customerService.findByBirthDate(LocalDate.of(1990, 1, 1));
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getLastName(), "Smith");
    }
}
