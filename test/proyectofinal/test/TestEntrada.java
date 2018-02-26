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
import proyectofinal.Impl.*;
import proyectofinal.dao.*;
import proyectofinal.entidades.*;

public class TestEntrada {

    public TestEntrada() {
    }
    @Test
    public void pruebageneral() throws Exception {
        //              INSERTAR
        int filasAfectadas = 0;
        IEntrada entradaDao = new EntradaImpl();
        IProveedor proveedorDao = new ProveedorImpl();
        Proveedor proveedor = proveedorDao.obtener(4);
        Entrada entrada = new Entrada(3, proveedor,1,new Date(),new Date(),"Marcos");
        try {
            filasAfectadas = entradaDao.insertar(entrada);
            System.out.println("Entrada ingresado!!!\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filasAfectadas > 0, true);
        //              LISTADO DE PEDIDO
        List<Entrada> lista = new ArrayList<>();
        try {
            lista = entradaDao.obtener();
            for (Entrada c : lista) {
                System.out.println("---Datos Entrada---");
                System.out.println("Codigo :" + c.getCodigoE());
                System.out.println("Fecha de Ingreso  :" + c.getFecha_ingreso());
                System.out.println("Proveedor  :" + c.getProveedor().getCodigoPv());
                System.out.println("Factura  :" + c.getFactura());
                System.out.println("Fecha de Factura :" + c.getFecha_factura());
                System.out.println("Vendedor :" + c.getVendedor());
                
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size() > 0);
    }
}

