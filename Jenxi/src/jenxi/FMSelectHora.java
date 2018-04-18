package jenxi;

import com.jfoenix.controls.JFXTimePicker;
import java.time.LocalTime;

public class FMSelectHora extends Validador implements Formulable
{
    JFXTimePicker input;
    
    public FMSelectHora(JFXTimePicker pinput)
    {
        super(pinput);
        input = pinput;
    }

    @Override
    public Object getDato()
    {
        return input.getValue();
    }

    @Override
    public void setDato(Object datum)
    {
        input.setValue((LocalTime)datum);
    }

    @Override
    public void inactivarEntradaModulo()
    {
        input.setDisable(true);        
    }

    @Override
    public boolean validarModulo()
    {
        return validarDatoIngresado();
    }

    @Override
    public boolean validarDatoIngresado()
    {
        if(getDato() == null)
        {
            ponerMensaje("el dato ingresado no es válido");
            return false;
            
        } else
            {
                quitarMensaje();
                return true;   
            }        
    }
}
