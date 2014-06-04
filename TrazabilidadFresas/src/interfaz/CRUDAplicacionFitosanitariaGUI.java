/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import control.AplicacionFitosanitariaControl;
import control.EquipoDeAplicacionFitosanitariaControl;
import control.ProductoFitosanitarioControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.AplicacionFitosanitaria;
import modelo.EquipoDeAplicacionFitosanitaria;
import modelo.ProductoFitosanitario;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;
import org.jdesktop.swingx.renderer.FormatStringValue;
import org.jdesktop.swingx.table.DatePickerCellEditor;

/**
 *
 * @author fredy
 */
public class CRUDAplicacionFitosanitariaGUI extends javax.swing.JFrame {

    /**
     * Creates new form CRUDAplicacionFitosanitariaGUI
     */
    private boolean editing = false;
    private int filaEditable = -1;
    private ArrayList aplicaciones;
    private final SimpleDateFormat sdf_brief = new SimpleDateFormat("dd/MM/yy");
    private final FormatStringValue stringValue = new FormatStringValue(sdf_brief);

    public CRUDAplicacionFitosanitariaGUI() {

        initComponents();
        this.aplicaciones = new ArrayList();
        //
        setCellEditors();
        //
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
        aplicacionesTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        agregarButton = new javax.swing.JButton();
        borrarButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Aplicaciones Fitosanitarias"));

        aplicacionesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Producto", "Ingrediente Activo", "Motivo de la aplicación", "PC", "Tr", "Cantidad aplicada", "Agua utilizada", "Equipo utilizado", "Responsable", "Autorizado", "Jornales", "Observaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        aplicacionesTable.setColumnSelectionAllowed(true);
        aplicacionesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        aplicacionesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(aplicacionesTable);
        aplicacionesTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (aplicacionesTable.getColumnModel().getColumnCount() > 0) {
            aplicacionesTable.getColumnModel().getColumn(0).setResizable(false);
            aplicacionesTable.getColumnModel().getColumn(1).setResizable(false);
            aplicacionesTable.getColumnModel().getColumn(2).setResizable(false);
            aplicacionesTable.getColumnModel().getColumn(3).setResizable(false);
            aplicacionesTable.getColumnModel().getColumn(4).setResizable(false);
            aplicacionesTable.getColumnModel().getColumn(5).setResizable(false);
            aplicacionesTable.getColumnModel().getColumn(6).setResizable(false);
            aplicacionesTable.getColumnModel().getColumn(7).setResizable(false);
            aplicacionesTable.getColumnModel().getColumn(8).setResizable(false);
            aplicacionesTable.getColumnModel().getColumn(9).setResizable(false);
            aplicacionesTable.getColumnModel().getColumn(10).setResizable(false);
            aplicacionesTable.getColumnModel().getColumn(11).setResizable(false);
            aplicacionesTable.getColumnModel().getColumn(12).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1338, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );

        agregarButton.setText("Agregar");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        borrarButton.setText("Borrar");
        borrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarButtonActionPerformed(evt);
            }
        });

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
                .addComponent(agregarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(borrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarButton)
                    .addComponent(guardarButton)
                    .addComponent(borrarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            DefaultTableModel modelo = (DefaultTableModel) aplicacionesTable.getModel();
            modelo.addRow(new Object[13]);
            filaEditable = modelo.getRowCount() - 1;
            guardarButton.setEnabled(true);
            editing = true;
        }
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        // TODO add your handling code here:
        editing = false;
        AplicacionFitosanitaria adm = new AplicacionFitosanitaria();
        try {
            //set the variables
            if (!new AplicacionFitosanitariaControl().crear(adm)) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        borrarTabla();
        cargarTabla();
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void borrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarButtonActionPerformed
        // TODO add your handling code here:
        if (aplicacionesTable.getSelectedRow() > -1) {
            AplicacionFitosanitaria a = (AplicacionFitosanitaria) aplicaciones.get(aplicacionesTable.getSelectedRow());
            new AplicacionFitosanitariaControl().eliminar(a);
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
            java.util.logging.Logger.getLogger(CRUDAplicacionFitosanitariaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDAplicacionFitosanitariaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDAplicacionFitosanitariaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDAplicacionFitosanitariaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDAplicacionFitosanitariaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private javax.swing.JTable aplicacionesTable;
    private javax.swing.JButton borrarButton;
    private javax.swing.JButton guardarButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) aplicacionesTable.getModel();
        aplicaciones = (ArrayList) new AplicacionFitosanitariaControl().leerTodos();
        for (int i = 0; i < aplicaciones.size(); i++) {
            AplicacionFitosanitaria a = (AplicacionFitosanitaria) aplicaciones.get(i);
            Object[] datos = {a.getFecha(),
                a.getProductoFitosanitario(),
                a.getProductoFitosanitario().getIngrediente_activo(),
                a.getMotivo(),
                a.getPc(),
                a.getTr(),
                a.getCantidadAplicada(),
                a.getLitrosDeAguaUtilizada(),
                a.getEquipoDeAplicacionFitosanitaria(),
                a.getAdministrador(),
                a.getFresicultor(),
                a.getJornales(),
                a.getObservaciones()};
            modelo.addRow(datos);
        }
    }

    private void borrarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) aplicacionesTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    private void setCellEditors() {
        TableColumn productoColumn = aplicacionesTable.getColumnModel().getColumn(1);
        JComboBox comboBox = new JComboBox();
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                if (arg0.getStateChange() == ItemEvent.SELECTED
                        && aplicacionesTable.getSelectedRow() > -1
                        && aplicacionesTable.getSelectedColumn() > -1) {
                    Object i = arg0.getItem();
                    aplicacionesTable.setValueAt(((ProductoFitosanitario) i).getIngrediente_activo(),
                            aplicacionesTable.getSelectedRow(),
                            aplicacionesTable.getSelectedColumn() + 1);
                }
            }
        });
        for (ProductoFitosanitario pf : new ProductoFitosanitarioControl().leerTodos()) {
            comboBox.addItem(pf);
        }
        productoColumn.setCellEditor(new DefaultCellEditor(comboBox));

        productoColumn = aplicacionesTable.getColumnModel().getColumn(0);
        DatePickerCellEditor picker = new DatePickerCellEditor();
        picker.setClickCountToStart(-1);
        productoColumn.setCellEditor(picker);
        productoColumn.setCellRenderer(new DefaultTableRenderer(stringValue, JLabel.RIGHT));

        productoColumn = aplicacionesTable.getColumnModel().getColumn(8);
        comboBox = new JComboBox();
        for (EquipoDeAplicacionFitosanitaria eaf : new EquipoDeAplicacionFitosanitariaControl().leerTodos()) {
            comboBox.addItem(eaf);
        }
        productoColumn.setCellEditor(new DefaultCellEditor(comboBox));
    }
}
