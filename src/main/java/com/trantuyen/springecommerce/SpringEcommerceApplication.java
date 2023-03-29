package com.trantuyen.springecommerce;

import com.github.javafaker.Faker;
import com.trantuyen.springecommerce.entity.Customer;
import com.trantuyen.springecommerce.entity.Product;
import com.trantuyen.springecommerce.repo.CartRepo;
import com.trantuyen.springecommerce.repo.CustomerRepo;
import com.trantuyen.springecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringEcommerceApplication implements CommandLineRunner {
    @Autowired
    private Faker faker;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private CartRepo cartRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringEcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        generateFakeProducts(10);
        generateFakeCustomers(10);
    }

    private void generateFakeProducts(int count) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.setName(faker.commerce().productName());
            product.setBrand(faker.company().name());
            product.setPrice(BigDecimal.valueOf(faker.number().randomDouble(2, 1, 100)));
            product.setColor(faker.commerce().color());
            product.setCategory(faker.commerce().department());
            products.add(product);
        }
        productRepo.saveAll(products);
    }

    private void generateFakeCustomers(int count) {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Customer customer = new Customer();
            customer.setName(faker.name().fullName());
            customer.setUsername(faker.internet().emailAddress());
            customer.setPassword(passwordEncoder.encode("123456"));
            customers.add(customer);
        }
        customerRepo.saveAll(customers);
    }

}
