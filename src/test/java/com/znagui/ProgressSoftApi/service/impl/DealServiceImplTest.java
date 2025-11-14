package com.znagui.ProgressSoftApi.service.impl;

import com.znagui.ProgressSoftApi.dto.deal.DealRequestDTO;
import com.znagui.ProgressSoftApi.dto.deal.DealResponseDTO;
import com.znagui.ProgressSoftApi.entity.Deal;
import com.znagui.ProgressSoftApi.exception.CurrencyCodesIdenticalException;
import com.znagui.ProgressSoftApi.mapper.DealMapper;
import com.znagui.ProgressSoftApi.repository.DealRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DealServiceImplTest {

    private DealRepository dealRepository;
    private DealMapper dealMapper;
    private DealServiceImpl dealService;

    @BeforeEach
    void setup() {
        dealRepository = mock(DealRepository.class);
        dealMapper = mock(DealMapper.class);
        dealService = new DealServiceImpl(dealRepository, dealMapper);
    }

    @Test
    void shouldSaveDealSuccessfully() {
        // Arrange
        DealRequestDTO req = new DealRequestDTO(
                "1TTR2","USD", "EUR", 1000.0
        );
        Deal mappedEntity = new Deal();

        when(dealMapper.toEntity(req)).thenReturn(mappedEntity);
        when(dealRepository.save(mappedEntity)).thenReturn(mappedEntity);
        when(dealMapper.toResponseDto(mappedEntity))
                .thenReturn(new DealResponseDTO("1TTR2", "USD", "EUR", LocalDateTime.now(),1000.00));

        // Act
        DealResponseDTO response = dealService.addDeal(req);

        // Assert
        assertNotNull(response);
        verify(dealRepository).save(mappedEntity);
        verify(dealMapper).toEntity(req);

        ArgumentCaptor<Deal> captor = ArgumentCaptor.forClass(Deal.class);
        verify(dealRepository).save(captor.capture());

        Deal savedDeal = captor.getValue();
        assertNotNull(savedDeal.getDealTimestamp());
    }

    @Test
    void shouldThrowException_WhenCurrencyCodesIdentical() {
        DealRequestDTO req = new DealRequestDTO("3ERRT","USD", "USD", 500.0);

        assertThrows(CurrencyCodesIdenticalException.class,
                () -> dealService.addDeal(req)
        );

        verifyNoInteractions(dealRepository);
    }
}