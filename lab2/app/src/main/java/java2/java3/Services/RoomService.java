package java3.Services;

import java2.Room;

import java.util.List;
import java.util.stream.Collectors;

public class RoomService {
    private final List<Room> rooms;

    public RoomService(List<Room> rooms) {
        this.rooms = rooms;
    }

    // Метод для знаходження кімнат за типом
    public List<Room> findByType(String type) {
        return rooms.stream()
                .filter(room -> room.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    // Метод для знаходження кімнат за кількістю ліжок
    public List<Room> findByBedCount(int bedCount) {
        return rooms.stream()
                .filter(room -> room.getBedCount() == bedCount)
                .collect(Collectors.toList());
    }

    // Метод для отримання всіх кімнат
    public List<Room> getAllRooms() {
        return rooms;
    }
}
