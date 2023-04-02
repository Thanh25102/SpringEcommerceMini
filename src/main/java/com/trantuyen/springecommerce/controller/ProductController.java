package com.trantuyen.springecommerce.controller;

import com.trantuyen.springecommerce.entity.Product;
import com.trantuyen.springecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private PagedResourcesAssembler<Product> pagedResourcesAssembler;

    @GetMapping("/products/random")
    public ResponseEntity<PagedModel<EntityModel<Product>>> random(@RequestParam("number") Integer number) {
        Pageable pageable = PageRequest.of(0, number);
        Page<Product> products = productRepo.findAll(pageable);
        PagedModel<EntityModel<Product>> pagedModel = pagedResourcesAssembler.toModel(products);
        return ResponseEntity.ok(pagedModel);
    }

    @GetMapping("/products")
    public ResponseEntity<PagedModel<EntityModel<Product>>> filter(
            @RequestParam(value = "categoryIdList", required = false, defaultValue = "1,2,3,4") List<Long> categoriesId,
            @RequestParam(value = "order", required = false, defaultValue = "price") String order,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "price", required = false, defaultValue = "0,30") List<Long> price,
            @RequestParam(value = "limit", required = false, defaultValue = "6") Integer limit,
            @RequestParam(value = "sort", required = false,defaultValue = "asc") String sort
    ) {
        Pageable pageable = sort.equals("desc") ? PageRequest.of(page, limit, Sort.by("price").descending()) :
                PageRequest.of(page, limit, Sort.by("price").ascending());

        Page<Product> products = productRepo.findByCategoryByCategoryIdInAndPriceBetween(categoriesId, new BigDecimal(price.get(0)), new BigDecimal(price.get(1)), pageable);
        PagedModel<EntityModel<Product>> pagedModel = pagedResourcesAssembler.toModel(products);

        return ResponseEntity.ok(pagedModel);
    }
}
