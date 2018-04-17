package jenxi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Ventana extends FXMLLoader
{
    public Ventana(String locacion, Initializable pcontrolador)
    {
        super();
        setLocation(getClass().getResource(locacion));
        setController(pcontrolador);
    }
    
    public Popable getPopControl()
    {
        return (Popable) getController();
    }
    
    public void dormir()
    {
        getControlable().dormir();
        setRoot(null);
    }
    
    public Controlable getControlable()
    {
        return (Controlable) getController();
    }
        
    public Node cargarNodo()
    {
        return (Node)cargarFXML();
    }
    
    public Scene cargarEscena()
    {
        return new Scene(cargarFXML());
    }
     
    public Stage cargarPop(Object contenido)
    {
        Stage escenario = new Stage();
        getControlable().actualizar(contenido);
        escenario.setScene(cargarEscena());

        escenario.initModality(Modality.APPLICATION_MODAL);
        escenario.show();
        escenario.centerOnScreen();
        escenario.setResizable(false);
        
        return escenario;
    }
    
    private Parent cargarFXML()
    {
        Parent raiz = null;
        try
        {
            raiz = load();
            
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);}
        
        return raiz;
    }
}
