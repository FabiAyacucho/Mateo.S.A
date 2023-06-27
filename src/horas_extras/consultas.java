package horas_extras;

import APP.Conexion;
import inicio.inicio;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class consultas extends javax.swing.JFrame {

    public consultas() {
        initComponents();
        cargarSectores();
        Limpiar();
    }

    private void cargarSectores() {
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT sector FROM empleados");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String sector = rs.getString("sector");
                jComboBox1.addItem(sector);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jCalendarEntreda = new com.toedter.calendar.JCalendar();
        jCalendarSalida = new com.toedter.calendar.JCalendar();
        btnLimpiar = new javax.swing.JButton();
        btnVerJcalender = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        txtFecha2 = new javax.swing.JTextField();
        txtFecha1 = new javax.swing.JTextField();
        btnLimpiarSector = new javax.swing.JButton();
        btnVerSector = new javax.swing.JButton();
        lbCantidadHoras1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bynImprimir = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        btnVerFeriado = new javax.swing.JButton();
        lbCantidadHorfERIADO = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lbFondo = new javax.swing.JLabel();
        lbCantidadHoraSector = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CONSULTA DE HORAS EXTRAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 23, 184, 25));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 54, 244, 10));

        jLabel3.setText("hasta:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, -1, -1));

        jCalendarEntreda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCalendarEntredaMouseClicked(evt);
            }
        });
        jCalendarEntreda.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarEntredaPropertyChange(evt);
            }
        });
        jPanel1.add(jCalendarEntreda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 320, 190));

        jCalendarSalida.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarSalidaPropertyChange(evt);
            }
        });
        jPanel1.add(jCalendarSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 340, 190));

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 140, -1));

        btnVerJcalender.setText("CONSULTAR");
        btnVerJcalender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerJcalenderActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerJcalender, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 140, -1));

        jLabel4.setText("FILTRAR POR FECHA :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 190, -1));

        jLabel6.setText("desde:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        btnMenu.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnMenu.setText("MENU PRINCIPAL");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, 20));
        jPanel1.add(txtFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 90, 30));
        jPanel1.add(txtFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnLimpiarSector.setText("LIMPIAR");
        btnLimpiarSector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSectorActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiarSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 140, -1));

        btnVerSector.setText("CONSULTAR");
        btnVerSector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSectorActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 140, -1));

        lbCantidadHoras1.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        getContentPane().add(lbCantidadHoras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 540, 30));

        jLabel2.setText("FILTRAR POR FERIADO/DOMINGO :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 400, 30));

        bynImprimir.setText("IMPRIMIR");
        bynImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bynImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(bynImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 100, 50));

        btnLimpiar2.setText("LIMPIAR");
        getContentPane().add(btnLimpiar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 530, 140, -1));

        btnVerFeriado.setText("CONSULTAR");
        btnVerFeriado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerFeriadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerFeriado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 140, -1));

        lbCantidadHorfERIADO.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        getContentPane().add(lbCantidadHorfERIADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 750, 40));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 420, 30));

        jLabel5.setText("FILTRAR POR SERTOR :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 190, 30));
        getContentPane().add(lbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 620));

        lbCantidadHoraSector.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        getContentPane().add(lbCantidadHoraSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 540, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSectorActionPerformed
        String sectorSeleccionado = (String) jComboBox1.getSelectedItem();

        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT SUM(he.cantidad_hora) AS cantidad_hora FROM hora_extra he JOIN empleados emp ON he.legajo = emp.legajo WHERE emp.sector = ?");
            ps.setString(1, sectorSeleccionado);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int cantidadHoras = rs.getInt("cantidad_hora");
                lbCantidadHoraSector.setText("La cantidad de horas extras  para el sector seleccionado es: " + cantidadHoras);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron registros para el sector seleccionado.");
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnVerSectorActionPerformed

    private void btnLimpiarSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSectorActionPerformed
       Limpiar();        
    }//GEN-LAST:event_btnLimpiarSectorActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        inicio ir = new inicio();
        ir.setVisible(true);
        hide();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnVerJcalenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerJcalenderActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Obtener las fechas seleccionadas en jCalendarEntreda y jCalendarSalida
        java.util.Date fechaEntrada = jCalendarEntreda.getDate();
        java.util.Date fechaSalida = jCalendarSalida.getDate();
        String fechaEntradaStr = sdf.format(fechaEntrada);
        String fechaSalidaStr = sdf.format(fechaSalida);
        // Crear objetos java.sql.Date a partir de las fechas seleccionadas
        java.sql.Date sqlFechaEntrada = new java.sql.Date(fechaEntrada.getTime());
        java.sql.Date sqlFechaSalida = new java.sql.Date(fechaSalida.getTime());

        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT SUM(cantidad_hora) AS cantidad_hora FROM hora_extra WHERE fecha BETWEEN ? AND ?");
            ps.setString(1, fechaEntradaStr);
            ps.setString(2, fechaSalidaStr);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int cantidadHoras = rs.getInt("cantidad_hora");
                lbCantidadHoras1.setText("La cantidad de horas extras entre las fechas seleccionadas es: " + cantidadHoras);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnVerJcalenderActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
      Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jCalendarEntredaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCalendarEntredaMouseClicked

    }//GEN-LAST:event_jCalendarEntredaMouseClicked

    private void jCalendarEntredaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarEntredaPropertyChange
        actualizarFechas1();
    }//GEN-LAST:event_jCalendarEntredaPropertyChange

    private void jCalendarSalidaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarSalidaPropertyChange
        actualizarFechas2();
    }//GEN-LAST:event_jCalendarSalidaPropertyChange

    private void btnVerFeriadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerFeriadoActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // Obtener las fechas seleccionadas en jCalendarEntreda y jCalendarSalida
    java.util.Date fechaEntrada = jCalendarEntreda.getDate();
    java.util.Date fechaSalida = jCalendarSalida.getDate();
    String fechaEntradaStr = sdf.format(fechaEntrada);
    String fechaSalidaStr = sdf.format(fechaSalida);
    // Crear objetos java.sql.Date a partir de las fechas seleccionadas
    java.sql.Date sqlFechaEntrada = new java.sql.Date(fechaEntrada.getTime());
    java.sql.Date sqlFechaSalida = new java.sql.Date(fechaSalida.getTime());

    try {
        Connection con = Conexion.getConexion();
        PreparedStatement ps = con.prepareStatement("SELECT SUM(cantidad_hora) AS cantidad_hora FROM hora_extra WHERE fecha BETWEEN ? AND ? AND feriado_domingo = 'SI'");
        ps.setString(1, fechaEntradaStr);
        ps.setString(2, fechaSalidaStr);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int cantidadHoras = rs.getInt("cantidad_hora");
            lbCantidadHorfERIADO.setText("La cantidad de horas extras en feriados/domingos entre las fechas seleccionadas es: " + cantidadHoras);
        } else {
            lbCantidadHorfERIADO.setText("No se encontraron horas extras en feriados/domingos entre las fechas seleccionadas.");
        }

        rs.close();
        ps.close();
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnVerFeriadoActionPerformed

    private void bynImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bynImprimirActionPerformed
          JFrame frame = new JFrame("consulta");
                 JFramePrinter printer = new JFramePrinter(frame);
                 printer.imprimir();
    }//GEN-LAST:event_bynImprimirActionPerformed

    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultas().setVisible(true);
                
            }
        });
    }

    private void actualizarFechas1() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // Obtener la fecha seleccionada en jCalendarEntrada
        java.util.Date fechaEntrada = jCalendarEntreda.getDate();
        String fechaEntradaStr = sdf.format(fechaEntrada);
        txtFecha1.setText(fechaEntradaStr);
    }

    private void actualizarFechas2() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date fechaSalida = jCalendarSalida.getDate();
        String fechaSalidaStr = sdf.format(fechaSalida);

        // Actualizar los campos de texto con las fechas seleccionadas
        txtFecha2.setText(fechaSalidaStr);
    }
     private void Limpiar(){
        lbCantidadHoras1.setText("");
        txtFecha1.setText("");
        txtFecha2.setText("");
        lbCantidadHorfERIADO.setText("");
        lbCantidadHorfERIADO.setText("");
     }
 
     
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnLimpiarSector;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnVerFeriado;
    private javax.swing.JButton btnVerJcalender;
    private javax.swing.JButton btnVerSector;
    private javax.swing.JButton bynImprimir;
    private com.toedter.calendar.JCalendar jCalendarEntreda;
    private com.toedter.calendar.JCalendar jCalendarSalida;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCantidadHoraSector;
    private javax.swing.JLabel lbCantidadHoras1;
    private javax.swing.JLabel lbCantidadHorfERIADO;
    private javax.swing.JLabel lbFondo;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    // End of variables declaration//GEN-END:variables
    }
