/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

/**
 *
 * @author Javier
 */
public class GestionDeEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form GestioDeEmpleados
     */
    public GestionDeEmpleados() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        LabelNombreCompleto = new javax.swing.JLabel();
        LabelIDEmpleado = new javax.swing.JLabel();
        LabelFechaIngreso = new javax.swing.JLabel();
        ComboTipoDeEmpleado = new javax.swing.JComboBox<>();
        CampoBuscarPorNombre = new javax.swing.JTextField();
        BtnAgregarEmpleado = new javax.swing.JButton();
        BtnConsultarInformacion = new javax.swing.JButton();
        BtnEditarInformacion = new javax.swing.JButton();
        BtnEliminarEmpleado = new javax.swing.JButton();
        BtnCerrarSesion = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        LabelNombreCompleto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelNombreCompleto.setText("Nombre completo");

        LabelIDEmpleado.setBackground(new java.awt.Color(0, 102, 102));
        LabelIDEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelIDEmpleado.setText("ID del empleado");

        LabelFechaIngreso.setBackground(new java.awt.Color(255, 255, 255));
        LabelFechaIngreso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelFechaIngreso.setText("Fecha de ingreso");

        ComboTipoDeEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ComboTipoDeEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de empleado" }));
        ComboTipoDeEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTipoDeEmpleadoActionPerformed(evt);
            }
        });

        CampoBuscarPorNombre.setBackground(new java.awt.Color(0, 102, 102));
        CampoBuscarPorNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CampoBuscarPorNombre.setForeground(new java.awt.Color(255, 255, 255));
        CampoBuscarPorNombre.setText("Buscar empleado por nombre");

        BtnAgregarEmpleado.setBackground(new java.awt.Color(0, 102, 102));
        BtnAgregarEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnAgregarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregarEmpleado.setText("Agregar empleado");
        BtnAgregarEmpleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BtnConsultarInformacion.setBackground(new java.awt.Color(0, 102, 102));
        BtnConsultarInformacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnConsultarInformacion.setForeground(new java.awt.Color(255, 255, 255));
        BtnConsultarInformacion.setText("Consultar información");
        BtnConsultarInformacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BtnEditarInformacion.setBackground(new java.awt.Color(0, 102, 102));
        BtnEditarInformacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnEditarInformacion.setForeground(new java.awt.Color(255, 255, 255));
        BtnEditarInformacion.setText("Editar información");
        BtnEditarInformacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnEditarInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarInformacionActionPerformed(evt);
            }
        });

        BtnEliminarEmpleado.setBackground(new java.awt.Color(0, 102, 102));
        BtnEliminarEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnEliminarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        BtnEliminarEmpleado.setText("Eliminar empleado");
        BtnEliminarEmpleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BtnCerrarSesion.setBackground(new java.awt.Color(255, 153, 0));
        BtnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        BtnCerrarSesion.setText("Cerrar sesion");
        BtnCerrarSesion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarSesionActionPerformed(evt);
            }
        });

        BtnSalir.setBackground(new java.awt.Color(255, 51, 0));
        BtnSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnSalir.setForeground(new java.awt.Color(255, 255, 255));
        BtnSalir.setText("Salir");
        BtnSalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Ricardo Javier Medina Caballero", "12345", "Farmaceutico", "20/11/2024"},
                {"", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CampoBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnCerrarSesion)
                                .addGap(61, 61, 61)
                                .addComponent(BtnSalir))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(LabelNombreCompleto))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(BtnAgregarEmpleado)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelIDEmpleado)
                                .addGap(50, 50, 50)
                                .addComponent(ComboTipoDeEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(BtnConsultarInformacion)
                                .addGap(54, 54, 54)
                                .addComponent(BtnEditarInformacion)
                                .addGap(0, 23, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(BtnEliminarEmpleado))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelFechaIngreso)
                                .addGap(37, 37, 37)))))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCerrarSesion)
                    .addComponent(BtnSalir))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNombreCompleto)
                    .addComponent(LabelIDEmpleado)
                    .addComponent(ComboTipoDeEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelFechaIngreso))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnConsultarInformacion)
                    .addComponent(BtnAgregarEmpleado)
                    .addComponent(BtnEditarInformacion)
                    .addComponent(BtnEliminarEmpleado))
                .addGap(55, 55, 55))
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

    private void ComboTipoDeEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTipoDeEmpleadoActionPerformed

    }//GEN-LAST:event_ComboTipoDeEmpleadoActionPerformed

    private void BtnEditarInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarInformacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEditarInformacionActionPerformed

    private void BtnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCerrarSesionActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(GestionDeEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionDeEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionDeEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionDeEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionDeEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarEmpleado;
    private javax.swing.JButton BtnCerrarSesion;
    private javax.swing.JButton BtnConsultarInformacion;
    private javax.swing.JButton BtnEditarInformacion;
    private javax.swing.JButton BtnEliminarEmpleado;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JTextField CampoBuscarPorNombre;
    private javax.swing.JComboBox<String> ComboTipoDeEmpleado;
    private javax.swing.JLabel LabelFechaIngreso;
    private javax.swing.JLabel LabelIDEmpleado;
    private javax.swing.JLabel LabelNombreCompleto;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}