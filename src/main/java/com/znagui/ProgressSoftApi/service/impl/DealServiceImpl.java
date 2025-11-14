package com.znagui.ProgressSoftApi.service.impl;

import com.znagui.ProgressSoftApi.dto.deal.DealRequestDTO;
import com.znagui.ProgressSoftApi.dto.deal.DealResponseDTO;
import com.znagui.ProgressSoftApi.entity.Deal;
import com.znagui.ProgressSoftApi.exception.CurrencyCodesIdenticalException;
import com.znagui.ProgressSoftApi.mapper.DealMapper;
import com.znagui.ProgressSoftApi.repository.DealRepository;
import com.znagui.ProgressSoftApi.service.DealService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Currency;
@Slf4j
@AllArgsConstructor
@Service
public class DealServiceImpl  implements DealService {

    private final DealRepository dealRepository;
    private final DealMapper dealMapper;



    public DealResponseDTO addDeal(DealRequestDTO dealRequestDTO) {
        log.info("Attempting to add new deal: {}", dealRequestDTO);

        if (dealRequestDTO.getFromCurrencyCode().equals(dealRequestDTO.getToCurrencyCode())) {
            log.warn("Attempt to insert deal with IDENTICAL currency codes: {} / {}",
                    dealRequestDTO.getFromCurrencyCode(), dealRequestDTO.getToCurrencyCode());            throw new CurrencyCodesIdenticalException();
            }
            Deal deal = dealMapper.toEntity(dealRequestDTO);
            deal.setDealTimestamp(LocalDateTime.now());
        log.debug("Mapped deal entity before saving: {}", deal);
        Deal savedDeal = dealRepository.save(deal);
        log.info("Deal successfully saved with id: {}", savedDeal.getDealId());

        return dealMapper.toResponseDto(savedDeal);
    }
}
