package jenxi;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import jenxi.acceso_datos.Producto;

public class ProductoVer implements Initializable, Controlable
{    
    private Producto producto;

    public ProductoVer()
    {
        
    }
    
    @Override
    public void dormir()
    {
        producto = null;
    }
    
    @Override
    public void actualizar(String nombre)
    {
        producto = Productos.gestor.obtenerProducto(nombre);
    }

    @FXML
    private AnchorPane tabVersiones;

    @FXML
    private AnchorPane tabClientes;

    @FXML
    private AnchorPane tabTareas;

    @FXML
    private ImageView imagenView;

    @FXML
    private Label labelNombre;

    @FXML
    private Label descripcion;
    
    @FXML
    private JFXButton btnModificar;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       labelNombre.setText(producto.getNombre());
       descripcion.setText(producto.getDescripcion());
       imagenView.setImage(producto.getImagen());
       btnModificar.setOnAction(event -> navegarModProducto());
    }
    
    public void navegarModProducto()
    {
        ProductoModificar modificar = new ProductoModificar();
        modificar.inyectarProducto(producto);
        
        Fxmleador loader = new Fxmleador(Xml.REGIS_PRODUCTO, modificar);
        modificar.inyectarEscenario(loader.cargarPop());
    }
}
