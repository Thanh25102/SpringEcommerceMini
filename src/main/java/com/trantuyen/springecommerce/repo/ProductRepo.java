package com.trantuyen.springecommerce.repo;

import com.trantuyen.springecommerce.entity.Category;
import com.trantuyen.springecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.math.BigDecimal;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepo extends PagingAndSortingRepository<Product, Long>, CrudRepository<Product, Long> {
    List<Product> findProductByBrandAndColor(String brand, String color);

    @Query("SELECT p FROM Product p WHERE p.categoryByCategoryId.id IN :categoryIds and p.price between :minPrice and :maxPrice and p.name like :name")
    Page<Product> findByCategoryByCategoryIdInAndPriceBetween(List<Long> categoryIds, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable,String name);

    @Query("SELECT p FROM Product p JOIN OrderDetail od ON p.id = od.productByProductId.id JOIN Order o ON od.orderByOrderId.id = o.id "
            + "GROUP BY p.id, p.name "
            + "ORDER BY SUM(od.quantity) DESC")
    List<Product> findTopSellingProducts(Pageable pageable);
}