package java2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking implements Comparable<Booking> {
    private Room room;
    private Customer customer;
    @JsonFormat(pattern = "dd-MM-yy")
    private LocalDate startDate;

    @JsonFormat(pattern = "dd-MM-yy")
    private LocalDate endDate;

    private double totalPrice;

public Booking(){

}

    private Booking(Builder builder) {
        this.room = builder.room;
        this.customer = builder.customer;
        this.startDate = LocalDate.parse(builder.startDate);
        this.endDate = LocalDate.parse(builder.endDate);
        this.totalPrice = builder.totalPrice;
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

    @JsonProperty("duration")
    public int getDuration() {
        return java.time.Period.between(startDate, endDate).getDays();
    }



    @Override
    public int compareTo(Booking other) {
        // Порівняння за датою початку бронювання
        int dateComparison = this.startDate.compareTo(other.startDate);
        if (dateComparison != 0) {
            return dateComparison;
        }
        // Якщо дати початку однакові, порівнюємо за загальною ціною
        return Double.compare(this.totalPrice, other.totalPrice);
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

    public void setRoom(Room room) {
        this.room = room;
    }

    // Метод для встановлення customer
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static class Builder {
        private Room room;
        private Customer customer;
        private String startDate;
        private String endDate;
        private double totalPrice;

        public Builder setRoom(Room room) {
            this.room = room;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public int setRoomNumber(int roomNumber) {
            return room != null ? room.getRoomNumber() : 0;
        }

        @JsonProperty("customerIdDocument")
        public String setCustomerIdDocument() {
            return customer != null ? customer.getIdDocument() : null;
        }



        public Booking build() {
            return new Booking(this);
        }
    }
}
