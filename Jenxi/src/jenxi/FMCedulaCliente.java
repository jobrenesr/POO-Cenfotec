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
public class FMCedulaCliente extends FModTexto {

    public FMCedulaCliente(TextInputControl pinput) {
        super(pinput);
    }

    @Override
    public Object getDato() {
        return input.getText().trim().replace("-", "");

    }

    String regex = "[0-9]";
    String cedulaJuridica = getDato().toString();
    @Override
    public boolean validarModulo() {
        if(!validarDatoIngresado()) return false; 
        else
        {
            
        
            if(cedulaJuridica.matches(regex))
            {
                ponerMensaje("No es una cédula júridica valida");
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



