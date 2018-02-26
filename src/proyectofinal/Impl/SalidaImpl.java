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
import proyectofinal.dao.ISalida;
import proyectofinal.entidades.Salida;

public class SalidaImpl implements ISalida {

    @Override
    public int insertar(Salida salida) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Salida values (?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, salida.getCodigoS()));
        lstPar.add(new Parametro(2, salida.getFecha_registro()));
        lstPar.add(new Parametro(3, salida.getFecha_salida()));
        lstPar.add(new Parametro(4, salida.getResponsable()));
        lstPar.add(new Parametro(5, salida.getVendedor()));
        
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
    public int modificar(Salida salida) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE Salida"
                + "   SET codigoS=?, fecha_registro=?, fecha_salida=?,responsable=?,vendedor=? "
                + " where codigoS=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, salida.getCodigoS()));
        lstPar.add(new Parametro(2, salida.getFecha_registro()));
        lstPar.add(new Parametro(3, salida.getFecha_salida()));
        lstPar.add(new Parametro(4, salida.getResponsable()));
        lstPar.add(new Parametro(5, salida.getVendedor()));
        
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
    public int eliminar(Salida salida) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Salida  where codigoS=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, salida.getCodigoS()));
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
    public Salida obtener(int codigoS) throws Exception {
        Salida salida = null;
        String sql = "SELECT * FROM Salida where codigoS=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoS));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                salida = new Salida();
                salida.setCodigoS(rst.getInt(1));
                salida.setFecha_registro(rst.getDate(2));
                salida.setFecha_salida(rst.getDate(3));
                salida.setResponsable(rst.getString(4));
                salida.setVendedor(rst.getString(5));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return salida;
    }


    @Override
    public List<Salida> obtener() throws Exception {
        List<Salida> lista = new ArrayList<>();
         String sql = "SELECT * FROM Salida ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Salida salida=null;
            while (rst.next()) {
                salida = new Salida();
                salida.setCodigoS(rst.getInt(1));
                salida.setFecha_registro(rst.getDate(2));
                salida.setFecha_salida(rst.getDate(3));
                salida.setResponsable(rst.getString(4));
                salida.setVendedor(rst.getString(5));
                
                lista.add(salida);
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
