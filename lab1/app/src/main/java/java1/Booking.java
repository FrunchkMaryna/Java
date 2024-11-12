package java1;

import java.time.LocalDate;

/**
 * Клас представляє бронювання номера.
 */
public class Booking {
    private Room room;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;

    private Booking(Builder builder) {
        this.room = builder.room;
        this.customer = builder.customer;
        this.startDate = LocalDate.parse(builder.startDate);
        this.endDate = LocalDate.parse(builder.endDate);
        this.totalPrice = builder.totalPrice;
    }

    /**
     * Клас Builder для створення об'єктів Booking.
     */
    public static class Builder {
        private Room room;
        private Customer customer;
        private String startDate;
        private String endDate;
        private double totalPrice;

        /**
         * Встановлює номер для бронювання.
         *
         * @param room номер
         * @return поточний екземпляр Builder
         */
        public Builder setRoom(Room room) {
            this.room = room;
            return this;
        }

        /**
         * Встановлює клієнта, який здійснює бронювання.
         *
         * @param customer клієнт
         * @return поточний екземпляр Builder
         */
        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        /**
         * Встановлює дату початку бронювання.
         *
         * @param startDate дата початку
         * @return поточний екземпляр Builder
         */
        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * Встановлює дату завершення бронювання.
         *
         * @param endDate дата завершення
         * @return поточний екземпляр Builder
         */
        public Builder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        /**
         * Встановлює загальну суму оплати.
         *
         * @param totalPrice загальна сума
         * @return поточний екземпляр Builder
         */
        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        /**
         * Створює об'єкт Booking з допомогою Builder.
         *
         * @return новий об'єкт Booking
         */
        public Booking build() {
            return new Booking(this);
        }
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", customer=" + customer +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (Double.compare(booking.totalPrice, totalPrice) != 0) return false;
        if (!room.equals(booking.room)) return false;
        if (!customer.equals(booking.customer)) return false;
        if (!startDate.equals(booking.startDate)) return false;
        return endDate.equals(booking.endDate);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = room.hashCode();
        result = 31 * result + customer.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        temp = Double.doubleToLongBits(totalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
