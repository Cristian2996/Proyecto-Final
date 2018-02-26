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
import proyectofinal.dao.IProducto;
import proyectofinal.entidades.Producto;

/**
 *
 * @author CRISTIAN
 */
public class ProductoImpl implements IProducto {

    @Override
    public int insertar(Producto producto) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Producto values (?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getCodigoP()));
        lstPar.add(new Parametro(2, producto.getProducto()));
        lstPar.add(new Parametro(3, producto.getCantidad()));
        lstPar.add(new Parametro(4, producto.getPrecio_unitario()));
        lstPar.add(new Parametro(5, producto.getPrecio_total()));
        lstPar.add(new Parametro(6, producto.getFecha_anulacion()));

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
    public int modificar(Producto producto) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE Producto"
                + "   SET codigoP=?, producto=?, cantidad=?,precio_unitario=?, "
                + "precio_total=?, fecha_anulacion=?"
                + " where codigoP=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getCodigoP()));
        lstPar.add(new Parametro(2, producto.getProducto()));
        lstPar.add(new Parametro(3, producto.getCantidad()));
        lstPar.add(new Parametro(4, producto.getPrecio_unitario()));
        lstPar.add(new Parametro(5, producto.getPrecio_total()));
        lstPar.add(new Parametro(6, producto.getFecha_anulacion()));

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
    public int eliminar(Producto producto) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Producto  where codigoP=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getCodigoP()));
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
    public Producto obtener(int codigoP) throws Exception {
        Producto producto = null;
        String sql = "SELECT * FROM Producto where codigoP=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoP));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                producto = new Producto();
                producto.setCodigoP(rst.getInt(1));
                producto.setProducto(rst.getString(2));
                producto.setCantidad(rst.getInt(3));
                producto.setPrecio_unitario(rst.getDouble(4));
                producto.setPrecio_total(rst.getDouble(5));
                producto.setFecha_anulacion(rst.getDate(6));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return producto;
    }

    @Override
    public List<Producto> obtener() throws Exception {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Producto ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Producto producto = null;
            while (rst.next()) {
                producto = new Producto();
                producto.setCodigoP(rst.getInt(1));
                producto.setProducto(rst.getString(2));
                producto.setCantidad(rst.getInt(3));
                producto.setPrecio_unitario(rst.getDouble(4));
                producto.setPrecio_total(rst.getDouble(5));
                producto.setFecha_anulacion(rst.getDate(6));
                
                lista.add(producto);
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
