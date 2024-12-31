package com.Sena_Market.domain.Service;

import com.Sena_Market.domain.dto.VentasPorMesDTO;
import com.Sena_Market.persistence.crud.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<VentasPorMesDTO> obtenerVentasPorMes() {
        List<Object[]> resultados = stockRepository.getCantidadVendidaPorMes();
        return resultados.stream().map(obj -> {
            VentasPorMesDTO dto = new VentasPorMesDTO();
            dto.setNombreProducto((String) obj[0]);
            dto.setAnio((int) obj[1]);
            dto.setMes((int) obj[2]);
            dto.setCantidadVendida((long) obj[3]);
            return dto;
        }).collect(Collectors.toList());
    }
}
