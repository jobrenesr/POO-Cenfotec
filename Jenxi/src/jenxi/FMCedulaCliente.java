package jenxi;

import javafx.scene.control.TextInputControl;

/**
 *
 * @author jobre
 */
public class FMCedulaCliente extends FMTexto {

    public FMCedulaCliente(TextInputControl pinput) {
        super(pinput);
    }

    @Override
    public Object getDato() {
        return input.getText().trim().replace("-", "");

    }
    @Override
    public boolean validarModulo() {

        String cedulaJuridica = getDato().toString();
        if(!validarDatoIngresado()) return false; 
        else
        {
            if(!cedulaJuridica.matches("[1-9][0-9]{9}"))
            {
                ponerMensaje("No es una cédula júridica valida \nFormato: 1234567890");
                return false;
            }
            else
                if(Clientes.gestor.validarClienteCedPrevio((String)getDato()))
                {
                    ponerMensaje("Esta cedula  ya ha sido registrada");
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



