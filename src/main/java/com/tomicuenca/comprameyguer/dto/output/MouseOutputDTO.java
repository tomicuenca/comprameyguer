package com.tomicuenca.comprameyguer.dto.output;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MouseOutputDTO extends PeripheralOutputDTO {
    private Integer buttons;
    private Integer dpi;
}
