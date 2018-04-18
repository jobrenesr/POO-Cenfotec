package jenxi;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class FMRadioDos extends Validador implements Formulable
{
    ToggleGroup input;
    RadioButton instalacion;
    RadioButton requisitos;
    
    public final String INSTALACION = "requisitos";
    public final String REQUISITOS = "instalacion";
    
    public FMRadioDos(RadioButton tipoInstalacion, RadioButton tipoRequisitos)
    {
        super();
        input = new ToggleGroup();
  
        tipoInstalacion.setToggleGroup(input);
        tipoInstalacion.setUserData(INSTALACION);
        
        tipoRequisitos.setToggleGroup(input);
        tipoRequisitos.setUserData(REQUISITOS);
        
        instalacion = tipoInstalacion;
        requisitos = tipoRequisitos;
    }

    @Override
    public Object getDato()
    {
        return input.getSelectedToggle().getUserData();
    }

    @Override
    public void setDato(Object dato)
    {
        String tipo = (String) dato;
        if(tipo != null)
        {
            if(tipo.equals(REQUISITOS))  input.selectToggle(requisitos);

            if(tipo.equals(INSTALACION)) input.selectToggle(instalacion);
        }
    }

    @Override
    public void inactivarEntradaModulo()
    {
        requisitos.setDisable(true);
        instalacion.setDisable(true);
    }

    @Override
    public boolean validarModulo()
    {
        return validarDatoIngresado();
    }

    @Override
    public boolean validarDatoIngresado()
    {
        if(input.getSelectedToggle() == null)
        {
            ponerMensaje("Debe seleccionar un tipo");
            return false;
        }
        else
        {
            quitarMensaje();
            return true;
        }
    }
}
