package com.tomicuenca.comprameyguer.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class PeripheralDTO {
    private String model;
    private Boolean imported;
    private String price;
    private Double weight;
    private Integer stock;
}
