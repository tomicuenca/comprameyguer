package com.tomicuenca.comprameyguer.dto.input;

import com.tomicuenca.comprameyguer.dto.PeripheralDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MouseInputDTO extends PeripheralInputDTO {
    private Integer buttons;
    private Integer DPI;
}
