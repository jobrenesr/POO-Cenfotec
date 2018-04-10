package jenxi;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PopRegistro implements Initializable
{
    Stage popUp;
    String stringContenido;
    
    Character direccionListado;
    String direccionVer;

    public PopRegistro(String pcontenido, Character pdireccionA, String pdireccionB)
    {
        stringContenido = pcontenido;
        direccionListado = pdireccionA;
        direccionVer = pdireccionB;
    }
    
    public void inyectarEscenario(Stage ppopUp)
    {
        popUp = ppopUp;
    }

    @FXML
    private JFXButton btnConfirma;
    
    @FXML
    private Label contenido;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        contenido.setText(stringContenido);
        btnConfirma.setOnAction(event ->
        {
            if(direccionListado.equals(Ventana.CLIENTES))
            {
                Aplicacion.control.navegarIzquierda(Ventana.CLIENTES, direccionVer);
                Aplicacion.control.navegarDerecha(Ventana.V_CLIENTE, direccionVer);
            }
            if(direccionListado.equals(Ventana.PRODUCTOS))
            {
                Aplicacion.control.navegarIzquierda(Ventana.PRODUCTOS, direccionVer);
                Aplicacion.control.navegarDerecha(Ventana.PRODUCTOS, direccionVer);
            }
            if(direccionListado.equals(Ventana.INSTALACS))
            {
                Aplicacion.control.navegarIzquierda(Ventana.INSTALACS, direccionVer);
                Aplicacion.control.navegarDerecha(Ventana.INSTALACS, direccionVer);
            }
            if(direccionListado.equals(Ventana.EMPLEADOS))
            {
                Aplicacion.control.navegarIzquierda(Ventana.EMPLEADOS, direccionVer);
                Aplicacion.control.navegarDerecha(Ventana.EMPLEADOS, direccionVer);
            }
            popUp.close();
        });
    } 
}
