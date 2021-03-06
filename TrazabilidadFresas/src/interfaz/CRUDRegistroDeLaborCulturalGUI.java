/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import control.CustomDateFormatter;
import control.FresicultorControl;
import control.RegistroDeLaborCulturalControl;
import control.LaborCulturalControl;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Fresicultor;
import modelo.RegistroDeLaborCultural;
import modelo.LaborCultural;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;
import org.jdesktop.swingx.table.DatePickerCellEditor;

/**
 *
 * @author fredy
 */
public class CRUDRegistroDeLaborCulturalGUI extends javax.swing.JFrame {

    /**
     * Creates new form CRUDRegistroDeLaborCulturalGUI
     */
    private boolean editing = false;
    private int filaEditable = -1;
    private ArrayList registros = new ArrayList();

    public CRUDRegistroDeLaborCulturalGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setCellEditors();
        cargarTabla();
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        registrosTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        agregarButton = new javax.swing.JButton();
        borrarButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registros de Labores Culturales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 255)));
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        registrosTable.setBackground(new java.awt.Color(204, 204, 255));
        registrosTable.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        registrosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Labor realizada", "Operario", "Jornales", "Observaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        registrosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        registrosTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(registrosTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 255)));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
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
                .addComponent(agregarButton)
                .addGap(7, 7, 7)
                .addComponent(guardarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(borrarButton)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
            DefaultTableModel modelo = (DefaultTableModel) registrosTable.getModel();
            Object[] fila = {new Date(),new LaborCultural(),new Fresicultor(),0,""};
            modelo.addRow(fila);            
            filaEditable = modelo.getRowCount() - 1;
            guardarButton.setEnabled(true);
            editing = true;
        }
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        // TODO add your handling code here:
        editing = false;
        RegistroDeLaborCultural adm = new RegistroDeLaborCultural();
        try {
            adm.setFecha((Date) registrosTable.getValueAt(filaEditable, 0));
            adm.setLaborCultural((LaborCultural) registrosTable.getValueAt(filaEditable, 1));
            adm.setFresicultor((Fresicultor) registrosTable.getValueAt(filaEditable, 2));
            adm.setJornales((double) registrosTable.getValueAt(filaEditable, 3));
            adm.setObservaciones((String) registrosTable.getValueAt(filaEditable, 4));
            if (!new RegistroDeLaborCulturalControl().crear(adm)) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        borrarTabla();
        cargarTabla();
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void borrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarButtonActionPerformed
        // TODO add your handling code here:
        if (registrosTable.getSelectedRow() > -1) {
            RegistroDeLaborCultural a = (RegistroDeLaborCultural) registros.get(registrosTable.getSelectedRow());
            new RegistroDeLaborCulturalControl().eliminar(a);
            borrarTabla();
            cargarTabla();
        }
    }//GEN-LAST:event_borrarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CRUDRegistroDeLaborCulturalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDRegistroDeLaborCulturalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDRegistroDeLaborCulturalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDRegistroDeLaborCulturalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDRegistroDeLaborCulturalGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private javax.swing.JButton borrarButton;
    private javax.swing.JButton guardarButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable registrosTable;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) registrosTable.getModel();
        registros = (ArrayList) new RegistroDeLaborCulturalControl().leerTodos();
        for (int i = 0; i < registros.size(); i++) {
            RegistroDeLaborCultural a = (RegistroDeLaborCultural) registros.get(i);
            Object[] datos = {a.getFecha(), a.getLaborCultural(), a.getFresicultor(), a.getJornales(),a.getObservaciones()};
            modelo.addRow(datos);
        }
    }

    private void borrarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) registrosTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    private void setCellEditors() {
        //DatePicker de fecha
        TableColumn productoColumn = registrosTable.getColumnModel().getColumn(0);
        DatePickerCellEditor picker = new DatePickerCellEditor();
        picker.setClickCountToStart(-1);
        productoColumn.setCellEditor(picker);
        productoColumn.setCellRenderer(new DefaultTableRenderer(new CustomDateFormatter().getStringValue(), JLabel.RIGHT));
        //ComboBox de responsable
        productoColumn = registrosTable.getColumnModel().getColumn(2);
        JComboBox comboBox = new JComboBox();
        for (Fresicultor f : new FresicultorControl().leerTodos()) {
            comboBox.addItem(f);
        }
        productoColumn.setCellEditor(new DefaultCellEditor(comboBox));
        //ComboBox de labor cultural
        productoColumn = registrosTable.getColumnModel().getColumn(1);
        comboBox = new JComboBox();
        for (LaborCultural s : new LaborCulturalControl().leerTodos()) {
            comboBox.addItem(s);
        }
        productoColumn.setCellEditor(new DefaultCellEditor(comboBox));
    }
}
