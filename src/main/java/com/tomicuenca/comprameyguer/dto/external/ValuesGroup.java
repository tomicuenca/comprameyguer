package com.tomicuenca.comprameyguer.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ValuesGroup {
    @JsonProperty("value_avg")
    private Double averageValue;

    @JsonProperty("value_sell")
    private Double sellValue;

    @JsonProperty("value_buy")
    private Double buyValue;
}
