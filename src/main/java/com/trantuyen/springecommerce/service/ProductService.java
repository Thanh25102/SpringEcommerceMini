package com.trantuyen.springecommerce.service;

import com.trantuyen.springecommerce.entity.Product;
import com.trantuyen.springecommerce.repo.ProductRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> findTopSellingProducts(){
        Pageable pageable = PageRequest.of(0, 5);
        return productRepo.findTopSellingProducts(pageable);
    }
}
