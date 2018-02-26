/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.dao;

import java.util.List;
import proyectofinal.entidades.Proveedor;

public interface IProveedor {
  public int insertar(Proveedor proveedor) throws Exception;
    public int modificar(Proveedor proveedor) throws Exception;
    public int eliminar(Proveedor proveedor) throws Exception;
    public Proveedor obtener(int codigoPv) throws Exception;
    public List<Proveedor> obtener() throws Exception;   
}
