package com.example.price_service.Controlador;

import com.example.price_service.modelo.Price;
import com.example.price_service.service.PriceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
class PriceControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    private Price createPriceInstance(int priceList, int productId, int brandId, LocalDateTime startDate, LocalDateTime endDate, double price, int priority, String currency) {
        return new Price(null, brandId, startDate, endDate, priceList, productId, priority, price, currency);
    }

    @Test
    public void Test1() throws Exception {
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
        Price mockPrice = createPriceInstance(1, 35455, 1, startDate, endDate, 35.50, 0, "EUR");

        Mockito.when(priceService.getPrice(35455, 1, LocalDateTime.of(2020, 6, 14, 10, 0, 0)))
                .thenReturn(Optional.of(mockPrice));

        mockMvc.perform(get("/find")
                        .param("applicationDate", "2020-06-14 10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    public void Test2() throws Exception {
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
        Price mockPrice = createPriceInstance(2, 35455, 1, startDate, endDate, 25.45, 1, "EUR");

        Mockito.when(priceService.getPrice(35455, 1, LocalDateTime.of(2020, 6, 14, 16, 0, 0)))
                .thenReturn(Optional.of(mockPrice));

        mockMvc.perform(get("/find")
                        .param("applicationDate", "2020-06-14 16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    public void Test3() throws Exception {
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 20, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
        Price mockPrice = createPriceInstance(3, 35455, 1, startDate, endDate, 30.50, 1, "EUR");

        Mockito.when(priceService.getPrice(35455, 1, LocalDateTime.of(2020, 6, 14, 21, 0, 0)))
                .thenReturn(Optional.of(mockPrice));

        mockMvc.perform(get("/find")
                        .param("applicationDate", "2020-06-14 21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    public void Test4() throws Exception {
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 15, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
        Price mockPrice = createPriceInstance(4, 35455, 1, startDate, endDate, 40.00, 1, "EUR");

        Mockito.when(priceService.getPrice(35455, 1, LocalDateTime.of(2020, 6, 15, 10, 0, 0)))
                .thenReturn(Optional.of(mockPrice));

        mockMvc.perform(get("/find")
                        .param("applicationDate", "2020-06-15 10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.price").value(40.00));
    }

    @Test
    public void Test5() throws Exception {
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 16, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
        Price mockPrice = createPriceInstance(5, 35455, 1, startDate, endDate, 38.95, 1, "EUR");

        Mockito.when(priceService.getPrice(35455, 1, LocalDateTime.of(2020, 6, 16, 21, 0, 0)))
                .thenReturn(Optional.of(mockPrice));

        mockMvc.perform(get("/find")
                        .param("applicationDate", "2020-06-16 21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(5))
                .andExpect(jsonPath("$.price").value(38.95));
    }

}