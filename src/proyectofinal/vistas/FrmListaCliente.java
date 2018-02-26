/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import proyectofinal.Impl.ClienteImpl;
import proyectofinal.dao.ICliente;
import proyectofinal.entidades.Cliente;

/**
 *
 * @author CRISTIAN
 */
public class FrmListaCliente extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;

    public FrmListaCliente() {
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo =new JLabel("Listado Cliente");
    tabla = new JTable();
    jscTabla= new JScrollPane(tabla); 
    this.add(lblTitulo, BorderLayout.NORTH);
    this.add(jscTabla, BorderLayout.CENTER);
    cargarTabla();
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cedula");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Sexo");
        
        List<Cliente>lista= new ArrayList<>();
        try {
            ICliente clienteDao = new ClienteImpl();
            lista = clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Cliente cli : lista){
            modelo.addRow(new Object[]{ cli.getCodigo_C(),cli.getNombre(),cli.getApellido(),cli.getCedula()
                    ,cli.getDireccion(),cli.getTelefono(),cli.getSexo().toString()});
        }
        tabla.setModel(modelo);
    }
    }
    

