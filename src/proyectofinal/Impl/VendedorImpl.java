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
import proyectofinal.dao.IVendedor;
import proyectofinal.entidades.Vendedor;

/**
 *
 * @author CRISTIAN
 */
public class VendedorImpl implements IVendedor {

    @Override
    public int insertar(Vendedor vendedor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Vendedor values (?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, vendedor.getCodigoV()));
        lstPar.add(new Parametro(2, vendedor.getNombre()));
        lstPar.add(new Parametro(3, vendedor.getApellido()));
        lstPar.add(new Parametro(4, vendedor.getCedula()));
        lstPar.add(new Parametro(5, vendedor.getTelefono()));
        lstPar.add(new Parametro(6, vendedor.getSexo()));
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
    public int modificar(Vendedor vendedor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE Vendedor"
                + "   SET codigoV=?, nombre=?, apellido=?,cedula=?, "
                + " telefono=?, sexo=?"
                + " where codigoV=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, vendedor.getCodigoV()));
        lstPar.add(new Parametro(2, vendedor.getNombre()));
        lstPar.add(new Parametro(3, vendedor.getApellido()));
        lstPar.add(new Parametro(4, vendedor.getCedula()));
        lstPar.add(new Parametro(5, vendedor.getTelefono()));
        lstPar.add(new Parametro(6, vendedor.getSexo()));

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
    public int eliminar(Vendedor vendedor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Vendedor  where codigoV=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, vendedor.getCodigoV()));
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
    public Vendedor obtener(int codigoV) throws Exception {
        Vendedor vendedor = null;
        String sql = "SELECT * FROM Vendedor where codigoV=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoV));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                vendedor = new Vendedor();
                vendedor.setCodigoV(rst.getInt(1));
                vendedor.setNombre(rst.getString(2));
                vendedor.setApellido(rst.getString(3));
                vendedor.setCedula(rst.getString(4));
                vendedor.setTelefono(rst.getString(5));
                vendedor.setSexo(rst.getString(6));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return vendedor;
    }

    @Override
    public List<Vendedor> obtener() throws Exception {
        List<Vendedor> lista = new ArrayList<>();
         String sql = "SELECT * FROM Vendedor ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Vendedor vendedor=null;
            while (rst.next()) {
                vendedor = new Vendedor();
                vendedor.setCodigoV(rst.getInt(1));
                vendedor.setNombre(rst.getString(2));
                vendedor.setApellido(rst.getString(3));
                vendedor.setCedula(rst.getString(4));
                vendedor.setTelefono(rst.getString(5));
                vendedor.setSexo(rst.getString(6));
                
                lista.add(vendedor);
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
