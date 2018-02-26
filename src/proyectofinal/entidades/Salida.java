/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.entidades;

import java.util.Date;

public class Salida {

    int codigoS;
    Date fecha_registro;
    Date fecha_salida;
    String responsable;
    String vendedor;

    public Salida() {
    }

    public Salida(int codigoS, Date fecha_registro, Date fecha_salida, String responsable, String vendedor) {
        this.codigoS = codigoS;
        this.fecha_registro = fecha_registro;
        this.fecha_salida = fecha_salida;
        this.responsable = responsable;
        this.vendedor = vendedor;
    }

    public int getCodigoS() {
        return codigoS;
    }

    public void setCodigoS(int codigoS) {
        this.codigoS = codigoS;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return responsable;
    }
}
