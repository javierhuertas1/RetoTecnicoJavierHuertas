package com.example.price_service.repository;

import com.example.price_service.modelo.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository  extends JpaRepository<Price, Long> {

    @Query("SELECT p FROM Price p WHERE p.productId = :productId AND p.brandId = :brandId " +
            "AND p.startDate <= :applicationDate AND p.endDate >= :applicationDate " +
            "ORDER BY p.priority DESC")
    List<Price> findAllApplicablePrices(@Param("productId") int productId,
                                        @Param("brandId") int brandId,
                                        @Param("applicationDate") LocalDateTime applicationDate);

    default Optional<Price> findFirstApplicablePrice(int productId, int brandId, LocalDateTime applicationDate) {
        List<Price> prices = findAllApplicablePrices(productId, brandId, applicationDate);
        if (prices.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(prices.get(0));
}
}
