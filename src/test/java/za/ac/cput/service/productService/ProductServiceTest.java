package za.ac.cput.service.productService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private static Product prod1;
    private static Product prod2;
    private static Product prod3;
    private Product savedProduct,savedProduct2,savedProduct1;
    byte[] photo1;
    byte[] photo2;
    byte[] photo3;

    static BufferedImage image;
    static ByteArrayOutputStream out;

    static BufferedImage image1;
    static ByteArrayOutputStream out1;

    static BufferedImage image2;
    static ByteArrayOutputStream out2;

    @BeforeAll
    static void setUp() {
        String url = "images/Umleqwa.jpeg";
        String url1 = "images/tupperwar.jpeg";
        String url2 = "images/iphone-x-silver.jpg";
        try {

            image = ImageIO.read(new File(url));
            out = new ByteArrayOutputStream();
            ImageIO.write(image, "png", out);


            image1 = ImageIO.read(new File(url1));
            out1 = new ByteArrayOutputStream();
            ImageIO.write(image1, "jpg", out1);


            image2 = ImageIO.read(new File(url2));
            out2 = new ByteArrayOutputStream();
            ImageIO.write(image2, "jpg", out2);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(out.toByteArray());




        prod1 = ProductFactory.buildProduct("Umleqwaa", 80, "Umleqwa Available ", out.toByteArray());
        System.out.println(prod1);
        prod2 = ProductFactory.buildProduct("tupper wear", 700, "Tupperwear skhaftn ",out1.toByteArray());
        System.out.println(prod2);
        prod3 = ProductFactory.buildProduct("Iphone 12 Pro", 9000, "Iphone Available", out2.toByteArray());
        System.out.println(prod3);
    }

    @Test
    void create() {
        System.out.println("===========================CREATE========================================");

        savedProduct = productService.create(prod1);
        assertNotNull(savedProduct);
        System.out.println(savedProduct);


        savedProduct1 = productService.create(prod2);
        assertNotNull(savedProduct1);
        System.out.println(savedProduct1);


        savedProduct2 = productService.create(prod3);
        assertNotNull(savedProduct2);
        System.out.println(savedProduct2);

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