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
import proyectofinal.Impl.ProductoImpl;
import proyectofinal.dao.IProducto;
import proyectofinal.entidades.Producto;

/**
 *
 * @author CRISTIAN
 */
public class FrmListaProducto extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;

    public FrmListaProducto() {
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo =new JLabel("Listado Producto");
    tabla = new JTable();
    jscTabla= new JScrollPane(tabla); 
    this.add(lblTitulo, BorderLayout.NORTH);
    this.add(jscTabla, BorderLayout.CENTER);
    cargarTabla();
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio unitario");
        modelo.addColumn("Precio Total");
        modelo.addColumn("Fecha de Anulacion");
        modelo.addColumn("Sexo");
        
        List<Producto>lista= new ArrayList<>();
        try {
            IProducto productoDao = new ProductoImpl();
            lista = productoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Producto cli : lista){
            modelo.addRow(new Object[]{ cli.getCodigoP(),cli.getProducto(),cli.getCantidad(),cli.getPrecio_unitario()
                    ,cli.getPrecio_total(),cli.getFecha_anulacion().toString()});
        }
        tabla.setModel(modelo);
    }
}
