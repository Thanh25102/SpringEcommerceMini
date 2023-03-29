package com.trantuyen.springecommerce.repo;

import com.trantuyen.springecommerce.entity.Cart;
import com.trantuyen.springecommerce.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "carts", path = "carts")
public interface CartRepo extends PagingAndSortingRepository<Cart, Long> {
}