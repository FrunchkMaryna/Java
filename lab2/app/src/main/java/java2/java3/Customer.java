package java3;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
    /** Прізвище замовника */
    private String lastName;

    /** Ім'я замовника */
    private String firstName;

    /** Документ, що підтверджує особу */
    private String idDocument;

    /** Дата народження замовника */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    /**
     * Конструктор для створення об'єкта Customer.
     *
     * @param lastName прізвище замовника
     * @param firstName ім'я замовника
     * @param idDocument документ, що підтверджує особу
     * @param birthDate дата народження замовника
     */
    public Customer(String lastName, String firstName, String idDocument, LocalDate birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.idDocument = idDocument;
        this.birthDate = birthDate;
    }

    // Гетери для всіх полів

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getIdDocument() {
        return idDocument;
    }

    // Сетери для всіх полів
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("idDocument")
    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    @JsonProperty("birthDate")
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Повертає рядкове представлення інформації про замовника.
     *
     * @return рядок з інформацією про прізвище, ім'я, документ та дату народження
     */
    @Override
    public String toString() {
        return "Customer{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", idDocument='" + idDocument + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!lastName.equals(customer.lastName)) return false;
        if (!firstName.equals(customer.firstName)) return false;
        if (!idDocument.equals(customer.idDocument)) return false;
        return birthDate.equals(customer.birthDate);
    }

    @Override
    public int hashCode() {
        int result = lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + idDocument.hashCode();
        result = 31 * result + birthDate.hashCode();
        return result;
    }

    @Override
    public int compareTo(Customer other) {
        // Спочатку порівнюємо за прізвищем
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        // Якщо прізвища однакові, порівнюємо за іменем
        return this.firstName.compareTo(other.firstName);
    }
}
