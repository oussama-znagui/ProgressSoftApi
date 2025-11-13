package com.znagui.ProgressSoftApi.dto.deal;

import com.znagui.ProgressSoftApi.validation.api.ValidCurrencyISO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class DealRequestDTO {
    @NotBlank(message = "Deal ID pleaase !")
    private String DealId;
    @ValidCurrencyISO
    @NotBlank(message = "From Currency code pleaase !")
    private String fromCurrencyCode;
    @ValidCurrencyISO
    @NotBlank(message = "From Currency code pleaase !")
    private String toCurrencyCode;
    @Min(0)
    @NotNull(message = "Deal amount please !")
    private Double DealAmount;
}
