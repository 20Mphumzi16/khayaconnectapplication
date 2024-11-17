package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;

import java.time.LocalDate;
import java.util.List;

public class CartFactory {

    public static Cart buildCart(Long id, Customer customer, List<Product> products, LocalDate createdDate, LocalDate updatedDate) {
        if (id<=0 || customer == null || products ==null || createdDate == null || updatedDate == null) {
            return null;
        }

        return new Cart.Builder()
                .setCustomer(customer)
                .setProducts(products)
                .setCreatedDate(createdDate)
                .setUpdatedDate(updatedDate)
                .build();
    }
}
