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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class MainWindow extends javax.swing.JFrame {
    // Datos
    private javax.swing.table.DefaultTableModel productosTableModel;
    private javax.swing.table.DefaultTableModel clientesTableModel;
    private javax.swing.table.DefaultTableModel detalleVentasTableModel;
    private javax.swing.table.DefaultTableModel ventasTableModel;
    private java.util.List<VentaDetalle> detallesVenta = new java.util.ArrayList<>();
    
    private Cliente clienteVentaActual = null;
    
    // Repositorios compartidos
    private final ClienteRepository clienteRepository = new ClienteRepository();
    private final ProductoRepository productoRepository = new ProductoRepository();
    VentaRepository ventaRepository = new VentaRepository(clienteRepository);
    private final VentaDetalleRepository ventaDetalleRepository = new VentaDetalleRepository();


    // Servicios
    private final IClienteService clienteService = new ClienteService(clienteRepository);
    private final IProductoService productoService = new ProductoService(productoRepository);
    private final IVentaDetalleService ventaDetalleService = new VentaDetalleService(ventaDetalleRepository);
    private final IVentaService ventaService = new VentaService(ventaRepository, new CalculadorTotalVenta(), productoService, clienteService, (VentaDetalleService) ventaDetalleService);
    
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
                        txtCodigo.setText(String.valueOf(p.getCodigo()));
                        txtNombreProductos.setText(p.getNombre());
                        txtTalla.setText(p.getTalla());
                        txtColor.setText(p.getColor());
                        txtPrecio.setText(String.valueOf(p.getPrecio()));
                        txtCantidad.setText(String.valueOf(p.getStock()));
                    }
                }
            }
        });
        
        // Configurar modelo de tabla para el detalle de ventas
        detalleVentasTableModel = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"ID Producto", "Nombre Producto", "Talla", "Cantidad", "Precio Unitario", "Precio Total"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaDetalleVenta.setModel(detalleVentasTableModel);
        actualizarTotalVenta();
        
        // Configurar modelo de tabla de ventas
        ventasTableModel = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"ID Venta", "Cliente", "Detalle", "Total", "Fecha"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaVentas.setModel(ventasTableModel);
        actualizarTotalVenta();
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
        scrollDetalleVentas = new javax.swing.JScrollPane();
        tablaDetalleVenta = new javax.swing.JTable();
        lblFechaVenta = new javax.swing.JLabel();
        lblTotalVenta = new javax.swing.JLabel();
        btnGuardarVenta = new javax.swing.JButton();
        btnLimpiarVenta = new javax.swing.JButton();
        btnAgregarProductoVenta = new javax.swing.JButton();
        lblDetalleVenta = new javax.swing.JLabel();
        scrollVentas = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        lblListadoVentas = new javax.swing.JLabel();
        comboClientesVenta = new javax.swing.JComboBox<>();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
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

        tablaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollDetalleVentas.setViewportView(tablaDetalleVenta);

        lblFechaVenta.setText("Aqui va la fecha");

        lblTotalVenta.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblTotalVenta.setText("Aqui va el valor total de la compra");

        btnGuardarVenta.setText("Guardar");
        btnGuardarVenta.addActionListener(this::btnGuardarVentaActionPerformed);

        btnLimpiarVenta.setText("Limpiar");
        btnLimpiarVenta.addActionListener(this::btnLimpiarVentaActionPerformed);

        btnAgregarProductoVenta.setText("Agregar Producto");
        btnAgregarProductoVenta.addActionListener(this::btnAgregarProductoVentaActionPerformed);

        lblDetalleVenta.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblDetalleVenta.setText("Detalle Venta");

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

        lblListadoVentas.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblListadoVentas.setText("Listado Ventas");

        javax.swing.GroupLayout tabVentasLayout = new javax.swing.GroupLayout(tabVentas);
        tabVentas.setLayout(tabVentasLayout);
        tabVentasLayout.setHorizontalGroup(
            tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabVentasLayout.createSequentialGroup()
                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabVentasLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(lblVentas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tabVentasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollDetalleVentas)
                            .addGroup(tabVentasLayout.createSequentialGroup()
                                .addComponent(btnAgregarProductoVenta)
                                .addGap(43, 43, 43)
                                .addComponent(lblDetalleVenta)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(scrollVentas)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabVentasLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalVenta, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabVentasLayout.createSequentialGroup()
                                        .addComponent(btnGuardarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLimpiarVenta)
                                        .addGap(154, 154, 154))))))
                    .addGroup(tabVentasLayout.createSequentialGroup()
                        .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabVentasLayout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(lblListadoVentas))
                            .addGroup(tabVentasLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(lblIngresarIDCliente)
                                .addGap(18, 18, 18)
                                .addComponent(comboClientesVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabVentasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblFechaVenta)
                .addGap(54, 54, 54))
        );
        tabVentasLayout.setVerticalGroup(
            tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabVentasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabVentasLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblVentas)
                        .addGap(18, 18, 18)
                        .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIngresarIDCliente)
                            .addComponent(comboClientesVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblFechaVenta))
                .addGap(19, 19, 19)
                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetalleVenta)
                    .addComponent(btnAgregarProductoVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollDetalleVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarVenta)
                    .addComponent(btnLimpiarVenta))
                .addGap(34, 34, 34)
                .addComponent(lblListadoVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
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

    //Guardar clientes
    private void btnGuardarClientesActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombreCliente.getText().trim();
            String email = txtEmail.getText().trim();
            String telefono = txtTelefono.getText().trim();
            if (nombre.isEmpty() || email.isEmpty()) return;
            clienteService.registrarCliente(id, nombre, email, telefono);
            actualizarTablaClientes();
            cargarClientesCombo();
            limpiarCamposCliente();
        } catch (NumberFormatException e) {
        // Ignorar entrada inválida
        } catch (IllegalArgumentException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    //Eliminar clientes
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

    //Guardar productos
    private void btnGuardarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event-btnGuardarProductosActionPerformed
        // Agregar producto usando servicio
        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            String nombre = txtNombreProductos.getText().trim();
            String talla = txtTalla.getText().trim();
            String color = txtColor.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int stock = Integer.parseInt(txtCantidad.getText().trim());
            productoService.registrarProducto(nombre, talla, color, precio, stock);
            actualizarTablaProductos();
            limpiarCamposProducto();
        } catch (NumberFormatException e) {
            // Ignorar entrada inválida
        } catch (IllegalArgumentException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event-btnGuardarProductosActionPerformed


    //Eliminar productos
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

    //Actualizar productos
    private void btnActualizarProductosActionPerformed(java.awt.event.ActionEvent evt) {
        // Actualizar producto seleccionado
        int fila = tablaProductos.getSelectedRow();
        if (fila < 0) return;
        java.util.List<Producto> allProductos = productoService.getAllProductos();
        if (fila >= allProductos.size()) return;
        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            String nombre = txtNombreProductos.getText().trim();
            String talla = txtTalla.getText().trim();
            String color = txtColor.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int stock = Integer.parseInt(txtCantidad.getText().trim());
            if (codigo == 0 || nombre.isEmpty()) return;
            productoService.actualizarProducto(codigo, nombre, talla, color, precio, stock);
            actualizarTablaProductos();
            limpiarCamposProducto();
        } catch (NumberFormatException e) {
            // Ignorar entrada inválida
        } catch (IllegalArgumentException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }


    //Actualizar clientes
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

    //Boton para abrir el dialog de productos para la venta
    private void btnAgregarProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoVentaActionPerformed
        try{
            DialogProductos dialogo = new DialogProductos(this, true, productoService);

            dialogo.setVisible(true);

            List<Producto> productos = dialogo.getProductosSeleccionados();

            for (Producto producto : productos) {
                ventaService.crearDetalleVenta(detallesVenta, producto.getCodigo(), 1);

                actualizarTablaDetalleVenta();
                actualizarTotalVenta();
            }

            actualizarTotalVenta();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_btnAgregarProductoVentaActionPerformed

    private void btnLimpiarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarVentaActionPerformed
        limpiarCamposVenta();
    }//GEN-LAST:event_btnLimpiarVentaActionPerformed

    private void btnGuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVentaActionPerformed
        try {
            Cliente clienteSeleccionado = (Cliente) comboClientesVenta.getSelectedItem();

            if (clienteSeleccionado == null) {

                JOptionPane.showMessageDialog(this,"Seleccione un cliente");
                return;
            }

            int idCliente = clienteSeleccionado.getId();
            
            ventaService.registrarVenta(idCliente,new ArrayList<>(detallesVenta));
            JOptionPane.showMessageDialog(this, "Venta registrada correctamente");
            actualizarTablaVentas();
            actualizarTablaProductos();
            limpiarCamposVenta();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarVentaActionPerformed

    private void txtClienteVentaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void txtProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }
    
    // Actualiza la tabla de clientes con los datos del servicio
    private void actualizarTablaClientes() {
        clientesTableModel.setRowCount(0);
        for (Cliente c : clienteService.getAllClients()) {
            clientesTableModel.addRow(new Object[]{c.getId(), c.getNombre(), c.getEmail(), c.getTelefono()});
        }
    }
    
    // Carga los clientes en el JComboBox para las ventas
    private void cargarClientesCombo() {
        comboClientesVenta.removeAllItems();

        for (Cliente cliente : clienteService.getAllClients()) {
            comboClientesVenta.addItem(cliente);
        }
        comboClientesVenta.setSelectedItem(null);
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

    //Carga la fecha actual
    private void cargarDatosIniciales() {
        lblFechaVenta.setText("Fecha: " + java.time.LocalDate.now().toString());
        cargarClientesCombo();
    }
    
    //Actualiza la tabla de Ventas
    private void actualizarTablaVentas() {
        ventasTableModel.setRowCount(0);

        for (var venta : ventaService.getAllVentas()) {
            StringBuilder detalle = new StringBuilder();
            for (VentaDetalle d : venta.getDetalles()) {
                detalle.append(
                    d.getProducto().getNombre()
                ).append(" x")
                 .append(d.getCantidad())
                 .append(" | ");
            }
            ventasTableModel.addRow(new Object[]{
                venta.getId(),
                venta.getCliente().getNombre(),
                detalle.toString(),
                venta.getTotal(),
                venta.getFecha()
            });
        }
    }

    //Limpia los campos del tab de ventas
    private void limpiarCamposVenta(){
        comboClientesVenta.setSelectedIndex(0);
        detalleVentasTableModel.setRowCount(0);
        detallesVenta.clear();
        clienteVentaActual = null;
        actualizarTotalVenta();
    }
    
    //Actualiza el valor de la venta total en el tab de venta
    private void actualizarTotalVenta() {
        double total = ventaService.calcularTotal(new java.util.ArrayList<>(detallesVenta));
        lblTotalVenta.setText("Total ventas: $" + total);
    }
    
    //Actualiza la tabla de detalle de venta
    private void actualizarTablaDetalleVenta() {
        detalleVentasTableModel.setRowCount(0);

        for (VentaDetalle detalle : detallesVenta) {

            detalleVentasTableModel.addRow(new Object[]{
                detalle.getProducto().getCodigo(),
                detalle.getProducto().getNombre(),
                detalle.getProducto().getTalla(),
                detalle.getCantidad(),
                detalle.getPrecioUnitario(),
                detalle.getCantidad()
                    * detalle.getPrecioUnitario()
            });
        }
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
    private javax.swing.JComboBox<Cliente> comboClientesVenta;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblDetalleVenta;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaVenta;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIngresarIDCliente;
    private javax.swing.JLabel lblListadoClientes;
    private javax.swing.JLabel lblListadoProductos;
    private javax.swing.JLabel lblListadoVentas;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreProductos;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblTalla;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTotalVenta;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JScrollPane scrollDetalleVentas;
    private javax.swing.JScrollPane scrollTablaClientes;
    private javax.swing.JScrollPane scrollTablaProductos;
    private javax.swing.JScrollPane scrollVentas;
    private javax.swing.JPanel tabCanal;
    private javax.swing.JTabbedPane tabMenu;
    private javax.swing.JPanel tabProductos;
    private javax.swing.JPanel tabVentas;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaDetalleVenta;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreProductos;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTalla;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
