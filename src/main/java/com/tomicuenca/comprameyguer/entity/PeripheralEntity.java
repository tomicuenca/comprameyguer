package com.tomicuenca.comprameyguer.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class PeripheralEntity {
    private Integer id;
    private String model;
    private Boolean imported;
    private Float price;
    private Double weight;
    private Integer stock;
}
