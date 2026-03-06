package com.tomicuenca.comprameyguer.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ConversionRateDTO {
    @JsonProperty("oficial")
    private ValuesGroup official;

    @JsonProperty("blue")
    private ValuesGroup blue;

    @JsonProperty("oficial_euro")
    private ValuesGroup officialEuro;

    @JsonProperty("blue_euro")
    private ValuesGroup blueEuro;

    @JsonProperty("last_update")
    private String lastUpdate;

}
