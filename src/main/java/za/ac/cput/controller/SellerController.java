package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Seller;
import za.ac.cput.service.customerService.CustomerService;
import za.ac.cput.service.sellerService.SellerService;

@RestController
@RequestMapping("/Seller")
public class SellerController {
    @Autowired
    private SellerService service;

    @PostMapping("/create")
    public Seller create(@RequestBody Seller seller) {
        System.out.println("Entered Seller");

        System.out.println("Seller: " + seller);

        Seller savedSeller = service.create(seller);
        System.out.println("Saved Seller: " + savedSeller);
        return savedSeller;
    }
}
