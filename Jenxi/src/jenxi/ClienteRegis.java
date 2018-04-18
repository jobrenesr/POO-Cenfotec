package jenxi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ClienteRegis extends Formulario implements Initializable, Controlable, Popable
{
    protected Stage escenario;
    
    public ClienteRegis()
    {
        super();
        
    }
    
    public void inyectarEscenario(Stage pPopUp) {
        escenario = pPopUp;
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

    @FXML
    protected ImageView imagenView;

    @FXML
    protected  JFXButton btnBuscar;

    @FXML
    protected Label mensaje1;

    @FXML
    private Label mensaje11;

    @FXML
    private Label mensaje111;

    @FXML
    private Label mensaje1111;

    @FXML
    protected  JFXTextField txtCedulaJuridica;

    @FXML
    protected JFXTextField txtRazonSocial;

    @FXML
    protected  JFXButton btnRegistrar;

    @FXML
    protected JFXButton btnCancelar;

    @FXML
    private Label mensaje11111;

    @FXML
   protected JFXTextField txtUbicacion;

    @FXML
    private Label mensaje111111;

    @FXML
     protected JFXTextField txtTelefono;

    @FXML
    private Label mensaje1111111;

    @FXML
    protected JFXTextArea  txtDireccionExacta;
    
    protected final String CDJ = "cedulaJuridica";
    protected final String    IMG = "imagen";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setModulo(IMG, new FMImagen(imagenView, btnBuscar));
        setModulo(CDJ, new FMCedulaCliente(txtCedulaJuridica));
        setModulo("razonSocial", new FMTexto(txtRazonSocial));
        setModulo("telefono", new FMTelefono(txtTelefono));
        setModulo("ubicacion", new FMTexto(txtUbicacion));
        setModulo("direccionExacta", new FMTexto(txtDireccionExacta));
        
        
        btnRegistrar.setText("Registrar");
        btnRegistrar.setOnAction(event -> registrarCliente());
        btnCancelar.setOnAction(event -> {
            Aplicacion.control.terminarPop(Bundle.CLIENTE_REGIS, escenario);
        });
    }

    public void registrarCliente(){
        
        if (validarFormulario()){
            
            Clientes.gestor.registrarCliente(
                    (ByteArrayInputStream) getDato(IMG),
                    (String) getDato(CDJ),
                    (String) getDato("razonSocial"),
                    (String) getDato("telefono"),
                    (String) getDato("ubicacion"),
                    (String) getDato("direccionExacta")
            );
                
            Aplicacion.control.navegarPop(

                Bundle.POP, new DatosPop(Bundle.CLIENTES, (String) getDato(CDJ), "El cliente ha sido registrado"));

            
            Aplicacion.control.terminarPop(Bundle.CLIENTE_REGIS, escenario);
        }
    }
}
