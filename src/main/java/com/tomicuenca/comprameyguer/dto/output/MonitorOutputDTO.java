package com.tomicuenca.comprameyguer.dto.output;

import com.tomicuenca.comprameyguer.enums.PanelEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MonitorOutputDTO extends PeripheralOutputDTO {
    private Float inches;
    private PanelEnum panel;
}
