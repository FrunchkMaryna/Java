package java2.Comparators;

import java2.Room;
import java2.Comparators.RoomComparator;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RoomComparatorTest {

    @Test
    public void testSortByBedCount() {
        List<Room> rooms = Arrays.asList(
                new Room("Standard", 2, 101, "WiFi"),
                new Room("Suite", 1, 201, "WiFi, TV"),
                new Room("Deluxe", 3, 102, "WiFi, AC")
        );

        rooms.sort(RoomComparator.byBedCount());

        assertEquals("Suite", rooms.get(0).getType());
        assertEquals("Standard", rooms.get(1).getType());
        assertEquals("Deluxe", rooms.get(2).getType());
    }

    @Test
    public void testSortByType() {
        List<Room> rooms = Arrays.asList(
                new Room("Standard", 2, 101, "WiFi"),
                new Room("Suite", 1, 201, "WiFi, TV"),
                new Room("Deluxe", 3, 102, "WiFi, AC")
        );

        rooms.sort(RoomComparator.byType());

        assertEquals("Deluxe", rooms.get(0).getType());
        assertEquals("Standard", rooms.get(1).getType());
        assertEquals("Suite", rooms.get(2).getType());
    }
}
