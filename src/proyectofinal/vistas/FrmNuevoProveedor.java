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
import javax.swing.*;
import proyectofinal.Impl.ProveedorImpl;
import proyectofinal.dao.IProveedor;
import proyectofinal.entidades.Proveedor;

/**
 *
 * @author CRISTIAN
 */
public class FrmNuevoProveedor extends JInternalFrame {

    JLabel Titulo;
    JLabel CodigoPv;
    JLabel Nombre;
    JLabel Apellido;
    JLabel Cedula;
    JLabel Direccion;
    JLabel Distrito;
    JLabel Email;
    JLabel Telefono;
    JLabel Sexo;

    JTextField txtCodigoPv;
    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtCedula;
    JTextField txtDireccion;
    JTextField txtDistrito;
    JTextField txtEmail;
    JTextField txtTelefono;
    JComboBox cmbSexo;
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoProveedor() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);             
        
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(9, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1, 2, 5, 5));

        Titulo = new JLabel("Datos Proveedor");
        CodigoPv = new JLabel("Codigo:");
        Nombre = new JLabel("Nombre");
        Apellido = new JLabel("Apellido:");
        Cedula = new JLabel("Cèdula:");
        Direccion = new JLabel("Direcciòn:");
        Distrito = new JLabel("Distrito:");
        Email = new JLabel("Email:");
        Telefono = new JLabel("Telefono");
        Sexo = new JLabel("Sexo");

        txtCodigoPv = new JTextField(2);
        txtNombre = new JTextField(2);
        txtApellido = new JTextField(2);
        txtCedula = new JTextField(2);
        txtDireccion = new JTextField(2);
        txtDistrito = new JTextField(2);
        txtEmail = new JTextField(2);
        txtTelefono = new JTextField(2);
        cmbSexo = new JComboBox(new String[]{"Masculino", "Femenino"});

        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");

        pnlCentral.add(CodigoPv);
        pnlCentral.add(txtCodigoPv);
        pnlCentral.add(Nombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(Apellido);
        pnlCentral.add(txtApellido);
        pnlCentral.add(Cedula);
        pnlCentral.add(txtCedula);
        pnlCentral.add(Direccion);
        pnlCentral.add(txtDireccion);
        pnlCentral.add(Distrito);
        pnlCentral.add(txtDistrito);
        pnlCentral.add(Email);
        pnlCentral.add(txtEmail);
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
                    System.out.println("Error:" + ex.getMessage());
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
        
        FrmNuevoProveedor frmMenu= new FrmNuevoProveedor();
        frmMenu.setVisible(true);
    } 
     public void btnAceptarActionListener(ActionEvent e){
        Proveedor proveedor = new Proveedor();
        IProveedor proveedorDao = new ProveedorImpl();
        proveedor.setCodigoPv(Integer.parseInt(txtCodigoPv.getText()));
        proveedor.setNombre(txtNombre.getText());
        proveedor.setApellido(txtApellido.getText());
        proveedor.setCedula(txtCedula.getText());
        proveedor.setDireccion(txtDireccion.getText());
        proveedor.setDistrito(txtDistrito.getText());
        proveedor.setEmail(txtEmail.getText());
        proveedor.setTelefono(txtTelefono.getText());
        proveedor.setSexo(cmbSexo.getSelectedIndex() == 0 ? "m" : "f");    

        try {
            if (proveedorDao.insertar(proveedor) > 0) {
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
