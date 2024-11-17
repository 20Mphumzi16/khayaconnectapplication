package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    private Cart cart1;
    byte[] photo;

    static BufferedImage image;
    static ByteArrayOutputStream out;

    @BeforeEach
    void setUp() {
        Address billingAddress = BillingAddressFactory.buildBillingAddress("card", "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");
        System.out.println(billingAddress);

        Address shippingAddress = ShippingAddressFactory.buildShippingAddress(LocalTime.of(9,52), "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");
        System.out.println(shippingAddress);

        Contact con1 = CustomerContactFactory.buildContact("leroyk@gmail.com", "0739946042", shippingAddress, billingAddress);
        Contact con2 = CustomerContactFactory.buildContact("2-mycput.za", "0739946042",  shippingAddress , billingAddress);

        Customer customer1 = CustomerFactory.buildCustomer("Leroy" , "Kulcha", "Liam","Lkulcha123",con1);

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


        Product prod1 = ProductFactory.buildProduct("Laptop", 5000, "Lenovo Laptop", photo);
        List prodList = new ArrayList();
        prodList.add(prod1);

        cart1 = CartFactory.buildCart(1L, customer1, prodList,  LocalDate.of(2022, 03, 04),  LocalDate.of(2022, 06, 04));
    }

    @Test
    void buildCart() {
        assertNotNull(cart1);
        System.out.println(cart1);
    }

    @Test
    void testBuildCart() {
    }
}