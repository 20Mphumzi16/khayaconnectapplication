package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Product;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {


    private Product prod1;
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
    void buildProduct() {
        assertNotNull(prod1);
        System.out.print(prod1);
    }
}