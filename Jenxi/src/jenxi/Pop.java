package jenxi;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Pop implements Initializable, Controlable, Popable
{
    Stage popUp;
    String stringContenido;
    Character direccionListado;
    String direccionVer;

    public Pop()
    {
        
    }

    @Override
    public void actualizar(Object vector)
    {
        DatosPop vectorLocal = (DatosPop)vector;
        stringContenido = vectorLocal.getContenido();
        direccionListado = vectorLocal.getDireccionListado();
        direccionVer = vectorLocal.getDireccionVer();
    }

    @Override
    public void dormir()
    {
        direccionListado = null;
        direccionVer = null;
        stringContenido = null;
    }
    
    @Override
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
            if(direccionListado.equals(Bundle.CLIENTES))
            {
                Aplicacion.control.navegarIzquierda(Bundle.CLIENTES, direccionVer);
                Aplicacion.control.navegarDerecha(Bundle.CLIENTE_VER, direccionVer);
            }
            if(direccionListado.equals(Bundle.PRODUCTOS))
            {
                Aplicacion.control.navegarIzquierda(Bundle.PRODUCTOS, direccionVer);
                Aplicacion.control.navegarDerecha(Bundle.PRODUCTO_VER, direccionVer);
            }
            if(direccionListado.equals(Bundle.INSTALACS))
            {
                Aplicacion.control.navegarIzquierda(Bundle.INSTALACS, direccionVer);
                Aplicacion.control.navegarDerecha(Bundle.INSTALACS, direccionVer);
            }
            if(direccionListado.equals(Bundle.EMPLEADOS))
            {
                Aplicacion.control.navegarIzquierda(Bundle.EMPLEADOS, direccionVer);
                Aplicacion.control.navegarDerecha(Bundle.EMPLEADOS, direccionVer);
            }
            popUp.close();
        });
    } 
}
