package com.tomicuenca.comprameyguer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MouseEntity extends PeripheralEntity {
    private Integer buttons;
    private Integer DPI;
}
