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
import proyectofinal.Impl.ClienteImpl;
import proyectofinal.Impl.SalidaImpl;
import proyectofinal.dao.ICliente;
import proyectofinal.dao.ISalida;
import proyectofinal.entidades.Cliente;
import proyectofinal.entidades.Salida;

/**
 *
 * @author CRISTIAN
 */
public class FrmNuevaSalida extends JInternalFrame {

    JLabel Titulo;
    JLabel CodigoS;
    JLabel Fecha_registro;
    JLabel Fecha_salida;
    JLabel Responsable;
    JLabel Vendedor;
    
    JTextField txtCodigoS;
    JTextField txtFecha_registro;
    JTextField txtFecha_salida;
    JTextField txtResponsable;
    JTextField txtVendedor;
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevaSalida() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(8, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1, 2, 5, 5));

        Titulo = new JLabel("Datos Salida");
        CodigoS = new JLabel("Codigo:");
        Fecha_registro = new JLabel("Fecha de registro");
        Fecha_salida = new JLabel("Fecha de Salida:");
        Responsable = new JLabel("Responsable:");
        Vendedor = new JLabel("Vendedor:");
        
        txtCodigoS = new JTextField(2);
        txtFecha_registro = new JTextField(2);
        txtFecha_salida = new JTextField(2);
        txtResponsable = new JTextField(2);
        txtVendedor = new JTextField(2);
        
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");

        pnlCentral.add(CodigoS);
        pnlCentral.add(txtCodigoS);
        pnlCentral.add(Fecha_registro);
        pnlCentral.add(txtFecha_registro);
        pnlCentral.add(Fecha_salida);
        pnlCentral.add(txtFecha_salida);
        pnlCentral.add(Responsable);
        pnlCentral.add(txtResponsable);
        pnlCentral.add(Vendedor);
        pnlCentral.add(txtVendedor);
        
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

        FrmNuevoCliente frmMenu = new FrmNuevoCliente();
        frmMenu.setVisible(true);
    }

    public void btnAceptarActionListener(ActionEvent e) {
        Salida salida = new Salida();
        ISalida salidaDao = new SalidaImpl();
        salida.setCodigoS(Integer.parseInt(txtCodigoS.getText()));
        salida.setResponsable(txtResponsable.getText());
        salida.setVendedor(txtVendedor.getText());
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            salida.setFecha_registro(formatoFecha.parse(txtFecha_registro.getText()));
            salida.setFecha_salida(formatoFecha.parse(txtFecha_salida.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en la fecha!!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        try {
            if (salidaDao.insertar(salida) > 0) {
                JOptionPane.showMessageDialog(this, "Registrado correctamente!!",
                        "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error desconocido: ",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error desconocido: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
