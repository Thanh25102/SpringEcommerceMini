package com.trantuyen.springecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerModel {
    private Long id;
    private String accessToken;
    private Boolean admin;
    private String avatar;
    private String username;
    private final Integer __v = 0;
}
