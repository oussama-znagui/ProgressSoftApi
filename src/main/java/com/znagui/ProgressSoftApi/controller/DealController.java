package com.znagui.ProgressSoftApi.controller;

import com.znagui.ProgressSoftApi.dto.deal.DealRequestDTO;
import com.znagui.ProgressSoftApi.dto.deal.DealResponseDTO;
import com.znagui.ProgressSoftApi.service.DealService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/deals")
public class DealController {
    private final DealService dealService;

    @GetMapping
    public String getAllDeals() {
        return "hello";
    }

    @PostMapping
    public ResponseEntity<DealResponseDTO> addDeal(@Valid @RequestBody DealRequestDTO dealRequestDTO) {
        return ResponseEntity.ok(dealService.addDeal(dealRequestDTO));
    }
}
