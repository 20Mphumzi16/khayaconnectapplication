package za.ac.cput.service.sellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Seller;
import za.ac.cput.repository.SellerRepository;
import za.ac.cput.service.IService;

import java.util.List;

@Service
public class SellerService implements ISellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller create(Seller seller) {
        Seller newSeller = new Seller.SellerBuilder().copy(seller).setVerified(false).build();
        return sellerRepository.save(seller);
    }

    @Override
    public Seller read(Long aLong) {
        return sellerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Seller update(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public boolean delete(Long aLong) {
        sellerRepository.deleteById(aLong);
        return sellerRepository.existsById(aLong);
    }

    @Override
    public List<Seller> getall() {
        return sellerRepository.findAll();
    }
}
