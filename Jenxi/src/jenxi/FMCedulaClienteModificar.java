/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenxi;

import javafx.scene.control.TextInputControl;


public class FMCedulaClienteModificar extends FMCedulaCliente
{
    
    public FMCedulaClienteModificar(TextInputControl pinput) {
        super(pinput);
    }
    
        @Override
    public boolean validarModulo()
    {
        return true;
    }
}

