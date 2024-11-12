package java1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RoomTest {

    @Test
    public void testToString() {
        Room room = new Room("Люкс", 2, 101, "Кондиціонер, Wi-Fi");
        String expected = "Room{type='Люкс', bedCount=2, roomNumber=101, amenities='Кондиціонер, Wi-Fi'}";
        Assert.assertEquals(room.toString(), expected);
    }

    @Test
    public void testEquals() {
        Room room1 = new Room("Люкс", 2, 101, "Кондиціонер, Wi-Fi");
        Room room2 = new Room("Люкс", 2, 101, "Кондиціонер, Wi-Fi");
        Assert.assertEquals(room1, room2);
    }

    @Test
    public void testHashCode() {
        Room room = new Room("Люкс", 2, 101, "Кондиціонер, Wi-Fi");
        Assert.assertEquals(room.hashCode(), -118166314);
    }
}
