package com.example.price_service.service;

import com.example.price_service.modelo.Price;

import com.example.price_service.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public Optional<Price> getPrice(int productId, int brandId, LocalDateTime applicationDate) {
        return priceRepository.findFirstApplicablePrice(productId, brandId, applicationDate);
    }
}
