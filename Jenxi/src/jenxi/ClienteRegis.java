package jenxi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import static jenxi.Clientes.gestor;

public class ClienteRegis extends Formulario implements Initializable {

    protected Stage popUp;

       @FXML
    private ImageView imagenView;

    @FXML
    private JFXButton btnBuscar;

    @FXML
    private Label mensaje1;

    @FXML
    private Label mensaje11;

    @FXML
    private Label mensaje111;

    @FXML
    private Label mensaje1111;

    @FXML
    private JFXTextField txtCedulaJuridica;

    @FXML
    private JFXTextField txtRazonSocial;

    @FXML
    private JFXButton btnRegistrar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private Label mensaje11111;

    @FXML
    private JFXTextField txtUbicacion;

    @FXML
    private Label mensaje111111;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private Label mensaje1111111;

    @FXML
    private JFXTextField txtDireccionExacta;

    public ClienteRegis() {
        super();
    }

    public void inyectarEscenario(Stage pPopUp) {
        popUp = pPopUp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setModulo("imagen", new FModImagen(imagenView, btnBuscar));
        // setModulo("nombre", new FMNombreProducto(txtNombre));
        setModulo("cedulaJuridica", new FMCedulaCliente(txtCedulaJuridica));
        setModulo("razonSocial", new FModTexto(txtRazonSocial));
        setModulo("telefono", new FModTexto(txtTelefono));
        setModulo("ubicacion", new FModTexto(txtUbicacion));
        setModulo("direccionExacta", new FModTexto(txtDireccionExacta));

        btnRegistrar.setOnAction(event -> registrarCliente());
        btnCancelar.setOnAction(event -> popUp.close());
    }

    public void registrarCliente() {
        if (validarFormulario()) {
                Clientes.gestor.registrarCliente(
                        (InputStream) getDato("imagen"),
                        (String) getDato("cedulaJuridica"),
                        (String) getDato("razonSocial"),
                        (String) getDato("telefono"),
                        (String) getDato("ubicacion"),
                        (String) getDato("direccionExacta")
                );
            popUp.close();
        }
        
    }

}
