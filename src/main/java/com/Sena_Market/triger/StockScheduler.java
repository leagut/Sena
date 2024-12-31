package com.Sena_Market.triger;


import com.Sena_Market.persistence.crud.ProductoRepository2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StockScheduler {

    private final ProductoRepository2 productoRepository;

    public StockScheduler(ProductoRepository2 productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Scheduled(cron = "0 0 * * * ?") // Se ejecuta cada hora en el minuto 0
    public void ejecutarStockSP() {
        productoRepository.getLowStockProducts(); // Llama al SP desde el repositorio
        System.out.println("SP ejecutado automáticamente: " + LocalDateTime.now());
    }

}
