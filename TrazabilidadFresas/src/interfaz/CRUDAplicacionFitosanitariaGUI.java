/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import control.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.*;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;
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

    public CRUDAplicacionFitosanitariaGUI() {

        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Aplicaciones Fitosanitarias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(204, 204, 255)));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        aplicacionesTable.setBackground(new java.awt.Color(153, 153, 255));
        aplicacionesTable.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        aplicacionesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Siembra", "Producto", "Ingrediente Activo", "Motivo de la aplicación", "PC", "Tr", "Cantidad aplicada", "Agua utilizada", "Equipo utilizado", "Responsable", "Autorizado", "Jornales", "Observaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
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

        jXDatePicker1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(204, 204, 255));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jCheckBox1.setText("Última Semana");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
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
                .addGap(145, 145, 145)
                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarButton)
                    .addComponent(guardarButton)
                    .addComponent(borrarButton)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXDatePicker1.setDate(new Date());

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
            Object[] fila = {new Date(), null, new ProductoFitosanitario(),
                "", "", false, false, 0.0, 0.0, new EquipoDeAplicacionFitosanitaria(),
                new Fresicultor(), new Administrador(), 0, ""};
            modelo.addRow(fila);
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
            adm.setFecha((Date) aplicacionesTable.getValueAt(filaEditable, 0));
            adm.setSiembra((Siembra) aplicacionesTable.getValueAt(filaEditable, 1));
            adm.setProductoFitosanitario((ProductoFitosanitario) aplicacionesTable.getValueAt(filaEditable, 2));
            adm.setMotivo((String) aplicacionesTable.getValueAt(filaEditable, 4));
            adm.setPc(aplicacionesTable.getValueAt(filaEditable, 5) != null && (Boolean) aplicacionesTable.getValueAt(filaEditable, 5));
            adm.setTr(aplicacionesTable.getValueAt(filaEditable, 6) != null && (Boolean) aplicacionesTable.getValueAt(filaEditable, 6));
            adm.setCantidadAplicada((double) aplicacionesTable.getValueAt(filaEditable, 7));
            adm.setLitrosDeAguaUtilizada((double) aplicacionesTable.getValueAt(filaEditable, 8));
            adm.setEquipoDeAplicacionFitosanitaria((EquipoDeAplicacionFitosanitaria) aplicacionesTable.getValueAt(filaEditable, 9));
            adm.setFresicultor((Fresicultor) aplicacionesTable.getValueAt(filaEditable, 10));
            adm.setAdministrador((Administrador) aplicacionesTable.getValueAt(filaEditable, 11));
            adm.setJornales((double) aplicacionesTable.getValueAt(filaEditable, 12));
            adm.setObservaciones((String) aplicacionesTable.getValueAt(filaEditable, 13));
            if (!new AplicacionFitosanitariaControl().crear(adm)) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        actualizarTabla();
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void borrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarButtonActionPerformed
        // TODO add your handling code here:
        if (aplicacionesTable.getSelectedRow() > -1) {
            AplicacionFitosanitaria a = (AplicacionFitosanitaria) aplicaciones.get(aplicacionesTable.getSelectedRow());
            new AplicacionFitosanitariaControl().eliminar(a);
            actualizarTabla();
        }
    }//GEN-LAST:event_borrarButtonActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        // TODO add your handling code here:
        actualizarTabla();
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        jXDatePicker1.setEnabled(!jCheckBox1.isSelected());
        actualizarTabla();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) aplicacionesTable.getModel();
        if (jCheckBox1.isSelected()) {
            aplicaciones = (ArrayList) new AplicacionFitosanitariaControl().leerUltimos();
        } else {
            aplicaciones = (ArrayList) new AplicacionFitosanitariaControl().leerTodos(jXDatePicker1.getDate());
        }
        for (int i = 0; i < aplicaciones.size(); i++) {
            AplicacionFitosanitaria a = (AplicacionFitosanitaria) aplicaciones.get(i);
            Object[] datos = {a.getFecha(),
                a.getSiembra(),
                a.getProductoFitosanitario(),
                a.getProductoFitosanitario().getIngredienteActivo(),
                a.getMotivo(),
                a.isPc(),
                a.isTr(),
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
        editing = false;
    }

    private void setCellEditors() {
        //ComboBox de producto fitosanitario
        TableColumn productoColumn = aplicacionesTable.getColumnModel().getColumn(2);
        JComboBox comboBox = new JComboBox();
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                if (arg0.getStateChange() == ItemEvent.SELECTED
                        && aplicacionesTable.getSelectedRow() > -1
                        && aplicacionesTable.getSelectedColumn() > -1) {
                    Object i = arg0.getItem();
                    aplicacionesTable.setValueAt(((ProductoFitosanitario) i).getIngredienteActivo(),
                            aplicacionesTable.getSelectedRow(),
                            aplicacionesTable.getSelectedColumn() + 1);
                }
            }
        });
        for (ProductoFitosanitario pf : new ProductoFitosanitarioControl().leerTodos()) {
            comboBox.addItem(pf);
        }
        productoColumn.setCellEditor(new DefaultCellEditor(comboBox));
        //DatePicker de fecha
        productoColumn = aplicacionesTable.getColumnModel().getColumn(0);
        DatePickerCellEditor picker = new DatePickerCellEditor();
        picker.setClickCountToStart(-1);
        productoColumn.setCellEditor(picker);
        productoColumn.setCellRenderer(new DefaultTableRenderer(new CustomDateFormatter().getStringValue(), JLabel.RIGHT));
        //ComboBox de equipos de aplicacion fitosanitaria
        productoColumn = aplicacionesTable.getColumnModel().getColumn(9);
        comboBox = new JComboBox();
        for (EquipoDeAplicacionFitosanitaria eaf : new EquipoDeAplicacionFitosanitariaControl().leerTodos()) {
            comboBox.addItem(eaf);
        }
        productoColumn.setCellEditor(new DefaultCellEditor(comboBox));
        //ComboBox de responsable
        productoColumn = aplicacionesTable.getColumnModel().getColumn(10);
        comboBox = new JComboBox();
        for (Fresicultor f : new FresicultorControl().leerTodos()) {
            comboBox.addItem(f);
        }
        productoColumn.setCellEditor(new DefaultCellEditor(comboBox));
        //ComboBox de autorizado
        productoColumn = aplicacionesTable.getColumnModel().getColumn(11);
        comboBox = new JComboBox();
        for (Administrador f : new AdministradorControl().leerTodos()) {
            comboBox.addItem(f);
        }
        productoColumn.setCellEditor(new DefaultCellEditor(comboBox));
        //ComboBox de siembra
        productoColumn = aplicacionesTable.getColumnModel().getColumn(1);
        comboBox = new JComboBox();
        for (Siembra s : new SiembraControl().leerTodos()) {
            comboBox.addItem(s);
        }
        productoColumn.setCellEditor(new DefaultCellEditor(comboBox));
    }

    private void actualizarTabla() {
        borrarTabla();
        setCellEditors();
        cargarTabla();
    }
}
