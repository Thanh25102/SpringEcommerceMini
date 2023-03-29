package com.trantuyen.springecommerce.repo;

import com.trantuyen.springecommerce.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepo extends PagingAndSortingRepository<Customer, Long> {
    List<Customer> findByName(@Param("name") String name);
}