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
import proyectofinal.Impl.KardexImpl;
import proyectofinal.dao.IKardex;
import proyectofinal.entidades.Kardex;

public class FrmListaKardex extends JInternalFrame{
  JLabel lblTitulo;
    JTable tabla;
    JScrollPane jscTabla;
    DefaultTableModel modelo;

    public FrmListaKardex() {
        this.setSize(800, 700);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Kardex");
        tabla = new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();
    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Entrada");
        modelo.addColumn("Salida");
        modelo.addColumn("Detalle");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Stock anterior");
        modelo.addColumn("Stock Actual");
        modelo.addColumn("Precio de compra");
        modelo.addColumn("Precio de venta");
        
        List<Kardex> lista = new ArrayList<>();
        try {
            IKardex kardexDao = new KardexImpl();
            lista = kardexDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for (Kardex est : lista) {
            modelo.addRow(new Object[]{est.getCodigoK(), est.getProducto(),
                est.getEntrada(), est.getSalida(), est.getDetalle(),est.getCantidad(),est.getStock_anterior(),est.getStock_actual(),est.getPrecio_compra(),est.getPrecio_venta().toString()});
        }
        tabla.setModel(modelo);
    }

}

