package jenxi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class TareaRegis extends Formulario implements Initializable, Controlable, Popable
{
    Stage Popup;
    
    public TareaRegis()
    {
        super();
    }

    @Override
    public void actualizar(Object vector)
    {
        
    }

    @Override
    public void dormir()
    {
        Popup = null;
    }

    @Override
    public void inyectarEscenario(Stage stage)
    {
        Popup = stage;
    }

    @FXML
    private Label labelEncargado;

    @FXML
    private ChoiceBox<String> sltEncargado;

    @FXML
    private Label labelCodigo;

    @FXML
    private JFXTextField txtCodigo;

    @FXML
    private RadioButton radioTipoInst;

    @FXML
    private RadioButton radioTipoReq;

    @FXML
    private Label LabelDescrip;

    @FXML
    private JFXTextArea txtDescripcion;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnContinuar;
    
    public final String NOMBRE = "N";
    public final String CODIGO = "C";
    public final String ENCARGADO = "E";
    public final String TIPO = "T";
    public final String DESCRIPCION = "D";
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        labelEncargado.setLabelFor(sltEncargado);
        labelCodigo.setLabelFor(txtCodigo);
        LabelDescrip.setLabelFor(txtDescripcion);

        setModulo(     CODIGO, new FMTexto(txtCodigo));
        setModulo(  ENCARGADO, new FMSelectString(sltEncargado));
        setModulo(       TIPO, new FMRadioDos(radioTipoInst, radioTipoReq));
        setModulo(DESCRIPCION, new FMTexto(txtDescripcion));
        
        get(ENCARGADO).setDato();
        
        btnCancelar.setOnAction(event ->
        {
            Aplicacion.control.terminarPop(Bundle.TAREA_REGIS, Popup);
        });
        
        btnContinuar.setOnAction(event ->
        {
            if(validarFormulario())
            {
                FazTareaInstalacion tarea = new FazTareaInstalacion();
                tarea.setCodigo     ((String) getDato(CODIGO));
                tarea.setIdEncargado((String) getDato(ENCARGADO));
                tarea.setTipo       ((String) getDato(TIPO));
                tarea.setDescripcion((String) getDato(DESCRIPCION));
                
                InstalacsRegis.instalacion.getTareasInstalacion().add(tarea);
            }
        });
        
    }
}
