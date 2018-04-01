/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenxi;

import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import jenxi.gestores.GestorProductos;

/**
 * FXML Controller class
 *
 * @author JoseAntonio
 */
public class ListarProductosController implements Initializable
{
    PrincipalController control;
    
    GestorProductos gestor;

    public ListarProductosController(PrincipalController pcontrol,
                                     GestorProductos pgestor)
    {
        control = pcontrol;
        gestor = pgestor;
    }

    @FXML
    private TextField filtrarTabla;

    @FXML
    private JFXListView<String> listaProductos;

    @FXML
    private Button btnRegistrarProducto;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        listaProductos.setItems(gestor.obtenerListaProductos());
        listaProductos.setOnMouseClicked((event)->
        {
            try
            {
                FXMLLoader loaderProducto = new FXMLLoader(getClass().getResource(Cxml.VER_PROD));
                loaderProducto.setController(new ProductoController
                (
                    control, gestor, listaProductos.getSelectionModel().getSelectedItem()
                ));
                control.ponerALaDerecha((Parent)loaderProducto.load());

            } catch (Exception e) {e.printStackTrace();}
        });
    }    
}
