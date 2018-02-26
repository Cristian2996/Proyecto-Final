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
public class KardexImpl implements IKardex {

    @Override
    public int insertar(Kardex kardex) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Kardex  values "
                + "(?,?,?,?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, kardex.getCodigoK()));
        lstPar.add(new Parametro(2, kardex.getProducto().getCodigoP()));
        lstPar.add(new Parametro(3, kardex.getEntrada().getCodigoE()));
        lstPar.add(new Parametro(4, kardex.getSalida().getCodigoS()));
        lstPar.add(new Parametro(5, kardex.getDetalle()));
        lstPar.add(new Parametro(6, kardex.getCantidad()));
        lstPar.add(new Parametro(7, kardex.getPrecio_compra()));
        lstPar.add(new Parametro(8, kardex.getPrecio_venta()));
        lstPar.add(new Parametro(9, kardex.getStock_anterior()));
        lstPar.add(new Parametro(10, kardex.getStock_actual()));

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
    public int modificar(Kardex kardex) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE Kardex"
                + "   SET codigoK=?,codigoP=?, codigoE=?, codigoS=?, detalle=?,cantidad=?,precio_compra=?,precio_venta=?,stock_anterior=?,stock_actual=? "
                + " where codigoK=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, kardex.getCodigoK()));
        lstPar.add(new Parametro(2, kardex.getProducto().getCodigoP()));
        lstPar.add(new Parametro(3, kardex.getEntrada().getCodigoE()));
        lstPar.add(new Parametro(4, kardex.getSalida().getCodigoS()));
        lstPar.add(new Parametro(5, kardex.getDetalle()));
        lstPar.add(new Parametro(6, kardex.getCantidad()));
        lstPar.add(new Parametro(7, kardex.getPrecio_compra()));
        lstPar.add(new Parametro(8, kardex.getPrecio_venta()));
        lstPar.add(new Parametro(9, kardex.getStock_anterior()));
        lstPar.add(new Parametro(10, kardex.getStock_actual()));

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
    public int eliminar(Kardex kardex) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM kardex  where codigoK=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, kardex.getCodigoK()));
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
    public Kardex obtener(int codigoK) throws Exception {
        Kardex kardex = null;
        Producto producto = null;
        IProducto productoDao = new ProductoImpl();
        Entrada entrada = null;
        IEntrada entradaDao = new EntradaImpl();
        Salida salida = null;
        ISalida salidaDao = new SalidaImpl();
        String sql = "SELECT * FROM kardex where codigoK=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoK));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);

            while (rst.next()) {
                producto = new Producto();
                producto = productoDao.obtener(rst.getInt(2));
                entrada = new Entrada();
                entrada = entradaDao.obtener(rst.getInt(3));
                salida = new Salida();
                salida = salidaDao.obtener(rst.getInt(4));
                kardex = new Kardex();
                kardex.setCodigoK(rst.getInt(1));
                kardex.setProducto(producto);
                kardex.setEntrada(entrada);
                kardex.setSalida(salida);
                kardex.setDetalle(rst.getString(5));
                kardex.setCantidad(rst.getInt(6));
                kardex.setPrecio_compra(rst.getDouble(7));
                kardex.setPrecio_venta(rst.getDouble(8));
                kardex.setStock_anterior(rst.getInt(9));
                kardex.setStock_actual(rst.getInt(10));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return kardex;
    }

    @Override
    public List<Kardex> obtener() throws Exception {
        List<Kardex> lista = new ArrayList<>();
        Producto producto = null;
        IProducto productoDao = new ProductoImpl();
        Entrada entrada = null;
        IEntrada entradaDao = new EntradaImpl();
        Salida salida = null;
        ISalida salidaDao = new SalidaImpl();
        String sql = "SELECT * FROM kardex ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Kardex kardex = null;
            while (rst.next()) {
                producto = new Producto();
                producto = productoDao.obtener(rst.getInt(2));
                entrada = new Entrada();
                entrada = entradaDao.obtener(rst.getInt(3));
                salida = new Salida();
                salida = salidaDao.obtener(rst.getInt(4));
                kardex = new Kardex();
                kardex.setCodigoK(rst.getInt(1));
                kardex.setProducto(producto);
                kardex.setEntrada(entrada);
                kardex.setSalida(salida);
                kardex.setDetalle(rst.getString(5));
                kardex.setCantidad(rst.getInt(6));
                kardex.setPrecio_compra(rst.getDouble(7));
                kardex.setPrecio_venta(rst.getDouble(8));
                kardex.setStock_anterior(rst.getInt(9));
                kardex.setStock_actual(rst.getInt(10));
                lista.add(kardex);
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
