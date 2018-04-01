package jenxi;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import jenxi.acceso_datos.Producto;
import jenxi.gestores.GestorProductos;
import sun.misc.BASE64Decoder;

public class ProductoController implements Initializable
{
    private PrincipalController control;
    
    private GestorProductos gestor;
    
    private Producto producto;

    public ProductoController(PrincipalController pcontrol, GestorProductos pgestor, String pnombre)
    {
        control = pcontrol;
        gestor = pgestor;
        producto = gestor.obtenerProducto(pnombre);
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

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       labelNombre.setText(producto.getNombre()); 
       descripcion.setText(producto.getDescripcion());
       //imagenView.setImage(new Image("prueba.jpeg"));
    }    
}
