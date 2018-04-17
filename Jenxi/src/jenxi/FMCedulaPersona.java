/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenxi;

import javafx.scene.control.TextInputControl;

/**
 *
 * @author jobre
 */
public class FMCedulaPersona extends FMTexto {
    
    
     public FMCedulaPersona(TextInputControl pinput) {
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
            if(!cedulaJuridica.matches("[1-9][0-9]{8}"))
            {
                ponerMensaje("No es una cédula  valida \nFormato: 123456789");
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
