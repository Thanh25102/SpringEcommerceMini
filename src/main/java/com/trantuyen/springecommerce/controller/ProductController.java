package com.trantuyen.springecommerce.controller;

import com.trantuyen.springecommerce.entity.Product;
import com.trantuyen.springecommerce.repo.ProductRepo;
import com.trantuyen.springecommerce.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {
    private final ProductRepo productRepo;

    private final PagedResourcesAssembler<Product> pagedResourcesAssembler;

    private final ProductService productService;
    public ProductController(ProductRepo productRepo, PagedResourcesAssembler<Product> pagedResourcesAssembler, ProductService productService) {
        this.productRepo = productRepo;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
        this.productService = productService;
    }

    @GetMapping("/products/random")
    public ResponseEntity<PagedModel<EntityModel<Product>>> random(@RequestParam("number") Integer number) {
        Pageable pageable = PageRequest.of(0, number);
        Page<Product> products = productRepo.findAll(pageable);
        PagedModel<EntityModel<Product>> pagedModel = pagedResourcesAssembler.toModel(products);
        return ResponseEntity.ok(pagedModel);
    }
    @GetMapping("/products/top-selling")
    public ResponseEntity<List<Product>> topSelling() {
        Pageable pageable = PageRequest.of(0, 5);
        List<Product> products = productRepo.findTopSellingProducts(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products")
    public ResponseEntity<PagedModel<EntityModel<Product>>> filter(
            @RequestParam(value = "categoryIdList", required = false, defaultValue = "1,2,3,4") List<Long> categoriesId,
            @RequestParam(value = "sort", required = false, defaultValue = "price") String order,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "price", required = false, defaultValue = "0,30") List<Long> price,
            @RequestParam(value = "limit", required = false, defaultValue = "6") Integer limit,
            @RequestParam(value = "order", required = false, defaultValue = "desc") String sort,
            @RequestParam(value = "name", required = false, defaultValue = "") String name
    ) {
        page = page - 1;
        Pageable pageable = sort.equals("desc") ? PageRequest.of(page, limit, Sort.sort(Product.class).by(order).descending()) :
                PageRequest.of(page, limit, Sort.sort(Product.class).by(order).ascending());

        Page<Product> products = productRepo.findByCategoryByCategoryIdInAndPriceBetween(categoriesId, new BigDecimal(price.get(0)), new BigDecimal(price.get(1)), pageable,name);
        PagedModel<EntityModel<Product>> pagedModel = pagedResourcesAssembler.toModel(products);

        return ResponseEntity.ok(pagedModel);
    }

    @PostMapping("/products")
    public Product save(@RequestBody Product product) {
        Product productSaved = productRepo.save(product);
        return productRepo.findById(productSaved.getId()).get();
    }

    @PutMapping("/products")
    public Product update(@RequestBody Product product) {
        Product productSaved = productRepo.save(product);
        return productRepo.findById(productSaved.getId()).get();
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Long id) {
        productRepo.deleteById(id);
    }
}
