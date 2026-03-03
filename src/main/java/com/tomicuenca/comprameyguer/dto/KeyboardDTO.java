package com.tomicuenca.comprameyguer.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class KeyboardDTO extends PeripheralDTO {
    private Integer keys;
    private Boolean mechanical;
}
