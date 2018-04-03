package jenxi;

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
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import jenxi.gestores.GestorPrincipal;

public class PrincipalController implements Initializable
{    
    static GestorPrincipal gestor;
    
    MenuController controladorMenu;

    public PrincipalController()
    {
        gestor = new GestorPrincipal();
    }

    @FXML private   JFXDrawer drawer;

    @FXML private   JFXHamburger hamburger;
    
        HamburgerBackArrowBasicTransition burgerTask;
        
    @FXML private SplitPane splitPane;
    
        @FXML private   AnchorPane ventanaIzquierda;

        @FXML private   AnchorPane ventanaDerecha;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {   
            FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource(Cxml.MENUDRAWER));
            controladorMenu = new MenuController(this);
            
            loaderMenu.setController(controladorMenu);
            drawer.setSidePane((Node)loaderMenu.load());

            burgerTask = new HamburgerBackArrowBasicTransition(hamburger);
            hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (event)->
            {
                toggleBurgerTask();
                if(drawer.isShown()) drawer.close();               
                    else
                        drawer.open();
                
            });
            
            controladorMenu.navegarProductos();
            burgerTask.setRate(-1);
            
        } catch (Exception e) {e.printStackTrace();}
    }
    
    public void ponerALaIzquierda(Parent ventana)
    {
        limpiarPantallaPrincipal();
        ventanaIzquierda.getChildren().add(ventana);
        drawer.close();
        toggleBurgerTask();
    }
    
    public void ponerALaDerecha(Parent ventana)
    {
        limpiarPantallaPrincipal();
        ventanaDerecha.getChildren().add(ventana);
        drawer.close();
        toggleBurgerTask();
    }
    
    public void limpiarPantallaPrincipal()
    {
        ventanaIzquierda.getChildren().clear();
        ventanaDerecha.getChildren().clear();
    }
    
    public void toggleBurgerTask()
    {
        burgerTask.setRate(burgerTask.getRate() * -1);
        burgerTask.play();   
    }
}
 
//    public Ventana initVentana(String vector)
//    {
//        Ventana abstracta = null;
//        try
//        {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(vector));
//                Parent rootxml = loader.load();
//                    rootxml.setId(vector);
//
//            abstracta = loader.getController();
//            abstracta.setRaizXml(rootxml);
//            abstracta.setNombre(vector);
//            abstracta.setControlador(this);
//
//
//        } catch (Exception e) {e.printStackTrace();}
//        
//        return abstracta;
//    }
