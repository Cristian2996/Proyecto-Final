/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.vistas;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author CRISTIAN
 */
public class Login extends JFrame implements ActionListener {

    JTextField txttexto1;
    JPasswordField txttexto2;
    JLabel tp1;
    JLabel tp2;
    JButton boton1;
    JButton boton2;

    public Login() {
        setLayout(null);
        setTitle("LOGIN");
        getContentPane().setBackground(Color.CYAN);
        txttexto1 = new JTextField();
        txttexto2 = new JPasswordField();
        tp1 = new JLabel("INGRESE USUARIO:");
        tp2 = new JLabel("INGRESE CONTRASEÑA:");
        boton1 = new JButton("ENTRAR");
        boton2 = new JButton("SALIR");
        txttexto1.setBounds(190, 20, 140, 25);
        txttexto2.setBounds(190, 50, 140, 25);
        tp1.setBounds(20, 20, 130, 25);
        tp2.setBounds(20, 50, 150, 25);
        boton1.setBounds(50, 110, 100, 30);
        boton2.setBounds(200, 110, 100, 30);

        add(txttexto1);
        add(txttexto2);
        add(tp1);
        add(tp2);
        add(boton1);
        add(boton2);
        boton1.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void salir() {
        System.exit(0);
    }
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == boton1) {
            if (txttexto1.getText().equals("Cristian") && txttexto2.getText().equals("1234")) {
                JOptionPane.showMessageDialog(null, "INGRESO CORRECTO",
                        "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "DATOS INCORECTOS", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ev.getSource() == boton2) {
            salir();
        }
    }

   

    public static void main(String[] args) {
        Login L = new Login();
        L.setVisible(true);
        L.setBounds(350, 250, 350, 200);
        L.setResizable(false);
    }

}
