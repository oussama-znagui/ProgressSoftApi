package com.znagui.ProgressSoftApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Deal {
    @Id
    private String DealId;
    @NotNull
    @Size(min = 3, max = 3)
    private String fromCurrencyCode;
    @NotNull
    @Size(min = 3, max = 3)
    private String toCurrencyCode;
    @NotNull
    private LocalDateTime dealTimestamp;
    @NotNull
    private Double DealAmount;

}
