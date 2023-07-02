package horas_extras;

import APP.Conexion;
import inicio.inicio;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class consultas extends javax.swing.JFrame {

    public consultas() {
        initComponents();
        Color customColor = new Color(249, 249, 249);

        jCalendarEntreda.setBackground(customColor);
        jCalendarEntreda.getDayChooser().getDayPanel().setBackground(customColor);
        jCalendarEntreda.getDayChooser().getDayPanel().setBorder(null);
        jCalendarEntreda.getMonthChooser().setBackground(customColor);
        jCalendarEntreda.getMonthChooser().setBorder(null);
        jCalendarEntreda.getYearChooser().setBackground(customColor);
        jCalendarEntreda.getYearChooser().setBorder(null);

        jCalendarSalida.setBackground(customColor);
        jCalendarSalida.getDayChooser().getDayPanel().setBackground(customColor);
        jCalendarSalida.getDayChooser().getDayPanel().setBorder(null);
        jCalendarSalida.getMonthChooser().setBackground(customColor);
        jCalendarSalida.getMonthChooser().setBorder(null);
        jCalendarSalida.getYearChooser().setBackground(customColor);
        jCalendarSalida.getYearChooser().setBorder(null);

        cargarSectores();
        actualizarFechas1();
        establecerFechaActualEnCampoTexto();
        establecerFechaActualEnCampoTexto2();

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
        jLabel3 = new javax.swing.JLabel();
        btnVerJcalender = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtFecha2 = new javax.swing.JTextField();
        txtFecha1 = new javax.swing.JTextField();
        jCalendarEntreda = new com.toedter.calendar.JCalendar();
        jCalendarSalida = new com.toedter.calendar.JCalendar();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lbCantidadHoras1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        bynImprimir = new javax.swing.JButton();
        btnVerSector = new javax.swing.JButton();
        lbCantidadHoraSector = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnLimpiar = new javax.swing.JButton();
        btnVerFeriado = new javax.swing.JButton();
        lbCantidadHorfERIADO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(30, 144, 255));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("HASTA:");

        btnVerJcalender.setBackground(new java.awt.Color(177, 197, 213));
        btnVerJcalender.setText("CONSULTAR");
        btnVerJcalender.setBorder(null);
        btnVerJcalender.setDoubleBuffered(true);
        btnVerJcalender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerJcalenderActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("DESDE:");

        jCalendarEntreda.setBackground(new java.awt.Color(249, 249, 249));
        jCalendarEntreda.setBorder(new javax.swing.border.MatteBorder(null));
        jCalendarEntreda.setForeground(new java.awt.Color(0, 86, 145));
        jCalendarEntreda.setToolTipText("");
        jCalendarEntreda.setWeekOfYearVisible(false);
        jCalendarEntreda.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarEntredaPropertyChange(evt);
            }
        });

        jCalendarSalida.setBackground(new java.awt.Color(249, 249, 249));
        jCalendarSalida.setBorder(new javax.swing.border.MatteBorder(null));
        jCalendarSalida.setForeground(new java.awt.Color(0, 86, 145));
        jCalendarSalida.setToolTipText("");
        jCalendarSalida.setWeekOfYearVisible(false);
        jCalendarSalida.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarSalidaPropertyChange(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("FILTRAR POR FECHA :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCalendarEntreda, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(btnVerJcalender, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jCalendarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCalendarEntreda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(txtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnVerJcalender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCalendarSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 930, 210));

        jPanel2.setBackground(new java.awt.Color(249, 249, 249));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenu.setBackground(new java.awt.Color(177, 197, 213));
        btnMenu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMenu.setText("MENU PRINCIPAL");
        btnMenu.setBorder(null);
        btnMenu.setDoubleBuffered(true);
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel2.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 140, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CONSULTA DE HORAS EXTRAS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 270, 25));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 260, 10));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("BATERIAS");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 140, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mateo-logo-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 430, 110));

        jLabel2.setText("FILTRAR POR FERIADO/DOMINGO :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 200, 30));

        jComboBox1.setForeground(new java.awt.Color(0, 86, 145));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 390, 30));

        jLabel5.setText("FILTRAR POR SERTOR :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 140, 30));

        lbCantidadHoras1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(lbCantidadHoras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 330, 750, 40));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 372, 920, 10));

        bynImprimir.setBackground(new java.awt.Color(177, 197, 213));
        bynImprimir.setText("IMPRIMIR");
        bynImprimir.setBorder(null);
        bynImprimir.setDoubleBuffered(true);
        bynImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bynImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(bynImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, 140, 40));

        btnVerSector.setBackground(new java.awt.Color(177, 197, 213));
        btnVerSector.setText("CONSULTAR");
        btnVerSector.setBorder(null);
        btnVerSector.setDoubleBuffered(true);
        btnVerSector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSectorActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 150, 30));

        lbCantidadHoraSector.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(lbCantidadHoraSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 540, 40));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 472, 920, 10));

        btnLimpiar.setBackground(new java.awt.Color(177, 197, 213));
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setBorder(null);
        btnLimpiar.setDoubleBuffered(true);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, 140, 40));

        btnVerFeriado.setBackground(new java.awt.Color(177, 197, 213));
        btnVerFeriado.setText("CONSULTAR");
        btnVerFeriado.setBorder(null);
        btnVerFeriado.setDoubleBuffered(true);
        btnVerFeriado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerFeriadoActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerFeriado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 150, 30));

        lbCantidadHorfERIADO.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(lbCantidadHorfERIADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 720, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 620));

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

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jCalendarSalidaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarSalidaPropertyChange
        if ("calendar".equals(evt.getPropertyName())) {
            actualizarFechas2();
        }
    }//GEN-LAST:event_jCalendarSalidaPropertyChange

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

    private void jCalendarEntredaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarEntredaPropertyChange
        if ("calendar".equals(evt.getPropertyName())) {
            actualizarFechas1();
        }
    }//GEN-LAST:event_jCalendarEntredaPropertyChange

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

    private void Limpiar() {
        lbCantidadHoras1.setText("");
        lbCantidadHorfERIADO.setText("");
        lbCantidadHoraSector.setText("");
        establecerFechaActualEnCampoTexto();
        establecerFechaActualEnCampoTexto2();

    }

    public void establecerFechaActualEnCampoTexto() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaActual = new Date();
        String fechaActualStr = sdf.format(fechaActual);
        txtFecha1.setText(fechaActualStr);
    }

    public void establecerFechaActualEnCampoTexto2() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaActual = new Date();
        String fechaActualStr = sdf.format(fechaActual);
        txtFecha2.setText(fechaActualStr);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbCantidadHoraSector;
    private javax.swing.JLabel lbCantidadHoras1;
    private javax.swing.JLabel lbCantidadHorfERIADO;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    // End of variables declaration//GEN-END:variables
}
