package navigatorlord;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PrincipalController implements Initializable
{    
    
    HamburgerBackArrowBasicTransition burgerTask;
            
    @FXML private   JFXDrawer drawer;

    @FXML private   JFXHamburger hamburger;
    
    @FXML private   AnchorPane ventanaIzquierda;

    @FXML private   AnchorPane ventanaDerecha;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {             
            FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource(Ct.MENUDRAWER));
            drawer.setSidePane((Node)loaderMenu.load());
            MenuController cMenu = loaderMenu.getController();
            cMenu.inyectarControlador(this);
            
            
            burgerTask = new HamburgerBackArrowBasicTransition(hamburger);
            burgerTask.setRate(-1);
            
            hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (event)->
            {
                burgerTask.setRate(burgerTask.getRate() * -1);
                burgerTask.play();
                
                if(drawer.isShown()) drawer.close();               
                    else
                        drawer.open();
                
            });
        } catch (Exception e) {e.printStackTrace();}
    }
    
    public Ventana initVentana(String vector)
    {
        Ventana abstracta = null;
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(vector));
                Parent rootxml = loader.load();
                    rootxml.setId(vector);

            abstracta = loader.getController();
            abstracta.setRaizXml(rootxml);
            abstracta.setNombre(vector);
            abstracta.setControlador(this);


        } catch (Exception e) {e.printStackTrace();}
        
        return abstracta;
    }
    
    public void ponerALaIzquierda(Parent ventana)
    {
        limpiarVentanaPrincipal();
        ventanaIzquierda.getChildren().add(ventana);
        drawer.close();
        burgerTask.setRate(burgerTask.getRate() * -1);
        burgerTask.play();
    }
    
    public void ponerALaDerecha(Parent ventana)
    {
        limpiarVentanaPrincipal();
        ventanaDerecha.getChildren().add(ventana);
        drawer.close();
        burgerTask.setRate(burgerTask.getRate() * -1);
        burgerTask.play();
    }
    
    public void limpiarVentanaPrincipal()
    {
        ventanaIzquierda.getChildren().clear();
        ventanaDerecha.getChildren().clear();
    }
}
