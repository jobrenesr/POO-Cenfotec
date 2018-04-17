package jenxi;

import com.jfoenix.controls.JFXDatePicker;
import java.time.LocalDate;

public class FMFecha extends Validador implements Formulable
{
    JFXDatePicker input;
    
    public FMFecha(JFXDatePicker pvector)
    {
        super(pvector);
        input = pvector;
        input . focusedProperty().addListener((obs, oldVal, newVal) ->{
            if(!newVal) validarModulo();});
    }

    @Override
    public Object getDato()
    {
        return input.getValue();
    }

    @Override
    public void setDato(Object datum)
    {
        input.setValue((LocalDate)datum);
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
            ponerMensaje("Fecha es inválida, formato correcto: dd/mm/aaaa");
            return false;
            
        } else
            {
                ponerMensaje("");
                return true;   
            }
    }
}
