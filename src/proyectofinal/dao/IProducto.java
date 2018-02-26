/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.dao;

import java.util.List;
import proyectofinal.entidades.Producto;

/**
 *
 * @author CRISTIAN
 */
public interface IProducto {
    public int insertar(Producto producto) throws Exception;
    public int modificar(Producto producto) throws Exception;
    public int eliminar(Producto producto) throws Exception;
    public Producto obtener(int codigoP) throws Exception;
    public List<Producto> obtener() throws Exception; 
}
