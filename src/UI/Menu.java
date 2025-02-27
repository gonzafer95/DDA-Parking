/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Controladores.ControladorMenu;

/**
 *
 * @author bruno
 */
public class Menu extends javax.swing.JFrame implements VistaMenu {
        private ControladorMenu controlador;

    /**
     * Creates new form Menu
     */
    public Menu() {
        this.controlador = new ControladorMenu(this);
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

        SimuladorUi = new javax.swing.JButton();
        TableroDeControl = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SimuladorUi.setText("Simulador UI");
        SimuladorUi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimuladorUiActionPerformed(evt);
            }
        });

        TableroDeControl.setText("Tablero de control");
        TableroDeControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TableroDeControlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TableroDeControl)
                    .addComponent(SimuladorUi, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(SimuladorUi)
                .addGap(42, 42, 42)
                .addComponent(TableroDeControl)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableroDeControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TableroDeControlActionPerformed
        controlador.TableroDeControldep();

    }//GEN-LAST:event_TableroDeControlActionPerformed

    private void SimuladorUiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimuladorUiActionPerformed
        controlador.SimuladorUIdep();
    }//GEN-LAST:event_SimuladorUiActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SimuladorUi;
    private javax.swing.JButton TableroDeControl;
    // End of variables declaration//GEN-END:variables
}
