package com.tomicuenca.comprameyguer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@SuperBuilder
public abstract class PeripheralEntity {
    @Id
    private Long id;
    private String model;
    private Boolean imported;
    private Float price;
    private Double weight;
    private Integer stock;
}
