/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigatorlord;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;


public class MenuController implements Initializable {
    
    private PrincipalController menuControlador;
    
    @FXML private   JFXButton btnProductos;
 
    @FXML private   JFXButton btnClientes;
    
    @FXML private   JFXButton btnInstalaciones;
    
    @FXML private   JFXButton btnEmpleados;
    
    @FXML private   JFXButton btnSalir;
    

    public void inyectarControlador(PrincipalController pmenuControlador)
    {
        menuControlador = pmenuControlador;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void toggleHamburger()
    {
        
    }
    
    public void navegarProductos()
    {
        try {
            menuControlador.ponerALaIzquierda((Parent)FXMLLoader.load(getClass().getResource(Ct.TERCERO)));
            
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        toggleHamburger();
    }
    
    public void navegarClientes()
    {
        try {
            menuControlador.ponerALaIzquierda((Parent)FXMLLoader.load(getClass().getResource(Ct.CLIENTES)));
            
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void navegarInstalaciones()
    {
        try {
            menuControlador.ponerALaIzquierda((Parent)FXMLLoader.load(getClass().getResource(Ct.INSTALACIONES)));
            
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void navegarEmpleados()
    {
        try {
            menuControlador.ponerALaIzquierda((Parent)FXMLLoader.load(getClass().getResource(Ct.TERCERO)));
            
        } catch (Exception e) {e.printStackTrace();}
    }
}
