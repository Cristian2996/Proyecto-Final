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
import proyectofinal.Impl.VendedorImpl;
import proyectofinal.dao.IVendedor;
import proyectofinal.entidades.Vendedor;


/**
 *
 * @author CRISTIAN
 */
public class TestVendedor {

    public TestVendedor() {
    }
    @Test
    public void pruebageneral() throws Exception{
        int filasAfectadas =0;
        IVendedor vendedorDao = new VendedorImpl();
        Vendedor vendedor = new Vendedor(1,"Josselyn","Leon","060313824-9","0986753481","F");
        try{
            filasAfectadas = vendedorDao.insertar(vendedor);
            System.out.println("Vendedor ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        
        Vendedor vendedore=new Vendedor();
        try {
            vendedore=vendedorDao.obtener(1);
            System.out.println("Codigo  :"+vendedore.getCodigoV());
            System.out.println("Nombre :"+vendedore.getNombre());
            System.out.println("Apellido:"+vendedore.getApellido());
            System.out.println("Cedula :"+vendedore.getCedula());
            System.out.println("Telefono :"+vendedore.getTelefono());
            System.out.println("Sexo :"+vendedore.getSexo());
            
        } catch (Exception e) {
        }

        List<Vendedor> lista = new ArrayList<>();
        try {
            lista = vendedorDao.obtener();
            for (Vendedor c:lista){
            System.out.println("Datos Vendedor");
            System.out.println("Codigo  :"+vendedore.getCodigoV());
            System.out.println("Nombre :"+vendedore.getNombre());
            System.out.println("Apellido:"+vendedore.getApellido());
            System.out.println("Cedula :"+vendedore.getCedula());
            System.out.println("Telefono :"+vendedore.getTelefono());
            System.out.println("Sexo :"+vendedore.getSexo());
            
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }   
}

