package com.znagui.ProgressSoftApi.service;

import com.znagui.ProgressSoftApi.dto.deal.DealRequestDTO;
import com.znagui.ProgressSoftApi.dto.deal.DealResponseDTO;

public interface DealService {
    public DealResponseDTO addDeal(DealRequestDTO dealRequestDTO);
}
