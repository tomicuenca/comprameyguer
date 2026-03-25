package com.tomicuenca.comprameyguer.entity;

import com.tomicuenca.comprameyguer.enums.PanelEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MonitorEntity extends PeripheralEntity {
    private Float inches;
    private PanelEnum panel;
}
