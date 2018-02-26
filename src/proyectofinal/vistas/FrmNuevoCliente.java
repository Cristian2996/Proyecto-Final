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
import proyectofinal.Impl.ClienteImpl;
import proyectofinal.dao.ICliente;
import proyectofinal.entidades.Cliente;

/**
 *
 * @author CRISTIAN
 */
public class FrmNuevoCliente extends JInternalFrame {
    JLabel Titulo;
    JLabel Codigo_C;
    JLabel Nombre;
    JLabel Apellido;
    JLabel Cedula;
    JLabel Direccion;
    JLabel Telefono;
    JLabel Sexo;
    
    JTextField txtCodigo_C;
    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtCedula;
    JTextField txtDireccion;
    JTextField txtTelefono;
    JComboBox cmbSexo;
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoCliente() {
        this.setSize(300,300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(8,2,5,5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        Titulo = new JLabel("Datos Cliente");
        Codigo_C = new JLabel("Codigo:");
        Nombre = new JLabel("Nombre");
        Apellido = new JLabel("Apellido:");
        Cedula = new JLabel("Cèdula:");
        Direccion = new JLabel("Direcciòn:");
        Telefono = new JLabel ("Telefono");
        Sexo = new JLabel("Sexo");
        
        txtCodigo_C = new JTextField(2);
        txtNombre = new JTextField(2);
        txtApellido = new JTextField(2);
        txtCedula = new JTextField(2);
        txtDireccion = new JTextField(2);
        txtTelefono = new JTextField(2);
        cmbSexo = new JComboBox(new String[]{"Masculino","Femenino"});
        
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");
        
        pnlCentral.add(Codigo_C);
        pnlCentral.add(txtCodigo_C);
        pnlCentral.add(Nombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(Apellido);
        pnlCentral.add(txtApellido);
        pnlCentral.add(Cedula);
        pnlCentral.add(txtCedula);
        pnlCentral.add(Direccion);
        pnlCentral.add(txtDireccion);
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
        
        FrmNuevoCliente frmMenu= new FrmNuevoCliente();
        frmMenu.setVisible(true);
    } 
     public void btnAceptarActionListener(ActionEvent e){
        Cliente cliente = new Cliente();
        ICliente clienteDao = new ClienteImpl();
        cliente.setCodigo_C(Integer.parseInt(txtCodigo_C.getText()));
        cliente.setNombre(txtNombre.getText());
        cliente.setApellido(txtApellido.getText());
        cliente.setCedula(txtCedula.getText());
        cliente.setDireccion(txtDireccion.getText());
        cliente.setTelefono(txtTelefono.getText());
        cliente.setSexo(cmbSexo.getSelectedIndex() == 0 ? "m" : "f");    

        try {
            if (clienteDao.insertar(cliente) > 0) {
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
