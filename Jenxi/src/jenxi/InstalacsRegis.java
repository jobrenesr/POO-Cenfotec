package jenxi;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InstalacsRegis extends Formulario implements Initializable, Controlable, Popable
{
    Stage popUp;
    
    public static FazInstalacion instalacion;
    
    Ventana primerFormulario;
    
    Ventana segundoFormulario;
    
    public InstalacsRegis()
    {
        super();
    }

    @Override
    public void actualizar(Object datum)
    {
        
    }

    @Override
    public void dormir()
    {
        popUp = null;
        instalacion = null;
        primerFormulario = null;
        segundoFormulario = null;
    }

    @Override
    public void inyectarEscenario(Stage stage)
    {
        popUp = stage;
    }
    
    @FXML
    private AnchorPane anchorRegisInstalac;
    @FXML
    private JFXButton btnContinuar;

    @FXML
    private JFXButton btnCancelar;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        primerFormulario = new Ventana(Xml.INSTALACS_A, new InstalacsRegisPrimeraParte());
        segundoFormulario = new Ventana(Xml.INSTALACS_B, new InstalacsRegisSegundaParte());
        
        anchorRegisInstalac.getChildren().add(primerFormulario.cargarNodo());

         btnCancelar.setOnAction(event-> {Aplicacion.control.terminarPop(Bundle.INSTALACS_REGIS, popUp);});
        btnContinuar.setOnAction(event-> registrarInstalacion());
    }
    
    public final String PRODUCTO = "p";
    public final String VERSION = "v";
    public final String FECHA = "f";
    public final String HORA = "h";
    
    public void registrarInstalacion()
    {
        anchorRegisInstalac.getChildren().clear();
        anchorRegisInstalac.getChildren().add(segundoFormulario.cargarNodo());
        
//        Formulario formulario = primerFormulario.getController();
//        if(formulario.validarFormulario())
//        {
//            instalacion = new FazInstalacion();
//            instalacion.setIdCliente(   ClienteVer.cliente.getCedulaJuridica());
//            instalacion.setIdVersion(   (String)formulario.get(VERSION).getDato());
//            instalacion.setTiempoInstalacion(   LocalDateTime.parse(
//                formulario.get(FECHA).getDato().toString()+" "+
//                formulario.get(HORA).getDato().toString()));
//            
//            
//            Controlable control = segundoFormulario.getController();
//            control.actualizar(instalacion.getTareasInstalacion());
//            anchorRegisInstalac.getChildren().add(primerFormulario.cargarNodo());
//        }
    }
}
