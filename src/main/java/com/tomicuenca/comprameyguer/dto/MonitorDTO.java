package com.tomicuenca.comprameyguer.dto;

import com.tomicuenca.comprameyguer.enums.PanelEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MonitorDTO extends PeripheralDTO {
    private Float inches;
    private PanelEnum panel;
}
