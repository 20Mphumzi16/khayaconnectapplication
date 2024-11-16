package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;

public class CartFactory {

    // Factory method to build a Cart with customer and dates
    public static Cart buildCart(Long id, Customer customer, LocalDate createdDate, LocalDate updatedDate) {
        if (id<=0 || customer == null || createdDate == null || updatedDate == null) {
            return null;
        }

        return new Cart.Builder()
                .setCustomer(customer)
                .setCreatedDate(createdDate)
                .setUpdatedDate(updatedDate)
                .build();
    }

    // Factory method to build a Cart with customer (without dates)
    public static Cart buildCart(Customer customer) {
        if (customer == null) {
            return null;
        }

        return new Cart.Builder()
                .setCustomer(customer)
                .setCreatedDate(LocalDate.now())  // Default to current date
                .setUpdatedDate(LocalDate.now())  // Default to current date
                .build();
    }
}
