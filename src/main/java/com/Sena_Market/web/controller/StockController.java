package com.Sena_Market.web.controller;

import com.Sena_Market.domain.Service.StockService;
import com.Sena_Market.domain.dto.VentasPorMesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {
    @Autowired
    private DataSource dataSource;


    @Autowired
    private StockService stockService;


    @PostMapping("/ejecutar")
    public ResponseEntity<String> ejecutarActualizarStock() {
        try (Connection connection = dataSource.getConnection();
             CallableStatement callableStatement = connection.prepareCall("{CALL ActualizarStock()}")) {
            callableStatement.execute();
            return ResponseEntity.ok("Procedimiento almacenado ejecutado con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al ejecutar el procedimiento almacenado.");
        }
    }

    @GetMapping("/por-mes")
    public List<VentasPorMesDTO> obtenerVentasPorMes() {
        return stockService.obtenerVentasPorMes();
    }



}
