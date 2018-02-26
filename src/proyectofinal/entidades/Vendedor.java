/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.entidades;
public class Vendedor {
private int codigoV;
private String nombre;
private String apellido;
private String cedula;
private String telefono;
private String sexo;

    public Vendedor() {
    }

    public Vendedor(int codigoV, String nombre, String apellido, String cedula, String telefono, String sexo) {
        this.codigoV = codigoV;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.sexo = sexo;
    }

    public int getCodigoV() {
        return codigoV;
    }

    public void setCodigoV(int codigoV) {
        this.codigoV = codigoV;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    @Override
    public String toString() {
        return nombre;
    }

}