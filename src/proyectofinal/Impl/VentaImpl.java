/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectofinal.accesodatos.Conexion;
import proyectofinal.accesodatos.Parametro;
import proyectofinal.dao.*;
import proyectofinal.entidades.*;

/**
 *
 * @author CRISTIAN
 */
public class VentaImpl implements IVenta {

    @Override
    public int insertar(Venta venta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Venta values "
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, venta.getCodigoVen()));
        lstPar.add(new Parametro(2, venta.getCliente().getCodigo_C()));
        lstPar.add(new Parametro(3, venta.getVendedor().getCodigoV()));
        lstPar.add(new Parametro(4, venta.getFecha_emi()));
        lstPar.add(new Parametro(5, venta.getFecha_anu()));
        
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
    public int modificar(Venta venta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE venta"
                + "   SET codigoVen=?, codigo_C=?, codigoV=?, fecha_emi=?,fecha_anu=? "
                + " where codigoVen=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, venta.getCodigoVen()));
        lstPar.add(new Parametro(2, venta.getCliente().getCodigo_C()));
        lstPar.add(new Parametro(3, venta.getVendedor().getCodigoV()));
        lstPar.add(new Parametro(4, venta.getFecha_emi()));
        lstPar.add(new Parametro(5, venta.getFecha_anu()));

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
    public int eliminar(Venta venta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM venta where codigoVen=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, venta.getCodigoVen()));
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
    public Venta obtener(int codigoVen) throws Exception {
        Venta venta= null;
        Cliente cliente = null;
        ICliente clienteDao = new ClienteImpl();
        Vendedor vendedor = null;
        IVendedor vendedorDao = new VendedorImpl();
        String sql = "SELECT * FROM venta where codigoVen=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoVen));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);

            while (rst.next()) {
                cliente = new Cliente();
                cliente = clienteDao.obtener(rst.getInt(2));
                vendedor = new Vendedor();
                vendedor = vendedorDao.obtener(rst.getInt(3));
                venta = new Venta();
                venta.setCodigoVen(rst.getInt(1));
                venta.setCliente(cliente);
                venta.setVendedor(vendedor);
                venta.setFecha_emi(rst.getDate(4));
                venta.setFecha_anu(rst.getDate(5));
                

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return venta;
    }

    @Override
    public List<Venta> obtener() throws Exception {
        List<Venta> lista = new ArrayList<>();
        Cliente cliente = null;
        ICliente clienteDao = new ClienteImpl();
        Vendedor vendedor = null;
        IVendedor vendedorDao = new VendedorImpl();
        String sql = "SELECT * FROM venta ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Venta venta = null;
            while (rst.next()) {
                cliente = new Cliente();
                cliente = clienteDao.obtener(rst.getInt(2));
                vendedor = new Vendedor();
                vendedor = vendedorDao.obtener(rst.getInt(3));
                venta = new Venta();
                venta.setCodigoVen(rst.getInt(1));
                venta.setCliente(cliente);
                venta.setVendedor(vendedor);
                venta.setFecha_emi(rst.getDate(4));
                venta.setFecha_anu(rst.getDate(5));
                
                lista.add(venta);
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
