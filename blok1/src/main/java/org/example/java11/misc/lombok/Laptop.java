package org.example.java11.misc.lombok;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Laptop { // POJO Plain Old Java Object

    private final String brand;
    private final BigDecimal price;
    private String owner;
    private String cpu;
    private double cpuSpeedGHz;

}
