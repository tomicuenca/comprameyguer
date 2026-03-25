package com.tomicuenca.comprameyguer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table("mice")
public class MouseEntity extends PeripheralEntity {
    private Integer buttons;
    private Integer dpi;
}