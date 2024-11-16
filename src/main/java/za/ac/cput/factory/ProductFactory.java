package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class ProductFactory {

    // Factory method to create a Product
    public static Product buildProduct(String name, double price, String description, byte[] photo ) {
        if (Helper.isStringNullorEmpty(name) || price <= 0 || Helper.isStringNullorEmpty(description)) {
            return null;
        }

        // Create and return a new Product
        return new Product.Builder()
                .setName(name)
                .setPrice(price)
                .setDescription(description)
                .setPhoto(photo)
                .build();
    }
}
