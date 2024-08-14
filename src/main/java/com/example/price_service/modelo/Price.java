package com.example.price_service.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Builder
@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private int priceList;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "priority")
    private int priority;

    @Column(name = "price")
    private double price;

    @Column(name = "curr")
    private String currency;

//    public Price(Long id, LocalDateTime startDate, LocalDateTime endDate, int brandId, int productId, int priority, double price, String curr) {
//        this.id = id;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.brandId = brandId;
//        this.productId = productId;
//        this.priority = priority;
//        this.price = price;
//        this.currency = curr;
//    }


    public Price(Long id, int brandId, LocalDateTime startDate, LocalDateTime endDate, int priceList, int productId, int priority, double price, String currency) {
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

}
