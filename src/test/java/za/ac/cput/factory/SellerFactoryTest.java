package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.Seller;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class SellerFactoryTest {

    private static Seller seller1;
    private static Seller seller2;
    private static Seller seller3;

    static byte[] photo;

    static BufferedImage image;
    static ByteArrayOutputStream out;

    @BeforeAll
    public static void setUp() {
        // Create addresses
        Address billingAddress = BillingAddressFactory.buildBillingAddress("card", "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");
        Address shippingAddress = ShippingAddressFactory.buildShippingAddress(LocalTime.of(9, 52), "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");

        // Create contacts
        Contact con1 = CustomerContactFactory.buildContact("leroyk@gmail.com", "0739946042", shippingAddress, billingAddress);
        Contact con2 = CustomerContactFactory.buildContact("james@gmail.com", "0739946042", shippingAddress, billingAddress);


        String url = "C:\\Users\\u0122437\\Downloads\\2.png";
        try {

            image = ImageIO.read(new File(url));
            out = new ByteArrayOutputStream();
            ImageIO.write(image, "png", out);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        photo = out.toByteArray();
        System.out.println(photo);

        Product product1 = ProductFactory.buildProduct("Laptop", 1500.00, "High-performance laptop", photo);
        Product product2 = ProductFactory.buildProduct("Smartphone", 800.00, "Latest model smartphone",photo);
        List<Product> products = List.of(product1, product2);

        // Create roles (assuming Role is an enum or class)
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("SELLER"));

        // Valid seller
        seller1 = SellerFactory.buildSeller(1L, "Leroy", "Kulcha", "Liam", "password123", con1, "Kulcha Electronics", products);

        // Invalid seller with missing business name
        seller2 = SellerFactory.buildSeller(2L, "James", "Ntokozo", "Liam", "password456", con2, "", products);

        // Invalid seller with missing products
        seller3 = SellerFactory.buildSeller(3L, "John", "Doe", "Jane", "password789", con1, "Doe Enterprises", null);
    }

    @Test
    void buildSeller() {
        assertNotNull(seller1);
        System.out.println("Valid Seller: " + seller1);
    }

    @Test
    void failingBuildSellerWithMissingBusinessName() {
        assertNull(seller2);
        System.out.println("Invalid Seller (missing business name): " + seller2);
    }

    @Test
    void failingBuildSellerWithNoProducts() {
        assertNull(seller3);
        System.out.println("Invalid Seller (no products): " + seller3);
    }
}
