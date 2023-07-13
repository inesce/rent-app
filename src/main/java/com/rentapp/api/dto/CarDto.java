package com.rentapp.api.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private Integer productionYear;
    private BigDecimal pricePerDay;
}
