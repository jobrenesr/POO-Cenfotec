package jenxi;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.stage.Window;

public abstract class Validador extends Tooltip
{
    Node vector;

    public Validador() {
    } 

    public Validador(Node pvector)
    {
        super();
        vector = pvector;
//        vector . setOnKeyPressed(event -> hide());
        
        
        setAutoHide(true);
        setContentDisplay(ContentDisplay.BOTTOM);
    }
    
    public void ponerMensaje(String pmensaje)
    {
        setText(pmensaje);
        Window ventana = vector.getScene().getWindow();

        Point2D contexto = vector.localToScene(
            vector.getBoundsInLocal().getWidth(),
            vector.getBoundsInLocal().getHeight());
        
        show(ventana, contexto.getX() + ventana.getX(), contexto.getY() + ventana.getY());
    }
    
    public void quitarMensaje()
    {
        hide();
    }   
    
    public Node getNodo()
    {
        return vector;
    }

    public void setNodo(Node pvector)
    {
        vector = pvector;
    }
}
