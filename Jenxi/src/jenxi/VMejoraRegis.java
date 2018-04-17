package jenxi;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class VMejoraRegis extends Formulario implements Initializable
{
    public VMejoraRegis()
    {
        super();
    }

    @FXML
    private JFXTextArea txtDescripcion;
    
    public static final String DESCRP = "d";

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setModulo(DESCRP, new FMTexto(txtDescripcion));
    }    
}
