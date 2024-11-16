package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.util.List;
import java.util.Set;

public class SellerFactory {

    // Factory method to create a Seller
    public static Seller buildSeller(long userId, String firstName, String middleName, String lastName, String password,
                                     Contact contact, String businessName, List<Product> products) {
        if (Helper.isStringNullorEmpty(firstName) || Helper.isStringNullorEmpty(lastName) ||
                Helper.isStringNullorEmpty(password) || contact == null || Helper.isStringNullorEmpty(businessName) ||
                products == null || products.isEmpty()) {
            return null;  // Invalid input, return null
        }

        // Create Name object
        Name name = new Name.NameBuilder().setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();

        // Build and return the Seller object using the builder
        return new Seller.SellerBuilder()
                .setUserId(userId)
                .setName(name)
                .setPassword(password)
                .setContact(contact)
                .setBusinessName(businessName)
                .setProducts(products)
                .build();
    }

    // Factory method for a simpler Seller creation without a middle name
    public static Seller buildSeller(long userId, String firstName, String lastName, String password,
                                     Contact contact, String businessName, List<Product> products) {
        return buildSeller(userId, firstName, "", lastName, password, contact, businessName, products);
    }
}
