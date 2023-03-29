package com.trantuyen.springecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "brand", nullable = false, length = 255)
    private String brand;
    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;
    @Basic
    @Column(name = "color", nullable = false, length = 255)
    private String color;
    @Basic
    @Column(name = "category", nullable = false, length = 255)
    private String category;
    @OneToMany(mappedBy = "productByProductId")
    private Set<Cart> cartsById = new HashSet<>();;
    @OneToMany(mappedBy = "productByProductId")
    private Set<OrderDetail> orderDetailsById = new HashSet<>();;
}