package EntregaProducto;

import APP.Conexion;
import horas_extras.JFramePrinter;
import inicio.inicio;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

public class entrega extends javax.swing.JFrame {

    private String textoBusqueda;
    List<String> legajos, nombres, apellidos = new ArrayList<>();
    private DefaultTableModel tableModel;

    public entrega() {
        initComponents();
        Color customColor = new Color(249, 249, 249);

        jCalendar2.setBackground(customColor);
        jCalendar2.getDayChooser().getDayPanel().setBackground(customColor);
        jCalendar2.getDayChooser().getDayPanel().setBorder(null);
        jCalendar2.getMonthChooser().setBackground(customColor);
        jCalendar2.getMonthChooser().setBorder(null);
        jCalendar2.getYearChooser().setBackground(customColor);
        jCalendar2.getYearChooser().setBorder(null);

    

                cargarTabla();
                actualizarFechas1();
                btnNuevaCarga.setVisible(false);
                btnGuardar.setVisible(false);

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

                jTable1.setModel(tableModel);
                jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jTable1MouseClicked(evt);
                    }

                });

            }

            @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtLegajo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1OcultarTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        bynImprimir = new javax.swing.JButton();
        lblLupa = new javax.swing.JLabel();
        btnNuevaCarga = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        bynLimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        bynVolver2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRODUCTOS");
        setBackground(new java.awt.Color(30, 144, 255));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1100, 650));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));
        jPanel1.setForeground(new java.awt.Color(249, 249, 249));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLegajo.setBackground(new java.awt.Color(249, 249, 249));
        txtLegajo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtLegajo.setBorder(null);
        jPanel1.add(txtLegajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 70, 30));

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel6.setText("Legajo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 70, 24));

        jPanel1OcultarTabla.setBackground(new java.awt.Color(249, 249, 249));

        jScrollPane1.setBackground(new java.awt.Color(249, 249, 249));

        jTable1.setBackground(new java.awt.Color(249, 249, 249));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(210, 228, 238));
        jTable1.setSelectionForeground(new java.awt.Color(249, 249, 249));
        jTable1.setShowHorizontalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1OcultarTablaLayout = new javax.swing.GroupLayout(jPanel1OcultarTabla);
        jPanel1OcultarTabla.setLayout(jPanel1OcultarTablaLayout);
        jPanel1OcultarTablaLayout.setHorizontalGroup(
            jPanel1OcultarTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1OcultarTablaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1OcultarTablaLayout.setVerticalGroup(
            jPanel1OcultarTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1OcultarTablaLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel1OcultarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 400, -1));

        jScrollPane3.setBackground(new java.awt.Color(249, 249, 249));
        jScrollPane3.setAutoscrolls(true);

        jTable2.setBackground(new java.awt.Color(249, 249, 249));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "PRODUCTO", "STOCK", "ENTREGADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoscrolls(false);
        jTable2.setGridColor(new java.awt.Color(210, 228, 238));
        jTable2.setPreferredSize(new java.awt.Dimension(225, 330));
        jTable2.setSelectionForeground(new java.awt.Color(249, 249, 249));
        jTable2.setShowHorizontalLines(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 550, 330));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 230, 10));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel1.setText("ENTREGA DE PRODUCTOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 240, 27));

        txtBuscador.setBackground(new java.awt.Color(249, 249, 249));
        txtBuscador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorActionPerformed(evt);
            }
        });
        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 214, 30));

        bynImprimir.setBackground(new java.awt.Color(210, 228, 238));
        bynImprimir.setText("IMPRIMIR");
        bynImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bynImprimirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bynImprimirMouseExited(evt);
            }
        });
        bynImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bynImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(bynImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 490, 340, 30));

        lblLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa-removebg-preview (1).png"))); // NOI18N
        jPanel1.add(lblLupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 31, 31));

        btnNuevaCarga.setBackground(new java.awt.Color(210, 228, 238));
        btnNuevaCarga.setText("NUEVA CARGA");
        btnNuevaCarga.setToolTipText("");
        btnNuevaCarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevaCargaMouseEntered(evt);
            }
        });
        btnNuevaCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCargaActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevaCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 610, 190, 40));

        btnGuardar.setBackground(new java.awt.Color(177, 197, 213));
        btnGuardar.setText("GUARDAR");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 370, 60));

        bynLimpiar.setBackground(new java.awt.Color(210, 228, 238));
        bynLimpiar.setText("LIMPIAR");
        bynLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bynLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bynLimpiarMouseExited(evt);
            }
        });
        bynLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bynLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(bynLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 550, 160, 38));

        jLabel2.setText("           Firma del empleado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 440, 170, 20));

        txtFecha.setBackground(new java.awt.Color(249, 249, 249));
        txtFecha.setBorder(null);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 130, 30));

        jLabel3.setText("Fecha de entrega :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 110, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, 220, 10));

        jCalendar2.setBackground(new java.awt.Color(249, 249, 249));
        jCalendar2.setBorder(new javax.swing.border.MatteBorder(null));
        jCalendar2.setForeground(new java.awt.Color(0, 86, 145));
        jCalendar2.setToolTipText("");
        jCalendar2.setWeekOfYearVisible(false);
        jCalendar2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar2PropertyChange(evt);
            }
        });
        jPanel1.add(jCalendar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 340, 220));

        bynVolver2.setBackground(new java.awt.Color(210, 228, 238));
        bynVolver2.setText("VOLVER");
        bynVolver2.setToolTipText("");
        bynVolver2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bynVolver2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bynVolver2MouseExited(evt);
            }
        });
        bynVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bynVolver2ActionPerformed(evt);
            }
        });
        jPanel1.add(bynVolver2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 550, 150, 38));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mateo-logo-removebg-preview.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 430, 110));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("BATERIAS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 140, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorActionPerformed

    private void txtBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyReleased

        String filtro = txtBuscador.getText(); // Obtener el texto del campo de búsqueda

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

        if (filtro.trim().length() == 0) {
            sorter.setRowFilter(null); // No se aplica ningún filtro si el campo está vacío
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro)); // Aplicar filtro ignorando mayúsculas/minúsculas
        }
    }//GEN-LAST:event_txtBuscadorKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow();
        String nombre = jTable1.getValueAt(selectedRow, 0).toString();
        String apellido = jTable1.getValueAt(selectedRow, 1).toString();
        String legajo = jTable1.getValueAt(selectedRow, 2).toString();

        // Asigna el nombre y apellido al campo txtBuscador
        txtBuscador.setText(nombre + " " + apellido);
        txtLegajo.setText(legajo);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnNuevaCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCargaActionPerformed
        Limpiar();
        jPanel1OcultarTabla.setVisible(true);
        jCalendar2.setVisible(true);
        bynImprimir.setVisible(true);
        btnGuardar.setVisible(false);
        bynVolver2.setVisible(true);
        bynLimpiar.setVisible(true);
        btnNuevaCarga.setVisible(false);
    }//GEN-LAST:event_btnNuevaCargaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas guardar los datos seleccionados?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            int rowCount = model.getRowCount();

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            // Obtener la fecha seleccionada en el calendario
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = dateFormat.format(jCalendar2.getDate());

            // Obtener el nombre y apellido del empleado
            String nombreEmpleado = txtBuscador.getText();

            // Obtener el legajo del empleado
            String legajo = txtLegajo.getText();

            try {
                con = Conexion.getConexion();

                // Verificar si ya existe una entrega para la fecha seleccionada
                PreparedStatement psVerificarEntrega = con.prepareStatement("SELECT id_entrega FROM entregado WHERE fecha = ?");
                psVerificarEntrega.setString(1, fecha);
                rs = psVerificarEntrega.executeQuery();

                if (rs.next()) {
                    // Si ya existe una entrega, obtener su id_entrega
                    int idEntrega = rs.getInt("id_entrega");

                    ps = con.prepareStatement("INSERT INTO productos_entrega (id_entrega, nombre_producto, entregado) VALUES (?, ?, ?)");

                    for (int i = 0; i < rowCount; i++) {
                        String producto = model.getValueAt(i, 0).toString();
                        boolean entregado = (boolean) model.getValueAt(i, 2);

                        // Obtener el id_producto correspondiente al producto
                        PreparedStatement psObtenerIdProducto = con.prepareStatement("SELECT id_producto FROM productos WHERE nombre_producto = ?");
                        psObtenerIdProducto.setString(1, producto);
                        ResultSet rsIdProducto = psObtenerIdProducto.executeQuery();
                        int idProducto = 0;

                        if (rsIdProducto.next()) {
                            idProducto = rsIdProducto.getInt("id_producto");
                        }

                        // Obtener el nombre del producto correspondiente al id_producto
                        PreparedStatement psObtenerNombreProducto = con.prepareStatement("SELECT nombre_producto FROM productos WHERE id_producto = ?");
                        psObtenerNombreProducto.setInt(1, idProducto);
                        ResultSet rsNombreProducto = psObtenerNombreProducto.executeQuery();
                        String nombreProducto = "";

                        if (rsNombreProducto.next()) {
                            nombreProducto = rsNombreProducto.getString("nombre_producto");
                        }

                        ps.setInt(1, idEntrega);
                        ps.setString(2, nombreProducto);
                        ps.setBoolean(3, entregado);
                        ps.addBatch();

                        // Obtener el stock actual del producto
                        PreparedStatement psObtenerStock = con.prepareStatement("SELECT stock FROM productos WHERE id_producto = ?");
                        psObtenerStock.setInt(1, idProducto);
                        ResultSet rsStock = psObtenerStock.executeQuery();
                        int stockActual = 0;

                        if (rsStock.next()) {
                            stockActual = rsStock.getInt("stock");
                        }

                        // Restar la cantidad entregada al stock actual
                        int cantidadEntregada = entregado ? 1 : 0;
                        int nuevoStock = stockActual - cantidadEntregada;

                        // Actualizar el valor del stock en la tabla 'productos'
                        PreparedStatement psActualizarStock = con.prepareStatement("UPDATE productos SET stock = ? WHERE id_producto = ?");
                        psActualizarStock.setInt(1, nuevoStock);
                        psActualizarStock.setInt(2, idProducto);
                        psActualizarStock.executeUpdate();
                    }

                    // Ejecutar la inserción de los productos en la entrega existente
                    ps.executeBatch();
                } else {
                    // Si no existe una entrega para la fecha seleccionada, crear una nueva entrega
                    con.setAutoCommit(false);
                    ps = con.prepareStatement("INSERT INTO entregado (fecha, nombre_empleado, legajo) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, fecha);
                    ps.setString(2, nombreEmpleado);
                    ps.setString(3, legajo);
                    ps.executeUpdate();
                    ResultSet generatedKeys = ps.getGeneratedKeys();

                    if (generatedKeys.next()) {
                        int idEntrega = generatedKeys.getInt(1);

                        // Insertar los productos en la nueva entrega
                        ps = con.prepareStatement("INSERT INTO productos_entrega (id_entrega, id_producto, nombre_producto, entregado) SELECT ?, id_producto, nombre_producto, ? FROM productos WHERE id_producto = ?");
                        for (int i = 0; i < rowCount; i++) {
                            String producto = model.getValueAt(i, 0).toString();
                            boolean entregado = (boolean) model.getValueAt(i, 2);

                            // Obtener el id_producto correspondiente al producto
                            PreparedStatement psObtenerIdProducto = con.prepareStatement("SELECT id_producto FROM productos WHERE nombre_producto = ?");
                            psObtenerIdProducto.setString(1, producto);
                            ResultSet rsIdProducto = psObtenerIdProducto.executeQuery();
                            int idProducto = 0;

                            if (rsIdProducto.next()) {
                                idProducto = rsIdProducto.getInt("id_producto");
                            }

                            ps.setInt(1, idEntrega);
                            ps.setBoolean(2, entregado);
                            ps.setInt(3, idProducto);
                            ps.addBatch();

                            // Resto del código...
                            // Obtener el stock actual del producto
                            PreparedStatement psObtenerStock = con.prepareStatement("SELECT stock FROM productos WHERE id_producto = ?");
                            psObtenerStock.setInt(1, idProducto);
                            ResultSet rsStock = psObtenerStock.executeQuery();
                            int stockActual = 0;

                            if (rsStock.next()) {
                                stockActual = rsStock.getInt("stock");
                            }
                            // Restar la cantidad entregada al stock actual
                            int cantidadEntregada = entregado ? 1 : 0;
                            int nuevoStock = stockActual - cantidadEntregada;

                            // Actualizar el valor del stock en la tabla 'productos'
                            PreparedStatement psActualizarStock = con.prepareStatement("UPDATE productos SET stock = ? WHERE id_producto = ?");
                            psActualizarStock.setInt(1, nuevoStock);
                            psActualizarStock.setInt(2, idProducto);
                            psActualizarStock.executeUpdate();
                        }
                        // Ejecutar la inserción de los productos en la nueva entrega
                        ps.executeBatch();
                        con.commit();

                    }
                }

                JOptionPane.showMessageDialog(this, "Datos guardados correctamente.");
                Limpiar();
                cargarTabla();

            } catch (SQLException e) {
                // Manejo de errores
                e.printStackTrace();

                if (con != null) {
                    try {
                        con.rollback();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } finally {
                // Cerrar los recursos...
            }


    }//GEN-LAST:event_btnGuardarActionPerformed
        }
    private void bynLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bynLimpiarActionPerformed
        Limpiar();
        jPanel1OcultarTabla.setVisible(true);
        jCalendar2.setVisible(true);

    }//GEN-LAST:event_bynLimpiarActionPerformed

    private void bynImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bynImprimirActionPerformed
        JFrame frame = new JFrame("entrega");
        JFramePrinter printer = new JFramePrinter(frame);
        jPanel1OcultarTabla.setVisible(false);
        jCalendar2.setVisible(false);
        bynImprimir.setVisible(false);
        btnGuardar.setVisible(false);
        bynVolver2.setVisible(true);
        bynLimpiar.setVisible(false);
        btnNuevaCarga.setVisible(true);
        guardarValoresMarcados();
        cargarTabla();
        printer.imprimir();
        btnGuardar.setVisible(true);
    }//GEN-LAST:event_bynImprimirActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void jCalendar2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar2PropertyChange
        if ("calendar".equals(evt.getPropertyName())) {
            actualizarFechas1();
        }
    }//GEN-LAST:event_jCalendar2PropertyChange

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        btnGuardar.setBackground(new Color(177, 197, 213));        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        btnGuardar.setBackground(new Color(210, 228, 238));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int filaSeleccionada = jTable2.rowAtPoint(evt.getPoint());
        int columnaSeleccionada = jTable2.columnAtPoint(evt.getPoint());

        // Verificar si se hizo clic en la columna "ENTREGADO"
        if (columnaSeleccionada == 2) {
            boolean valorActual = (boolean) jTable2.getValueAt(filaSeleccionada, columnaSeleccionada);
            jTable2.setValueAt(!valorActual, filaSeleccionada, columnaSeleccionada);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void bynVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bynVolver2ActionPerformed
        inicio ini = new inicio();
        ini.setVisible(true);
        hide();
    }//GEN-LAST:event_bynVolver2ActionPerformed

    private void bynLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bynLimpiarMouseEntered
        bynLimpiar.setBackground(new Color(177, 197, 213));
    }//GEN-LAST:event_bynLimpiarMouseEntered

    private void bynVolver2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bynVolver2MouseEntered
        bynVolver2.setBackground(new Color(177, 197, 213));
    }//GEN-LAST:event_bynVolver2MouseEntered

    private void btnNuevaCargaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaCargaMouseEntered
        btnNuevaCarga.setBackground(new Color(177, 197, 213));
    }//GEN-LAST:event_btnNuevaCargaMouseEntered

    private void bynLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bynLimpiarMouseExited
        bynLimpiar.setBackground(new Color(210, 228, 238));
    }//GEN-LAST:event_bynLimpiarMouseExited

    private void bynVolver2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bynVolver2MouseExited
        bynVolver2.setBackground(new Color(210, 228, 238));
    }//GEN-LAST:event_bynVolver2MouseExited

    private void bynImprimirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bynImprimirMouseExited
        bynImprimir.setBackground(new Color(210, 228, 238));
    }//GEN-LAST:event_bynImprimirMouseExited

    private void bynImprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bynImprimirMouseEntered
        bynImprimir.setBackground(new Color(177, 197, 213));
    }//GEN-LAST:event_bynImprimirMouseEntered

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
                java.util.logging.Logger.getLogger(entrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(entrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(entrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(entrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new entrega().setVisible(true);

                }
            });
        }
        private javax.swing.JScrollPane jScrollPaneCargaProducto;
        private boolean mostrarStock = true;
        private Map<Integer, Boolean> valoresMarcados = new HashMap<>();

        private void cargarTabla() {
            DefaultTableModel modeloTabla = new DefaultTableModel(new Object[][]{}, new String[]{"PRODUCTO", "STOCK", "A ENTREGAR"}) {
                Class[] columnTypes = new Class[]{String.class, Integer.class, Boolean.class};
                boolean[] columnEditable = new boolean[]{false, false, true};

                public Class getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            };

            modeloTabla.setRowCount(0);

            PreparedStatement ps;
            ResultSet rs;
            ResultSetMetaData rsmd;
            int columnas;
            int[] anchos = {150, 100, 50}; // Ajusta el ancho de la columna "ENTREGADO"
            for (int i = 0; i < jTable2.getColumnCount(); i++) {
                jTable2.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            try {
                Connection con = Conexion.getConexion();
                ps = con.prepareStatement("SELECT  nombre_producto, stock FROM productos");
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();
                columnas = rsmd.getColumnCount();

                while (rs.next()) {
                    Object[] fila = new Object[columnas];
                    for (int indice = 0; indice < columnas; indice++) {
                        fila[indice] = rs.getObject(indice + 1);
                    }
                    modeloTabla.addRow(fila);
                }

                // Convertir los valores a mayúsculas
                for (int fila = 0; fila < modeloTabla.getRowCount(); fila++) {
                    for (int columna = 0; columna < modeloTabla.getColumnCount(); columna++) {
                        Object valor = modeloTabla.getValueAt(fila, columna);
                        if (valor instanceof String) {
                            modeloTabla.setValueAt(((String) valor).toUpperCase(), fila, columna);
                        }
                    }
                }
                // Establecer los valores iniciales del CheckBox en false
                for (int fila = 0; fila < modeloTabla.getRowCount(); fila++) {
                    modeloTabla.setValueAt(false, fila, 2); // 2 es el índice de la columna "ENTREGADO"
                }

                // Asignar el modelo de tabla al jTable2
                jTable2.setModel(modeloTabla);

                // Alinear la columna "PRODUCTO" a la izquierda
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.LEFT);
                jTable2.getColumnModel().getColumn(0).setCellRenderer(renderer);

                // Alinear la columna "STOCK" a la izquierda
                DefaultTableCellRenderer rendererStock = new DefaultTableCellRenderer();
                rendererStock.setHorizontalAlignment(SwingConstants.LEFT);
                jTable2.getColumnModel().getColumn(1).setCellRenderer(rendererStock);
                int margin = 5;
                jTable2.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));

                DefaultTableCellRenderer rendererEntregado = new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        JCheckBox checkBox = new JCheckBox();
                        checkBox.setSelected((Boolean) value);
                        checkBox.setHorizontalAlignment(SwingConstants.LEFT);

                        // Agregar un margen de 5 píxeles a todos los lados del JCheckBox
                        int margin = 5;
                        checkBox.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));

                        return checkBox;
                    }
                };

                jTable2.getColumnModel().getColumn(2).setCellRenderer(rendererEntregado);

                // Ajustar el ancho de la columna "ENTREGADO"
                TableColumn columnEntregado = jTable2.getColumnModel().getColumn(2);
                columnEntregado.setPreferredWidth(50); // Ajusta el ancho de la columna "ENTREGADO" a la mitad

                // Habilitar la selección del checkbox con un clic izquierdo
                jTable2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int column = jTable2.getColumnModel().getColumnIndexAtX(e.getX());
                        int row = e.getY() / jTable2.getRowHeight();

                        if (row < jTable2.getRowCount() && row >= 0 && column < jTable2.getColumnCount() && column >= 0) {
                            if (jTable2.getValueAt(row, column) instanceof Boolean) {
                                jTable2.setValueAt(!(Boolean) jTable2.getValueAt(row, column), row, column);
                            }
                        }
                    }
                });

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            restaurarValoresMarcados();
        }

        private void actualizarFechas1() {
            java.util.Date fechaActual = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            // Obtener la fecha seleccionada en jCalendarEntrada
            java.util.Date fechaEntrada = jCalendar2.getDate();
            String fechaEntradaStr = sdf.format(fechaEntrada);
            txtFecha.setText(fechaEntradaStr);
        }

        public void establecerFechaActualEnCampoTexto() {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaActual = new Date();
            String fechaActualStr = sdf.format(fechaActual);
            txtFecha.setText(fechaActualStr);
        }

        private void Limpiar() {
            txtBuscador.setText("");
            txtLegajo.setText("");
            txtFecha.setText("");
            establecerFechaActualEnCampoTexto();
            cargarTabla();
        }

        private void guardarValoresMarcados() {
            valoresMarcados.clear();
            for (int fila = 0; fila < jTable2.getRowCount(); fila++) {
                boolean marcado = (boolean) jTable2.getValueAt(fila, 2); // 2 es el índice de la columna "A ENTREGAR"
                valoresMarcados.put(fila, marcado);
            }
        }

        private void restaurarValoresMarcados() {
            for (int fila = 0; fila < jTable2.getRowCount(); fila++) {
                boolean marcado = valoresMarcados.getOrDefault(fila, false);
                jTable2.setValueAt(marcado, fila, 2); // 2 es el índice de la columna "A ENTREGAR"
            }
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevaCarga;
    private javax.swing.JButton bynImprimir;
    private javax.swing.JButton bynLimpiar;
    private javax.swing.JButton bynVolver2;
    private com.toedter.calendar.JCalendar jCalendar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel1OcultarTabla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblLupa;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtLegajo;
    // End of variables declaration//GEN-END:variables
}
