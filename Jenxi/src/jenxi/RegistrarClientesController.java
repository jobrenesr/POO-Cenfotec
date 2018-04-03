/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenxi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/**
 *
 * @author jobre
 */
public class RegistrarClientesController implements Initializable{
    
    private PrincipalController control;
    
    
    
    @FXML
    private TextField cedJuridicaCliente;

    @FXML
    private TextField razonSocialCliente;

    @FXML
    private TextField telefonoCliente;

    @FXML
    private TextField ubicacionCliente;

    @FXML
    private TextField direccionExactaCliente;

    @FXML
    private Button RegistrarEmpresa;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
