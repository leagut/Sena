package com.Sena_Market.web.controller;

import com.Sena_Market.domain.Service.CorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private CorreoService correoService;

    @PostMapping("/enviarCorreo")
    public void enviarPedido(@RequestBody Map<String, Object> pedido) {
        // Extraer datos del JSON
        String numeroFactura = pedido.get("numeroFactura").toString();
        String productos = pedido.get("productos").toString();
        String total = pedido.get("total").toString();

        // Crear el cuerpo del correo
        String asunto = "Nuevo Pedido Recibido - Factura N° " + numeroFactura;
        String cuerpo = "Detalles del pedido:\n" +
                "Número de Factura: " + numeroFactura + "\n" +
                "Productos: " + productos + "\n" +
                "Total: " + total + "\n";

        // Enviar el correo al mismo correo
        correoService.enviarCorreo(asunto, cuerpo);
    }

}
