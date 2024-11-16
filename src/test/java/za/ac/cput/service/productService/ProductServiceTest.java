package za.ac.cput.service.productService;

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
    private Product prod1;
    private Product savedProduct;
    byte[] photo;

    static BufferedImage image;
    static ByteArrayOutputStream out;

    @BeforeEach
    void setUp() {
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


        prod1 = ProductFactory.buildProduct("Laptop", 5000, "Lenovo Laptop", photo);
    }

    @Test
    void create() {
        System.out.println("===========================CREATE========================================");

        savedProduct = productService.create(prod1);
        assertNotNull(savedProduct);
        System.out.println(savedProduct);

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