package jenxi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import jenxi.acceso_datos.Producto;
import jenxi.acceso_datos.CualidadVersion;

public class VersionRegis extends Formulario implements Initializable, Controlable, Popable
{
    Stage escenario;
    
    Producto producto;

    public VersionRegis()
    {
        super();
    }
    
    @Override    public void actualizar(Object vector)
    {
        producto = (Producto)vector;
    }

    @Override
    public void dormir()
    {
        escenario = null;
    }

    @Override
    public void inyectarEscenario(Stage stage)
    {
        escenario = stage;
    }
    
    @FXML
    private Label labelTitutlo;

    @FXML
    private JFXButton btnRegistrar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private JFXButton btnCaractRegis;
    
    @FXML
    private JFXButton btnCaractMod;

    @FXML
    private JFXListView<CualidadVersion> listaCaract;

    @FXML
    private Label labelDescripcion;

    @FXML
    private Label labelMensajeCaract;
    
    @FXML
    private Label txtExtra;
    
    final String NOM = "nombre";
    final String FECHA = "fecha";
    final String CARACT = "caracteristicas";
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        labelTitutlo.setText("Registrar versión de "+producto.getNombre());
        
        setModulo(   NOM, new FMNombreVersion(txtNombre));
        setModulo( FECHA, new FMFecha(datePicker));
        setModulo(CARACT, new MiradorDeCualidades
            (listaCaract, labelMensajeCaract, labelDescripcion, txtExtra, btnCaractRegis, btnCaractMod));

        btnCaractRegis.setOnAction(event -> {
            Aplicacion.control.navegarPop(Bundle.CUALIDAD_REGIS, null);});
        
        btnCancelar.setOnAction(event ->{
            Aplicacion.control.terminarPop(Bundle.VERSION_REGIS, escenario);});
        
        btnRegistrar.setOnAction(event -> VersionRegistrar());
    }
    
    public void agregarCaracteristica(CualidadVersion cualidadNueva)
    {
       MiradorDeCualidades modulo = (MiradorDeCualidades)get(CARACT);
       modulo.agregarACualidades(cualidadNueva);
    }

    public void VersionRegistrar()
    {
        if(validarFormulario())
        {            
            String nombre = (String)getDato(NOM);
            
            Productos.gestor.registrarVersion(
                ProductoVer.producto.getIdem(),
                nombre,
                (LocalDate)getDato(FECHA)/*,
                (ObservableList<CualidadVersion>)getDato(CARACT)*/);
            
            Aplicacion.control.navegarPop(Bundle.POP,
                new DatosPop(Bundle.PRODUCTOS, nombre, "La version ha sido registrada"));
            
            Aplicacion.control.terminarPop(Bundle.VERSION_REGIS, escenario);
        }
    }
}
