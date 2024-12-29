package com.Sena_Market.web.controller;

import com.Sena_Market.domain.Service.CompraService;
import com.Sena_Market.domain.dto.CompraRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/compraconfirm")
@CrossOrigin(origins = "http://localhost:4200")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/efectivo")
    public ResponseEntity<Map<String, String>> registrarCompra(@RequestBody CompraRequest compraRequest) {
        try {
            compraService.registrarCompra(compraRequest);
            return ResponseEntity.ok(Collections.singletonMap("message", "Compra registrada exitosamente."));
        } catch (DataIntegrityViolationException e) {
            // Maneja errores de restricción de base de datos
            if (e.getMessage().contains("UK415938u2a4qf899crw9fx4n57")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Collections.singletonMap("error", "La factura ya ha sido gestionada."));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Error de integridad en la base de datos."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Error al registrar la compra: " + e.getMessage()));
        }
    }

}
