package org.example.java11.misc.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
// @AllArgsConstructor
// @RequiredArgsConstructor
@Builder
public class Laptop { // POJO Plain Old Java Object

    private String brand;
    private final BigDecimal price;

}
