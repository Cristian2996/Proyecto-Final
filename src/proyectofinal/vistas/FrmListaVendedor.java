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
import proyectofinal.Impl.VendedorImpl;
import proyectofinal.dao.IVendedor;
import proyectofinal.entidades.Vendedor;

/**
 *
 * @author CRISTIAN
 */
public class FrmListaVendedor extends JInternalFrame {

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;

    public FrmListaVendedor() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Vendedor");
        tabla = new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();
    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cedula");
        modelo.addColumn("Telefono");
        modelo.addColumn("Sexo");

        List<Vendedor> lista = new ArrayList<>();
        try {
            IVendedor vendedorDao = new VendedorImpl();
            lista = vendedorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for (Vendedor cli : lista) {
            modelo.addRow(new Object[]{cli.getCodigoV(), cli.getNombre(), cli.getApellido(), cli.getCedula(),
               cli.getTelefono(), cli.getSexo().toString()});
        }
        tabla.setModel(modelo);
    }
}
