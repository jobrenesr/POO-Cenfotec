
package jenxi;

import javafx.scene.control.TextInputControl;

public class FMNombreProductoModificar extends FMNombreProducto
{
    public FMNombreProductoModificar(TextInputControl pinput) {
        super(pinput);
    }
    
        @Override
    public boolean validarModulo()
    {
        return true;
    }
}
