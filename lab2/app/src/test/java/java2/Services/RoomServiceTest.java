package java2.Services;

import java2.Room;
import java2.Services.RoomService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RoomServiceTest {
    private RoomService roomService;
    private List<Room> rooms;

    @BeforeMethod
    public void setUp() {
        rooms = new ArrayList<>();
        rooms.add(new Room("Standard", 2, 101, "WiFi"));
        rooms.add(new Room("Suite", 1, 201, "WiFi, TV"));
        rooms.add(new Room("Deluxe", 3, 102, "WiFi, AC"));
        roomService = new RoomService(rooms);
    }

    @Test
    public void testFindByType() {
        List<Room> result = roomService.findByType("Suite");
        assertEquals(2, result.size());
        assertEquals("Suite", result.get(0).getType());
    }

    @Test
    public void testFindByBedCount() {
        List<Room> result = roomService.findByBedCount(2);
        assertEquals(1, result.size());
        assertEquals(2, result.get(0).getBedCount());
    }

    @Test
    public void testGetAllRooms() {
        List<Room> result = roomService.getAllRooms();
        assertEquals(3, result.size());
    }
}
