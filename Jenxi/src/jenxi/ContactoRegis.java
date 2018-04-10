/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenxi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ContactoRegis extends Formulario implements Initializable{
        
    protected Stage popUp;
    
    @FXML
    private Label mensaje1;

    @FXML
    private Label Cedula;

    @FXML
    private JFXTextField txtCedulaEmpleado;

    @FXML
    private Label NombreCompleto;

    @FXML
    private JFXTextField txtNombreEmpleado;

    @FXML
    private Label Telefono;

    @FXML
    private JFXTextField txtTelefonoEmpleado;

    @FXML
    private Label Puesto;

    @FXML
    private JFXTextField txtPuestoEmpleado;

    @FXML
    private Label CorreoElectrónico;

    @FXML
    private JFXTextField txtCorreoElectronico;

    @FXML
    private JFXButton btnRegistrarContacto;

    @FXML
    private JFXButton btnCancelarRegisContacto;
    
    public ContactoRegis() {
        super();
    }

    public void inyectarEscenario(Stage pPopUp) {
        popUp = pPopUp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        setModulo("cedulaEmpleado", new FMCedulaCliente(txtCedulaEmpleado));
        setModulo("nombreEmpleado", new FModTexto(txtNombreEmpleado));
        setModulo("telefonoEmpleado", new FModTexto(txtTelefonoEmpleado));
        setModulo("puestoEmpleado", new FModTexto(txtPuestoEmpleado));
        setModulo("correoElectronico", new FModTexto(txtCorreoElectronico));
        
        btnRegistrarContacto.setOnAction(event -> registrarContacto());
        //btnCancelarRegisContacto.setOnAction(event -> {popUp.close();});
        popUp.close();
    }
    
  
    
    public void registrarContacto() {
        if (validarFormulario()) {
                Clientes.gestor.registrarContacto(
                        (String) getDato("cedulaEmpleado"),
                        (String) getDato("nombreEmpleado"),
                        (String) getDato("telefonoEmpleado"),
                        (String) getDato("puestoEmpleado"),
                        (String) getDato("correoElectronico")
                );
            popUp.close();
        }
        
    }
}
