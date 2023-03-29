package com.trantuyen.springecommerce.repo;

import com.trantuyen.springecommerce.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepo extends PagingAndSortingRepository<Product, Long>, CrudRepository<Product, Long> {
    List<Product> findProductByBrandAndCategoryAndColor(String brand, String category, String color);
}