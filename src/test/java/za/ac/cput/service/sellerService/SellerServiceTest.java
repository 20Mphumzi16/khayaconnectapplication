package za.ac.cput.service.sellerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SellerServiceTest {

    @Autowired
    private SellerService sellerService;

    private static Seller seller1;
    private static Seller seller2;
    private static Seller seller3;

    private static Seller savedSeller;

    static byte[] photo;

    static BufferedImage image;
    static ByteArrayOutputStream out;

    @BeforeEach
    void setUp() {
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

        // Valid seller
        seller1 = SellerFactory.buildSeller(1L, "Leroy", "Kulcha", "Liam", "password123", con1, "Kulcha Electronics", products);

        // Invalid seller with missing business name
        seller2 = SellerFactory.buildSeller(2L, "James", "Ntokozo", "Liam", "password456", con2, "", products);

        // Invalid seller with missing products
        seller3 = SellerFactory.buildSeller(3L, "John", "Doe", "Jane", "password789", con1, "Doe Enterprises", null);
    }

    @Test
    void create() {
        System.out.println("===========================CREATE========================================");

        savedSeller = sellerService.create(seller1);
        assertNotNull(savedSeller);
        System.out.println(savedSeller);
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getall() {
    }
}