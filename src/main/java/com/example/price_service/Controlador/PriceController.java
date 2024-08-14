package com.example.price_service.Controlador;

import com.example.price_service.modelo.Price;
import com.example.price_service.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;
    @Operation(summary = "Find price", description = "Find a pvp single price", tags = {"price"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Price.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos proporcionados"),
            @ApiResponse(responseCode = "404", description = "Precio no encontrado")})
    @GetMapping("/find")
    public Optional<Price> getPrice(
            @RequestParam("applicationDate") String applicationDateStr,
            @RequestParam("productId") int productId,
            @RequestParam("brandId") int brandId) {

        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(applicationDate);
        return priceService.getPrice(productId, brandId, applicationDate);
    }


}
