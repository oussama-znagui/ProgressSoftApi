package com.znagui.ProgressSoftApi.mapper;

import com.znagui.ProgressSoftApi.dto.deal.DealRequestDTO;
import com.znagui.ProgressSoftApi.dto.deal.DealResponseDTO;
import com.znagui.ProgressSoftApi.entity.Deal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DealMapper {
    Deal toEntity(DealRequestDTO dto);
    DealResponseDTO toResponseDto(Deal deal);
}
