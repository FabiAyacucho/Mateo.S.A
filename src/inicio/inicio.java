package inicio;

import horas_extras.Liquidacion;
import APP.empleado;
import APP.productos.Producto;
import EntregaProducto.entrega;
import horas_extras.horas_extras;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import sistema.loginAdmin;

public class inicio extends javax.swing.JFrame {

    public inicio() {
        initComponents();

    }
    @Override
    public Image getIconImage(){
        
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("./imagenes/icon.jpeg"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbBateria = new javax.swing.JLabel();
        btnHorasExtras = new javax.swing.JButton();
        btNEentrega = new javax.swing.JButton();
        btnConsultaHoras = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnStockInventario = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnCargaEmpleado = new javax.swing.JButton();
        lbMATEO = new javax.swing.JLabel();
        lbFondo = new javax.swing.JLabel();
        btnStockInventario2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIO");
        setLocation(new java.awt.Point(200, 200));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(640, 330));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbBateria.setFont(new java.awt.Font("Rockwell Extra Bold", 3, 14)); // NOI18N
        lbBateria.setForeground(new java.awt.Color(255, 255, 255));
        lbBateria.setText("BATERIAS");
        jPanel1.add(lbBateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 160, -1));

        btnHorasExtras.setBackground(new java.awt.Color(191, 245, 244));
        btnHorasExtras.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnHorasExtras.setText("HORAS EXTRAS");
        btnHorasExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorasExtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnHorasExtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 180, 40));

        btNEentrega.setBackground(new java.awt.Color(191, 245, 244));
        btNEentrega.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btNEentrega.setText("ENTREGA DE PRODUCTOS");
        btNEentrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNEentregaActionPerformed(evt);
            }
        });
        jPanel1.add(btNEentrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 180, 40));

        btnConsultaHoras.setBackground(new java.awt.Color(191, 245, 244));
        btnConsultaHoras.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnConsultaHoras.setText("CONSULTA HORAS EXTRAS");
        btnConsultaHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaHorasActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultaHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 180, 40));

        btnAdmin.setBackground(new java.awt.Color(191, 245, 244));
        btnAdmin.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAdmin.setText("ADMIN");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, 180, 40));

        btnStockInventario.setBackground(new java.awt.Color(191, 245, 244));
        btnStockInventario.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnStockInventario.setText("STOCK INVENTARIO");
        btnStockInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockInventarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnStockInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 180, 40));

        btnExit.setBackground(new java.awt.Color(191, 245, 244));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 180, 40));

        btnCargaEmpleado.setBackground(new java.awt.Color(191, 245, 244));
        btnCargaEmpleado.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnCargaEmpleado.setText("CARGA DE EMPLEADOS");
        btnCargaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargaEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 180, 40));

        lbMATEO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mateo-logo-removebg-preview.png"))); // NOI18N
        jPanel1.add(lbMATEO, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 490, 120));

        lbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FONDO-BLOG.jpg"))); // NOI18N
        jPanel1.add(lbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        btnStockInventario2.setBackground(new java.awt.Color(191, 245, 244));
        btnStockInventario2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnStockInventario2.setText("STOCK INVENTARIO");
        btnStockInventario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockInventario2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnStockInventario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 180, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStockInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockInventarioActionPerformed
        Producto produc = new Producto();
        produc.setVisible(true);
        hide();

    }//GEN-LAST:event_btnStockInventarioActionPerformed

    private void btNEentregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNEentregaActionPerformed
        entrega entregas = new entrega();
        entregas.setVisible(true);
        hide();
    }//GEN-LAST:event_btNEentregaActionPerformed

    private void btnCargaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaEmpleadoActionPerformed
        empleado irr = new empleado();
        irr.setVisible(true);
        hide();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCargaEmpleadoActionPerformed

    private void btnHorasExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorasExtrasActionPerformed
        horas_extras hs = new horas_extras();
        hs.setVisible(true);
        hide();

    }//GEN-LAST:event_btnHorasExtrasActionPerformed

    private void btnConsultaHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaHorasActionPerformed
        Liquidacion liquidacion = new Liquidacion();
        liquidacion.setVisible(true);
        hide();
    }//GEN-LAST:event_btnConsultaHorasActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        loginAdmin admin = new loginAdmin();
        admin.setVisible(true);
        hide();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnStockInventario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockInventario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStockInventario2ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                inicio frame = new inicio();
              ImageIcon icon = new ImageIcon("./imagenes/icon.jpeg");
    Image image = icon.getImage();
    Image resizedImage = image.getScaledInstance(128, 128, Image.SCALE_SMOOTH);

    // Establecer el ícono de la aplicación
    frame.setIconImage(resizedImage);

    frame.setVisible(true);
               
            }
        });
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNEentrega;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnCargaEmpleado;
    private javax.swing.JButton btnConsultaHoras;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHorasExtras;
    private javax.swing.JButton btnStockInventario;
    private javax.swing.JButton btnStockInventario2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbBateria;
    private javax.swing.JLabel lbFondo;
    private javax.swing.JLabel lbMATEO;
    // End of variables declaration//GEN-END:variables

}
