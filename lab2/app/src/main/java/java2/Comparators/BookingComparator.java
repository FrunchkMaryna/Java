package java2.Comparators;

import java2.Booking;

import java.util.Comparator;

public class BookingComparator {
    // Компаратор для порівняння бронювань за ціною
    public static Comparator<Booking> byPrice() {
        return Comparator.comparingDouble(Booking::getTotalPrice);
    }

    // Компаратор для порівняння бронювань за датою початку
    public static Comparator<Booking> byStartDate() {
        return Comparator.comparing(Booking::getStartDate);
    }

    // Компаратор для порівняння бронювань за датою завершення
    public static Comparator<Booking> byEndDate() {
        return Comparator.comparing(Booking::getEndDate);
    }

    // Компаратор для порівняння бронювань за тривалістю (кількістю днів)
    public static Comparator<Booking> byDuration() {
        return Comparator.comparingInt(Booking::getDuration);
    }
}

