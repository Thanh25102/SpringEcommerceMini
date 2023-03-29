package com.trantuyen.springecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

public record AuthenticationResponse(@Getter String jwt) {
}
