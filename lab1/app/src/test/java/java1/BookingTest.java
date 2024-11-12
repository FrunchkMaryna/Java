package java1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTest {

    @Test
    public void testToString() {
        Room room = new Room("Люкс", 2, 101, "Кондиціонер, Wi-Fi");
        Customer customer = new Customer("Поттер", "Гаррі", "123456", "31.07.1980");
        Booking booking = new Booking.Builder()
                .setRoom(room)
                .setCustomer(customer)
                .setStartDate("2024-11-01")
                .setEndDate("2024-11-05")
                .setTotalPrice(1000.00)
                .build();

        String expected = "Booking{room=" + room + ", customer=" + customer + ", startDate='2024-11-01', endDate='2024-11-05', totalPrice=1000.0}";
        Assert.assertEquals(booking.toString(), expected);
    }

    @Test
    public void testEquals() {
        Room room = new Room("Люкс", 2, 101, "Кондиціонер, Wi-Fi");
        Customer customer = new Customer("Поттер", "Гаррі", "123456", "31.07.1980");
        Booking booking1 = new Booking.Builder()
                .setRoom(room)
                .setCustomer(customer)
                .setStartDate("2024-11-01")
                .setEndDate("2024-11-05")
                .setTotalPrice(1000.00)
                .build();
        Booking booking2 = new Booking.Builder()
                .setRoom(room)
                .setCustomer(customer)
                .setStartDate("2024-11-01")
                .setEndDate("2024-11-05")
                .setTotalPrice(1000.00)
                .build();
        Assert.assertEquals(booking1, booking2);
    }

    @Test
    public void testHashCode() {
        Room room = new Room("Люкс", 2, 101, "Кондиціонер, Wi-Fi");
        Customer customer = new Customer("Поттер", "Гаррі", "123456", "31.07.1980");
        Booking booking = new Booking.Builder()
                .setRoom(room)
                .setCustomer(customer)
                .setStartDate("2024-11-01")
                .setEndDate("2024-11-05")
                .setTotalPrice(1000.00)
                .build();
        Assert.assertEquals(booking.hashCode(), -928176273);
    }
}
