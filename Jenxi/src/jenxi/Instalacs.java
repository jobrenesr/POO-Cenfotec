package jenxi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import jenxi.acceso_datos.InstalacListable;
import jenxi.acceso_datos.TareasInstalacion;

public class Instalacs implements Initializable
{
    FilteredList<InstalacListable> instalacsFiltered;

    @FXML
    private JFXTextField txtFiltrarInsta;

    @FXML
    private JFXButton btnInstaRegis;

    @FXML
    private JFXButton btnTareaRegis;

    @FXML
    private JFXButton btnTareaQuitar;

    @FXML
    private JFXButton btnTareaMod;

    @FXML
    private TableView<InstalacListable> tblInstalaciones;

    @FXML
    private TableView<TareasInstalacion> tblTareas;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
//        instalacsFiltered = new FilteredList<InstalacListable>(
//            Clientes.gestor.instalacionesCliente(
//                ClienteVer.cliente.getCedulaJuridica()));

        tblInstalaciones.setItems(instalacsFiltered);
        
        btnInstaRegis.setOnAction(event ->
        {
            Aplicacion.control.navegarPop(Bundle.INSTALACS_REGIS, null);
        });
        
        btnTareaRegis.setOnAction(event ->
        {
            Aplicacion.control.navegarPop(Bundle.TAREA_REGIS, null);
        });
        
    }    
    
}
