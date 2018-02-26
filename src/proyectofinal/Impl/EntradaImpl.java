/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import proyectofinal.accesodatos.Conexion;
import proyectofinal.accesodatos.Parametro;
import proyectofinal.dao.IEntrada;
import proyectofinal.dao.IProveedor;
import proyectofinal.entidades.Entrada;
import proyectofinal.entidades.Proveedor;

/**
 *
 * @author CRISTIAN
 */
public class EntradaImpl implements IEntrada {

    @Override
    public int insertar(Entrada entrada) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into entrada  values "
                + "(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, entrada.getCodigoE()));
        lstPar.add(new Parametro(2, entrada.getProveedor().getCodigoPv()));
        lstPar.add(new Parametro(3, entrada.getFactura()));
        lstPar.add(new Parametro(4, entrada.getFecha_ingreso()));
        lstPar.add(new Parametro(5, entrada.getFecha_factura()));
        lstPar.add(new Parametro(6, entrada.getVendedor()));

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
    public int modificar(Entrada entrada) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE entrada"
                + "   SET codigoE=?, codigopv=?, factura=?, fecha_ingreso=?, fecha_factura=?,vendedor=? "
                + " where codigoE=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, entrada.getCodigoE()));
        lstPar.add(new Parametro(2, entrada.getProveedor().getCodigoPv()));
        lstPar.add(new Parametro(3, entrada.getFactura()));
        lstPar.add(new Parametro(4, entrada.getFecha_ingreso()));
        lstPar.add(new Parametro(5, entrada.getFecha_factura()));
        lstPar.add(new Parametro(6, entrada.getVendedor()));

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
    public int eliminar(Entrada entrada) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM entrada  where codigoE=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, entrada.getCodigoE()));
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
    public Entrada obtener(int codigoE) throws Exception {
        Entrada entrada = null;
        Proveedor proveedor = null;
        IProveedor proveedorDao = new ProveedorImpl();
        String sql = "SELECT * FROM entrada where codigoE=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoE));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);

            while (rst.next()) {
                proveedor = new Proveedor();
                proveedor = proveedorDao.obtener(rst.getInt(2));
                entrada = new Entrada();
                entrada.setCodigoE(rst.getInt(1));
                entrada.setProveedor(proveedor);
                entrada.setFactura(rst.getInt(3));
                entrada.setFecha_ingreso(rst.getDate(4));
                entrada.setFecha_factura(rst.getDate(5));
                entrada.setVendedor(rst.getString(6));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return entrada;
    }

    @Override
    public List<Entrada> obtener() throws Exception {
        List<Entrada> lista = new ArrayList<>();
        Proveedor proveedor = null;
        IProveedor proveedorDao = new ProveedorImpl();
        String sql = "SELECT * FROM entrada ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Entrada entrada = null;
            while (rst.next()) {
                proveedor = new Proveedor();
                proveedor = proveedorDao.obtener(rst.getInt(2));
                entrada = new Entrada();
                entrada.setCodigoE(rst.getInt(1));
                entrada.setProveedor(proveedor);
                entrada.setFactura(rst.getInt(3));
                entrada.setFecha_ingreso(rst.getDate(4));
                entrada.setFecha_factura(rst.getDate(5));
                entrada.setVendedor(rst.getString(6));

                lista.add(entrada);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return lista;
    }
}
