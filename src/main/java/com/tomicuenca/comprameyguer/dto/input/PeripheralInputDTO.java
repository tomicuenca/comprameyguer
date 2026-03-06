package com.tomicuenca.comprameyguer.dto.input;

import com.tomicuenca.comprameyguer.enums.CurrencyEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class PeripheralInputDTO {
    private String model;
    private Boolean imported;
    private Double price;
    private Double weight;
    private Integer stock;
}
