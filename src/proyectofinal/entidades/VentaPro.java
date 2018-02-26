package proyectofinal.entidades;

import java.util.Date;

public class VentaPro {
private Venta venta;
private Producto producto;
private int cantidad;
private Double precio_uni;
private Double precio_total;
private Date fecha_anulacion;

    public VentaPro() {
    }

    public VentaPro(Venta venta, Producto producto, int cantidad, Double precio_uni, Double precio_total, Date fecha_anulacion) {
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio_uni = precio_uni;
        this.precio_total = precio_total;
        this.fecha_anulacion = fecha_anulacion;
    }

    public Date getFecha_anulacion() {
        return fecha_anulacion;
    }

    public void setFecha_anulacion(Date fecha_anulacion) {
        this.fecha_anulacion = fecha_anulacion;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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

    public Double getPrecio_uni() {
        return precio_uni;
    }

    public void setPrecio_uni(Double precio_uni) {
        this.precio_uni = precio_uni;
    }

    public Double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Double precio_total) {
        this.precio_total = precio_total;
    }

}
