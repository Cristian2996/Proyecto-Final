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
import javax.swing.*;
import proyectofinal.Impl.EntradaImpl;
import proyectofinal.Impl.ProveedorImpl;
import proyectofinal.dao.IEntrada;
import proyectofinal.dao.IProveedor;
import proyectofinal.entidades.Entrada;
import proyectofinal.entidades.Proveedor;

public class FrmNuevaEntrada extends JInternalFrame {

    List<Proveedor> lstProveedor;
    JComboBox<Proveedor> cmbProveedor;
    JLabel lblCodigoE;
    JLabel lblProveedor;
    JLabel lblFactura;
    JLabel lblFecha_ingreso;
    JLabel lblFecha_factura;
    JLabel lblVendedor;
    JLabel lblTitulo0;
    
    JTextField txtCodigoE;
    JTextField txtFactura;
    JTextField txtFecha_ingreso;
    JTextField txtFecha_factura;
    JTextField txtVendedor;    
        
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevaEntrada() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Entrada");
        
        lblCodigoE= new JLabel("Código:");
        lblProveedor= new JLabel("Proveedor:");
        lblFactura= new JLabel("Factura:");
        lblFecha_ingreso= new JLabel("Fecha Ingreso:");
        lblFecha_factura= new JLabel("Fecha Factura:");
        lblVendedor= new JLabel("Vendedor:");
        
        txtCodigoE = new JTextField(2);
        cargarProveedor();
        cmbProveedor= new JComboBox(lstProveedor.toArray());
        txtFactura= new JTextField(2);
        txtFecha_ingreso= new JTextField(2);
        txtFecha_factura= new JTextField(2);
        txtVendedor= new JTextField(2);        
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigoE);
        pnlCentral.add(txtCodigoE);
        pnlCentral.add(lblProveedor);
        pnlCentral.add(cmbProveedor);
        pnlCentral.add(lblFactura);
        pnlCentral.add(txtFactura);
        pnlCentral.add(lblFecha_ingreso);
        pnlCentral.add(txtFecha_ingreso);
        pnlCentral.add(lblFecha_factura);
        pnlCentral.add(txtFecha_factura);
        pnlCentral.add(lblVendedor);
        pnlCentral.add(txtVendedor);
                       
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
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmNuevaEntrada frmMenu= new FrmNuevaEntrada();
        frmMenu.setVisible(true);
    } 
    public void cargarProveedor(){
        IProveedor proveedorDao = new ProveedorImpl();
        try {
            lstProveedor = proveedorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Proveedores!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void btnAceptarActionListener(ActionEvent e){
        Entrada entrada = new Entrada();
        IEntrada entradaDao = new EntradaImpl();
        entrada.setCodigoE(Integer.parseInt(txtCodigoE.getText()));
        entrada.setProveedor((Proveedor) cmbProveedor.getSelectedItem());
        entrada.setFactura(Integer.parseInt(txtFactura.getText()));
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            entrada.setFecha_ingreso(formatoFecha.parse(txtFecha_ingreso.getText()));
            entrada.setFecha_factura(formatoFecha.parse(txtFecha_factura.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en la fecha!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
         
        entrada.setVendedor(txtVendedor.getText());
        

        try {
            if (entradaDao.insertar(entrada) > 0) {
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