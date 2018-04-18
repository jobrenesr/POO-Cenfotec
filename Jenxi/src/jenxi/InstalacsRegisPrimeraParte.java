package jenxi;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class InstalacsRegisPrimeraParte extends Formulario implements Initializable
{
    public InstalacsRegisPrimeraParte()
    {
        super();
    }
    
    @FXML
    private Label labelProducto;

    @FXML
    private ChoiceBox<String> sltProducto;

    @FXML
    private Label labelVersion;

    @FXML
    private ChoiceBox<String> sltVersion;

    @FXML
    private Label labelFecha;

    @FXML
    private JFXDatePicker sltFecha;
    
    @FXML
    private Label labelHora;

    @FXML
    private JFXTimePicker sltHora;

    public final String PRODUCTO = "p";
    public final String VERSION = "v";
    public final String FECHA = "f";
    public final String HORA = "h";

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        labelProducto.setLabelFor(sltProducto);
        labelVersion.setLabelFor(sltVersion);
        labelFecha.setLabelFor(sltFecha);
        labelHora.setLabelFor(sltHora);
        
        setModulo(PRODUCTO, new FMSelectString(sltProducto));
        setModulo(VERSION, new FMSelectString(sltVersion));
        setModulo(FECHA, new FMFechaInstalacion(sltFecha));
        setModulo(HORA, new FMSelectHora(sltHora));
    }
}
