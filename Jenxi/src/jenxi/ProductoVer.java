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
    public static Producto producto;

    public ProductoVer()
    {
        
    }
    
    @Override
    public void dormir()
    {
        producto = null;
    }
    
    @Override
    public void actualizar(Object nombre)
    {
        producto = Productos.gestor.obtenerProducto((String)nombre);
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
        
        Image imagen = producto.getImagen();
        if(imagen != null) imagenView.setImage(imagen);
        
        Ventana versiones = new Ventana(Xml.VERSIONES, new Versiones());
        tabVersiones.getChildren().add(versiones.cargarNodo());

        btnModificar.setOnAction(event -> navegarModProducto());
    }
    
    public void navegarModProducto()
    {
        Aplicacion.control.navegarPop(Bundle.PRODUCTO_MOD, producto);
    }
}
