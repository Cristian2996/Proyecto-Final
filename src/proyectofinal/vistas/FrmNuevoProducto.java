/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.JOptionPane;
import proyectofinal.Impl.ProductoImpl;
import proyectofinal.dao.IProducto;
import proyectofinal.entidades.Producto;

/**
 *
 * @author CRISTIAN
 */
public class FrmNuevoProducto extends JInternalFrame {
    JLabel Titulo;
    JLabel CodigoP;
    JLabel Producto;
    JLabel Cantidad;
    JLabel Precio_unitario;
    JLabel Precio_total;
    JLabel Fecha_anulacion;
        
    JTextField txtCodigoP;
    JTextField txtProducto;
    JTextField txtCantidad;
    JTextField txtPrecio_unitario;
    JTextField txtPrecio_total;
    JTextField txtFecha_anulacion;
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoProducto() {
        this.setSize(300,300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(8,2,5,5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        Titulo = new JLabel("Datos Producto");
        CodigoP = new JLabel("Codigo:");
        Producto = new JLabel("Producto:");
        Cantidad = new JLabel("Cantidad:");
        Precio_unitario = new JLabel("Precio Unitario:");
        Precio_total = new JLabel("Precio Total:");
        Fecha_anulacion = new JLabel ("Fecha de Anulacion");
                
        txtCodigoP = new JTextField(2);
        txtProducto = new JTextField(2);
        txtCantidad = new JTextField(2);
        txtPrecio_unitario = new JTextField(2);
        txtPrecio_total = new JTextField(2);
        txtFecha_anulacion = new JTextField(2);
                
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");
        
        pnlCentral.add(CodigoP);
        pnlCentral.add(txtCodigoP);
        pnlCentral.add(Producto);
        pnlCentral.add(txtProducto);
        pnlCentral.add(Cantidad);
        pnlCentral.add(txtCantidad);
        pnlCentral.add(Precio_unitario);
        pnlCentral.add(txtPrecio_unitario);
        pnlCentral.add(Precio_total);
        pnlCentral.add(txtPrecio_total);
        pnlCentral.add(Fecha_anulacion);
        pnlCentral.add(txtFecha_anulacion);
               
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        this.add(Titulo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        
        FrmNuevoProducto frmMenu= new FrmNuevoProducto();
        frmMenu.setVisible(true);
    } 
     public void btnAceptarActionListener(ActionEvent e){
        Producto producto = new Producto();
        IProducto productoDao = new ProductoImpl();
        producto.setCodigoP(Integer.parseInt(txtCodigoP.getText()));
        producto.setProducto(txtProducto.getText());
        producto.setCantidad(Integer.parseInt(txtCantidad.getText()));
        producto.setPrecio_unitario(Double.parseDouble(txtPrecio_unitario.getText()));
        producto.setPrecio_total(Double.parseDouble(txtPrecio_total.getText()));
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            producto.setFecha_anulacion(formatoFecha.parse(txtFecha_anulacion.getText()));
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en la fecha!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }      

        try {
            if (productoDao.insertar(producto) > 0) {
                JOptionPane.showMessageDialog(this, "Registrado correctamente!!",
                        "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            } else {
            JOptionPane.showMessageDialog(this,"Error desconocido: ",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
}
