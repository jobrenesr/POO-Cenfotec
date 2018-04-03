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
import javafx.scene.control.Label;
import jenxi.acceso_datos.Cliente;
import jenxi.gestores.GestorClientes;

/**
 *
 * @author jobre
 */
public class ClienteController implements Initializable {

    private PrincipalController control;

    private GestorClientes gestor;

    private Cliente cliente;

    public ClienteController(PrincipalController pcontrol, GestorClientes pgestor, String pRazonSocial) {
        control = pcontrol;
        gestor = pgestor;
        cliente = gestor.obtenerCliente(pRazonSocial);
    }

    
      @FXML
    private Label labelRazonSocial;

    @FXML
    private Label labelCedulaJuridica;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelRazonSocial.setText(cliente.getRazonSocial());
        labelCedulaJuridica.setText(cliente.getCedulaJuridica());
    }
}
