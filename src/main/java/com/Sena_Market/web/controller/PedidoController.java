package com.Sena_Market.web.controller;

import com.Sena_Market.domain.Preventa;
import com.Sena_Market.domain.Service.CorreoService;
import com.Sena_Market.persistence.crud.PedidoRepository;
import com.Sena_Market.persistence.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CorreoService correoService;

    @PostMapping("/enviarCorreo")
    public void enviarPedido(@RequestBody Pedido pedido) {
        // Guardar el pedido en la base de datos
        pedidoRepository.save(pedido);

        // Crear el cuerpo del correo
        StringBuilder preventasString = new StringBuilder();
        for (Preventa preventa : pedido.getPreventas()) {
            preventasString.append("- ").append(preventa.getName())
                    .append(" (ID: ").append(preventa.getProductId())
                    .append(", Precio: ").append(preventa.getPrice())
                    .append(")\n");
        }

        String asunto = "Nuevo Pedido Recibido - Factura N° " + pedido.getNumeroFactura();
        String cuerpo = "Detalles del pedido:\n" +
                "Número de Factura: " + pedido.getNumeroFactura() + "\n" +
                "Productos:\n" + preventasString +
                "Total: $" + pedido.getTotal() + "\n" +
                "Dirección: " + pedido.getDireccion() + "\n" +
                "Teléfono: " + pedido.getTelefono() + "\n";

        // Enviar el correo
        correoService.enviarCorreo(asunto, cuerpo);
    }

}
