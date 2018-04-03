package jenxi;

import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import jenxi.gestores.GestorClientes;
import jenxi.gestores.GestorProductos;

public class ListarClientesController implements Initializable
{
      PrincipalController control;
    
    GestorClientes gestor;
    
    public ListarClientesController(PrincipalController pcontrol,
                                     GestorClientes pgestor)
    {
        control = pcontrol;
        gestor = pgestor;
    }
    

    @FXML
    private TextField filtrarTabla;

   // @FXML
   // private TableView<String> tablaClientes;
    
    @FXML
    private JFXListView<String> tablaClientes;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        tablaClientes.setItems(gestor.obtenerListaClientes());
        tablaClientes.setOnMouseClicked((event)->
        {
            try
            {
                FXMLLoader loaderCliente = new FXMLLoader(getClass().getResource(Cxml.VER_PROD));
                loaderCliente.setController(new ClienteController
                (
                    control, gestor, tablaClientes.getSelectionModel().getSelectedItem()
                ));
                control.ponerALaDerecha((Parent)loaderCliente.load());

            } catch (Exception e) {e.printStackTrace();}
        });
    }    
}
