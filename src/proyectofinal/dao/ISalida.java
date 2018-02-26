/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.dao;

import java.util.List;
import proyectofinal.entidades.Salida;

/**
 *
 * @author CRISTIAN
 */
public interface ISalida {
    public int insertar(Salida salida) throws Exception;
    public int modificar(Salida salida) throws Exception;
    public int eliminar(Salida salida) throws Exception;
    public Salida obtener(int codigoS) throws Exception;
    public List<Salida> obtener() throws Exception;   
}
