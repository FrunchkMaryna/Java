package java3;

import java2.Booking;
import java2.Customer;
import java2.Room;

import java3.Serialization.JSONSerializer;
import java3.Serialization.Serialization;
import java3.Serialization.XMLSerializer;
import java3.Serialization.YMLSerializer;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створення екземплярів класів Room, Customer, та Booking
        Room room1 = new Room("Standard", 2, 101, "WiFi, TV");
        Room room2 = new Room("Deluxe", 3, 102, "WiFi, TV, Mini-bar");

        Customer customer1 = new Customer("Dea", "Fluke", "AA123456", LocalDate.of(1990, 5, 15));
        Customer customer2 = new Customer("Hockney", "David", "BB654321", LocalDate.of(1985, 8, 20));

        Booking booking1 = new Booking.Builder()
                .setRoom(room1)
                .setCustomer(customer1)
                .setStartDate("2023-12-01")
                .setEndDate("2023-12-10")
                .setTotalPrice(5000.0)
                .build();

        Booking booking2 = new Booking.Builder()
                .setRoom(room2)
                .setCustomer(customer2)
                .setStartDate("2024-01-05")
                .setEndDate("2024-01-15")
                .setTotalPrice(8000.0)
                .build();

        // Створення списків для серіалізації
        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);

        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking1);
        bookings.add(booking2);

        // Серіалізатори для різних форматів
        JSONSerializer<Room> jsonRoomSerializer = new JSONSerializer<>();
        JSONSerializer<Customer> jsonCustomerSerializer = new JSONSerializer<>();
        JSONSerializer<Booking> jsonBookingSerializer = new JSONSerializer<>();

        XMLSerializer<Room> xmlRoomSerializer = new XMLSerializer<>();
        XMLSerializer<Customer> xmlCustomerSerializer = new XMLSerializer<>();
        XMLSerializer<Booking> xmlBookingSerializer = new XMLSerializer<>();

        YMLSerializer<Room> yamlRoomSerializer = new YMLSerializer<>();
        YMLSerializer<Customer> yamlCustomerSerializer = new YMLSerializer<>();
        YMLSerializer<Booking> yamlBookingSerializer = new YMLSerializer<>();

        try {
//            // Серіалізація та запис списків об'єктів у файли
//            serializeEntities(jsonRoomSerializer, rooms, "rooms.json");
//            serializeEntities(jsonCustomerSerializer, customers, "customers.json");
//            serializeEntities(jsonBookingSerializer, bookings, "bookings.json");
//
//            serializeEntities(xmlRoomSerializer, rooms, "rooms.xml");
//            serializeEntities(xmlCustomerSerializer, customers, "customers.xml");
//            serializeEntities(xmlBookingSerializer, bookings, "bookings.xml");
//
//            serializeEntities(yamlRoomSerializer, rooms, "rooms.yml");
//            serializeEntities(yamlCustomerSerializer, customers, "customers.yml");
//            serializeEntities(yamlBookingSerializer, bookings, "bookings.yml");
//
//            System.out.println("Серіалізація списків виконана успішно. Файли створено.");

            // Десеріалізація з файлів та запис в інші файли
            deserializeAndSaveToNewFile(jsonRoomSerializer, "rooms.json", Room.class, "rooms_deserialized.json");
            deserializeAndSaveToNewFile(jsonCustomerSerializer, "customers.json", Customer.class, "customers_deserialized.json");
            deserializeAndSaveToNewFile(jsonBookingSerializer, "bookings.json", Booking.class, "bookings_deserialized.json");

            deserializeAndSaveToNewFile(xmlRoomSerializer, "rooms.xml", Room.class, "rooms_deserialized.xml");
            deserializeAndSaveToNewFile(xmlCustomerSerializer, "customers.xml", Customer.class, "customers_deserialized.xml");
            deserializeAndSaveToNewFile(xmlBookingSerializer, "bookings.xml", Booking.class, "bookings_deserialized.xml");

            deserializeAndSaveToNewFile(yamlRoomSerializer, "rooms.yml", Room.class, "rooms_deserialized.yml");
            deserializeAndSaveToNewFile(yamlCustomerSerializer, "customers.yml", Customer.class, "customers_deserialized.yml");
            deserializeAndSaveToNewFile(yamlBookingSerializer, "bookings.yml", Booking.class, "bookings_deserialized.yml");

        } catch (IOException e) {
            System.err.println("Помилка під час серіалізації або десеріалізації: " + e.getMessage());
        }
    }

//    // Метод серіалізації
//    private static <T> void serializeEntities(Serialization<T> serializer, List<T> entities, String filePath) throws IOException {
//        serializer.fromEntityListToFile(entities, filePath);
//    }

    // Метод десеріалізації та запису в новий файл
    public static <T> void deserializeAndSaveToNewFile(Serialization<T> serializer, String inputFilePath, Class<T> type, String outputFilePath) throws IOException {

    }

}