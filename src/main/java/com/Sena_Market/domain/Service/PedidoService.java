package com.Sena_Market.domain.Service;

import com.Sena_Market.domain.Pedido;
import com.Sena_Market.domain.dto.PedidoPreventaDTO;
import com.Sena_Market.persistence.crud.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoPreventaDTO getPedidoPorNumeroFactura(String numeroFactura) {
        Pedido pedido = pedidoRepository.findByNumeroFactura(numeroFactura)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        PedidoPreventaDTO pedidoDTO = new PedidoPreventaDTO();
        pedidoDTO.setNumeroFactura(pedido.getNumeroFactura());
        pedidoDTO.setDireccion(pedido.getDireccion());
        pedidoDTO.setTelefono(pedido.getTelefono());
        pedidoDTO.setTotal(pedido.getTotal());

        pedidoDTO.setPreventas(
                pedido.getPreventas().stream().map(preventa -> {
                    PedidoPreventaDTO.PreventaDTO preventaDTO = new PedidoPreventaDTO.PreventaDTO();
                    preventaDTO.setProductId(preventa.getProductId());
                    preventaDTO.setName(preventa.getName());
                    preventaDTO.setPrice(preventa.getPrice());
                    return preventaDTO;
                }).collect(Collectors.toList())
        );

        return pedidoDTO;
    }

}
