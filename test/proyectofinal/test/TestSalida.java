/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proyectofinal.Impl.SalidaImpl;
import proyectofinal.dao.ISalida;
import proyectofinal.entidades.Salida;
/**
 *
 * @author CRISTIAN
 */
public class TestSalida {

    public TestSalida() {
    }
    @Test
    public void pruebageneral() throws Exception{
        int filasAfectadas =0;
        ISalida salidaDao = new SalidaImpl();
        Salida salida = new Salida(1,new Date(),new Date(),"Daniela","Jonathan");
        try{
            filasAfectadas = salidaDao.insertar(salida);
            System.out.println("Salida ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        
        Salida salidae=new Salida();
        try {
            salidae=salidaDao.obtener(1);
            System.out.println("Codigo  :"+salidae.getCodigoS());
            System.out.println("Fecha registro :"+salidae.getFecha_registro());
            System.out.println("Fecha Salida :"+salidae.getFecha_salida());
            System.out.println("Responsable :"+salidae.getResponsable());
            System.out.println("Vendedor :"+salidae.getVendedor());
            
        } catch (Exception e) {
        }

        List<Salida> lista = new ArrayList<>();
        try {
            lista = salidaDao.obtener();
            for (Salida c:lista){
            System.out.println("Datos Salida");
            System.out.println("Codigo  :"+salidae.getCodigoS());
            System.out.println("Fecha registro :"+salidae.getFecha_registro());
            System.out.println("Fecha Salida :"+salidae.getFecha_salida());
            System.out.println("Responsable :"+salidae.getResponsable());
            System.out.println("Vendedor :"+salidae.getVendedor());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }   
}

    

