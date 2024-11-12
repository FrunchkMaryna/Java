package java1;

import java.time.LocalDate;

/**
 * Клас представляє замовника готельного номеру.
 */
public class Customer {
    /** Прізвище замовника */
    private String lastName;

    /** Ім'я замовника */
    private String firstName;

    /** Документ, що підтверджує особу */
    private String idDocument;

    /** Дата народження замовника */
    private LocalDate birthDate;

    /**
     * Конструктор для створення об'єкта Customer.
     *
     * @param lastName прізвище замовника
     * @param firstName ім'я замовника
     * @param idDocument документ, що підтверджує особу
     * @param birthDate дата народження замовника
     */
    public Customer(String lastName, String firstName, String idDocument, String birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.idDocument = idDocument;
        this.birthDate = LocalDate.parse(birthDate);
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
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    /**
     * Перевіряє чи є два об'єкти Customer однаковими.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо об'єкти однакові, інакше false
     */
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

    /**
     * Повертає хеш-код для об'єкта Customer.
     *
     * @return хеш-код на основі прізвища, імені, документа та дати народження
     */
    @Override
    public int hashCode() {
        int result = lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + idDocument.hashCode();
        result = 31 * result + birthDate.hashCode();
        return result;
    }
}
