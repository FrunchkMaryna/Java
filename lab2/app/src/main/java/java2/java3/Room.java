package java3;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Room implements Comparable<Room> {
    /** Тип кімнати (наприклад, стандарт, люкс) */
    private String type;

    /** Кількість ліжок у кімнаті */
    private int bedCount;

    /** Номер кімнати */
    private int roomNumber;

    /** Зручності, доступні в кімнаті */
    private String amenities;

    /**
     * Конструктор для створення об'єкта Room.
     *
     * @param type тип кімнати
     * @param bedCount кількість ліжок
     * @param roomNumber номер кімнати
     * @param amenities зручності в кімнаті
     */
    public Room(String type, int bedCount, int roomNumber, String amenities) {
        this.type = type;
        this.bedCount = bedCount;
        this.roomNumber = roomNumber;
        this.amenities = amenities;
    }

    // Гетери для всіх полів

    public String getType() {
        return type;
    }

    public int getBedCount() {
        return bedCount;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    // Сетери для всіх полів
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("bedCount")
    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    @JsonProperty("roomNumber")
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @JsonProperty("amenities")
    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }


    public String getAmenities() {
        return amenities;
    }

    /**
     * Повертає рядкове представлення інформації про номер.
     *
     * @return рядок з інформацією про тип, кількість ліжок, номер кімнати та зручності
     */
    @Override
    public String toString() {
        return "Room{" +
                "type='" + type + '\'' +
                ", bedCount=" + bedCount +
                ", roomNumber=" + roomNumber +
                ", amenities='" + amenities + '\'' +
                '}';
    }

    // equals та hashCode методи
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (bedCount != room.bedCount) return false;
        if (roomNumber != room.roomNumber) return false;
        if (!type.equals(room.type)) return false;
        return amenities.equals(room.amenities);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + bedCount;
        result = 31 * result + roomNumber;
        result = 31 * result + amenities.hashCode();
        return result;
    }

    @Override
    public int compareTo(Room other) {
        // Спочатку порівнюємо за кількістю ліжок
        int bedCountComparison = Integer.compare(this.bedCount, other.bedCount);
        if (bedCountComparison != 0) {
            return bedCountComparison;
        }
        // Якщо кількість ліжок однакова, порівнюємо за номером кімнати
        return Integer.compare(this.roomNumber, other.roomNumber);
    }
}
