package com.example.price_service.repository;

import static org.junit.jupiter.api.Assertions.*;
import com.example.price_service.modelo.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Sql("/test-data.sql")
class PriceRepositoryTest {

    @Autowired
    private PriceRepository priceRepository;

    @Test
    void Test1() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        int productId = 35455;
        int brandId = 1;

        Optional<Price> price = priceRepository.findFirstApplicablePrice(productId, brandId, applicationDate);
        assertTrue(price.isPresent());
        assertEquals(1, price.get().getBrandId());
        assertEquals(productId, price.get().getProductId());
        assertEquals(applicationDate.getDayOfMonth(), price.get().getStartDate().getDayOfMonth());
    }

    @Test
    void Test2() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);
        int productId = 35455;
        int brandId = 1;

        Optional<Price> price = priceRepository.findFirstApplicablePrice(productId, brandId, applicationDate);
        assertTrue(price.isPresent());
        assertEquals(1, price.get().getBrandId());
        assertEquals(productId, price.get().getProductId());
    }

    @Test
    void Test3() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0);
        int productId = 35455;
        int brandId = 1;

        Optional<Price> price = priceRepository.findFirstApplicablePrice(productId, brandId, applicationDate);
        assertTrue(price.isPresent());
        assertEquals(1, price.get().getBrandId());
        assertEquals(productId, price.get().getProductId());
    }

    @Test
    void Test4() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0);
        int productId = 35455;
        int brandId = 1;

        Optional<Price> price = priceRepository.findFirstApplicablePrice(productId, brandId, applicationDate);
        assertTrue(price.isPresent());
        assertEquals(1, price.get().getBrandId());
        assertEquals(productId, price.get().getProductId());
    }

    @Test
    void Test5() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0);
        int productId = 35455;
        int brandId = 1;

        Optional<Price> price = priceRepository.findFirstApplicablePrice(productId, brandId, applicationDate);
        assertTrue(price.isPresent());
        assertEquals(1, price.get().getBrandId());
        assertEquals(productId, price.get().getProductId());
    }

}