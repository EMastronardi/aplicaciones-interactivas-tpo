/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.vistas.clientes;

import java.awt.Component;
import javax.swing.JTextField;
import metergas.modelo.views.ClienteIndustrialView;
import metergas.modelo.views.ClienteView;
import metergas.vistas.clientes.contratos.FormularioClienteInterface;

/**
 *
 * @author eteodoro
 */
public class FormularioIndustrial extends javax.swing.JPanel implements FormularioClienteInterface {
    protected int id = 0;
    /**
     * Creates new form FormularioIndustrial
     */
    public FormularioIndustrial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNroIBB = new javax.swing.JTextField();
        txtCondicionFiscal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCUIT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        formularioDomicilio = new metergas.vistas.clientes.FormularioDomicilio();

        jLabel1.setText("Razón social");
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 30));

        txtRazonSocial.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel5.setText("Número de Ingresos brutos");
        jLabel5.setPreferredSize(new java.awt.Dimension(200, 30));

        txtNroIBB.setPreferredSize(new java.awt.Dimension(300, 30));

        txtCondicionFiscal.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel6.setText("Condición fiscal");
        jLabel6.setPreferredSize(new java.awt.Dimension(200, 30));

        txtCUIT.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel7.setText("CUIT");
        jLabel7.setPreferredSize(new java.awt.Dimension(200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNroIBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCondicionFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(formularioDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroIBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCondicionFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formularioDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private metergas.vistas.clientes.FormularioDomicilio formularioDomicilio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCUIT;
    private javax.swing.JTextField txtCondicionFiscal;
    private javax.swing.JTextField txtNroIBB;
    private javax.swing.JTextField txtRazonSocial;
    // End of variables declaration//GEN-END:variables

    @Override
    public ClienteView getCliente() {
        return new ClienteIndustrialView(txtRazonSocial.getText(), txtNroIBB.getText(), txtCondicionFiscal.getText(),
                txtCUIT.getText(),id,"", formularioDomicilio.getDomicilio());
    }
    
    @Override
    public void cargarCliente(ClienteView c) {
        ClienteIndustrialView cliente = (ClienteIndustrialView) c;
        id = cliente.getId();
        txtRazonSocial.setText(cliente.getRazonSocial());
        txtNroIBB.setText(cliente.getNroIIBB());
        txtCondicionFiscal.setText(cliente.getCondicionFiscal());
        txtCUIT.setText(cliente.getCUIT());
        formularioDomicilio.cargarDomicilio(cliente.getDomicilio());
        
    }

    @Override
    public void clear() {
        for (Component component : this.getComponents()) {
            if(component instanceof JTextField){
                ((JTextField)component).setText("");
            }
        }
        formularioDomicilio.clean();
    }
}
