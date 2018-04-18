package jenxi;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class InstalacsRegisSegundaParte extends Validador implements Initializable, Formulable, Controlable
{
    public static ObservableList<FazTareaInstalacion> tareasInstalacion;
    
    public InstalacsRegisSegundaParte()
    {
        super();
    }

    @Override
    public void actualizar(Object datum)
    {
        tareasInstalacion = (ObservableList<FazTareaInstalacion>) datum;
    }

    @Override
    public void dormir()
    {
        tareasInstalacion = null;
    }

    @FXML
    private TableView<FazTareaInstalacion> tblTareas;

    @FXML
    private JFXButton btnAgregarTarea;

    @FXML
    private JFXButton btnModificarTarea;

    @FXML
    private JFXButton btnQuitarTarea;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        setNodo(tblTareas);
        tareasInstalacion = FXCollections.observableArrayList();
        
        btnAgregarTarea.setOnAction(event ->
        {
            
        });
        btnModificarTarea.setOnAction(event ->
        {
            
        });
        btnQuitarTarea.setOnAction(event ->
        {
            FazTareaInstalacion selecc = tblTareas.getSelectionModel().getSelectedItem();       
            if(selecc != null) tareasInstalacion.remove(selecc);
        });
    }

    @Override
    public Object getDato()
    {
        return tblTareas.getItems();
    }

    @Override
    public void setDato(Object datum)
    {
        tblTareas.setItems((ObservableList<FazTareaInstalacion>) datum);
    }

    @Override
    public void inactivarEntradaModulo()
    {
        btnAgregarTarea.setDisable(true);
        btnQuitarTarea.setDisable(true);
        btnModificarTarea.setDisable(true);
    }

    @Override
    public boolean validarModulo()
    {
        return validarDatoIngresado();
    }

    @Override
    public boolean validarDatoIngresado()
    {
        ObservableList<FazTareaInstalacion> lista = tblTareas.getItems();
        
        if(lista == null || lista.isEmpty())
        {
            ponerMensaje("Debe registrar al menos una tarea de instalación");
            return false;
        }
        else
        {
            quitarMensaje();
            return true;
        }
    }
}
