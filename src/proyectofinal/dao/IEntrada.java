/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.dao;

import java.util.List;
import proyectofinal.entidades.Entrada;

/**
 *
 * @author CRISTIAN
 */
public interface IEntrada {
    
    public int insertar(Entrada entrada) throws Exception;
    public int modificar(Entrada entrada) throws Exception;
    public int eliminar(Entrada entrada) throws Exception;
    public Entrada obtener(int codigoE) throws Exception;
    public List<Entrada> obtener() throws Exception;   
}
