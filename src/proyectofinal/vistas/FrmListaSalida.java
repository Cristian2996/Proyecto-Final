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
import proyectofinal.Impl.SalidaImpl;
import proyectofinal.dao.ISalida;
import proyectofinal.entidades.Salida;

/**
 *
 * @author CRISTIAN
 */
public class FrmListaSalida extends JInternalFrame {

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;

    public FrmListaSalida() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Cliente");
        tabla = new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();
    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Fecha de Registro");
        modelo.addColumn("Fecha de Salida");
        modelo.addColumn("Responsable");
        modelo.addColumn("Vendedor");
        
        List<Salida> lista = new ArrayList<>();
        try {
            ISalida salidaDao = new SalidaImpl();
            lista = salidaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for (Salida cli : lista) {
            modelo.addRow(new Object[]{cli.getCodigoS(), cli.getFecha_registro(), cli.getFecha_salida(), cli.getResponsable(),
                 cli.getVendedor().toString()});
        }
        tabla.setModel(modelo);
    }
}
