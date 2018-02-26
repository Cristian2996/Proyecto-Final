/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proyectofinal.Impl.ProveedorImpl;
import proyectofinal.dao.IProveedor;
import proyectofinal.entidades.Proveedor;

public class TestProveedor {

    public TestProveedor() {
    }
     @Test
    public void pruebageneral() throws Exception{
        int filasAfectadas =0;
        IProveedor proveedorDao = new ProveedorImpl();
        Proveedor proveedor = new Proveedor(4,"Marlon","Morales","060313824-9","Chimborazo","123@gmIL.COM","Los alamos","0938746521","M");
        try{
            filasAfectadas = proveedorDao.insertar(proveedor);
            System.out.println("Proveedor ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);

        List<Proveedor> lista = new ArrayList<>();
        try {
            lista = proveedorDao.obtener();
            for (Proveedor c:lista){
            System.out.println("Datos Proveedor");
            System.out.println("Codigo  :"+c.getCodigoPv());
            System.out.println("Nombre :"+c.getNombre());
            System.out.println("Apellido :"+c.getApellido());
            System.out.println("Cedula :"+c.getCedula());
            System.out.println("Direccion :"+c.getDireccion());
             System.out.println("Direccion :"+c.getDistrito());
            System.out.println("Telefono :"+c.getEmail());
            System.out.println("Telefono :"+c.getTelefono());
            System.out.println("Sexo :"+c.getSexo());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }   
}

