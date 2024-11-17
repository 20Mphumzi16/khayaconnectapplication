package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.customerService.CustomerService;
import za.ac.cput.service.sellerService.SellerService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SellerControllerTest {

    private final String BASE_URL = "http://localhost:8080/comiccity/Seller";
    @Autowired
    private TestRestTemplate testRestTemplate;

    private static Seller seller1;
    private static Seller seller2;
    private static Seller seller3;

    private static Seller savedSeller;

    static byte[] photo;

    static BufferedImage image;
    static ByteArrayOutputStream out;

    @BeforeAll
    static void setUp() {
        Address billingAddress = BillingAddressFactory.buildBillingAddress("card", "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");
        Address shippingAddress = ShippingAddressFactory.buildShippingAddress(LocalTime.of(9, 52), "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");

        // Create contacts
        Contact con1 = CustomerContactFactory.buildContact("leroyk666@gmail.com", "0739946042", shippingAddress, billingAddress);
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

        String url = BASE_URL + "/create";

        //Saving book 1
        ResponseEntity<Seller> response1 = testRestTemplate.postForEntity(url, seller1, Seller.class);

        assertNotNull(response1);
        assertNotNull(response1.getBody());

        System.out.println("Saved Seller: " + response1.getBody());
    }
}