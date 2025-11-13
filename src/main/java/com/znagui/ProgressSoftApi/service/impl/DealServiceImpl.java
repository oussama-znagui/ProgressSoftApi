package com.znagui.ProgressSoftApi.service.impl;

import com.znagui.ProgressSoftApi.dto.deal.DealRequestDTO;
import com.znagui.ProgressSoftApi.dto.deal.DealResponseDTO;
import com.znagui.ProgressSoftApi.mapper.DealMapper;
import com.znagui.ProgressSoftApi.repository.DealRepository;
import com.znagui.ProgressSoftApi.service.DealService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Currency;

@AllArgsConstructor
@Service
public class DealServiceImpl  implements DealService {

    private final DealRepository dealRepository;
    private final DealMapper dealMapper;



    public DealResponseDTO addDeal(DealRequestDTO dealRequestDTO) {
            if (dealRequestDTO.getFromCurrencyCode().equals(dealRequestDTO.getToCurrencyCode())) {
                Currency.getInstance("A");
            }


        return null;
    }
}
