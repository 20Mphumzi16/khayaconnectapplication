package za.ac.cput.service.sellerService;

import za.ac.cput.domain.Seller;
import za.ac.cput.service.IService;

import java.util.List;

public interface ISellerService extends IService<Seller, Long> {
    List<Seller> getall();
}
