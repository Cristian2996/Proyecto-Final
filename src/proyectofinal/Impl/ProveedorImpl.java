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
import proyectofinal.dao.IProveedor;
import proyectofinal.entidades.Proveedor;

public class ProveedorImpl implements IProveedor {

    @Override
    public int insertar(Proveedor proveedor) throws Exception {
         int numFilasAfectadas = 0;
        String sql = "insert into Proveedor values (?,?,?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getCodigoPv()));
        lstPar.add(new Parametro(2, proveedor.getNombre()));
        lstPar.add(new Parametro(3, proveedor.getApellido()));
        lstPar.add(new Parametro(4, proveedor.getCedula()));
        lstPar.add(new Parametro(5, proveedor.getDireccion()));
        lstPar.add(new Parametro(6, proveedor.getDistrito()));
        lstPar.add(new Parametro(7, proveedor.getEmail()));
        lstPar.add(new Parametro(8, proveedor.getTelefono()));
        lstPar.add(new Parametro(9, proveedor.getSexo()));
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
    public int modificar(Proveedor proveedor) throws Exception {
       int numFilasAfectadas = 0;
        String sql = "UPDATE Proveedor"
                + "   SET codigoPv=?, nombre=?, apellido=?,cedula=?, "
                + "direccion=?,distrito=?,email=? telefono=?, sexo=?"
                + " where codigoPv=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getCodigoPv()));
        lstPar.add(new Parametro(2, proveedor.getNombre()));
        lstPar.add(new Parametro(3, proveedor.getApellido()));
        lstPar.add(new Parametro(4, proveedor.getCedula()));
        lstPar.add(new Parametro(5, proveedor.getDireccion()));
        lstPar.add(new Parametro(6, proveedor.getDistrito()));
        lstPar.add(new Parametro(7, proveedor.getEmail()));
        lstPar.add(new Parametro(8, proveedor.getTelefono()));
        lstPar.add(new Parametro(9, proveedor.getSexo()));

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
    public int eliminar(Proveedor proveedor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Proveedor  where codigoPv=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getCodigoPv()));
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
    public Proveedor obtener(int codigoPv) throws Exception {
        Proveedor proveedor = null;
        String sql = "SELECT * FROM Proveedor where codigoPv=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoPv));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                proveedor = new Proveedor();
                proveedor.setCodigoPv(rst.getInt(1));
                proveedor.setNombre(rst.getString(2));
                proveedor.setApellido(rst.getString(3));
                proveedor.setCedula(rst.getString(4));
                proveedor.setDireccion(rst.getString(5));
                proveedor.setDistrito(rst.getString(6));
                proveedor.setEmail(rst.getString(7));
                proveedor.setTelefono(rst.getString(8));
                proveedor.setSexo(rst.getString(9));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return proveedor;
    }


    @Override
    public List<Proveedor> obtener() throws Exception {
       List<Proveedor> lista = new ArrayList<>();
         String sql = "SELECT * FROM Proveedor ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Proveedor proveedor=null;
            while (rst.next()) {
                proveedor = new Proveedor();
                proveedor.setCodigoPv(rst.getInt(1));
                proveedor.setNombre(rst.getString(2));
                proveedor.setApellido(rst.getString(3));
                proveedor.setCedula(rst.getString(4));
                proveedor.setDireccion(rst.getString(5));
                proveedor.setDistrito(rst.getString(6));
                proveedor.setEmail(rst.getString(7));
                proveedor.setTelefono(rst.getString(8));
                proveedor.setSexo(rst.getString(9));                
                lista.add(proveedor);
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
