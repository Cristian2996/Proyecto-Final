/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.watermark.SubstanceImageWatermark;

/**
 *
 * @author CRISTIAN
 */
public class FrmMenuPrincipal extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
    JMenu mnCliente;
    JMenuItem mniNuevoCliente;
    JMenuItem mniModificaCliente;
    JMenuItem mniEliminaCliente;
    JMenuItem mniBuscarCliente;
    JMenuItem mniListarCliente;
    JMenu mnEntrada;
    JMenuItem mniNuevoEntrada;
    JMenuItem mniModificaEntrada;
    JMenuItem mniEliminaEntrada;
    JMenuItem mniBuscaEntrada;
    JMenuItem mniListaEntrada;
    JMenu mnKardex;
    JMenuItem mniNuevoKardex;
    JMenuItem mniModificaKardex;
    JMenuItem mniEliminaKardex;
    JMenuItem mniBuscaKardex;
    JMenuItem mniListaKardex;
    JMenu mnProducto;
    JMenuItem mniNuevoProducto;
    JMenuItem mniModificaProducto;
    JMenuItem mniEliminaProducto;
    JMenuItem mniBuscaProducto;
    JMenuItem mniListaProducto;
    JMenu mnProveedor;
    JMenuItem mniNuevoProveedor;
    JMenuItem mniModificaProveedor;
    JMenuItem mniEliminaProveedor;
    JMenuItem mniBuscaProveedor;
    JMenuItem mniListaProveedor;
    JMenu mnSalida;
    JMenuItem mniNuevoSalida;
    JMenuItem mniModificaSalida;
    JMenuItem mniEliminaSalida;
    JMenuItem mniBuscaSalida;
    JMenuItem mniListaSalida;
    JMenu mnVendedor;
    JMenuItem mniNuevoVendedor;
    JMenuItem mniModificaVendedor;
    JMenuItem mniEliminaVendedor;
    JMenuItem mniBuscaVendedor;
    JMenuItem mniListaVendedor;
    JMenu mnVenta;
    JMenuItem mniNuevoVenta;
    JMenuItem mniModificaVenta;
    JMenuItem mniEliminaVenta;
    JMenuItem mniBuscaVenta;
    JMenuItem mniListaVenta;
    JDesktopPane dkpEscritorio;

    public FrmMenuPrincipal() {
        dkpEscritorio = new JDesktopPane();
        dkpEscritorio.setBackground(new Color(240, 240, 240));
        mnbPrincipal = new JMenuBar();
        mnInicio = new JMenu("Inicio");
        mniLogin = new JMenuItem("Iniciar Seciòn");
        mniSalir = new JMenuItem("Salir");
        mniSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniSalirActionPerformed(e);
            }
        });
        mnCliente = new JMenu("Cliente");
        mnProveedor = new JMenu("Proveedor");
        mnVendedor = new JMenu("Vendedor");
        mnProducto = new JMenu("Producto");
        mnEntrada = new JMenu("Entrada");
        mnSalida = new JMenu("Salida");
        mnKardex = new JMenu("Kardex");
        mnVenta = new JMenu("Venta");
        mniNuevoCliente = new JMenuItem("Nuevo");
        mniNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoClienteActionPerformed(e);
            }
        });
        mniModificaCliente = new JMenuItem("Modificar");
        mniEliminaCliente = new JMenuItem("Eliminar");
        mniBuscarCliente = new JMenuItem("Buscar");
        mniListarCliente = new JMenuItem("Listar");
        mniListarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaClienteActionPerdormed(e);
            }
        });

        mniNuevoProveedor = new JMenuItem("Nuevo");
        mniNuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoProveedorActionPerformed(e);
            }
        });
        mniModificaProveedor = new JMenuItem("Modificar");
        mniEliminaProveedor = new JMenuItem("Eliminar");
        mniBuscaProveedor = new JMenuItem("Buscar");
        mniListaProveedor = new JMenuItem("Listar");
        mniListaProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaProveedorActionPerdormed(e);
            }
        });

        mniNuevoVendedor = new JMenuItem("Nuevo");
        mniNuevoVendedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoVendedorActionPerformed(e);
            }
        });
        mniModificaVendedor = new JMenuItem("Modificar");
        mniEliminaVendedor = new JMenuItem("Eliminar");
        mniBuscaVendedor = new JMenuItem("Buscar");
        mniListaVendedor = new JMenuItem("Listar");
        mniListaVendedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaVendedorActionPerdormed(e);
            }
        });

        mniNuevoProducto = new JMenuItem("Nuevo");
        mniNuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoProductoActionPerformed(e);
            }
        });
        mniModificaProducto = new JMenuItem("Modificar");
        mniEliminaProducto = new JMenuItem("Eliminar");
        mniBuscaProducto = new JMenuItem("Buscar");
        mniListaProducto = new JMenuItem("Listar");
        mniListaProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaProductoActionPerdormed(e);
            }
        });

        mniNuevoEntrada = new JMenuItem("Nuevo");
        mniNuevoEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoEntradaActionPerformed(e);
            }
        });
        mniModificaEntrada = new JMenuItem("Modificar");
        mniEliminaEntrada = new JMenuItem("Eliminar");
        mniBuscaEntrada = new JMenuItem("Buscar");
        mniListaEntrada = new JMenuItem("Listar");
        mniListaEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaEntradaActionPerdormed(e);
            }
        });

        mniNuevoSalida = new JMenuItem("Nuevo");
        mniNuevoSalida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoSalidaActionPerformed(e);
            }
        });
        mniModificaSalida = new JMenuItem("Modificar");
        mniEliminaSalida = new JMenuItem("Eliminar");
        mniBuscaSalida = new JMenuItem("Buscar");
        mniListaSalida = new JMenuItem("Listar");
        mniListaSalida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaSalidaActionPerdormed(e);
            }
        });

        mniNuevoKardex = new JMenuItem("Nuevo");
        mniNuevoKardex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoKardexActionPerformed(e);
            }
        });
        mniModificaKardex = new JMenuItem("Modificar");
        mniEliminaKardex = new JMenuItem("Eliminar");
        mniBuscaKardex = new JMenuItem("Buscar");
        mniListaKardex = new JMenuItem("Listar");
        mniListaKardex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaKardexActionPerdormed(e);
            }
        });

        mniNuevoVenta = new JMenuItem("Nuevo");
        mniNuevoVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoVentaActionPerformed(e);
            }
        });
        mniModificaVenta = new JMenuItem("Modificar");
        mniEliminaVenta = new JMenuItem("Eliminar");
        mniBuscaVenta = new JMenuItem("Buscar");
        mniListaVenta = new JMenuItem("Listar");
        mniListaVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaVentaActionPerdormed(e);
            }
        });

        mnCliente.add(mniNuevoCliente);
        mnCliente.add(mniModificaCliente);
        mnCliente.add(mniEliminaCliente);
        mnCliente.addSeparator();
        mnCliente.add(mniBuscarCliente);
        mnCliente.add(mniListarCliente);
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnCliente);
        mnbPrincipal.add(mnProveedor);
        mnbPrincipal.add(mnVendedor);
        mnbPrincipal.add(mnProducto);
        mnbPrincipal.add(mnEntrada);
        mnbPrincipal.add(mnSalida);
        mnbPrincipal.add(mnKardex);
        mnbPrincipal.add(mnVenta);
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);

        mnProveedor.add(mniNuevoProveedor);
        mnProveedor.add(mniModificaProveedor);
        mnProveedor.add(mniEliminaProveedor);
        mnProveedor.addSeparator();
        mnProveedor.add(mniBuscaProveedor);
        mnProveedor.add(mniListaProveedor);

        mnVendedor.add(mniNuevoVendedor);
        mnVendedor.add(mniModificaVendedor);
        mnVendedor.add(mniEliminaVendedor);
        mnVendedor.addSeparator();
        mnVendedor.add(mniBuscaVendedor);
        mnVendedor.add(mniListaVendedor);

        mnProducto.add(mniNuevoProducto);
        mnProducto.add(mniModificaProducto);
        mnProducto.add(mniEliminaProducto);
        mnProducto.addSeparator();
        mnProducto.add(mniBuscaProducto);
        mnProducto.add(mniListaProducto);

        mnEntrada.add(mniNuevoEntrada);
        mnEntrada.add(mniModificaEntrada);
        mnEntrada.add(mniEliminaEntrada);
        mnEntrada.addSeparator();
        mnEntrada.add(mniBuscaEntrada);
        mnEntrada.add(mniListaEntrada);

        mnSalida.add(mniNuevoSalida);
        mnSalida.add(mniModificaSalida);
        mnSalida.add(mniEliminaSalida);
        mnSalida.addSeparator();
        mnSalida.add(mniBuscaSalida);
        mnSalida.add(mniListaSalida);

        mnKardex.add(mniNuevoKardex);
        mnKardex.add(mniModificaKardex);
        mnKardex.add(mniEliminaKardex);
        mnKardex.addSeparator();
        mnKardex.add(mniBuscaKardex);
        mnKardex.add(mniListaKardex);

        mnVenta.add(mniNuevoVenta);
        mnVenta.add(mniModificaVenta);
        mnVenta.add(mniEliminaVenta);
        mnVenta.addSeparator();
        mnVenta.add(mniBuscaVenta);
        mnVenta.add(mniListaVenta);

        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0,0,500,450);
    }

     public void mniSalirActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public void mniNuevoClienteActionPerformed(ActionEvent e) {
        FrmNuevoCliente frm = new FrmNuevoCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniListaClienteActionPerdormed(ActionEvent e) {
        FrmListaCliente frm = new FrmListaCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniNuevoProveedorActionPerformed(ActionEvent e) {
        FrmNuevoProveedor frm = new FrmNuevoProveedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniListaProveedorActionPerdormed(ActionEvent e) {
        FrmListaProveedor frm = new FrmListaProveedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniNuevoVendedorActionPerformed(ActionEvent e) {
        FrmNuevoVendedor frm = new FrmNuevoVendedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniListaVendedorActionPerdormed(ActionEvent e) {
        FrmListaVendedor frm = new FrmListaVendedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniNuevoProductoActionPerformed(ActionEvent e) {
        FrmNuevoProducto frm = new FrmNuevoProducto();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniListaProductoActionPerdormed(ActionEvent e) {
        FrmListaProducto frm = new FrmListaProducto();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniNuevoEntradaActionPerformed(ActionEvent e) {
        FrmNuevaEntrada frm = new FrmNuevaEntrada();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
        
    }

    public void mniListaEntradaActionPerdormed(ActionEvent e) {
        FrmListaEntrada frm = new FrmListaEntrada();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniNuevoSalidaActionPerformed(ActionEvent e) {
        FrmNuevaSalida frm = new FrmNuevaSalida();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniListaSalidaActionPerdormed(ActionEvent e) {
        FrmListaSalida frm = new FrmListaSalida();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniNuevoKardexActionPerformed(ActionEvent e) {
        FrmNuevoKardex frm = new FrmNuevoKardex();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniListaKardexActionPerdormed(ActionEvent e) {
        FrmListaKardex frm = new FrmListaKardex();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniNuevoVentaActionPerformed(ActionEvent e) {
        FrmNuevoVenta frm = new FrmNuevoVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniListaVentaActionPerdormed(ActionEvent e) {
        FrmListaVenta frm = new FrmListaVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.EmeraldDuskSkin");
        SubstanceLookAndFeel.setCurrentTheme(" org.jvnet.substance.theme.SubstanceRaspberryTheme");
        SubstanceLookAndFeel.setCurrentWatermark( new SubstanceImageWatermark("C:\\Users\\CRISTIAN\\Pictures\\imagen-3.jpg"));
       SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(1.0));
        FrmMenuPrincipal frmMEnu = new FrmMenuPrincipal();
        frmMEnu.setVisible(true);

    }

}
