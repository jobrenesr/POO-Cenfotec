package jenxi;

import com.jfoenix.controls.JFXDatePicker;
import java.time.LocalDate;

public class FMFechaInstalacion extends FMFecha
{
    public FMFechaInstalacion(JFXDatePicker pvector)
    {
        super(pvector);
    }
    
    @Override
    public boolean validarModulo()
    {
        LocalDate fechaCita = null;
        
        if(validarDatoIngresado()) return false;
        else
        {
            fechaCita = (LocalDate)getDato();
            if(fechaCita.isEqual(LocalDate.now()) || fechaCita.isBefore(LocalDate.now()))
            {
                ponerMensaje("La fecha debe estar en el futuro");
                return false;
            }
            else
            {
                quitarMensaje();
                return true;                                
            }
        }

    }
    
}
