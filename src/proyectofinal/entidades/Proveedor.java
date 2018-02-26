/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.entidades;

/**
 *
 * @author CRISTIAN
 */
public class Proveedor {

    private int codigoPv;
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String distrito;
    private String email;
    private String telefono;
    private String sexo;

    public Proveedor() {
    }

    public Proveedor(int codigoPv, String nombre, String apellido, String cedula, String direccion, String distrito, String email, String telefono, String sexo) {
        this.codigoPv = codigoPv;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.distrito = distrito;
        this.email = email;
        this.telefono = telefono;
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCodigoPv() {
        return codigoPv;
    }

    public void setCodigoPv(int codigoPv) {
        this.codigoPv = codigoPv;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
