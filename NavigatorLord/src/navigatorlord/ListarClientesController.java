package navigatorlord;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ListarClientesController implements Initializable
{
    @FXML private TextField filtrarTabla;
    
    @FXML private TableView tablaClientes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
}
