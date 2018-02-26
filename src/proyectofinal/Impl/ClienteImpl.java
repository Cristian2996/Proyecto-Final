/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import proyectofinal.accesodatos.Conexion;
import proyectofinal.accesodatos.Parametro;
import proyectofinal.dao.ICliente;
import proyectofinal.entidades.Cliente;

/**
 *
 * @author CRISTIAN
 */
public class ClienteImpl implements ICliente {

    @Override
    public int insertar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Cliente values (?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodigo_C()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getApellido()));
        lstPar.add(new Parametro(4, cliente.getCedula()));
        lstPar.add(new Parametro(5, cliente.getDireccion()));
        lstPar.add(new Parametro(6, cliente.getTelefono()));
        lstPar.add(new Parametro(7, cliente.getSexo()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE Cliente"
                + "   SET codigo_C=?, nombre=?, apellido=?,cedula=?, "
                + "direccion=?, telefono=?, sexo=?"
                + " where codigo_C=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodigo_C()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getApellido()));
        lstPar.add(new Parametro(4, cliente.getCedula()));
        lstPar.add(new Parametro(5, cliente.getDireccion()));
        lstPar.add(new Parametro(6, cliente.getTelefono()));
        lstPar.add(new Parametro(7, cliente.getSexo()));

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Cliente  where codigo_C=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodigo_C()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public Cliente obtener(int codigo_C) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT * FROM Cliente where codigo_C=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo_C));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCodigo_C(rst.getInt(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellido(rst.getString(3));
                cliente.setCedula(rst.getString(4));
                cliente.setDireccion(rst.getString(5));
                cliente.setTelefono(rst.getString(6));
                cliente.setSexo(rst.getString(7));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtener() throws Exception {
        List<Cliente> lista = new ArrayList<>();
         String sql = "SELECT * FROM Cliente ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cliente cliente=null;
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCodigo_C(rst.getInt(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellido(rst.getString(3));
                cliente.setCedula(rst.getString(4));
                cliente.setDireccion(rst.getString(5));
                cliente.setTelefono(rst.getString(6));
                cliente.setSexo(rst.getString(7));

                
                
                lista.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }

}
