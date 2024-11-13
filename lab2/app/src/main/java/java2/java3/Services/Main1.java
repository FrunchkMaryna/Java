package java3.Services;

import java3.Customer;
import java3.Serialization.Serialization;
import java3.Serialization.YMLSerializer;

import java.io.File;
import java.io.IOException;

public class Main1 {
    public static void main(String[] args) throws IOException {
        Serialization<Customer> ser = new YMLSerializer<>();
        ser.toEntityFromFile(new File("customers.yml"), Customer.class);
    }
}