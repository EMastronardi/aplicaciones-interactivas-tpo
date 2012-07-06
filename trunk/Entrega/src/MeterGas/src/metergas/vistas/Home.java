/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import metergas.controller.MeterGasController;
import metergas.modelo.views.ClienteIndustrialView;
import metergas.modelo.views.ClienteResidencialView;
import metergas.modelo.views.ClienteView;
import metergas.modelo.views.DomicilioView;
import metergas.vistas.clientes.JFrameBase;

/**
 *
 * @author eteodoro
 */
public class Home extends javax.swing.JFrame {

    private JFrame ventanaPrincipal;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        ventanaPrincipal = this;
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int inset = 0;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuClientes = new javax.swing.JMenu();
        jMenuAlta = new javax.swing.JMenuItem();
        jMenuBaja = new javax.swing.JMenuItem();
        jMenuModificacion = new javax.swing.JMenuItem();
        jMenuConceptos = new javax.swing.JMenu();
        jMenuItemAdministrar = new javax.swing.JMenuItem();
        jMenuMediciones = new javax.swing.JMenu();
        jMenuNuevaMedicion = new javax.swing.JMenuItem();
        jMenuLiquidaciones = new javax.swing.JMenu();
        jMenuNuevaLiquidacion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        desktop.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(desktop);

        jMenuClientes.setText("Clientes");
        jMenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });

        jMenuAlta.setText("Alta");
        jMenuAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuAlta);

        jMenuBaja.setText("Baja");
        jMenuBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuBaja);

        jMenuModificacion.setText("Modificacion");
        jMenuModificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuModificacion);

        jMenuBar.add(jMenuClientes);

        jMenuConceptos.setText("Conceptos");

        jMenuItemAdministrar.setText("Administrar");
        jMenuItemAdministrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });
        jMenuConceptos.add(jMenuItemAdministrar);

        jMenuBar.add(jMenuConceptos);

        jMenuMediciones.setText("Mediciones");

        jMenuNuevaMedicion.setText("Registrar medición");
        jMenuNuevaMedicion.setActionCommand("Nueva");
        jMenuNuevaMedicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });
        jMenuMediciones.add(jMenuNuevaMedicion);

        jMenuBar.add(jMenuMediciones);

        jMenuLiquidaciones.setText("Liquidaciones");

        jMenuNuevaLiquidacion.setText("Generar");
        jMenuNuevaLiquidacion.setActionCommand("Nueva");
        jMenuNuevaLiquidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });
        jMenuLiquidaciones.add(jMenuNuevaLiquidacion);

        jMenuBar.add(jMenuLiquidaciones);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuActionPerformed
        javax.swing.JMenuItem source = (javax.swing.JMenuItem) evt.getSource();
        javax.swing.JPopupMenu parentPopup = (JPopupMenu) source.getParent();
        javax.swing.JMenu menu = (javax.swing.JMenu) parentPopup.getInvoker();

        JFrameBase vista = VistasManager.getInstance().getVista(String.format("%s.%s", menu.getActionCommand(),
                source.getActionCommand()));

        
        vista.addInternalFrameListener(new InternalFrameListener() {

            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
            }


            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                JFrameBase vistaCerrada = (JFrameBase) e.getSource();
                vistaCerrada.clear();
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
            }
          
        });
        
        vista.setVisible(true);
        vista.setFocusable(true);
        
        desktop.remove(vista);
        desktop.add(vista);
    }//GEN-LAST:event_jMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */

        /*
         * Instanciacion de parametria y clases de base
         *
         */
        
        MeterGasController mg = MeterGasController.getInstance();

//        mg.inicializar();
        DomicilioView dv = new DomicilioView("Alem", "7", "5", "A", "1878", "Quilmes", "Buenos Aires");

        ClienteView cv = new ClienteResidencialView("Ronnie James", "Dio", "111111", 0, null, dv);
        int id1 = mg.altaCliente(cv);

        cv = new ClienteResidencialView("Steve", "Harris", "222222", 0, null, dv);
        int id2 = mg.altaCliente(cv);

        cv = new ClienteIndustrialView("Deep Purple", "123", "Responsable Inscripto", "333333", 0, null, dv);
        int id3 = mg.altaCliente(cv);

        cv = new ClienteIndustrialView("Iron Maiden", "456", "Responsable Inscripto", "444444", 0, null, dv);
        int id4 = mg.altaCliente(cv);

        mg.registrarMedicion(id1, new Date(2012, 03, 10), 100);
        mg.registrarMedicion(id1, new Date(2012, 05, 10), 200);
        mg.registrarMedicion(id2, new Date(2012, 03, 10), 50);
        mg.registrarMedicion(id2, new Date(2012, 05, 10), 400);
        mg.registrarMedicion(id3, new Date(2012, 03, 10), 100);
        mg.registrarMedicion(id3, new Date(2012, 05, 10), 200);
        mg.registrarMedicion(id4, new Date(2012, 03, 10), 100);
        mg.registrarMedicion(id4, new Date(2012, 05, 10), 1000);
//        
//        mg.eliminarCliente(2);
//        
//        mg.generarLiquidacion();
//        
//        mg.imprimirFacturas();
//        
//        mg.imprimirSubsidio();
//        
        /*
         * Invocacion de la ventana principal
         *
         *
         *
         *
         *
         */

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Home().setVisible(true);
            }
        });



    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem jMenuAlta;
    private javax.swing.JMenuItem jMenuBaja;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenu jMenuConceptos;
    private javax.swing.JMenuItem jMenuItemAdministrar;
    private javax.swing.JMenu jMenuLiquidaciones;
    private javax.swing.JMenu jMenuMediciones;
    private javax.swing.JMenuItem jMenuModificacion;
    private javax.swing.JMenuItem jMenuNuevaLiquidacion;
    private javax.swing.JMenuItem jMenuNuevaMedicion;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the ventanaPrincipal
     */
    public JFrame getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    /**
     * @param ventanaPrincipal the ventanaPrincipal to set
     */
    public void setVentanaPrincipal(JFrame ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
}
