package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String name;
    private double price;
    private String description;

    @Lob
    @Column(length=100000)
    private byte[] photo;

    public Product() {}

    public Product(Builder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.price = builder.price;
        this.description = builder.description;
        this.photo = builder.photo;
    }
    public long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(price, product.price) == 0 && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.deepEquals(photo, product.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price, description, Arrays.hashCode(photo));
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
    public static class Builder {
        private long productId;
        private String name;
        private double price;
        private String description;

        private byte[] photo;

        public Builder() {
        }

        public Builder setProductId(long productId) {
            this.productId = productId;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder setPhoto(byte[] photo) {
            this.photo = photo;
            return this;
        }
        public Product build() {
            return new Product(this);
        }
        public Builder copy(Product product) {
            this.productId = product.productId;
            this.name = product.name;
            this.price = product.price;
            this.description = product.description;
            this.photo = product.photo;
            return this;
        }
    }



}
