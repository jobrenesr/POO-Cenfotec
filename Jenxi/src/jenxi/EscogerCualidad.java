package jenxi;

import java.time.LocalDate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import jenxi.acceso_datos.CualidadVersion;
import jenxi.acceso_datos.VersionError;
import jenxi.acceso_datos.VersionMejora;

public class EscogerCualidad extends ToggleGroup
{  
    public EscogerCualidad(AnchorPane recipiente, RadioButton error, RadioButton mejora)
    {
        super();

        Ventana ventanaError = new Ventana(Xml.ERROR_REGIS, new VErrorRegis());
        Ventana ventanaMejora = new Ventana(Xml.MEJORA_REGIS, new VMejoraRegis());
        
        error.setToggleGroup(this); 
        error.setUserData(ventanaError);

        mejora.setToggleGroup(this);
        mejora.setUserData(ventanaMejora);
        mejora.setSelected(true);
        recipiente.getChildren().add(ventanaMejora.cargarNodo());
        
        ToggleGroup thus = this;
        this.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle)
            {
                if (thus.getSelectedToggle() != null)
                {
                    Ventana vActiva = (Ventana)thus.getSelectedToggle().getUserData();
                    vActiva.setRoot(null);
                    recipiente.getChildren().clear();
                    recipiente.getChildren().add(vActiva.cargarNodo());
                }                
            }
        });
    }
    
    public boolean validarFormulario()
    {
        Ventana vActiva = (Ventana)getSelectedToggle().getUserData();
        Formulario formulario = vActiva.getController();
        
        return formulario.validarFormulario();
    }
    
    public CualidadVersion getDato()
    {
        Ventana vActiva = (Ventana)getSelectedToggle().getUserData();
        Formulario formulario = vActiva.getController();
        CualidadVersion cualidad;
        
        if(formulario instanceof VMejoraRegis)
        {
            VersionMejora mejora = new VersionMejora();
            mejora.setDescripcion((String) formulario.get(VMejoraRegis.DESCRP).getDato());
            cualidad = mejora;
            
        } else
        {
            VersionError error = new VersionError();
            error.setDescripcion((String) formulario.get(VErrorRegis.DESCRP).getDato());
            error.setFechaReporte((LocalDate) formulario.get(VErrorRegis.FECHA).getDato());
            cualidad = error;
        }
        return cualidad;
    }    
}
