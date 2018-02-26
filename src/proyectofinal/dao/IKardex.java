/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.dao;

import java.util.List;
import proyectofinal.entidades.Kardex;

/**
 *
 * @author CRISTIAN
 */
public interface IKardex {
    public int insertar(Kardex kardex) throws Exception;
    public int modificar(Kardex kardex) throws Exception;
    public int eliminar(Kardex kardex) throws Exception;
    public Kardex obtener(int codigoK) throws Exception;
    public List<Kardex> obtener() throws Exception; 
}
