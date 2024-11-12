package java2.Comparators;

import java2.Room;
import java.util.Comparator;

public class RoomComparator {

    /**
     * Компаратор для порівняння кімнат за кількістю ліжок.
     */
    public static Comparator<Room> byBedCount() {
        return Comparator.comparingInt(Room::getBedCount);
    }

    /**
     * Компаратор для порівняння кімнат за типом.
     */
    public static Comparator<Room> byType() {
        return Comparator.comparing(Room::getType);
    }

    /**
     * Компаратор для порівняння кімнат за номером кімнати.
     */
    public static Comparator<Room> byRoomNumber() {
        return Comparator.comparingInt(Room::getRoomNumber);
    }

    /**
     * Компаратор для порівняння кімнат за зручностями.
     */
    public static Comparator<Room> byAmenities() {
        return Comparator.comparing(Room::getAmenities);
    }

    /**
     * Компаратор для порівняння кімнат за кількістю ліжок, а якщо значення однакові, тоді за типом.
     */
    public static Comparator<Room> byBedCountThenType() {
        return Comparator.comparingInt(Room::getBedCount)
                .thenComparing(Room::getType);
    }

    /**
     * Компаратор для порівняння кімнат за типом, а якщо значення однакові, тоді за номером кімнати.
     */
    public static Comparator<Room> byTypeThenRoomNumber() {
        return Comparator.comparing(Room::getType)
                .thenComparingInt(Room::getRoomNumber);
    }

    /**
     * Компаратор для порівняння кімнат за кількістю ліжок, потім за зручностями, і нарешті за номером кімнати.
     */
    public static Comparator<Room> byBedCountThenAmenitiesThenRoomNumber() {
        return Comparator.comparingInt(Room::getBedCount)
                .thenComparing(Room::getAmenities)
                .thenComparingInt(Room::getRoomNumber);
    }
}
