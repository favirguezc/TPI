/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import control.AdministradorControl;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Administrador;

/**
 *
 * @author fredy
 */
public class CRUDAdministradorGUI extends javax.swing.JFrame {

    /**
     * Creates new form CRUDAdministradorGUI
     */
    private boolean editing = false;
    private int filaEditable = -1;
    private ArrayList administradores = new ArrayList();

    public CRUDAdministradorGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cargarTabla();
        administradoresTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = administradoresTable.rowAtPoint(e.getPoint());
                int columna = administradoresTable.columnAtPoint(e.getPoint());
                if (editing && fila > -1 && columna > -1) {
                    if (filaEditable != -1 && fila == filaEditable) {
                        String mensaje = "";
                        switch (columna) {
                            case 0:
                                mensaje = "Ingrese el numero de cédula";
                                break;
                            case 1:
                                mensaje = "Ingrese los nombres";
                                break;
                            case 2:
                                mensaje = "Ingrese los apellidos";
                                break;
                            case 3:
                                mensaje = "Ingrese la fecha de nacimiento así: dd/mm/aaaa";
                                break;
                            case 4:
                                mensaje = "Ingrese la clave";
                                break;
                        }
                        String m = JOptionPane.showInputDialog(mensaje);
                        administradoresTable.setValueAt(m, fila, columna);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        administradoresTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        agregarButton = new javax.swing.JButton();
        borrarButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administradores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 153, 255)));

        administradoresTable.setBackground(new java.awt.Color(204, 204, 255));
        administradoresTable.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        administradoresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombres", "Apellidos", "Fecha de nacimiento", "Clave"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        administradoresTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        administradoresTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(administradoresTable);
        if (administradoresTable.getColumnModel().getColumnCount() > 0) {
            administradoresTable.getColumnModel().getColumn(0).setResizable(false);
            administradoresTable.getColumnModel().getColumn(1).setResizable(false);
            administradoresTable.getColumnModel().getColumn(2).setResizable(false);
            administradoresTable.getColumnModel().getColumn(3).setResizable(false);
            administradoresTable.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(153, 153, 255)));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            DefaultTableModel modelo = (DefaultTableModel) administradoresTable.getModel();
            Object[] fila = {0, "", "", null, ""};
            modelo.addRow(fila);
            filaEditable = modelo.getRowCount() - 1;
            guardarButton.setEnabled(true);
            editing = true;
        }
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        // TODO add your handling code here:
        editing = false;
        Administrador adm = new Administrador();
        try {
            adm.setApellidos((String) administradoresTable.getValueAt(filaEditable, 2));
            adm.setCedula(Long.parseLong((String) administradoresTable.getValueAt(filaEditable, 0)));
            adm.setNombres((String) administradoresTable.getValueAt(filaEditable, 1));
            adm.setClave((String) administradoresTable.getValueAt(filaEditable, 4));
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
            String strFecha = (String) administradoresTable.getValueAt(filaEditable, 3);
            strFecha = strFecha.replaceAll(" ", "");
            Date fecha = null;
            fecha = formatoDelTexto.parse(strFecha);
            adm.setFechadeNacimiento(fecha);
            if (!new AdministradorControl().crear(adm)) {
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
        if (administradoresTable.getSelectedRow() > -1) {
            Administrador a = (Administrador) administradores.get(administradoresTable.getSelectedRow());
            new AdministradorControl().eliminar(a);
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
            java.util.logging.Logger.getLogger(CRUDAdministradorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDAdministradorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDAdministradorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDAdministradorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDAdministradorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable administradoresTable;
    private javax.swing.JButton agregarButton;
    private javax.swing.JButton borrarButton;
    private javax.swing.JButton guardarButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) administradoresTable.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        administradores = (ArrayList) new AdministradorControl().leerTodos();
        for (int i = 0; i < administradores.size(); i++) {
            Administrador a = (Administrador) administradores.get(i);
            String fecha = sdf.format(a.getFechadeNacimiento());
            String clave = "";
            for (int k = 0; k < a.getClave().length(); k++) {
                clave += "*";
            }
            Object[] datos = {a.getCedula(), a.getNombres(), a.getApellidos(), fecha, clave};
            modelo.addRow(datos);
        }
    }

    private void borrarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) administradoresTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
}
