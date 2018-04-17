
package jenxi;

import javafx.scene.control.TextInputControl;

public class FMNombreProducto extends FMTexto
{    
    public FMNombreProducto(TextInputControl pinput)
    {
        super(pinput);
    }
    
    @Override
    public boolean validarModulo()
    {
        if(!validarDatoIngresado()) return false; 
        else
            if(Productos.gestor.validaProductoPrevio((String)getDato()))
            {
                ponerMensaje("Este producto ya ha sido registrado");
                return false;   
            }
            else 
            {
                quitarMensaje();
                return true;
            }
    }
}
