package za.ac.cput.service.sellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.Seller;
import za.ac.cput.repository.RoleRepository;
import za.ac.cput.repository.SellerRepository;
import za.ac.cput.service.IService;

import java.util.Collections;
import java.util.List;

@Service
public class SellerService implements ISellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Seller create(Seller seller) {

        String encodedPassword = passwordEncoder.encode(seller.getPassword());
        Role adminRole = roleRepository.findByName("ROLE_SELLER")
                .orElseThrow(() -> new RuntimeException("Role not found: ROLE_CUSTOMER"));

        Seller seller1 = new Seller.SellerBuilder()
                .copy(seller)
                .setPassword(encodedPassword)
                .setVerified(false)
                .setRoles(Collections.singleton(adminRole))
                .build();

        return sellerRepository.save(seller1);
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
