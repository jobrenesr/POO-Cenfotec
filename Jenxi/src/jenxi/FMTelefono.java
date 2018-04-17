package jenxi;

import javafx.scene.control.TextInputControl;

/**
 *
 * @author jobre
 */
public class FMTelefono extends FMTexto {
    public FMTelefono(TextInputControl pinput) {
        super(pinput);
    }
    
    @Override
    public Object getDato() {
        return input.getText().trim().replace("-", "");
    }
    

    @Override
    public boolean validarModulo() {
        
        String telefono = (String)getDato();
        
        if(!validarDatoIngresado()) return false; 
        else
        {
            if(!telefono.matches("[1-9][0-9]{7}"))
            {
                ponerMensaje("No es un telefono valido");
                return false;
            }
            /*else
                if(Clientes.gestor.validaProductoPrevio((String)getDato()))
                {
                    ponerMensaje("Este producto ya ha sido registrado");
                    return false;   
                }
                else 
                {
                    quitarMensaje();
                    return true;
                } */
        }
        return true;
    }
}
