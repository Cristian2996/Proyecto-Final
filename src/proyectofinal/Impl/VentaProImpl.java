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
public class VentaProImpl implements IVentaPro {

    @Override
    public int insertar(VentaPro ventapro) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into ventapro  values "
                + "(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ventapro.getVenta().getCodigoVen()));
        lstPar.add(new Parametro(2, ventapro.getProducto().getCodigoP()));
        lstPar.add(new Parametro(3, ventapro.getCantidad()));
        lstPar.add(new Parametro(4, ventapro.getPrecio_uni()));
        lstPar.add(new Parametro(5, ventapro.getPrecio_total()));
        lstPar.add(new Parametro(6, ventapro.getFecha_anulacion()));

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
    public int modificar(VentaPro ventapro) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE ventapro"
                + "   SET codigoVen=?, codigoP=?, cantidad=?, precio_uni=?, precio_total=?, fecha_anulacion=? "
                + " where codigoVP=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ventapro.getVenta().getCodigoVen()));
        lstPar.add(new Parametro(2, ventapro.getProducto().getCodigoP()));
        lstPar.add(new Parametro(3, ventapro.getCantidad()));
        lstPar.add(new Parametro(4, ventapro.getPrecio_uni()));
        lstPar.add(new Parametro(5, ventapro.getPrecio_total()));
        lstPar.add(new Parametro(6, ventapro.getFecha_anulacion()));

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
    public VentaPro obtener(int codigoVP) throws Exception {
        VentaPro ventapro = null;
        Venta venta = null;
        IVenta ventaDao = new VentaImpl();
        Producto producto = null;
        IProducto productoDao = new ProductoImpl();
        String sql = "SELECT * FROM ventapro where codigoVP=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoVP));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);

            while (rst.next()) {
                venta = new Venta();
                venta = ventaDao.obtener(rst.getInt(1));
                producto = new Producto();
                producto = productoDao.obtener(rst.getInt(2));
                ventapro = new VentaPro();
                ventapro.setVenta(venta);
                ventapro.setProducto(producto);
                ventapro.setCantidad(rst.getInt(3));
                ventapro.setPrecio_uni(rst.getDouble(4));
                ventapro.setPrecio_total(rst.getDouble(5));
                ventapro.setFecha_anulacion(rst.getDate(6));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return ventapro;
    }

    @Override
    public List<VentaPro> obtener() throws Exception {
        List<VentaPro> lista = new ArrayList<>();
        Venta venta = null;
        IVenta ventaDao = new VentaImpl();
        Producto producto = null;
        IProducto productoDao = new ProductoImpl();
        String sql = "SELECT * FROM ventapro ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            VentaPro ventapro = null;
            while (rst.next()) {
                venta = new Venta();
                venta = ventaDao.obtener(rst.getInt(1));
                producto = new Producto();
                producto = productoDao.obtener(rst.getInt(2));
                ventapro = new VentaPro();
                ventapro.setVenta(venta);
                ventapro.setProducto(producto);
                ventapro.setCantidad(rst.getInt(3));
                ventapro.setPrecio_uni(rst.getDouble(4));
                ventapro.setPrecio_total(rst.getDouble(5));
                ventapro.setFecha_anulacion(rst.getDate(6));
                
                lista.add(ventapro);
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
