package java2.Comparators;

import java2.Customer;
import java.util.Comparator;

public class CustomerComparator {
    // Компаратор для порівняння клієнтів за прізвищем
    public static Comparator<Customer> byLastName() {
        return Comparator.comparing(Customer::getLastName);
    }

    // Компаратор для порівняння клієнтів за датою народження
    public static Comparator<Customer> byBirthDate() {
        return Comparator.comparing(Customer::getBirthDate);
    }

    // Компаратор для порівняння клієнтів за номером документа
    public static Comparator<Customer> byIdDocument() {
        return Comparator.comparing(Customer::getIdDocument);
    }

    // Компаратор для порівняння клієнтів за іменем
    public static Comparator<Customer> byFirstName() {
        return Comparator.comparing(Customer::getFirstName);
    }
}

