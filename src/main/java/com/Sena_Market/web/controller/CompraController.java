package com.Sena_Market.web.controller;

import com.Sena_Market.domain.Service.CompraService;
import com.Sena_Market.domain.dto.CompraRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compraconfirm")
@CrossOrigin(origins = "http://localhost:4200")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/efectivo")
    public ResponseEntity<String> registrarCompra(@RequestBody CompraRequest compraRequest) {
        try {
            compraService.registrarCompra(compraRequest);
            return ResponseEntity.ok("Compra registrada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar la compra: " + e.getMessage());
        }
    }

}
