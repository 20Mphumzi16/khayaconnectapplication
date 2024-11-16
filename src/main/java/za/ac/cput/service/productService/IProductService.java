package za.ac.cput.service.productService;

import za.ac.cput.domain.Product;
import za.ac.cput.service.IService;

import java.util.List;

public interface IProductService extends IService<Product, Long> {
    List<Product> getall();
}

