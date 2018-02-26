/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.dao;

import java.util.List;
import proyectofinal.entidades.Vendedor;

/**
 *
 * @author CRISTIAN
 */
public interface IVendedor {
    public int insertar(Vendedor vendedor) throws Exception;
    public int modificar(Vendedor vendedor) throws Exception;
    public int eliminar(Vendedor vendedor) throws Exception;
    public Vendedor obtener(int codigoV) throws Exception;
    public List<Vendedor> obtener() throws Exception; 
}
