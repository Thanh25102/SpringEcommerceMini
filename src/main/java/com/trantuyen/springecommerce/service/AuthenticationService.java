package com.trantuyen.springecommerce.service;

import com.trantuyen.springecommerce.entity.Customer;
import com.trantuyen.springecommerce.models.CustomerModel;
import com.trantuyen.springecommerce.models.RegisterModel;
import com.trantuyen.springecommerce.repo.CustomerRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final CustomerRepo customerRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthenticationService(CustomerRepo customerRepo, BCryptPasswordEncoder passwordEncoder) {
        this.customerRepo = customerRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer register(RegisterModel registerModel){
        Customer customer = new Customer();
        customer.setName(registerModel.getFullName());
        customer.setUsername(registerModel.getUsername());
        customer.setPassword(passwordEncoder.encode(registerModel.getPassword()));
        return customerRepo.save(customer);
    }
}
