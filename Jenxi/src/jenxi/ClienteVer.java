/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenxi;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import static jenxi.Clientes.formularioRegistrar;
import jenxi.acceso_datos.Cliente;

/**
 *
 * @author jobre
 */
public class ClienteVer  implements Initializable,Controlable {

    private Cliente cliente;

     
    public ClienteVer() {
        
    }
    
    @Override
    public void actualizar(String nombreSeleccionado)
    {
        cliente = Clientes.gestor.obtenerCliente(nombreSeleccionado);
    }
    
    @Override
    public void dormir()
    {
        cliente = null;
    }
    
    
    static ContactoRegis formularioRegistrar1;

    @FXML
    private Label labelRazonSocial;

    @FXML
    private Label labelCedulaJuridica;

    @FXML
   private ImageView imagenView;
    
       @FXML
    private Label labelTelefono;
           @FXML
    private AnchorPane tabVersiones;

    @FXML
    private JFXButton btnRegistrarContacto;

    @FXML
    private AnchorPane tabClientes;

    @FXML
    private AnchorPane tabTareas;

    @FXML

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelRazonSocial.setText(cliente.getRazonSocial());
        labelCedulaJuridica.setText(cliente.getCedulaJuridica());
        labelTelefono.setText(cliente.getTelefono());
        imagenView.setImage(new Image(cliente.getImagen()));
        
        btnRegistrarContacto.setOnAction(event ->
        {
            //formularioRegistrar1 = new ContactoRegis();
            Fxmleador ContactoRegis = new Fxmleador(Xml.REGIS_CONTACTO, new ContactoRegis());
            formularioRegistrar1.inyectarEscenario(ContactoRegis.cargarPop());
      
        });  
    }
                     
}
