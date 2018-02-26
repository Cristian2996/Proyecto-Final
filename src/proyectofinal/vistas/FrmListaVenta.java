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
import proyectofinal.Impl.VentaImpl;
import proyectofinal.dao.IVenta;
import proyectofinal.entidades.Venta;

/**
 *
 * @author CRISTIAN
 */
public class FrmListaVenta extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    JScrollPane jscTabla;
    DefaultTableModel modelo;

    public FrmListaVenta() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado De Venta");
        tabla = new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();
    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Cliente");
        modelo.addColumn("Vendedor");
        modelo.addColumn("Fecha de emision");
        modelo.addColumn("Fecha de anulacion");
        
        List<Venta> lista = new ArrayList<>();
        try {
            IVenta ventaDao = new VentaImpl();
            lista = ventaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for (Venta est : lista) {
            modelo.addRow(new Object[]{est.getCodigoVen(), est.getCliente(),
                est.getVendedor(), est.getFecha_emi(), est.getFecha_anu().toString()});
        }
        tabla.setModel(modelo);
    }

}
