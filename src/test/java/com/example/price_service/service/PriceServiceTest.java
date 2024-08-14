package com.example.price_service.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.price_service.modelo.Price;
import com.example.price_service.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void Test1() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        int productId = 35455;
        int brandId = 1;

        Price expectedPrice = new Price(); // Configura el objeto Price esperado
        when(priceRepository.findFirstApplicablePrice(productId, brandId, applicationDate))
                .thenReturn(Optional.of(expectedPrice));

        Optional<Price> actualPrice = priceService.getPrice(productId, brandId, applicationDate);
        assertEquals(Optional.of(expectedPrice), actualPrice);
    }

    @Test
    void Test2() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);
        int productId = 35455;
        int brandId = 1;

        Price expectedPrice = new Price(); // Configura el objeto Price esperado
        when(priceRepository.findFirstApplicablePrice(productId, brandId, applicationDate))
                .thenReturn(Optional.of(expectedPrice));

        Optional<Price> actualPrice = priceService.getPrice(productId, brandId, applicationDate);
        assertEquals(Optional.of(expectedPrice), actualPrice);
    }

    @Test
    void Test3() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0);
        int productId = 35455;
        int brandId = 1;

        Price expectedPrice = new Price(); // Configura el objeto Price esperado
        when(priceRepository.findFirstApplicablePrice(productId, brandId, applicationDate))
                .thenReturn(Optional.of(expectedPrice));

        Optional<Price> actualPrice = priceService.getPrice(productId, brandId, applicationDate);
        assertEquals(Optional.of(expectedPrice), actualPrice);
    }

    @Test
    void Test4() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0);
        int productId = 35455;
        int brandId = 1;

        Price expectedPrice = new Price(); // Configura el objeto Price esperado
        when(priceRepository.findFirstApplicablePrice(productId, brandId, applicationDate))
                .thenReturn(Optional.of(expectedPrice));

        Optional<Price> actualPrice = priceService.getPrice(productId, brandId, applicationDate);
        assertEquals(Optional.of(expectedPrice), actualPrice);
    }

    @Test
    void Test5() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0);
        int productId = 35455;
        int brandId = 1;

        Price expectedPrice = new Price(); // Configura el objeto Price esperado
        when(priceRepository.findFirstApplicablePrice(productId, brandId, applicationDate))
                .thenReturn(Optional.of(expectedPrice));

        Optional<Price> actualPrice = priceService.getPrice(productId, brandId, applicationDate);
        assertEquals(Optional.of(expectedPrice), actualPrice);
    }


}