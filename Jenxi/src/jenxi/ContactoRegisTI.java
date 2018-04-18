package jenxi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import jenxi.acceso_datos.Cliente;
import jenxi.acceso_datos.Contacto;

public class ContactoRegisTI extends Formulario  implements Initializable, Controlable, Popable
{
    protected Stage escenario;
    
    private Contacto referenciaContacto;
    
     public ContactoRegisTI()
    {
        super();
        
    }
     
     public void inyectarEscenario(Stage pPopUp) {
        escenario = pPopUp;
    }
     
     @Override
    public void actualizar(Object contactoReferencia)
    {
       referenciaContacto = (Contacto)contactoReferencia;
    }

    @Override
    public void dormir()
    {
        borrarFormulario();
    }
    
@FXML
    protected Label mensaje1;

    @FXML
    private Label Cedula;

    protected JFXTextField txtCedulaEmpleado;

    @FXML
    private Label NombreCompleto;

    protected JFXTextField txtNombreEmpleado;

    @FXML
    private Label Telefono;

    protected JFXTextField txtTelefonoEmpleado;

    @FXML
    private Label CorreoElectrónico;

    @FXML
    protected JFXTextField txtCorreoElectronico;

    @FXML
    protected JFXButton btnRegistrar;

    @FXML
    protected JFXButton btnCancelarRegisContacto;

    @FXML
    protected JFXTextField txtCedulaJuridica;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        setModulo("cedulaEmpleado", new FMCedulaPersona(txtCedulaEmpleado));
        setModulo("nombreEmpleado", new FMTexto(txtNombreEmpleado));
        setModulo("telefonoEmpleado", new FMTelefono(txtTelefonoEmpleado));
        setModulo("correoEmpleado", new FMCorreo(txtCorreoElectronico));
      
        setModulo("cedulaJuridica", new FMTexto(txtCedulaJuridica));
        
        
        String x = ClienteVer.cliente.getCedulaJuridica();
        ponerModIficar("cedulaJuridica", x);
        inactivarModulo("cedulaJuridica");
        
        txtCedulaJuridica.setVisible(false);
        
        mensaje1.setText("Registrar Contacto TI");
        txtCedulaJuridica.setVisible(false);
        btnRegistrar.setOnAction(event -> registrarContacto());
        btnCancelarRegisContacto.setOnAction(event ->{
            Aplicacion.control.terminarPop(Bundle.CONTACTO_REGISTI, escenario);
        });
    }
    
  
    
    public void registrarContacto() {
        if (validarFormulario()) {
            
            
                Clientes.gestor.registrarContactoTI(
                        (String) getDato("cedulaEmpleado"),
                        (String) getDato("nombreEmpleado"),
                        (String) getDato("telefonoEmpleado"),
                        (String) getDato("correoEmpleado"),
                        (String) getDato("cedulaJuridica") 
                        );

           Aplicacion.control.navegarPop(
                Bundle.POP, new DatosPop(Bundle.CLIENTES, (String) getDato("cedulaJuridica")  ,"El contacto ha sido registrado"));
            
            Aplicacion.control.terminarPop(Bundle.CONTACTO_REGISTI, escenario);
            escenario.close();
        }
        
    }
}
