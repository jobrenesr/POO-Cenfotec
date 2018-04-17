package jenxi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ProductoRegis extends Formulario implements Initializable, Controlable, Popable
{
    protected Stage escenario;
    
    protected final String    IMG = "imagen";
    protected final String    NOM = "nombre";
    protected final String DESCRP = "descripcion";
    
    public ProductoRegis()
    {
        super();
    }
    
    @Override
    public void actualizar(Object vector)
    {
        
    }

    @Override
    public void dormir()
    {
        borrarFormulario();
    }
    
    @Override
    public void inyectarEscenario(Stage pPopUp)
    {
        escenario = pPopUp;        
    }

    @FXML protected JFXButton btnRegistrar;

    @FXML protected JFXButton btnCancelar;
        
    @FXML protected ImageView imagenView; 

    @FXML protected JFXButton btnBuscar;

    @FXML protected JFXTextField txtNombre;

    @FXML protected JFXTextArea txtDescripcion;
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        setModulo(   IMG, new FMImagen(imagenView, btnBuscar)); 
        setModulo(   NOM, new FMNombreProducto(txtNombre));
        setModulo(DESCRP, new FMTexto(txtDescripcion));
        
        btnRegistrar.setOnAction(event -> registrar());
        btnCancelar.setOnAction(event ->
        {
            Aplicacion.control.terminarPop(Bundle.PRODUCTO_REGIS, escenario);
        });
    }
    
    public void registrar()
    {
        if(validarFormulario())
        {            
            String nombre = (String)getDato(NOM);
            
            Productos.gestor.registrarProducto(
                (ByteArrayInputStream)getDato(IMG), nombre, (String)getDato(DESCRP));
            
            Aplicacion.control.navegarPop(Bundle.POP,
                new DatosPop(Bundle.PRODUCTOS, nombre, "El producto ha sido registrado"));
            
            Aplicacion.control.terminarPop(Bundle.PRODUCTO_REGIS, escenario);
        }
    }
}
