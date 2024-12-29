package com.Sena_Market.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;

@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {
    @Autowired
    private DataSource dataSource;

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
}
