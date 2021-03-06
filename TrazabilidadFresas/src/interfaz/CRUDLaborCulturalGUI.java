/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import control.LaborCulturalControl;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.LaborCultural;

/**
 *
 * @author fredy
 */
public class CRUDLaborCulturalGUI extends javax.swing.JFrame {

    /**
     * Creates new form CRUDLaborCulturalGUI
     */
    private boolean editing = false;
    private int filaEditable = -1;
    private ArrayList laboresCulturales = new ArrayList();

    public CRUDLaborCulturalGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cargarTabla();
        laboresCulturalesTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = laboresCulturalesTable.rowAtPoint(e.getPoint());
                int columna = laboresCulturalesTable.columnAtPoint(e.getPoint());
                if (editing && fila > -1 && columna > -1) {
                    if (filaEditable != -1 && fila == filaEditable) {
                        String mensaje = "";
                        switch (columna) {
                            case 0:
                                mensaje = "Ingrese el nombre";
                                break;
                            case 1:
                                mensaje = "Ingrese la descripcion";
                                break;
                        }
                        String m = JOptionPane.showInputDialog(mensaje);
                        laboresCulturalesTable.setValueAt(m, fila, columna);
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        agregarButton = new javax.swing.JButton();
        borrarButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        laboresCulturalesTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Labores Culturales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 255)));
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        agregarButton.setBackground(new java.awt.Color(153, 153, 255));
        agregarButton.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        agregarButton.setText("Agregar");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        borrarButton.setBackground(new java.awt.Color(153, 153, 255));
        borrarButton.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        borrarButton.setText("Borrar");
        borrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarButtonActionPerformed(evt);
            }
        });

        guardarButton.setBackground(new java.awt.Color(153, 153, 255));
        guardarButton.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        guardarButton.setText("Guardar");
        guardarButton.setEnabled(false);
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        laboresCulturalesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(laboresCulturalesTable);
        if (laboresCulturalesTable.getColumnModel().getColumnCount() > 0) {
            laboresCulturalesTable.getColumnModel().getColumn(0).setResizable(false);
            laboresCulturalesTable.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(agregarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(borrarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(guardarButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(agregarButton)
                        .addGap(7, 7, 7)
                        .addComponent(guardarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(borrarButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        // TODO add your handling code here:
        if (!editing) {
            DefaultTableModel modelo = (DefaultTableModel) laboresCulturalesTable.getModel();
            Object[] fila = {"", ""};
            modelo.addRow(fila);
            filaEditable = modelo.getRowCount() - 1;
            guardarButton.setEnabled(true);
            editing = true;
        }
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void borrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarButtonActionPerformed
        // TODO add your handling code here:
        if (laboresCulturalesTable.getSelectedRow() > -1) {
            LaborCultural a = (LaborCultural) laboresCulturales.get(laboresCulturalesTable.getSelectedRow());
            new LaborCulturalControl().eliminar(a);
            borrarTabla();
            cargarTabla();
        }
    }//GEN-LAST:event_borrarButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        // TODO add your handling code here:
        guardarButton.setEnabled(false);
        editing = false;
        LaborCultural lc = new LaborCultural();
        try {
            lc.setNombre((String) laboresCulturalesTable.getValueAt(filaEditable, 0));
            lc.setDescripcion((String) laboresCulturalesTable.getValueAt(filaEditable, 1));
            if (!new LaborCulturalControl().crear(lc)) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        borrarTabla();
        cargarTabla();
    }//GEN-LAST:event_guardarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CRUDLaborCulturalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDLaborCulturalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDLaborCulturalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDLaborCulturalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDLaborCulturalGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private javax.swing.JButton borrarButton;
    private javax.swing.JButton guardarButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable laboresCulturalesTable;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) laboresCulturalesTable.getModel();
        laboresCulturales = (ArrayList) new LaborCulturalControl().leerTodos();
        for (int i = 0; i < laboresCulturales.size(); i++) {
            LaborCultural a = (LaborCultural) laboresCulturales.get(i);
            String[] datos = {a.getNombre(), a.getDescripcion()};
            modelo.addRow(datos);
        }
    }

    private void borrarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) laboresCulturalesTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
}
