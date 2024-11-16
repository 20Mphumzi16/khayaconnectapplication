package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorValue("Seller")
public class Seller extends User {

    @Column(nullable = false)
    private String businessName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    protected Seller() {
    }

    // Constructor using the builder
    private Seller(SellerBuilder s) {
        this.userId = s.userId;
        this.name = s.name;
        this.contact = s.contact;
        this.password = s.password;
        this.businessName = s.businessName;
        this.products = s.products;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static class SellerBuilder {

        private long userId;
        private Name name;
        private String password;
        private Contact contact;
        private String businessName;
        private List<Product> products;

        // Builder methods
        public SellerBuilder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public SellerBuilder setName(Name name) {
            this.name = name;
            return this;
        }

        public SellerBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public SellerBuilder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public SellerBuilder setBusinessName(String businessName) {
            this.businessName = businessName;
            return this;
        }

        public SellerBuilder setProducts(List<Product> products) {
            this.products = products;
            return this;
        }

        // Copy constructor
        public SellerBuilder copy(Seller s) {
            if (s.getUserId() != null) {
                this.userId = s.getUserId();
            }

            this.name = s.name;
            this.password = s.password;
            this.contact = s.contact;
            this.businessName = s.businessName;
            this.products = s.products;
            return this;
        }

        public Seller build() {
            return new Seller(this);
        }
    }

    @Override
    public String toString() {
        return "Seller{" +
                "userId=" + userId +
                ", name=" + name +
                ", contact=" + contact +
                ", businessName='" + businessName + '\'' +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return userId == seller.userId &&
                Objects.equals(name, seller.name) &&
                Objects.equals(contact, seller.contact) &&
                Objects.equals(password, seller.password) &&
                Objects.equals(businessName, seller.businessName) &&
                Objects.equals(products, seller.products);

    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, contact, password, businessName, products);
    }
}
