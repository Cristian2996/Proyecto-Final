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
import proyectofinal.Impl.EntradaImpl;
import proyectofinal.dao.IEntrada;
import proyectofinal.entidades.Entrada;

/**
 *
 * @author CRISTIAN
 */
public class FrmListaEntrada extends JInternalFrame {

    JLabel lblTitulo;
    JTable tabla;
    JScrollPane jscTabla;
    DefaultTableModel modelo;

    public FrmListaEntrada() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Entrada");
        tabla = new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();
    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Fecha de Ingreso");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Factura");
        modelo.addColumn("Fecha de Factura");
        modelo.addColumn("Vendedor");

        List<Entrada> lista = new ArrayList<>();
        try {
            IEntrada entradaDao = new EntradaImpl();
            lista = entradaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for (Entrada est : lista) {
            modelo.addRow(new Object[]{est.getCodigoE(), est.getFecha_ingreso(),
                est.getProveedor(), est.getFactura(), est.getFecha_factura(),est.getVendedor().toString()});
        }
        tabla.setModel(modelo);
    }

}
