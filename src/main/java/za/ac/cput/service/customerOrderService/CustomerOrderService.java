package za.ac.cput.service.customerOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.CustomerOrderRepository;
import za.ac.cput.repository.ProductRepository;
import za.ac.cput.service.customerService.CustomerService;
import za.ac.cput.service.productService.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerOrderService implements ICustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public CustomerOrderService(CustomerOrderRepository customerOrderRepository, CustomerService customerService) {

        this.customerOrderRepository = customerOrderRepository;
        this.customerService = customerService;
    }
    @Override
    public CustomerOrder create(CustomerOrder customerOrder) {
        Customer customer = customerService.create(customerOrder.getCustomer());
        List<Product> products = customerOrder.getProducts();

        if (products != null) {
            products = products.stream()
                    .map(product -> {
                        System.out.println("comicBook: " + product );
                        if (product.getProductId() <=0 ) {
                            // If productID is null, save the comicBooks directly
                            return productService.create(product);

                        } else {

                            // If comicBookID is not null, try to find the comicBook in the repository
                            Optional<Product> existingProduct = productRepository.findById(product.getProductId());

                            // Return the existing comicBook if found, or save and return the new one if not found
                            return existingProduct.orElseGet(() -> productService.create(product));
                        }
                    })
                    .collect(Collectors.toList());
        }

        System.out.println("Comic Books: " + products);

        customerOrder = new CustomerOrder.CustomerOrderBuilder()
                .copy(customerOrder)
                .setCustomer(customer)
                .setProducts(products)
                .setStatus(customerOrder.getStatus())
                .build();


        if (customerOrder != null) {
            System.out.println("Order to be Saved: " + customerOrder);
            if(customerOrder.getOrderId() ==  null ||
                    customerOrder.getOrderId() == 0){
                System.out.println("saving new customerOrder");

                customerOrder = customerOrderRepository.save(customerOrder);
                System.out.println("Saved");
                System.out.println("Saved Order" + customerOrder);
            }else{
                System.out.println("checking if existing customerOrder exists");

                Optional<CustomerOrder> existingCustomerOrder = customerOrderRepository.findById(customerOrder.getOrderId());

                if (existingCustomerOrder.isPresent()) {
                    System.out.println("found customerOrder");
                    customerOrder = existingCustomerOrder.get();
                }}
        }

        return  customerOrder;
    }

    @Override
    public CustomerOrder read(Long id) {
       return customerOrderRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerOrder update(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    @Override
    public boolean delete(Long id) {
        customerOrderRepository.deleteById(id);
        return !customerOrderRepository.existsById(id);
    }

    @Override
    public List<CustomerOrder> getall() {
        return customerOrderRepository.findAll();
    }

    public List<CustomerOrder> findCustomerOrdersByEmail(String email) {
        return customerOrderRepository.findCustomerOrdersByCustomer_ContactEmail(email);
    }
}
