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

public class Fxmleador extends FXMLLoader
{
    public Fxmleador(String locacion, Initializable pcontrolador)
    {
        super();
        setLocation(getClass().getResource(locacion));
        setController(pcontrolador);
    }
    
    public void actualizarse(String vector)
    {
        Controlable controlador = getController();
        controlador.actualizar(vector);
    }
    
    public void dormir()
    {
        Controlable controlador = getController();
        controlador.dormir();
    }
        
    public Node cargarNodo()
    {
        return (Node)cargarFXML();
    }
    
    public Scene cargarEscena()
    {
        return new Scene(cargarFXML());
    }
     
    public Stage cargarPop()
    {
        Stage escenario = new Stage();
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
            Logger.getLogger(Fxmleador.class.getName()).log(Level.SEVERE, null, ex);}
        
        return raiz;
    }
}
