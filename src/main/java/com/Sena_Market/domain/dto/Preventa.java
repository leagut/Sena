package com.Sena_Market.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Preventa {
    @JsonProperty("productId")
    private Integer idProducto; // ID del producto comprado
    private Double precio;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
