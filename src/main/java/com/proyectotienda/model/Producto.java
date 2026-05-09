

package com.proyectotienda.model;

/**
 *
 * @author Manuela
 */
public class Producto {

    private int codigo;

    private String nombre;
    private String talla;
    private String color;
    private double precio;
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public Producto(){
    }
    

    public Producto(int codigo, String nombre, String talla, String color, double precio, int stock){
        this.codigo = codigo;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "Producto: Código = " + codigo + " | Nombre = " + nombre + " | Talla = " + talla + " | Color = " + color + " | Precio = $" + precio + " | Stock = " + stock;
    }
}


