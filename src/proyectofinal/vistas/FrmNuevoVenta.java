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
import proyectofinal.Impl.*;
import proyectofinal.dao.*;
import proyectofinal.entidades.*;

/**
 *
 * @author CRISTIAN
 */
public class FrmNuevoVenta extends JInternalFrame{
    List<Cliente> lstCliente;
    JComboBox<Cliente> cmbCliente;
    List<Vendedor> lstVendedor;
    JComboBox<Vendedor> cmbVendedor;
    JLabel lblCodigoVen;
    JLabel lblCliente;
    JLabel lblVendedor;
    JLabel lblFecha_emi;
    JLabel lblFecha_anu;
    JLabel lblTitulo;
    
    JTextField txtCodigoVen;
    JTextField txtFecha_emi;
    JTextField txtFecha_anu;
       
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoVenta() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(6, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo = new JLabel("Datos Venta");
        
        lblCodigoVen= new JLabel("Código:");
        lblCliente= new JLabel("Cliente:");
        lblVendedor= new JLabel("Vendedor:");
        lblFecha_emi= new JLabel("Fecha Emision:");
        lblFecha_anu= new JLabel("Fecha Anulacion:");
        
        txtCodigoVen = new JTextField(2);
        cargarCliente();
        cmbCliente= new JComboBox(lstCliente.toArray());
        cargarVendedor();
        cmbVendedor= new JComboBox(lstVendedor.toArray());
        txtFecha_emi= new JTextField(2);
        txtFecha_anu= new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigoVen);
        pnlCentral.add(txtCodigoVen);
        pnlCentral.add(lblCliente);
        pnlCentral.add(cmbCliente);
        pnlCentral.add(lblVendedor);
        pnlCentral.add(cmbVendedor);
        pnlCentral.add(lblFecha_emi);
        pnlCentral.add(txtFecha_emi);
        pnlCentral.add(lblFecha_anu);
        pnlCentral.add(txtFecha_anu);
        
        
                
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
        FrmNuevoVenta frmMenu= new FrmNuevoVenta();
        frmMenu.setVisible(true);
    } 
    public void cargarCliente(){
        ICliente clienteDao = new ClienteImpl();
        try {
            lstCliente = clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Clientes!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void cargarVendedor(){
        IVendedor vendedorDao = new VendedorImpl();
        try {
            lstVendedor = vendedorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Vendedores!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void btnAceptarActionListener(ActionEvent e){
        Venta venta = new Venta();
        IVenta ventaDao = new VentaImpl();
        venta.setCodigoVen(Integer.parseInt(txtCodigoVen.getText()));
        venta.setCliente((Cliente) cmbCliente.getSelectedItem());
        venta.setVendedor((Vendedor) cmbVendedor.getSelectedItem());
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            venta.setFecha_emi(formatoFecha.parse(txtFecha_emi.getText()));
            venta.setFecha_anu(formatoFecha.parse(txtFecha_anu.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en la fecha!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        

        try {
            if (ventaDao.insertar(venta) > 0) {
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
