package com.Sena_Market.web.controller;

import com.Sena_Market.domain.Service.PedidoService;
import com.Sena_Market.domain.dto.PedidoPreventaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recupero")
@CrossOrigin(origins = "http://localhost:4200")
public class Confirmacompra {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/factura/{numeroFactura}")
    public PedidoPreventaDTO getPedidoPorNumeroFactura(@PathVariable("numeroFactura") String numeroFactura) {
        return pedidoService.getPedidoPorNumeroFactura(numeroFactura);
    }
}
