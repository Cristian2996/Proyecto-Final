/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.dao;
import java.util.ArrayList;
import java.util.*;
import proyectofinal.entidades.Cliente;

/**
 *
 * @author CRISTIAN
 */
public interface ICliente {
    public int insertar(Cliente cliente) throws Exception;
    public int modificar(Cliente cliente) throws Exception;
    public int eliminar(Cliente cliente) throws Exception;
    public Cliente obtener(int codigo_C) throws Exception;
    public List<Cliente> obtener() throws Exception; 
}
