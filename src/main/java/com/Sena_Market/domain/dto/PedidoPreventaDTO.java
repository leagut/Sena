package com.Sena_Market.domain.dto;

import java.util.List;

public class PedidoPreventaDTO {
    private String numeroFactura;
    private String direccion;
    private String telefono;
    private double total;
    private List<PreventaDTO> preventas;

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<PreventaDTO> getPreventas() {
        return preventas;
    }

    public void setPreventas(List<PreventaDTO> preventas) {
        this.preventas = preventas;
    }

    public static class PreventaDTO {
        private int productId;
        private String name;
        private double price;

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

}
