package com.tomicuenca.comprameyguer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class KeyboardEntity extends PeripheralEntity {
    private Integer keys;
    private Boolean mechanical;
}
