package za.ac.cput.service.productService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product read(Long aLong) {
        return productRepository.findById(aLong).orElse(null);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean delete(Long aLong) {
        productRepository.deleteById(aLong);
        return productRepository.existsById(aLong);
    }
    @Override
    public List<Product> getall() {
        return productRepository.findAll();
    }
}
