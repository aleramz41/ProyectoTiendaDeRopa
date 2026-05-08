/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.proyectotienda.view;

import com.proyectotienda.model.Producto;
import com.proyectotienda.repository.ProductoRepository;
import com.proyectotienda.service.IProductoService;
import com.proyectotienda.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class DialogProductos extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DialogProductos.class.getName());

    private IProductoService productoService;
    private javax.swing.table.DefaultTableModel productosTableModel;
    private List<Producto> productosSeleccionados = new ArrayList<>();
    
    public DialogProductos(java.awt.Frame parent, boolean modal, IProductoService productoService) {
        super(parent, modal);
        this.productoService = productoService;
        initComponents();
        
        productosTableModel = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Código", "Nombre", "Talla", "Color", "Precio", "Stock"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaProductos.setModel(productosTableModel);
        actualizarTablaProductos();
    }

    // Actualiza la tabla de productos con los datos del servicio
    private void actualizarTablaProductos() {
        productosTableModel.setRowCount(0);
        for (Producto p : productoService.getAllProductos()) {
            productosTableModel.addRow(new Object[]{p.getCodigo(), p.getNombre(), p.getTalla(), p.getColor(), p.getPrecio(), p.getStock()});
        }
    }
    
    public List<Producto> getProductosSeleccionados() {
        return productosSeleccionados;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProductos = new javax.swing.JLabel();
        scrollTablaProductos = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblProductos.setText("Seleccione los productos a vender:");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaProductos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        scrollTablaProductos.setViewportView(tablaProductos);

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(this::btnSeleccionarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSeleccionar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblProductos)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblProductos)
                .addGap(18, 18, 18)
                .addComponent(scrollTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSeleccionar)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        
        int[] filas = tablaProductos.getSelectedRows();

        if (filas.length == 0) {

            JOptionPane.showMessageDialog(this,
                "Seleccione al menos un producto");
            return;
        }

        productosSeleccionados.clear();

        for (int fila : filas) {

            int codigo = Integer.parseInt(tablaProductos.getValueAt(fila, 0).toString());

            Producto producto = productoService.getProductoByCodigo(codigo);

            productosSeleccionados.add(producto);
        }
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        IProductoService productoService = new ProductoService(new ProductoRepository());


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DialogProductos dialog = new DialogProductos(new javax.swing.JFrame(), true, productoService);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JScrollPane scrollTablaProductos;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
