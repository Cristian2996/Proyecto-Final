/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose  Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import proyectofinal.Impl.VendedorImpl;
import proyectofinal.dao.IVendedor;
import proyectofinal.entidades.Vendedor;

/**
 *
 * @author CRISTIAN
 */
public class FrmNuevoVendedor extends JInternalFrame{
   JLabel Titulo;
    JLabel CodigoV;
    JLabel Nombre;
    JLabel Apellido;
    JLabel Cedula;
    JLabel Telefono;
    JLabel Sexo;
    
    JTextField txtCodigoV;
    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtCedula;
    JTextField txtTelefono;
    JComboBox cmbSexo;
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoVendedor() {
        this.setSize(300,300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(7,2,5,5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        Titulo = new JLabel("Datos Vendedor");
        CodigoV = new JLabel("Codigo:");
        Nombre = new JLabel("Nombre");
        Apellido = new JLabel("Apellido:");
        Cedula = new JLabel("Cèdula:");
        Telefono = new JLabel ("Telefono");
        Sexo = new JLabel("Sexo");
        
        txtCodigoV = new JTextField(2);
        txtNombre = new JTextField(2);
        txtApellido = new JTextField(2);
        txtCedula = new JTextField(2);
        txtTelefono = new JTextField(2);
        cmbSexo = new JComboBox(new String[]{"Masculino","Femenino"});
        
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");
        
        pnlCentral.add(CodigoV);
        pnlCentral.add(txtCodigoV);
        pnlCentral.add(Nombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(Apellido);
        pnlCentral.add(txtApellido);
        pnlCentral.add(Cedula);
        pnlCentral.add(txtCedula);
        pnlCentral.add(Telefono);
        pnlCentral.add(txtTelefono);
        pnlCentral.add(Sexo);
        pnlCentral.add(cmbSexo);
       
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
        
        FrmNuevoVendedor frmMenu= new FrmNuevoVendedor();
        frmMenu.setVisible(true);
    } 
     public void btnAceptarActionListener(ActionEvent e){
        Vendedor vendedor = new Vendedor();
        IVendedor vendedorDao = new VendedorImpl();
        vendedor.setCodigoV(Integer.parseInt(txtCodigoV.getText()));
        vendedor.setNombre(txtNombre.getText());
        vendedor.setApellido(txtApellido.getText());
        vendedor.setCedula(txtCedula.getText());
        vendedor.setTelefono(txtTelefono.getText());
        vendedor.setSexo(cmbSexo.getSelectedIndex() == 0 ? "m" : "f");    

        try {
            if (vendedorDao.insertar(vendedor) > 0) {
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
