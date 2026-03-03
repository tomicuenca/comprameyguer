package com.tomicuenca.comprameyguer.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MouseDTO extends PeripheralDTO {
    private Integer buttons;
    private Integer DPI;
}
