package proyectofinal.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import proyectofinal.Impl.*;
import proyectofinal.dao.*;
import proyectofinal.entidades.*;

public class TestKardex {

    public TestKardex() {
    }

    @Test
    public void pruebageneral() throws Exception {
        //              INSERTAR
        int filasAfectadas = 0;
        IKardex kardexDao = new KardexImpl();
        IProducto productoDao = new ProductoImpl();
        Producto producto = productoDao.obtener(1);
        IEntrada entradaDao = new EntradaImpl();
        Entrada entrada = entradaDao.obtener(1);
        ISalida salidaDao = new SalidaImpl();
        Salida salida = salidaDao.obtener(1);
        Kardex kardex = new Kardex(3,producto,entrada,salida,"Ventas",123,1.5,1.6,12,24);
        try {
            filasAfectadas = entradaDao.insertar(entrada);
            System.out.println("Kardex ingresado!!!\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filasAfectadas > 0, true);
        //              LISTADO DE PEDIDO
        List<Kardex> lista = new ArrayList<>();
        try {
            lista = kardexDao.obtener();
            for (Kardex c : lista) {
                System.out.println("---Datos Kardex---");
                System.out.println("Codigo :" + c.getCodigoK());
                System.out.println("Fecha de Ingreso  :" + c.getProducto().getCodigoP());
                System.out.println("Proveedor  :" + c.getEntrada().getCodigoE());
                System.out.println("Factura  :" + c.getSalida().getCodigoS());
                System.out.println("Fecha de Factura :" + c.getDetalle());
                System.out.println("Vendedor :" + c.getCantidad());
                System.out.println("Vendedor :" + c.getPrecio_compra());
                System.out.println("Vendedor :" + c.getPrecio_venta());
                System.out.println("Vendedor :" + c.getStock_anterior());
                System.out.println("Vendedor :" + c.getStock_actual());

            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size() > 0);
    }
}
