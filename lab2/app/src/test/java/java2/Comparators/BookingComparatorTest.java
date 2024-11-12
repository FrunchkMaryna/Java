package java2.Comparators;

import java2.Booking;
import java2.Room;
import java2.Customer;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BookingComparatorTest {

    private Booking createBooking(String roomType, String customerLastName, String startDate, String endDate, double totalPrice) {
        Room room = new Room(roomType, 2, 101, "WiFi");
        Customer customer = new Customer(customerLastName, "FirstName", "ID123", LocalDate.of(1990, 1, 1));
        return new Booking.Builder()
                .setRoom(room)
                .setCustomer(customer)
                .setStartDate(String.valueOf(LocalDate.parse(startDate)))
                .setEndDate(String.valueOf(LocalDate.parse(endDate)))
                .setTotalPrice(totalPrice)
                .build();
    }

    @Test
    public void testSortByPrice() {
        List<Booking> bookings = Arrays.asList(
                createBooking("Standard", "Smith", "2024-01-01", "2024-01-05", 300.0),
                createBooking("Suite", "Doe", "2024-01-02", "2024-01-06", 200.0),
                createBooking("Deluxe", "Adams", "2024-01-03", "2024-01-07", 400.0)
        );

        bookings.sort(BookingComparator.byPrice());

        assertEquals(200.0, bookings.get(0).getTotalPrice());
        assertEquals(300.0, bookings.get(1).getTotalPrice());
        assertEquals(400.0, bookings.get(2).getTotalPrice());
    }

    @Test
    public void testSortByStartDate() {
        List<Booking> bookings = Arrays.asList(
                createBooking("Standard", "Smith", "2024-01-03", "2024-01-07", 300.0),
                createBooking("Suite", "Doe", "2024-01-01", "2024-01-05", 200.0),
                createBooking("Deluxe", "Adams", "2024-01-02", "2024-01-06", 400.0)
        );

        bookings.sort(BookingComparator.byStartDate());

        assertEquals("2024-01-01", bookings.get(0).getStartDate().toString());
        assertEquals("2024-01-02", bookings.get(1).getStartDate().toString());
        assertEquals("2024-01-03", bookings.get(2).getStartDate().toString());
    }

    @Test
    public void testSortByEndDate() {
        List<Booking> bookings = Arrays.asList(
                createBooking("Standard", "Smith", "2024-01-01", "2024-01-07", 300.0),
                createBooking("Suite", "Doe", "2024-01-01", "2024-01-05", 200.0),
                createBooking("Deluxe", "Adams", "2024-01-01", "2024-01-06", 400.0)
        );

        bookings.sort(BookingComparator.byEndDate());

        assertEquals("2024-01-05", bookings.get(0).getEndDate().toString());
        assertEquals("2024-01-06", bookings.get(1).getEndDate().toString());
        assertEquals("2024-01-07", bookings.get(2).getEndDate().toString());
    }

    @Test
    public void testSortByDuration() {
        List<Booking> bookings = Arrays.asList(
                createBooking("Standard", "Smith", "2024-01-01", "2024-01-03", 300.0), // 2 days
                createBooking("Suite", "Doe", "2024-01-01", "2024-01-05", 200.0), // 4 days
                createBooking("Deluxe", "Adams", "2024-01-01", "2024-01-04", 400.0)  // 3 days
        );

        bookings.sort(BookingComparator.byDuration());

        assertEquals(2, bookings.get(0).getDuration());
        assertEquals(3, bookings.get(1).getDuration());
        assertEquals(4, bookings.get(2).getDuration());
    }
}
