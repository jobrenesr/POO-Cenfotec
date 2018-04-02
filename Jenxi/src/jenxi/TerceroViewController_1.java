package jenxi;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import jenxi.Cxml;
import jenxi.Ventana;

public class TerceroViewController_1 extends Ventana implements Initializable
{
    @FXML
    Label labelServer;

    @FXML
    Button buttonBack;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
            // TODO Auto-generated method stub
    }

    public void onDismissViewController() {
//            getNavegacionControlador().mostrarVentana(Cxml.SEGUNDO);
    }
}
