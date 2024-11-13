package java3;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java2.Customer;
import java2.Room;

import java.time.LocalDate;
import java.time.Period;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking implements Comparable<Booking> {
    private Room room;
    private Customer customer;
    private double totalPrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private Booking() {}

    private Booking(Builder builder) {
        this.room = builder.room;
        this.customer = builder.customer;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.totalPrice = builder.totalPrice;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    // Метод для встановлення customer
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @JsonProperty("roomNumber")
    public int getRoomNumber() {
        return room != null ? room.getRoomNumber() : 0;
    }

    @JsonProperty("customerIdDocument")
    public String getCustomerIdDocument() {
        return customer != null ? customer.getIdDocument() : null;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @JsonIgnore
    public int getDuration() {
        return startDate != null && endDate != null ? Period.between(startDate, endDate).getDays() : 0;
    }

    @Override
    public int compareTo(Booking other) {
        int dateComparison = this.startDate.compareTo(other.startDate);
        if (dateComparison != 0) {
            return dateComparison;
        }
        return Double.compare(this.totalPrice, other.totalPrice);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", customer=" + customer +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public static class Builder {
        private Room room;
        private Customer customer;
        private LocalDate startDate;
        private LocalDate endDate;
        private double totalPrice;

        public Builder setRoom(Room room) {
            this.room = room;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}
