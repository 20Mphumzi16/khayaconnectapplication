package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class CustomerOrderFactory {

    // Factory method to build a CustomerOrder with valid data
    public static CustomerOrder buildCustomerOrder(Customer customer, double totalAmount, OrderStatus status) {
        if (customer == null || totalAmount <= 0 || status == null) {
            return null; // Invalid input, return null
        }

        // Set the order date to current date if not provided
        LocalDate orderDate = LocalDate.now();

        // Create and return a new CustomerOrder using the builder pattern
        return new CustomerOrder.CustomerOrderBuilder()
                .setCustomer(customer)
                .setOrderDate(orderDate)
                .setTotalAmount(totalAmount)
                .setStatus(status)
                .build();
    }

    // Factory method to build a CustomerOrder with a custom order date
    public static CustomerOrder buildCustomerOrder(Customer customer, double totalAmount, OrderStatus status, LocalDate orderDate) {
        if (customer == null || totalAmount <= 0 || status == null || orderDate == null) {
            return null; // Invalid input, return null
        }

        // Create and return a new CustomerOrder using the builder pattern
        return new CustomerOrder.CustomerOrderBuilder()
                .setCustomer(customer)
                .setOrderDate(orderDate)
                .setTotalAmount(totalAmount)
                .setStatus(status)
                .build();
    }
}
