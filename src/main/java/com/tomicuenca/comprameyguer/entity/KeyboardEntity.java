package com.tomicuenca.comprameyguer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table("keyboards")
public class KeyboardEntity extends PeripheralEntity {
    @Column("key_count")
    private Integer keys;
    private Boolean mechanical;
}
