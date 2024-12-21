package com.Sena_Market.domain.dto;

import java.util.List;

public class CompraRequest {

    private String direccion;
    private String numeroFactura;
    private String telefono;
    private Double total;
    private List<Preventa> preventas;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Preventa> getPreventas() {
        return preventas;
    }

    public void setPreventas(List<Preventa> preventas) {
        this.preventas = preventas;
    }
}
