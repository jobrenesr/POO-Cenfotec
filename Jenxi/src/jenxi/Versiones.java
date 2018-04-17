package jenxi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import jenxi.acceso_datos.VersionError;
import jenxi.acceso_datos.CualidadVersion;
import jenxi.acceso_datos.Version;

public class Versiones implements Initializable
{    
    FilteredList<Version> versionesfiltradas;
    
    MiradorDeCualidades cualidades;

    public Versiones(){   }
    
    @FXML
    private JFXListView<Version> listaViewVersiones;

    @FXML
    private JFXListView<CualidadVersion> listaCaract;

    @FXML
    private JFXTextField filtrarVersiones;

    @FXML
    private JFXButton btnAgregarVersion;

    @FXML
    private JFXButton btnModificarVersion;

    @FXML
    private Label versionMensaje;

    @FXML
    private Label cualidadDescripcion;

    @FXML
    private JFXButton btnAgregarCaracteristica;

    @FXML
    private Label cualidadMensaje;

    @FXML
    private Label cualidadExtra;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        versionesfiltradas = new FilteredList<Version>(ProductoVer.producto.getVersiones());
        cualidades = new MiradorDeCualidades
            (listaCaract, versionMensaje, cualidadMensaje, cualidadDescripcion, cualidadExtra);
        
        listaViewVersiones.setCellFactory(param -> ponerStringAdapter());   
        
        if(versionesfiltradas != null || !versionesfiltradas.isEmpty())
            listaViewVersiones.setItems(versionesfiltradas);
        
        if(!versionesfiltradas.isEmpty())
        {
            listaViewVersiones.setOnMouseClicked(event -> cualidades.setDato(
            
                listaViewVersiones.getSelectionModel().getSelectedItem().getCaracteristicas()));
        }
        filtrarVersiones.setOnKeyReleased(filtrarListaVersiones());

        btnAgregarVersion.setOnAction(event -> {
            Aplicacion.control.navegarPop(Bundle.VERSION_REGIS, ProductoVer.producto);});
    }
        
    public EventHandler<KeyEvent>  filtrarListaVersiones()
    {
        return new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent key)
            {
                if (key.getCode().equals(KeyCode.ENTER))
                {
                    String filter = filtrarVersiones.getText();
                    
                    if(filter == null || filter.length() == 0)
                        versionesfiltradas.setPredicate(null); 
                    
                    else versionesfiltradas.setPredicate
                        (version -> version.getNombre().toLowerCase().contains(filter.toLowerCase()));
                }
            };
        };
    }
    
    public ListCell<Version> ponerStringAdapter()
    {
        return new ListCell<Version>()
        {
            @Override
            protected void updateItem(Version item, boolean empty)
            {
                super.updateItem(item, empty);
                if (empty || item == null || item.getNombre()== null)
                    setText("");
                
                else
                {
                    setText(item.getNombre());
                }
            }
        };
    }
}
