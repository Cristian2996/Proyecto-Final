/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.entidades;

import java.util.Date;

public class Venta {
 int codigoVen;
 Cliente cliente;
 Vendedor vendedor;
 Date fecha_emi;
 Date fecha_anu;

    public Venta() {
    }

    public Venta(int codigoVen, Cliente cliente, Vendedor vendedor, Date fecha_emi, Date fecha_anu) {
        this.codigoVen = codigoVen;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.fecha_emi = fecha_emi;
        this.fecha_anu = fecha_anu;
    }

    public int getCodigoVen() {
        return codigoVen;
    }

    public void setCodigoVen(int codigoVen) {
        this.codigoVen = codigoVen;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Date getFecha_emi() {
        return fecha_emi;
    }

    public void setFecha_emi(Date fecha_emi) {
        this.fecha_emi = fecha_emi;
    }

    public Date getFecha_anu() {
        return fecha_anu;
    }

    public void setFecha_anu(Date fecha_anu) {
        this.fecha_anu = fecha_anu;
    }
 
}
