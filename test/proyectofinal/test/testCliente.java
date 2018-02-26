package proyectofinal.test;

import java.util.ArrayList;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import proyectofinal.Impl.ClienteImpl;
import proyectofinal.dao.ICliente;
import proyectofinal.entidades.Cliente;

/**
 *
 * @author CRISTIAN
 */
public class testCliente {

    public testCliente() {
    }
    @Test
    public void pruebageneral() throws Exception{
        int filasAfectadas =0;
        ICliente clienteDao = new ClienteImpl();
        Cliente cliente = new Cliente(4,"Marlon","Morales","060313824-9","Los alamos","0938746521","M");
        try{
            filasAfectadas = clienteDao.insertar(cliente);
            System.out.println("Cliente ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        
        Cliente clientee=new Cliente();
        try {
            clientee=clienteDao.obtener(4);
            System.out.println("Codigo  :"+clientee.getCodigo_C());
            System.out.println("Nombre :"+clientee.getNombre());
            System.out.println("Apellido :"+clientee.getApellido());
            System.out.println("Cedula :"+clientee.getCedula());
            System.out.println("Direccion :"+clientee.getDireccion());
            System.out.println("Telefono :"+clientee.getTelefono());
            System.out.println("Sexo :"+clientee.getSexo());
        } catch (Exception e) {
        }

        List<Cliente> lista = new ArrayList<>();
        try {
            lista = clienteDao.obtener();
            for (Cliente c:lista){
            System.out.println("Datos Cliente");
            System.out.println("Codigo  :"+c.getCodigo_C());
            System.out.println("Nombre :"+c.getNombre());
            System.out.println("Apellido :"+c.getApellido());
            System.out.println("Cedula :"+c.getCedula());
            System.out.println("Direccion :"+c.getDireccion());
            System.out.println("Telefono :"+c.getTelefono());
            System.out.println("Sexo :"+c.getSexo());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }   
}

    

