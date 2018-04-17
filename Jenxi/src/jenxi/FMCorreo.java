
package jenxi;

import javafx.scene.control.TextInputControl;

public class FMCorreo extends FMTexto{
    
    public FMCorreo(TextInputControl pinput) {
        super(pinput);
    }
    
     @Override
    public boolean validarModulo() {

        String cedulaJuridica = getDato().toString();
        if(!validarDatoIngresado()) return false; 
        else
        {
            if(!cedulaJuridica.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$"))
            {
                ponerMensaje("No es un email valido \nutlice minusculas");
                return false;
            }
//            else
//                if(Clientes.gestor.validarClienteCedPrevio((String)getDato()))
//                {
//                    ponerMensaje("Esta cedula  ya ha sido registrada");
//                    return false;   
//                }
                else 
                {
                    quitarMensaje();
                    return true;
                } 
        }
    }
}
