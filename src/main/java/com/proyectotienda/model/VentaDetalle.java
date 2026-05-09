package com.proyectotienda.model;

/**
 *
 * @author aleja
 */
public class VentaDetalle {
    private int id;
    private int idVenta;
    private int idProducto;
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    public VentaDetalle() {
    }

    public VentaDetalle(int idVenta, int idProducto, Producto producto, int cantidad, double precioUnitario) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    
    public VentaDetalle(Producto producto,int cantidad,double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    
    public VentaDetalle(int idProducto, Producto producto, int cantidad, double precioUnitario) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public VentaDetalle(int id, int idVenta, int idProducto, Producto producto, int cantidad, double precioUnitario) {
        this.id = id;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
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

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
        return "VentaDetalle{" + "id=" + id + ", idVenta=" + idVenta + ", idProducto=" + idProducto + ", producto=" + producto.getNombre() + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subtotal=" + getSubtotal() + '}';
    }
}
