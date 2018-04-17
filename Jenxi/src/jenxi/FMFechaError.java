package jenxi;

import com.jfoenix.controls.JFXDatePicker;
import java.time.LocalDate;

public class FMFechaError extends FMFecha
{
    public FMFechaError(JFXDatePicker pvector) {
        super(pvector);
    }
//    @Override
//    public boolean validarModulo()
//    {
//        if(!validarDatoIngresado()) return false; 
//        else
//        {
//            VersionRegis formulario = Aplicacion.control.get(Bundle.VERSION_REGIS).getController();
//            LocalDate fechaVersion = (LocalDate)formulario.get("fecha").getDato();
//            
//            if())
//            {
//                ponerMensaje("Este producto ya ha sido registrado");
//                return false;   
//            }
//            else 
//            {
//                quitarMensaje();
//                return true;
//            }
//        }
//            
//    }
}
