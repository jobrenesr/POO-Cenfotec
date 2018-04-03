
package jenxi;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import jenxi.gestores.GestorProductos;


public class MenuController implements Initializable {
    
    private PrincipalController control;

    public MenuController(PrincipalController pcontroladorPrincipal)
    {
        control = pcontroladorPrincipal;
    }
    
    @FXML private   JFXButton btnProductos;
 
    @FXML private   JFXButton btnClientes;
    
    @FXML private   JFXButton btnInstalaciones;
    
    @FXML private   JFXButton btnEmpleados;
    
    @FXML private   JFXButton btnSalir;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
     
    public void navegarProductos()
    {
        try
        {
            FXMLLoader loaderProductos = new FXMLLoader(getClass().getResource(Cxml.PRODUCTOS));
            loaderProductos.setController(new ListarProductosController
            (
                control, new GestorProductos()
            ));
            
            control.ponerALaIzquierda((Parent)loaderProductos.load());
            
        } catch (Exception e) {e.printStackTrace();}
    }
    
    public void navegarClientes()
    {
        try {
            control.ponerALaIzquierda
            (
                (Parent)FXMLLoader.load(getClass().getResource(Cxml.CLIENTES))
            );
            
        } catch (Exception e) {e.printStackTrace();}
    }
    
    public void navegarInstalaciones()
    {
        try {
            control.ponerALaIzquierda((Parent)FXMLLoader.load(getClass().getResource(Cxml.INSTALACIONES)));
            
        } catch (Exception e) {e.printStackTrace();}
    }
    
    public void navegarEmpleados()
    {
        try {
            control.ponerALaIzquierda((Parent)FXMLLoader.load(getClass().getResource(Cxml.TERCERO)));
            
        } catch (Exception e) {e.printStackTrace();}
    }
}
