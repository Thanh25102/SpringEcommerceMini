package com.trantuyen.springecommerce.repo;

import com.trantuyen.springecommerce.entity.Cart;
import com.trantuyen.springecommerce.entity.Customer;
import com.trantuyen.springecommerce.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface ProductRepo extends PagingAndSortingRepository<Order, Long> {
}