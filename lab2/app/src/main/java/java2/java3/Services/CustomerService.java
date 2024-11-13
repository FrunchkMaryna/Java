package java3.Services;

import java2.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    private final List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    // Метод для знаходження клієнтів за прізвищем
    public List<Customer> findByLastName(String lastName) {
        return customers.stream()
                .filter(customer -> customer.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    // Метод для знаходження клієнтів за ім'ям
    public List<Customer> findByFirstName(String firstName) {
        return customers.stream()
                .filter(customer -> customer.getFirstName().equalsIgnoreCase(firstName))
                .collect(Collectors.toList());
    }

    // Метод для отримання всіх клієнтів
    public List<Customer> getAllCustomers() {
        return customers;
    }

    // Метод для знаходження клієнтів за датою народження
    public List<Customer> findByBirthDate(LocalDate birthDate) {
        return customers.stream()
                .filter(customer -> customer.getBirthDate().equals(birthDate))
                .collect(Collectors.toList());
    }
}
