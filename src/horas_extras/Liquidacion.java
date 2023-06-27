package horas_extras;

import APP.Conexion;
import APP.login1;
import java.awt.print.PrinterJob;
import inicio.inicio;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Liquidacion extends javax.swing.JFrame {

    public String textoBusqueda;
    List<String> legajos, nombres, apellidos = new ArrayList<>();
    private DefaultTableModel tableModel;

    private void imprimir() {
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(jTableLiq.getPrintable(JTable.PrintMode.FIT_WIDTH, null, null));
            if (job.printDialog()) {
                job.print();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Liquidacion() {
        initComponents();

        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Deshabilitar la edición de todas las celdas
                return false;
            }

        };

        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellido");
        tableModel.addColumn("Legajo");
        legajos = new ArrayList<>();
        nombres = new ArrayList<>();
        apellidos = new ArrayList<>();

        try {
            Connection con = Conexion.getConexion();
            PreparedStatement statement = con.prepareStatement("SELECT legajo,nombre,apellido FROM empleados ORDER BY nombre ASC, apellido ASC");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                String legajo = resultado.getString("legajo");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");

                Object[] fila = {nombre, apellido, legajo};
                tableModel.addRow(fila);
                legajos.add(legajo);
                nombres.add(nombre);
                apellidos.add(apellido);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        for (String legajo : legajos) {
            sb.append(legajo).append("\n");
        }
        for (String nombre : nombres) {
            sb.append(nombre).append("\n");
        }
        for (String apellido : apellidos) {
            sb.append(apellido).append("\n");
        }

        jTableLiq.setModel(tableModel);

        jTableLiq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });

    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTableLiq.getSelectedRow();
        String legajo = jTableLiq.getValueAt(selectedRow, 2).toString();
        String nombre = jTableLiq.getValueAt(selectedRow, 0).toString();
        String apellido = jTableLiq.getValueAt(selectedRow, 1).toString();

        // Asigna el nombre y apellido al campo txtBuscador
        txtBusqueda.setText(nombre + " " + apellido);

        // Realiza la consulta para obtener la cantidad de horas extra y su valor
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement statement = con.prepareStatement("SELECT SUM(cantidad_hora) AS total_horas, SUM(valor) AS total_valor FROM hora_extra WHERE legajo = ?");
            statement.setString(1, legajo);
            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                int totalHoras = resultado.getInt("total_horas");
                int totalValor = resultado.getInt("total_valor");
                int totalPagar = totalHoras * totalValor;

                // Muestra el total a pagar en el campo txtTotal
                txtTotal.setText(String.valueOf(totalPagar));
            } else {
                // No se encontraron resultados, puedes mostrar un mensaje o limpiar el campo txtTotal
                txtTotal.setText("");
            }

            resultado.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void limpiar() {
        txtBusqueda.setText("");
        txtTotal.setText("");

    }

    private void completarNombreApellido(String filtro) {
        String consulta = "SELECT nombre, apellido FROM empleados WHERE ( nombre LIKE ? OR apellido LIKE ? ,legajo Like ?)";
        Connection con = Conexion.getConexion();
        try (PreparedStatement stmt = con.prepareStatement(consulta)) {
            stmt.setString(1, filtro + "%");
            stmt.setString(2, filtro + "%");

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");

                String nombreCompleto = nombre + " " + apellido;

                // Completa el nombre y apellido en el TextField
                txtBusqueda.setText(nombreCompleto);
            } else {
                // No se encontraron resultados, puedes mostrar un mensaje o limpiar el TextField
                txtBusqueda.setText("");
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLiq = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        bynImprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BTNdETALLE = new javax.swing.JButton();
        txtLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtfILTRO = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtPagar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        getContentPane().add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 320, 30));

        jTableLiq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableLiq);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 321, 210));

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 140, -1));

        bynImprimir.setText("IMPRIMIR");
        bynImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bynImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(bynImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 100, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("TOTAL A PAGAR  $ :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 150, 40));

        BTNdETALLE.setText("VER DETALLE");
        BTNdETALLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTNdETALLEMouseClicked(evt);
            }
        });
        BTNdETALLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNdETALLEActionPerformed(evt);
            }
        });
        getContentPane().add(BTNdETALLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 140, -1));

        txtLimpiar.setText("LIMPIAR");
        txtLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(txtLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 110, 50));

        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 110, 50));

        jLabel4.setFont(new java.awt.Font("Rockwell Extra Bold", 3, 18)); // NOI18N
        jLabel4.setText("Detalle de horas Extras");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 450, 38));

        txtfILTRO.setText("FILTRAR POR FECHA/SECTOR/FERIADO");
        txtfILTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfILTROActionPerformed(evt);
            }
        });
        getContentPane().add(txtfILTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 330, 40));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 440));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 52, 320, 10));

        txtPagar1.setText("PAGAR");
        txtPagar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagar1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtPagar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 120, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        String filtro = txtBusqueda.getText(); // Obtener el texto del campo de búsqueda

        DefaultTableModel model = (DefaultTableModel) jTableLiq.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTableLiq.setRowSorter(sorter);

        if (filtro.trim().length() == 0) {
            sorter.setRowFilter(null); // No se aplica ningún filtro si el campo está vacío
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro)); // Aplicar filtro ignorando mayúsculas/minúsculas
        }


    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtfILTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfILTROActionPerformed
        consultas con = new consultas();
        con.setVisible(true);
        hide();
    }//GEN-LAST:event_txtfILTROActionPerformed

    private void BTNdETALLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNdETALLEActionPerformed
        if (txtBusqueda.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione el nombre y apellido por favor", "mensaje de informacion", JOptionPane.ERROR_MESSAGE);
        } else {
            verDetalle();
      hide();

        }


    }//GEN-LAST:event_BTNdETALLEActionPerformed

    private void BTNdETALLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTNdETALLEMouseClicked


    }//GEN-LAST:event_BTNdETALLEMouseClicked

    private void txtLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_txtLimpiarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        inicio ir = new inicio();
        ir.setVisible(true);
        hide();

    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtPagar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagar1ActionPerformed

    private void bynImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bynImprimirActionPerformed
        JFrame frame = new JFrame("consulta");
        JFramePrinter printer = new JFramePrinter(frame);
        printer.imprimir();
    }//GEN-LAST:event_bynImprimirActionPerformed
    private void verDetalle() {
        String nombreApellido = txtBusqueda.getText(); // Obtener el nombre y apellido del empleado seleccionado

        // Obtener el legajo a partir del nombre y apellido
        String[] partesNombreApellido = nombreApellido.split(" ");
        String nombre = partesNombreApellido[0];
        String apellido = partesNombreApellido[1];
        String legajo = null;

        try {
            Connection con = Conexion.getConexion();
            PreparedStatement statement = con.prepareStatement("SELECT legajo FROM empleados WHERE nombre = ? AND apellido = ?");
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                legajo = resultado.getString("legajo");

            }

            resultado.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Realizar la consulta de las horas extras para el legajo obtenido
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement statement = con.prepareStatement("SELECT cantidad_hora, hora_inicio, hora_fin, fecha, valor, feriado_domingo, motivo FROM hora_extra WHERE legajo = ?");
            statement.setString(1, legajo);
            ResultSet resultado = statement.executeQuery();

            // Crear la tabla para mostrar los datos
            JFrame frame = new JFrame("Detalle de horas extras");
            frame.setSize(900, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Cantidad de horas");
            tableModel.addColumn("Hora de inicio");
            tableModel.addColumn("Hora de fin");
            tableModel.addColumn("Fecha");
            tableModel.addColumn("Valor");
            tableModel.addColumn("Feriado o domingo");
            tableModel.addColumn("Motivo");

            // Agregar filas al modelo de la tabla
            while (resultado.next()) {
                int cantidadHoras = resultado.getInt("cantidad_hora");
                String horaInicio = resultado.getString("hora_inicio");
                String horaFin = resultado.getString("hora_fin");
                String fecha = resultado.getString("fecha");
                int valor = resultado.getInt("valor");
                String feriadoDomingo = resultado.getString("feriado_domingo");
                String motivo = resultado.getString("motivo");

                Object[] fila = {cantidadHoras, horaInicio, horaFin, fecha, valor, feriadoDomingo, motivo};
                tableModel.addRow(fila);
            }

            // Crear la tabla y agregarla a un JScrollPane
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);

            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setVisible(true);
            JButton btnImprimir = new JButton("Imprimir");
            JButton btnVolver = new JButton("  Volver  ");
            btnImprimir.setSize(50, 20);
            btnVolver.setSize(50, 20);

            btnVolver.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Liquidacion liquidacion = new Liquidacion();
                    liquidacion.setVisible(true);
                    frame.setVisible(false);
                }
            });

            btnImprimir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    imprimir();
                }
            });
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(btnImprimir);
            buttonPanel.add(btnVolver);

            frame.add(buttonPanel, BorderLayout.SOUTH);

            // Ajustar el tamaño del JFrame
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

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
            java.util.logging.Logger.getLogger(Liquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Liquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Liquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Liquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login1().setVisible(true);
            }
        });
    }
    /*
    public void reiniciarContadorYInsertarHorasPagas() {
    try {
        Connection con = Conexion.getConexion();

        // Reiniciar el contador de cantidad_hora en la tabla hora_extra
        PreparedStatement reiniciarContadorStmt = con.prepareStatement("UPDATE hora_extra SET cantidad_hora = 0 WHERE legajo = ?");
        reiniciarContadorStmt.executeUpdate();
        reiniciarContadorStmt.close();

        // Insertar los valores en la columna hora_pagas en la tabla hora_extra
        PreparedStatement insertarHorasPagasStmt = con.prepareStatement("INSERT INTO horas_pagas (hora_pagas) SELECT cantidad_hora FROM hora_extra");
        insertarHorasPagasStmt.executeUpdate();
        insertarHorasPagasStmt.close();

        con.close();

        // Mensaje de éxito
        JOptionPane.showMessageDialog(this, "Se reinició el contador de cantidad_hora y se insertaron los valores en hora_pagas",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
        e.printStackTrace();
        // Mensaje de error
        JOptionPane.showMessageDialog(this, "Error al reiniciar el contador y/o insertar las horas pagas",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNdETALLE;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton bynImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableLiq;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JButton txtLimpiar;
    private javax.swing.JButton txtPagar1;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JButton txtfILTRO;
    // End of variables declaration//GEN-END:variables

    

}
