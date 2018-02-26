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
import proyectofinal.Impl.ProveedorImpl;
import proyectofinal.dao.IProveedor;
import proyectofinal.entidades.Proveedor;

/**
 *
 * @author CRISTIAN
 */
public class FrmListaProveedor extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;

    public FrmListaProveedor() {
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo =new JLabel("Listado Proveedor");
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
        modelo.addColumn("Distrito");
        modelo.addColumn("Email");
        modelo.addColumn("Telefono");
        modelo.addColumn("Sexo");
        
        List<Proveedor>lista= new ArrayList<>();
        try {
            IProveedor proveedorDao = new ProveedorImpl();
            lista = proveedorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Proveedor cli : lista){
            modelo.addRow(new Object[]{ cli.getCodigoPv(),cli.getNombre(),cli.getApellido(),cli.getCedula()
                    ,cli.getDireccion(),cli.getDistrito(),cli.getEmail(),cli.getTelefono(),cli.getSexo().toString()});
        }
        tabla.setModel(modelo);
    }
    
}
