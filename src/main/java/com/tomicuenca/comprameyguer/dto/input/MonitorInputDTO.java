package com.tomicuenca.comprameyguer.dto.input;

import com.tomicuenca.comprameyguer.dto.PeripheralDTO;
import com.tomicuenca.comprameyguer.enums.PanelEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MonitorInputDTO extends PeripheralInputDTO {
    private Float inches;
    private PanelEnum panel;
}
