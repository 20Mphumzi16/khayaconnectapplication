package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private LocalDate orderDate;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    protected CustomerOrder() {
    }

    private CustomerOrder(CustomerOrderBuilder builder) {
        this.orderId = builder.orderId;
        this.orderDate = builder.orderDate;
        this.products = builder.products;
        this.totalAmount = builder.totalAmount;
        this.customer = builder.customer;
        this.status = builder.status;


    }

    public Long getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", products=" + products +
                ", totalAmount=" + totalAmount +
                ", customer=" + customer +
                ", status=" + status +
                '}';
    }

    public static class CustomerOrderBuilder {
        private Long orderId;
        private LocalDate orderDate;
        private List<Product> products;
        private double totalAmount;
        private Customer customer;
        private OrderStatus status;


        public CustomerOrderBuilder() {
        }

        public CustomerOrderBuilder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public CustomerOrderBuilder setStatus(OrderStatus status) {
            this.status = status;
            return this;
        }

        public CustomerOrderBuilder setOrderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public CustomerOrderBuilder setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public CustomerOrderBuilder setProducts(List<Product> products) {
            this.products = products;
            return this;
        }

        public CustomerOrderBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public CustomerOrderBuilder copy(CustomerOrder customerOrder) {
            this.orderId = customerOrder.orderId;
            this.orderDate = customerOrder.orderDate;

            this.totalAmount = customerOrder.totalAmount;


            return this;
        }

        public CustomerOrder build() {
            return new CustomerOrder(this);
        }
    }
}