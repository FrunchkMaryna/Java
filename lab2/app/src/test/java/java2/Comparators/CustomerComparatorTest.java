package java2.Comparators;

import java2.Customer;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CustomerComparatorTest {

    @Test
    public void testSortByLastName() {
        List<Customer> customers = Arrays.asList(
                new Customer("Smith", "John", "ID123", LocalDate.of(1990, 1, 1)),
                new Customer("Doe", "Jane", "ID456", LocalDate.of(1985, 2, 15)),
                new Customer("Adams", "Alice", "ID789", LocalDate.of(2000, 5, 25))
        );

        customers.sort(CustomerComparator.byLastName());

        assertEquals("Adams", customers.get(0).getLastName());
        assertEquals("Doe", customers.get(1).getLastName());
        assertEquals("Smith", customers.get(2).getLastName());
    }

    @Test
    public void testSortByBirthDate() {
        List<Customer> customers = Arrays.asList(
                new Customer("Smith", "John", "ID123", LocalDate.of(1990, 1, 1)),
                new Customer("Doe", "Jane", "ID456", LocalDate.of(1985, 2, 15)),
                new Customer("Adams", "Alice", "ID789", LocalDate.of(2000, 5, 25))
        );

        customers.sort(CustomerComparator.byBirthDate());

        assertEquals("Doe", customers.get(0).getLastName());
        assertEquals("Smith", customers.get(1).getLastName());
        assertEquals("Adams", customers.get(2).getLastName());
    }

    @Test
    public void testSortByIdDocument() {
        List<Customer> customers = Arrays.asList(
                new Customer("Smith", "John", "ID123", LocalDate.of(1990, 1, 1)),
                new Customer("Doe", "Jane", "ID456", LocalDate.of(1985, 2, 15)),
                new Customer("Adams", "Alice", "ID789", LocalDate.of(2000, 5, 25))
        );

        customers.sort(CustomerComparator.byIdDocument());

        assertEquals("ID123", customers.get(0).getIdDocument());
        assertEquals("ID456", customers.get(1).getIdDocument());
        assertEquals("ID789", customers.get(2).getIdDocument());
    }

    @Test
    public void testSortByFirstName() {
        List<Customer> customers = Arrays.asList(
                new Customer("Smith", "John", "ID123", LocalDate.of(1990, 1, 1)),
                new Customer("Doe", "Jane", "ID456", LocalDate.of(1985, 2, 15)),
                new Customer("Adams", "Alice", "ID789", LocalDate.of(2000, 5, 25))
        );

        customers.sort(CustomerComparator.byFirstName());

        assertEquals("Alice", customers.get(0).getFirstName());
        assertEquals("Jane", customers.get(1).getFirstName());
        assertEquals("John", customers.get(2).getFirstName());
    }
}
