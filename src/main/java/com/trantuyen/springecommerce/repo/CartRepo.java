package com.trantuyen.springecommerce.repo;

import com.trantuyen.springecommerce.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "carts", path = "carts")
public interface CartRepo extends PagingAndSortingRepository<Cart, Long>, CrudRepository<Cart, Long> {
}