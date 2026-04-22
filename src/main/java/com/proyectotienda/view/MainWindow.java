/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.proyectotienda.view;

import com.proyectotienda.model.Cliente;
import com.proyectotienda.model.Producto;
import com.proyectotienda.model.VentaDetalle;
import com.proyectotienda.repository.ClienteRepository;
import com.proyectotienda.repository.ProductoRepository;
import com.proyectotienda.repository.VentaRepository;
import com.proyectotienda.repository.VentaDetalleRepository;
import com.proyectotienda.service.IClienteService;
import com.proyectotienda.service.IProductoService;
import com.proyectotienda.service.IVentaService;
import com.proyectotienda.service.IVentaDetalleService;
import com.proyectotienda.service.ClienteService;
import com.proyectotienda.service.ProductoService;
import com.proyectotienda.service.VentaService;
import com.proyectotienda.service.VentaDetalleService;
import com.proyectotienda.service.CalculadorTotalVenta;

/**
 *
 * @author aleja
 */
public class MainWindow extends javax.swing.JFrame {
    // Datos
    private javax.swing.table.DefaultTableModel productosTableModel;
    private javax.swing.table.DefaultTableModel clientesTableModel;
    private javax.swing.table.DefaultTableModel ventasTableModel;
    private int contadorVenta = 1;
    private java.util.List<VentaDetalle> detallesVenta = new java.util.ArrayList<>();
    private Cliente clienteVentaActual = null;
    // Servicios
    private final IClienteService clienteService = new ClienteService(new ClienteRepository());
    private final IProductoService productoService = new ProductoService(new ProductoRepository());
    private final IVentaService ventaService = new VentaService(new VentaRepository(), new CalculadorTotalVenta(), productoService);
    private final IVentaDetalleService ventaDetalleService = new VentaDetalleService(new VentaDetalleRepository());
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        cargarDatosIniciales();
        // Configurar modelo de tabla para productos
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
        // Configurar modelo de tabla para clientes
        clientesTableModel = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Id", "Nombre", "Email", "Teléfono"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaClientes.setModel(clientesTableModel);
        actualizarTablaClientes();
        // Evento: llenar campos al seleccionar una fila de la tabla de clientes
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tablaClientes.getSelectedRow();
                if (fila >= 0) {
                    java.util.List<Cliente> allClientes = clienteService.getAllClients();
                    if (fila < allClientes.size()) {
                        Cliente c = allClientes.get(fila);
                        txtId.setText(String.valueOf(c.getId()));
                        txtNombreCliente.setText(c.getNombre());
                        txtEmail.setText(c.getEmail());
                        txtTelefono.setText(c.getTelefono());
                    }
                }
            }
        });
        // Evento: llenar campos al seleccionar una fila de la tabla de productos
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tablaProductos.getSelectedRow();
                if (fila >= 0) {
                    java.util.List<Producto> allProductos = productoService.getAllProductos();
                    if (fila < allProductos.size()) {
                        Producto p = allProductos.get(fila);
                        txtCodigo.setText(p.getCodigo());
                        txtNombreProductos.setText(p.getNombre());
                        txtTalla.setText(p.getTalla());
                        txtColor.setText(p.getColor());
                        txtPrecio.setText(String.valueOf(p.getPrecio()));
                        txtCantidad.setText(String.valueOf(p.getStock()));
                    }
                }
            }
        });
        // Configurar modelo de tabla para ventas
        ventasTableModel = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"# Venta", "ID-Cliente", "Nombre Producto", "Precio Unitario", "Cantidad", "Total"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaVentas.setModel(ventasTableModel);
        actualizarTotalVenta();
        // Asignar acciones a los botones de ventas
        btnAgregarProductoVenta.addActionListener(this::btnAgregarProductoVentaActionPerformed);
        btnGuardarVenta.addActionListener(this::btnGuardarVentaActionPerformed);
        btnLimpiarVenta.addActionListener(this::btnLimpiarVentaActionPerformed);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabMenu = new javax.swing.JTabbedPane();
        tabProductos = new javax.swing.JPanel();
        btnGuardarProductos = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        btnActualizarProductos = new javax.swing.JButton();
        lblPrecio = new javax.swing.JLabel();
        btnEliminarProductos = new javax.swing.JButton();
        lblProductos = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        scrollTablaProductos = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        txtNombreProductos = new javax.swing.JTextField();
        lblNombreProductos = new javax.swing.JLabel();
        lblTalla = new javax.swing.JLabel();
        txtTalla = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblListadoProductos = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        tabCanal = new javax.swing.JPanel();
        btnGuardarClientes = new javax.swing.JButton();
        btnActualizarClientes = new javax.swing.JButton();
        btnEliminarClientes = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblClientes = new javax.swing.JLabel();
        scrollTablaClientes = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        lblListadoClientes = new javax.swing.JLabel();
        tabVentas = new javax.swing.JPanel();
        lblVentas = new javax.swing.JLabel();
        lblIngresarIDCliente = new javax.swing.JLabel();
        scrollVentas = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        lblFechaVenta = new javax.swing.JLabel();
        lblTotalVenta = new javax.swing.JLabel();
        btnGuardarVenta = new javax.swing.JButton();
        btnLimpiarVenta = new javax.swing.JButton();
        lblIngresarIDProducto = new javax.swing.JLabel();
        lblIngresarCantidadProductoVenta = new javax.swing.JLabel();
        txtCantidadVenta = new javax.swing.JTextField();
        btnAgregarProductoVenta = new javax.swing.JButton();
        txtClienteVenta = new javax.swing.JTextField();
        txtProductoVenta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabMenu.setToolTipText("");
        tabMenu.setName(""); // NOI18N

        btnGuardarProductos.setText("Guardar");
        btnGuardarProductos.addActionListener(this::btnGuardarProductosActionPerformed);

        btnActualizarProductos.setText("Actualizar");
        btnActualizarProductos.addActionListener(this::btnActualizarProductosActionPerformed);

        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrecio.setText("Precio:");

        btnEliminarProductos.setText("Eliminar");
        btnEliminarProductos.addActionListener(this::btnEliminarProductosActionPerformed);

        lblProductos.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblProductos.setText("Gestion de Productos");

        lblCodigo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCodigo.setText("ID:");

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
        scrollTablaProductos.setViewportView(tablaProductos);

        lblNombreProductos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreProductos.setText("Nombre:");

        lblTalla.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTalla.setText("Talla:");

        lblCantidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantidad.setText("Cantidad:");

        lblListadoProductos.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblListadoProductos.setText("Listado de Productos");

        lblColor.setText("Color:");

        txtColor.addActionListener(this::txtColorActionPerformed);

        javax.swing.GroupLayout tabProductosLayout = new javax.swing.GroupLayout(tabProductos);
        tabProductos.setLayout(tabProductosLayout);
        tabProductosLayout.setHorizontalGroup(
            tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProductosLayout.createSequentialGroup()
                .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabProductosLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(lblProductos))
                    .addGroup(tabProductosLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblListadoProductos)))
                    .addGroup(tabProductosLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btnGuardarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnActualizarProductos)
                        .addGap(35, 35, 35)
                        .addComponent(btnEliminarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabProductosLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNombreProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(txtCodigo)
                            .addComponent(txtTalla)
                            .addComponent(txtPrecio)
                            .addComponent(txtCantidad)
                            .addComponent(txtColor))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        tabProductosLayout.setVerticalGroup(
            tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProductosLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblProductos)
                .addGap(35, 35, 35)
                .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreProductos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTalla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColor))
                .addGap(34, 34, 34)
                .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarProductos)
                    .addComponent(btnActualizarProductos)
                    .addComponent(btnEliminarProductos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(lblListadoProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        tabMenu.addTab("Productos", tabProductos);

        btnGuardarClientes.setText("Guardar");
        btnGuardarClientes.addActionListener(this::btnGuardarClientesActionPerformed);

        btnActualizarClientes.setText("Actualizar");
        btnActualizarClientes.addActionListener(this::btnActualizarClientesActionPerformed);

        btnEliminarClientes.setText("Eliminar");
        btnEliminarClientes.addActionListener(this::btnEliminarClientesActionPerformed);

        lblId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblId.setText("ID:");

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre:");

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("Email:");

        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTelefono.setText("Telefono:");

        lblClientes.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblClientes.setText("Gestion de Clientes");

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollTablaClientes.setViewportView(tablaClientes);

        lblListadoClientes.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblListadoClientes.setText("Listado Clientes");

        javax.swing.GroupLayout tabCanalLayout = new javax.swing.GroupLayout(tabCanal);
        tabCanal.setLayout(tabCanalLayout);
        tabCanalLayout.setHorizontalGroup(
            tabCanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCanalLayout.createSequentialGroup()
                .addGroup(tabCanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabCanalLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(tabCanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(tabCanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tabCanalLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(btnActualizarClientes)
                                .addGap(43, 43, 43)
                                .addComponent(btnEliminarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabCanalLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(tabCanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreCliente)
                                    .addComponent(txtId)
                                    .addComponent(txtEmail)
                                    .addComponent(txtTelefono)))))
                    .addGroup(tabCanalLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(lblClientes))
                    .addGroup(tabCanalLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(tabCanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblListadoClientes)
                            .addComponent(scrollTablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        tabCanalLayout.setVerticalGroup(
            tabCanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCanalLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblClientes)
                .addGap(38, 38, 38)
                .addGroup(tabCanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono))
                .addGap(26, 26, 26)
                .addGroup(tabCanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarClientes)
                    .addComponent(btnActualizarClientes)
                    .addComponent(btnGuardarClientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(lblListadoClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        tabMenu.addTab("Clientes", tabCanal);

        lblVentas.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblVentas.setText("Gestion de Ventas");

        lblIngresarIDCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIngresarIDCliente.setText("ID-Cliente:");

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollVentas.setViewportView(tablaVentas);

        lblFechaVenta.setText("Aqui va la fecha");

        lblTotalVenta.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblTotalVenta.setText("Aqui va el valor total de la compra");

        btnGuardarVenta.setText("Guardar");

        btnLimpiarVenta.setText("Limpiar");

        lblIngresarIDProducto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIngresarIDProducto.setText("ID-Producto:");

        lblIngresarCantidadProductoVenta.setText("Cantidad:");

        txtCantidadVenta.setText("   ");

        btnAgregarProductoVenta.setText("Agregar Producto");

        txtClienteVenta.addActionListener(this::txtClienteVentaActionPerformed);

        txtProductoVenta.addActionListener(this::txtProductoVentaActionPerformed);

        javax.swing.GroupLayout tabVentasLayout = new javax.swing.GroupLayout(tabVentas);
        tabVentas.setLayout(tabVentasLayout);
        tabVentasLayout.setHorizontalGroup(
            tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabVentasLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(btnGuardarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnLimpiarVenta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabVentasLayout.createSequentialGroup()
                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabVentasLayout.createSequentialGroup()
                        .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabVentasLayout.createSequentialGroup()
                                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabVentasLayout.createSequentialGroup()
                                        .addGap(176, 176, 176)
                                        .addComponent(lblVentas))
                                    .addGroup(tabVentasLayout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblIngresarIDProducto)
                                            .addComponent(lblIngresarCantidadProductoVenta)
                                            .addComponent(lblIngresarIDCliente))
                                        .addGap(18, 18, 18)
                                        .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtClienteVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                            .addComponent(txtProductoVenta)
                                            .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(108, 108, 108))
                            .addComponent(btnAgregarProductoVenta)
                            .addComponent(lblFechaVenta))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tabVentasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                            .addGroup(tabVentasLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblTotalVenta)))))
                .addContainerGap())
        );
        tabVentasLayout.setVerticalGroup(
            tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabVentasLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblVentas)
                .addGap(11, 11, 11)
                .addComponent(lblFechaVenta)
                .addGap(19, 19, 19)
                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresarIDCliente)
                    .addComponent(txtClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresarIDProducto)
                    .addComponent(txtProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresarCantidadProductoVenta)
                    .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(btnAgregarProductoVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTotalVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarVenta)
                    .addComponent(btnLimpiarVenta))
                .addGap(27, 27, 27))
        );

        tabMenu.addTab("Ventas", tabVentas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMenu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarClientesActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombreCliente.getText().trim();
            String email = txtEmail.getText().trim();
            String telefono = txtTelefono.getText().trim();
            if (nombre.isEmpty() || email.isEmpty()) return;
            clienteService.registrarCliente(id, nombre, email, telefono);
            actualizarTablaClientes();
            limpiarCamposCliente();
        } catch (NumberFormatException e) {
        // Ignorar entrada inválida
        } catch (IllegalArgumentException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnEliminarClientesActionPerformed(java.awt.event.ActionEvent evt) {
        int fila = tablaClientes.getSelectedRow();
        if (fila < 0) return;
        java.util.List<Cliente> allClientes = clienteService.getAllClients();
        if (fila >= allClientes.size()) return;
        Cliente c = allClientes.get(fila);
        clienteService.eliminarCliente(c.getId());
        actualizarTablaClientes();
        limpiarCamposCliente();
    }

    private void btnGuardarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event-btnGuardarProductosActionPerformed
        // Agregar producto usando servicio
        try {
            String codigo = txtCodigo.getText().trim();
            String nombre = txtNombreProductos.getText().trim();
            String talla = txtTalla.getText().trim();
            String color = txtColor.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int stock = Integer.parseInt(txtCantidad.getText().trim());
            if (codigo.isEmpty() || nombre.isEmpty()) return;
            productoService.registrarProducto(codigo, nombre, talla, color, precio, stock);
            actualizarTablaProductos();
            limpiarCamposProducto();
        } catch (NumberFormatException e) {
            // Ignorar entrada inválida
        } catch (IllegalArgumentException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event-btnGuardarProductosActionPerformed


    private void btnEliminarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event-btnEliminarProductosActionPerformed
        // Eliminar producto seleccionado
        int fila = tablaProductos.getSelectedRow();
        if (fila < 0) return;
        java.util.List<Producto> allProductos = productoService.getAllProductos();
        if (fila >= allProductos.size()) return;
        Producto p = allProductos.get(fila);
        productoService.eliminarProducto(p.getCodigo());
        actualizarTablaProductos();
        limpiarCamposProducto();
    }//GEN-LAST:event-btnEliminarProductosActionPerformed

    private void btnActualizarProductosActionPerformed(java.awt.event.ActionEvent evt) {
        // Actualizar producto seleccionado
        int fila = tablaProductos.getSelectedRow();
        if (fila < 0) return;
        java.util.List<Producto> allProductos = productoService.getAllProductos();
        if (fila >= allProductos.size()) return;
        try {
            String codigo = txtCodigo.getText().trim();
            String nombre = txtNombreProductos.getText().trim();
            String talla = txtTalla.getText().trim();
            String color = txtColor.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int stock = Integer.parseInt(txtCantidad.getText().trim());
            if (codigo.isEmpty() || nombre.isEmpty()) return;
            productoService.actualizarProducto(codigo, nombre, talla, color, precio, stock);
            actualizarTablaProductos();
            limpiarCamposProducto();
        } catch (NumberFormatException e) {
            // Ignorar entrada inválida
        } catch (IllegalArgumentException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }


    private void btnActualizarClientesActionPerformed(java.awt.event.ActionEvent evt) {
        int fila = tablaClientes.getSelectedRow();
        if (fila < 0) return;
        java.util.List<Cliente> allClientes = clienteService.getAllClients();
        if (fila >= allClientes.size()) return;
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombreCliente.getText().trim();
            String email = txtEmail.getText().trim();
            String telefono = txtTelefono.getText().trim();
            clienteService.actualizarCliente(id, nombre, email, telefono);
            actualizarTablaClientes();
            limpiarCamposCliente();
        } catch (NumberFormatException e) {
        // Ignorar entrada inválida
        } catch (IllegalArgumentException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event-txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event-txtColorActionPerformed

    private void txtClienteVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event-txtClienteVentaActionPerformed

    private void txtProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event-txtProductoVentaActionPerformed
    // Actualiza la tabla de clientes con los datos del servicio
    private void actualizarTablaClientes() {
        clientesTableModel.setRowCount(0);
        for (Cliente c : clienteService.getAllClients()) {
            clientesTableModel.addRow(new Object[]{c.getId(), c.getNombre(), c.getEmail(), c.getTelefono()});
        }
    }

    // Limpia los campos de entrada de cliente
    private void limpiarCamposCliente() {
        txtId.setText("");
        txtNombreCliente.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
    }

    // Actualiza la tabla de productos con los datos del servicio
    private void actualizarTablaProductos() {
        productosTableModel.setRowCount(0);
        for (Producto p : productoService.getAllProductos()) {
            productosTableModel.addRow(new Object[]{p.getCodigo(), p.getNombre(), p.getTalla(), p.getColor(), p.getPrecio(), p.getStock()});
        }
    }

    // Limpia los campos de entrada de producto
    private void limpiarCamposProducto() {
        txtCodigo.setText("");
        txtNombreProductos.setText("");
        txtTalla.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        if (txtColor != null) {
            txtColor.setText("");
        }
    }

    // No se requiere inicializar servicios ni combos ni lógica anterior

    private void cargarDatosIniciales() {
        lblFechaVenta.setText("Fecha: " + java.time.LocalDate.now().toString());
    }

    private void btnAgregarProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {
        String idCliente = txtClienteVenta.getText().trim();
        String idProducto = txtProductoVenta.getText().trim();
        String cantidadStr = txtCantidadVenta.getText().trim();
        if (idCliente.isEmpty() || idProducto.isEmpty() || cantidadStr.isEmpty()) {
            return;
        }
        if (clienteVentaActual == null) {
            for (Cliente c : clienteService.getAllClients()) {
                if (String.valueOf(c.getId()).equals(idCliente)) {
                    clienteVentaActual = c;
                    break;
                }
            }
            if (clienteVentaActual == null) {
                return;
            }
        }
        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(cantidadStr);
        } catch (Exception e) {
            return;
        }
        try {
            VentaDetalle detalle = ventaService.crearDetalleVenta(idProducto, cantidad, "VENTA-" + contadorVenta, detallesVenta.size());
            detallesVenta.add(detalle);
            // Agregar a tabla
            double total = detalle.getPrecioUnitario() * detalle.getCantidad();
            ventasTableModel.addRow(new Object[]{contadorVenta, idCliente, detalle.getProducto().getNombre(), detalle.getPrecioUnitario(), detalle.getCantidad(), total});
            actualizarTotalVenta();
            // Limpiar solo producto y cantidad
            txtProductoVenta.setText("");
            txtCantidadVenta.setText("");
            actualizarTablaProductos(); // Reflejar stock actualizado
        } catch (IllegalArgumentException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void btnGuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {
        if (clienteVentaActual == null || detallesVenta.isEmpty()) {
            return;
        }
        String idVenta = "VENTA-" + contadorVenta++;
        String fecha = java.time.LocalDate.now().toString();
        try {
            ventaService.registrarVenta(idVenta, clienteVentaActual, new java.util.ArrayList<>(detallesVenta), fecha);
            // Limpiar después de guardar
            txtClienteVenta.setText("");
            txtProductoVenta.setText("");
            txtCantidadVenta.setText("");
            ventasTableModel.setRowCount(0);
            detallesVenta.clear();
            clienteVentaActual = null;
            actualizarTotalVenta();
            javax.swing.JOptionPane.showMessageDialog(this, "Venta guardada exitosamente.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnLimpiarVentaActionPerformed(java.awt.event.ActionEvent evt) {
        txtClienteVenta.setText("");
        txtProductoVenta.setText("");
        txtCantidadVenta.setText("");
        ventasTableModel.setRowCount(0);
        detallesVenta.clear();
        clienteVentaActual = null;
        actualizarTotalVenta();
    }

    private void actualizarTotalVenta() {
        double total = ventaService.calcularTotal(new java.util.ArrayList<>(detallesVenta));
        lblTotalVenta.setText("Total ventas: $" + total);
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MainWindow().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarClientes;
    private javax.swing.JButton btnActualizarProductos;
    private javax.swing.JButton btnAgregarProductoVenta;
    private javax.swing.JButton btnEliminarClientes;
    private javax.swing.JButton btnEliminarProductos;
    private javax.swing.JButton btnGuardarClientes;
    private javax.swing.JButton btnGuardarProductos;
    private javax.swing.JButton btnGuardarVenta;
    private javax.swing.JButton btnLimpiarVenta;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaVenta;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIngresarCantidadProductoVenta;
    private javax.swing.JLabel lblIngresarIDCliente;
    private javax.swing.JLabel lblIngresarIDProducto;
    private javax.swing.JLabel lblListadoClientes;
    private javax.swing.JLabel lblListadoProductos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreProductos;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblTalla;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTotalVenta;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JScrollPane scrollTablaClientes;
    private javax.swing.JScrollPane scrollTablaProductos;
    private javax.swing.JScrollPane scrollVentas;
    private javax.swing.JPanel tabCanal;
    private javax.swing.JTabbedPane tabMenu;
    private javax.swing.JPanel tabProductos;
    private javax.swing.JPanel tabVentas;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtClienteVenta;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreProductos;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProductoVenta;
    private javax.swing.JTextField txtTalla;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
