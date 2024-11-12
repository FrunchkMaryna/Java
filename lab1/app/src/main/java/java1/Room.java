package java1;

public class Room {
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

    /**
     * Перевіряє чи є два об'єкти Room однаковими.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо об'єкти однакові, інакше false
     */
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

    /**
     * Повертає хеш-код для об'єкта Room.
     *
     * @return хеш-код на основі полів типу кімнати, кількості ліжок, номера кімнати та зручностей
     */
    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + bedCount;
        result = 31 * result + roomNumber;
        result = 31 * result + amenities.hashCode();
        return result;
    }
}

