package jenxi;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VCualidadRegis extends Formulario implements Initializable, Controlable, Popable
{
    Stage popUp;
    //FazVersion versionReferencia;
    EscogerCualidad subControl;
    
    public VCualidadRegis()
    {
        super();
    }
    
    @Override
    public void actualizar(Object version)
    {
        //versionReferencia = (FazVersion) version;
    }

    @Override
    public void dormir()
    {
        //versionReferencia = null;
    }

    @Override
    public void inyectarEscenario(Stage stage)
    {
        popUp = stage;
    }
    
    @FXML
    private Label labelTitutlo;
    @FXML
    private RadioButton radioErrror;
    @FXML
    private RadioButton radioMejora;
    @FXML
    private AnchorPane anchorFormulario;
    @FXML
    private JFXButton btnRegistrar;
    @FXML
    private JFXButton btnCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        labelTitutlo.setText("Registro de característica version");
        
        subControl = new EscogerCualidad(anchorFormulario, radioErrror, radioMejora);
        
        btnRegistrar.setOnAction(event -> registrarCualidad());
        btnCancelar.setOnAction(event -> { popUp.close();});
    }
    
    public void registrarCualidad()
    {                
        if(subControl.validarFormulario())
        {
            VersionRegis formularioRegis = (VersionRegis) Aplicacion.control.get(Bundle.VERSION_REGIS).getController();
            formularioRegis.agregarCaracteristica(subControl.getDato());
        }
    }
}
