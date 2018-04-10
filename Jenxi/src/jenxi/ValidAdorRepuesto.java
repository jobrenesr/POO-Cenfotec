package jenxi;

import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;

public abstract class ValidAdorRepuesto extends ContextMenu
{
    Node vector;
    MenuItem mensaje;
    
    public ValidAdorRepuesto(Node pvector)
    {
        vector = pvector;
        setAutoHide(false);
        mensaje = new MenuItem();
        vector.setOnMouseClicked(event -> hide());
    }
    
    public void ponerMensaje(String pmensaje)
    {
        mensaje.setText(pmensaje);
        getItems().clear();
        getItems().add(mensaje);
        show(vector, Side.BOTTOM, 10, 0);
    }
}
