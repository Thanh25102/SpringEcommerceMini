package com.trantuyen.springecommerce.controller;

import com.trantuyen.springecommerce.entity.Product;
import com.trantuyen.springecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<PagedModel<EntityModel<Product>>> filter(@RequestParam("categoryIdList") List<Integer> categoriesId, @RequestParam("order") String order,
                                                                   @RequestParam("page") String page, @RequestParam("price") List<Long> price,
                                                                   @RequestParam("sort") String sort
    ) {
        Pageable pageable = PageRequest.of(0, 10                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        );
        Page<Product> products = productRepo.findAll(pageable);
        PagedModel<EntityModel<Product>> pagedModel = pagedResourcesAssembler.toModel(products);
        return ResponseEntity.ok(pagedModel);
    }
}
