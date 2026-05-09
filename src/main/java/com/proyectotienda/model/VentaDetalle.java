package com.proyectotienda.model;

/**
 *
 * @author aleja
 */
public class VentaDetalle {
    private int id;
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    public VentaDetalle() {
    }

    public VentaDetalle(int id, Producto producto, int cantidad, double precioUnitario) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return precioUnitario * cantidad;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "VentaDetalle{" + "id=" + id + ", producto=" + producto.getNombre() + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subtotal=" + getSubtotal() + '}';
    }
}
