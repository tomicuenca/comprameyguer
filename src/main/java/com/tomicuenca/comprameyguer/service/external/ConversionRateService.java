package com.tomicuenca.comprameyguer.service.external;

import com.tomicuenca.comprameyguer.dto.external.ConversionRateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ConversionRateService {

    private final WebClient webClient;

    private static final String URI = "https://api.bluelytics.com.ar/v2/latest";

    public ConversionRateDTO getConversionRate(){
        return webClient.get()
                .uri(URI)
                .retrieve()
                .bodyToMono(ConversionRateDTO.class)
                .block();
    }
}
