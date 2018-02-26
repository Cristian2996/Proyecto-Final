/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.dao;

import java.util.List;
import proyectofinal.entidades.Venta;

/**
 *
 * @author CRISTIAN
 */
public interface IVenta {
    public int insertar(Venta venta) throws Exception;
    public int modificar(Venta venta) throws Exception;
    public int eliminar(Venta venta) throws Exception;
    public Venta obtener(int codigoVen) throws Exception;
    public List<Venta> obtener() throws Exception;
}
