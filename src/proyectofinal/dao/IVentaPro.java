/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.dao;

import java.util.List;
import proyectofinal.entidades.VentaPro;

/**
 *
 * @author CRISTIAN
 */
public interface IVentaPro {
    
    public int insertar(VentaPro ventapro) throws Exception;
    public int modificar(VentaPro ventapro) throws Exception;
    public VentaPro obtener(int codigoVP) throws Exception;
    public List<VentaPro> obtener() throws Exception;  
}
