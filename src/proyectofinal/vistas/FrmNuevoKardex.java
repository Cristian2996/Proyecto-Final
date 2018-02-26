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
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyectofinal.Impl.*;
import proyectofinal.dao.*;
import proyectofinal.entidades.*;
public class FrmNuevoKardex extends JInternalFrame {
    List<Producto> lstProducto;
    JComboBox<Producto> cmbProducto;
    List<Entrada> lstEntrada;
    JComboBox<Entrada> cmbEntrada;
    List<Salida> lstSalida;
    JComboBox<Salida> cmbSalida;
    JLabel lblCodigoK;
    JLabel lblProducto;
    JLabel lblEntrada;
    JLabel lblSalida;
    JLabel lblDetalle;
    JLabel lblCantidad;
    JLabel lblPrecio_compra;
    JLabel lblPrecio_venta;
    JLabel lblStock_anterior;
    JLabel lblStock_actual;
    JLabel lblTitulo;
    
    JTextField txtCodigoK;
    JTextField txtDetalle;
    JTextField txtCantidad;
    JTextField txtPrecio_compra;
    JTextField txtPrecio_venta;
    JTextField txtStock_anterior;
    JTextField txtStock_actual;    
        
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoKardex() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo = new JLabel("Datos Kardex");
        
        lblCodigoK= new JLabel("Código:");
        lblProducto= new JLabel("Producto:");
        lblEntrada= new JLabel("Entrada:");
        lblSalida= new JLabel("Salida:");
        lblDetalle= new JLabel("Detalle:");
        lblCantidad= new JLabel("Cantidad:");
        lblPrecio_compra= new JLabel("Precio de compra:");
        lblPrecio_venta= new JLabel("Precio de venta:");
        lblStock_anterior= new JLabel("Stock anterior:");
        lblStock_actual= new JLabel("Stock actual:");
        
        txtCodigoK = new JTextField(2);
        cargarProducto();
        cmbProducto= new JComboBox(lstProducto.toArray());
        cargarEntrada();
        cmbEntrada= new JComboBox(lstEntrada.toArray());
        cargarSalida();
        cmbSalida= new JComboBox(lstSalida.toArray());
        txtDetalle = new JTextField(2);
        txtCantidad= new JTextField(2);
        txtPrecio_compra= new JTextField(2);
        txtPrecio_venta= new JTextField(2);
        txtStock_anterior= new JTextField(2);
        txtStock_actual= new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigoK);
        pnlCentral.add(txtCodigoK);
        pnlCentral.add(lblProducto);
        pnlCentral.add(cmbProducto);
        pnlCentral.add(lblEntrada);
        pnlCentral.add(cmbEntrada);
        pnlCentral.add(lblSalida);
        pnlCentral.add(cmbSalida);
        pnlCentral.add(lblDetalle);
        pnlCentral.add(txtDetalle);
        pnlCentral.add(lblCantidad);
        pnlCentral.add(txtCantidad);
        pnlCentral.add(lblPrecio_compra);
        pnlCentral.add(txtPrecio_compra);
        pnlCentral.add(lblPrecio_venta);
        pnlCentral.add(txtPrecio_venta);
        pnlCentral.add(lblStock_anterior);
        pnlCentral.add(txtStock_anterior);
        pnlCentral.add(lblStock_actual);
        pnlCentral.add(txtStock_actual);
                        
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
        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
}
    public static void main(String[] args) {
        FrmNuevoKardex frmMenu= new FrmNuevoKardex();
        frmMenu.setVisible(true);
    } 
    public void cargarProducto(){
        IProducto productoDao = new ProductoImpl();
        try {
            lstProducto = productoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Productos!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void cargarEntrada(){
        IEntrada entradaDao = new EntradaImpl();
        try {
            lstEntrada = entradaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar las Entradas!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void cargarSalida(){
        ISalida salidaDao = new SalidaImpl();
        try {
            lstSalida = salidaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar las Salida!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void btnAceptarActionListener(ActionEvent e){
        Kardex kardex = new Kardex();
        IKardex kardexDao = new KardexImpl();
        kardex.setCodigoK(Integer.parseInt(txtCodigoK.getText()));
        kardex.setProducto((Producto) cmbProducto.getSelectedItem());
        kardex.setEntrada((Entrada) cmbEntrada.getSelectedItem());
        kardex.setSalida((Salida) cmbSalida.getSelectedItem());
        kardex.setDetalle(txtDetalle.getText());
        kardex.setCantidad(Integer.parseInt(txtCantidad.getText()));
        kardex.setPrecio_compra(Double.parseDouble(txtPrecio_compra.getText()));
        kardex.setPrecio_venta(Double.parseDouble(txtPrecio_venta.getText()));
        kardex.setStock_anterior(Integer.parseInt(txtStock_anterior.getText()));
        kardex.setStock_actual(Integer.parseInt(txtStock_actual.getText()));

        try {
            if (kardexDao.insertar(kardex) > 0) {
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
