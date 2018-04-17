package jenxi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import jenxi.acceso_datos.CualidadVersion;
import jenxi.acceso_datos.VersionError;
import jenxi.acceso_datos.VersionMejora;

public class MiradorDeCualidades extends Validador implements Formulable
{
    JFXListView<CualidadVersion> lista;
    Label mensajeVersion;
    Label mensajeCualidad;
    Label extra;
    Label descripcion;
    JFXButton btnCaractRegis;
    JFXButton btnCaractMod;
    
    public MiradorDeCualidades(JFXListView plista,
                             Label pmensajeVersion,
                             Label pmensajeCualidad,
                             Label pdescripcion,
                             Label ptxtExtra)
    {
        super(plista);
        
        mensajeVersion = pmensajeVersion;
        mensajeCualidad = pmensajeCualidad;
        extra = ptxtExtra;
        descripcion = pdescripcion;
        
        lista = plista;
        lista.setCellFactory(param -> ponerStringAdapter());
        lista.setOnMouseClicked(event ->
        {
            if(!lista.getItems().isEmpty() || lista != null)
                verCualidad(lista.getSelectionModel().getSelectedItem());
        });
    }
    
    public MiradorDeCualidades(JFXListView plista,
                                Label pmensajeVersion,
                                Label pmensajeCualidad,
                                Label pdescripcion,
                                JFXButton pbtnCaractRegis,
                                JFXButton pbtnCaractMod)
    {
        super(plista);
        
        mensajeVersion = pmensajeVersion;
        mensajeCualidad = pmensajeCualidad;
        descripcion = pdescripcion;
        btnCaractRegis = pbtnCaractRegis;
        btnCaractMod = pbtnCaractMod;
        
        lista = plista;
        lista.setCellFactory(param -> ponerStringAdapter());
        lista.setOnMouseClicked(event ->
        {
            if(!lista.getItems().isEmpty() || lista != null)
                verCualidad(lista.getSelectionModel().getSelectedItem());
        });
    }
    
    public void ponerMensajeVersion(String mensaje)
    {
        mensajeVersion.setText(mensaje);
    }
    
    public void agregarACualidades(CualidadVersion cualidad)
    {
        lista.getItems().add(cualidad);
    }
    
    public ListCell<CualidadVersion> ponerStringAdapter()
    {
        return new ListCell<CualidadVersion>()
        {
            @Override
            protected void updateItem(CualidadVersion item, boolean empty)
            {
                super.updateItem(item, empty);
                if (empty || item == null || item.getNombre()== null)
                     setText("");
                
                else setText(item.getNombre());
            }
        };
    }
    
    public void verCualidad(CualidadVersion cualidad)
    {
        if(cualidad instanceof VersionError)
        {
            mensajeCualidad.setText("Error: "+ cualidad.getNombre());
        }
        if(cualidad instanceof VersionMejora)
        {
            mensajeCualidad.setText("Mejora: "+ cualidad.getNombre());
        }
        extra.setText(cualidad.getDatoExtra());
        descripcion.setText(cualidad.getDescripcion());
    }

    @Override
    public Object getDato()
    {
        return lista.getItems();
    }

    @Override
    public void setDato(Object dato)
    {
        lista.setItems((ObservableList<CualidadVersion>) dato);
    }

    @Override
    public void inactivarEntradaModulo()
    {
        btnCaractRegis.setDisable(true);
        btnCaractMod.setDisable(true);
    }

    @Override
    public boolean validarModulo()
    {
        return true;
    }

    @Override
    public boolean validarDatoIngresado()
    {
        ObservableList<CualidadVersion> lista = (ObservableList<CualidadVersion>)getDato();
        if(lista.isEmpty())
        {
            ponerMensaje("Debe ingresar al menos una caracteristica");
            return false;
            
        } else
        {
            ponerMensaje("");
            return true;
        }
    }
}
