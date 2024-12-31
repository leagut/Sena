package com.Sena_Market.domain.dto;

public class VentasPorMesDTO {

    private String nombreProducto;
    private int anio;
    private int mes;
    private long cantidadVendida;

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public long getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(long cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
}
