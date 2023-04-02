package com.trantuyen.springecommerce.controller;

import com.trantuyen.springecommerce.repo.OrderRepo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderRepo orderRepo;

    public OrderController(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
}
