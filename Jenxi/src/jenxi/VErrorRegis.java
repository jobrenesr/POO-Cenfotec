package jenxi;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class VErrorRegis extends Formulario implements Initializable
{
    public VErrorRegis()
    {
        super();
    }

    @FXML
    private JFXDatePicker txtFecha;
    @FXML
    private JFXTextArea txtDescrip;
    
    public static final String FECHA = "f";
    public static final String DESCRP = "d";

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setModulo(FECHA, new FMFechaError(txtFecha));
        setModulo(DESCRP, new FMTexto(txtDescrip));
    }    
}
