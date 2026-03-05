package com.tomicuenca.comprameyguer.dto.output;

import com.tomicuenca.comprameyguer.enums.CurrencyEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class PeripheralOutputDTO {
    private String model;
    private Boolean imported;
    private Float price;
    private CurrencyEnum currency;
    private Double weight;
    private Integer stock;
}
