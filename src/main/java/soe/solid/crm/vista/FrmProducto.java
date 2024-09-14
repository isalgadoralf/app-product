package soe.solid.crm.vista;
import soe.solid.crm.datos.ProductoRepository;
import soe.solid.crm.datos.ProductoRepositoryImpl;
import soe.solid.crm.modelo.Producto;
import soe.solid.crm.servicio.ProductoService;
import soe.solid.crm.servicio.ProductoServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmProducto {
    private JTextField txtSku;
    private JTextField txtNombre;
    private JTextField txtNombreExtranjero;
    private JTextField txtCodGrupoProducto;
    private JTextField txtNombreGrupoProducto;
    private JTextField txtSkuFabricante;
    private JTextField txtNombreFabricante;
    private JTextField txtNombreProveedor;
    private JTextField txtPeso;
    private JTextField txtUnidadMedida;
    private JTextField txtPrecioLista;
    private JTextField txtCodigoBarra;
    private JTextField txtSkuAlternante;
    private JButton guardarButton;
    private JButton listarButton;
    private JPanel panelMain;
    private ProductoService productoService;

    public FrmProducto(ProductoService productoService) {
        this.initComponents();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear el objeto Producto y llenar los datos
                Producto producto = new Producto();
                producto.setCSku(txtSku.getText());
                producto.setCNombre(txtNombre.getText());
                producto.setCNombreExtranjero(txtNombreExtranjero.getText());
                producto.setCCodGrupoProducto(txtCodGrupoProducto.getText());
                producto.setCNombreGrupoProducto(txtNombreGrupoProducto.getText());
                producto.setCSkuFabricante(txtSkuFabricante.getText());
                producto.setCNmbFabricante(txtNombreFabricante.getText());
                producto.setCNmbProveedor(txtNombreProveedor.getText());
                producto.setNPeso(Double.parseDouble(txtPeso.getText()));
                producto.setCUM(txtUnidadMedida.getText());
                producto.setNPrecioLista(Double.parseDouble(txtPrecioLista.getText()));
                producto.setCCodBarra(txtCodigoBarra.getText());
                producto.setCSkuAlternante(txtSkuAlternante.getText());

                // Registrar el producto
                productoService.registrarProducto(producto);

                JOptionPane.showMessageDialog(null, "Producto registrado exitosamente!");
                limpiarFormulario();
            }
        });
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var productos = productoService.listarProductos();
                StringBuilder productosListados = new StringBuilder("Productos Guardados:\n");
                for (Producto producto : productos) {
                    productosListados.append("SKU: ").append(producto.getCSku())
                            .append(", Nombre: ").append(producto.getCNombre()).append("\n");
                }
                JOptionPane.showMessageDialog(null, productosListados.toString());
            }
        });
    }
    private void initComponents() {

        // Configurar el layout GridBagLayout
        panelMain = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);  // Espacio entre componentes

        // Inicializar los campos
        txtSku = new JTextField(15);
        txtNombre = new JTextField(15);
        txtNombreExtranjero = new JTextField(15);
        txtCodGrupoProducto = new JTextField(15);
        txtNombreGrupoProducto = new JTextField(15);
        txtSkuFabricante = new JTextField(15);
        txtNombreFabricante = new JTextField(15);
        txtNombreProveedor = new JTextField(15);
        txtPeso = new JTextField(15);
        txtUnidadMedida = new JTextField(15);
        txtPrecioLista = new JTextField(15);
        txtCodigoBarra = new JTextField(15);
        txtSkuAlternante = new JTextField(15);
        guardarButton = new JButton("Guardar");
        listarButton = new JButton("Listar Productos");

        // Añadir componentes al panel usando GridBagLayout

        // Primera fila - Etiqueta SKU y Campo SKU
        gbc.gridx = 0; gbc.gridy = 0;
        panelMain.add(new JLabel("SKU:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panelMain.add(txtSku, gbc);

        // Segunda fila - Etiqueta Nombre y Campo Nombre
        gbc.gridx = 0; gbc.gridy = 1;
        panelMain.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panelMain.add(txtNombre, gbc);

        // Tercera fila - Etiqueta Nombre Extranjero y Campo Nombre Extranjero
        gbc.gridx = 0; gbc.gridy = 2;
        panelMain.add(new JLabel("Nombre Extranjero:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panelMain.add(txtNombreExtranjero, gbc);

        // Cuarta fila - Etiqueta Código Grupo Producto y Campo Código Grupo Producto
        gbc.gridx = 0; gbc.gridy = 3;
        panelMain.add(new JLabel("Código Grupo Producto:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        panelMain.add(txtCodGrupoProducto, gbc);

        // Quinta fila - Etiqueta Nombre Grupo Producto y Campo Nombre Grupo Producto
        gbc.gridx = 0; gbc.gridy = 4;
        panelMain.add(new JLabel("Nombre Grupo Producto:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        panelMain.add(txtNombreGrupoProducto, gbc);

        // Continuar de forma similar para los demás campos
        gbc.gridx = 0; gbc.gridy = 5;
        panelMain.add(new JLabel("SKU Fabricante:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5;
        panelMain.add(txtSkuFabricante, gbc);

        gbc.gridx = 0; gbc.gridy = 6;
        panelMain.add(new JLabel("Nombre Fabricante:"), gbc);
        gbc.gridx = 1; gbc.gridy = 6;
        panelMain.add(txtNombreFabricante, gbc);

        gbc.gridx = 0; gbc.gridy = 7;
        panelMain.add(new JLabel("Nombre Proveedor:"), gbc);
        gbc.gridx = 1; gbc.gridy = 7;
        panelMain.add(txtNombreProveedor, gbc);

        gbc.gridx = 0; gbc.gridy = 8;
        panelMain.add(new JLabel("Peso:"), gbc);
        gbc.gridx = 1; gbc.gridy = 8;
        panelMain.add(txtPeso, gbc);

        gbc.gridx = 0; gbc.gridy = 9;
        panelMain.add(new JLabel("Unidad de Medida:"), gbc);
        gbc.gridx = 1; gbc.gridy = 9;
        panelMain.add(txtUnidadMedida, gbc);

        gbc.gridx = 0; gbc.gridy = 10;
        panelMain.add(new JLabel("Precio de Lista:"), gbc);
        gbc.gridx = 1; gbc.gridy = 10;
        panelMain.add(txtPrecioLista, gbc);

        gbc.gridx = 0; gbc.gridy = 11;
        panelMain.add(new JLabel("Código de Barras:"), gbc);
        gbc.gridx = 1; gbc.gridy = 11;
        panelMain.add(txtCodigoBarra, gbc);

        gbc.gridx = 0; gbc.gridy = 12;
        panelMain.add(new JLabel("SKU Alternante:"), gbc);
        gbc.gridx = 1; gbc.gridy = 12;
        panelMain.add(txtSkuAlternante, gbc);

        // Botón de guardar
        gbc.gridx = 1; gbc.gridy = 13;
        panelMain.add(guardarButton, gbc);
        // Botón para listar productos
        gbc.gridx = 1; gbc.gridy = 14;
        panelMain.add(listarButton, gbc);

        panelMain.add(guardarButton);  // Agregar el botón al panel
    }

    private void limpiarFormulario() {
        txtSku.setText("");
        txtNombre.setText("");
        txtNombreExtranjero.setText("");
        txtCodGrupoProducto.setText("");
        txtNombreGrupoProducto.setText("");
        txtSkuFabricante.setText("");
        txtNombreFabricante.setText("");
        txtNombreProveedor.setText("");
        txtPeso.setText("");
        txtUnidadMedida.setText("");
        txtPrecioLista.setText("");
        txtCodigoBarra.setText("");
        txtSkuAlternante.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro de Producto");
        ProductoRepository repository = new ProductoRepositoryImpl();
        ProductoService service = new ProductoServiceImpl(repository);
        frame.setContentPane(new FrmProducto(service).panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
