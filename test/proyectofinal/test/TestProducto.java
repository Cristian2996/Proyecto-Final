package proyectofinal.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proyectofinal.Impl.*;
import proyectofinal.dao.*;
import proyectofinal.entidades.*;

public class TestProducto {

    public TestProducto() {
    }
    @Test
    public void pruebageneral() throws Exception{
        int filasAfectadas =0;
        IProducto productoDao = new ProductoImpl();
        Producto producto = new Producto(1,"Aceite",20,1.40,28.0,new Date());
        try{
            filasAfectadas = productoDao.insertar(producto);
            System.out.println("Producto ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        
        Producto productoo=new Producto();
        try {
            productoo=productoDao.obtener(1);
            System.out.println("Codigo  :"+productoo.getCodigoP());
            System.out.println("Nombre :"+productoo.getProducto());
            System.out.println("Apellido :"+productoo.getCantidad());
            System.out.println("Cedula :"+productoo.getPrecio_unitario());
            System.out.println("Direccion :"+productoo.getPrecio_total());
            System.out.println("Telefono :"+productoo.getFecha_anulacion());
            
        } catch (Exception e) {
        }

        List<Producto> lista = new ArrayList<>();
        try {
            lista = productoDao.obtener();
            for (Producto c:lista){
            System.out.println("Datos Producto");
            System.out.println("Codigo  :"+productoo.getCodigoP());
            System.out.println("Nombre :"+productoo.getProducto());
            System.out.println("Apellido :"+productoo.getCantidad());
            System.out.println("Cedula :"+productoo.getPrecio_unitario());
            System.out.println("Direccion :"+productoo.getPrecio_total());
            System.out.println("Telefono :"+productoo.getFecha_anulacion());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }   
}


