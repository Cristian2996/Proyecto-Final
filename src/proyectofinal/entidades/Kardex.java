/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.entidades;
public class Kardex {
private int codigoK;
private Producto producto;
private Entrada entrada;
private Salida salida;
private String detalle;
private int cantidad;
private Double precio_compra;
private Double precio_venta;
private int stock_anterior;
private int stock_actual;

    public Kardex() {
    }

    public Kardex(int codigoK, Producto producto, Entrada entrada, Salida salida, String detalle, int cantidad, Double precio_compra, Double precio_venta, int stock_anterior, int stock_actual) {
        this.codigoK = codigoK;
        this.producto = producto;
        this.entrada = entrada;
        this.salida = salida;
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stock_anterior = stock_anterior;
        this.stock_actual = stock_actual;
    }

    public int getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    public int getCodigoK() {
        return codigoK;
    }

    public void setCodigoK(int codigoK) {
        this.codigoK = codigoK;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getStock_anterior() {
        return stock_anterior;
    }

    public void setStock_anterior(int stock_anterior) {
        this.stock_anterior = stock_anterior;
    }
     @Override
    public String toString() {
        return detalle;
    }

}
