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

public class ProductoRegis extends Formulario implements Initializable
{
    protected Stage popUp;

    @FXML protected JFXButton btnRegistrar;

    @FXML protected JFXButton btnCancelar;
        
    @FXML protected ImageView imagenView; 

    @FXML protected JFXButton btnBuscar;

    @FXML protected JFXTextField txtNombre;

    @FXML protected JFXTextArea txtDescripcion;
    
    protected final String    IMG = "imagen";
    protected final String    NOM = "nombre";
    protected final String DESCRP = "descripcion";
    
    public ProductoRegis()
    {
        super();
    }
    
    public void inyectarEscenario(Stage pPopUp)
    {
        popUp = pPopUp;        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        setModulo(IMG, new FModImagen(imagenView, btnBuscar)); 
        setModulo(NOM, new FMNombreProducto(txtNombre));
        setModulo(DESCRP, new FModTexto(txtDescripcion));
        
        btnRegistrar.setOnAction(event -> registrar());
        btnCancelar.setOnAction(event -> {popUp.close();});
    }
    
    public void registrar()
    {
        if(validarFormulario())
        {            
            String nombre = (String)getDato(NOM);
            Productos.gestor.registrarProducto
            (
                (ByteArrayInputStream)getDato(IMG), nombre, (String)getDato(DESCRP)
            );

            PopRegistro popConfirma = new PopRegistro("El producto ha sido registrado",Ventana.PRODUCTOS, nombre);
            Fxmleador popLoader = new Fxmleador(Xml.POP_UNO, popConfirma);
            popConfirma.inyectarEscenario(popLoader.cargarPop());
            
            popUp.close();
        }
    }
}
