package com.znagui.ProgressSoftApi.dto.deal;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class DealResponseDTO {
    private String DealId;
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private LocalDateTime dealTimestamp;
    private Double DealAmount;
}
