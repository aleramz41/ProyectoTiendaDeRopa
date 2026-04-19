package com.proyectotienda.model;

import java.util.ArrayList;

public class Ventas {
    private String id;
    private Cliente cliente;
    private ArrayList<VentaDetalle> detalles;
    private double total;
    private String fecha;

    public Ventas() {
    }

    public Ventas(String id, Cliente cliente, ArrayList<VentaDetalle> detalles, double total, String fecha) {
        this.id = id;
        this.cliente = cliente;
        this.detalles = detalles;
        this.total = total;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<VentaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<VentaDetalle> detalles) {
        this.detalles = detalles;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        String nombreCliente = (cliente != null) ? cliente.getNombre() : "Sin cliente";
        return "Ventas{" + "id=" + id + ", cliente=" + nombreCliente + ", total=" + total + ", fecha=" + fecha + '}';
    }
}