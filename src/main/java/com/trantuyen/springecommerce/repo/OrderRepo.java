package com.trantuyen.springecommerce.repo;

import com.trantuyen.springecommerce.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRepo extends PagingAndSortingRepository<Order, Long> {
}