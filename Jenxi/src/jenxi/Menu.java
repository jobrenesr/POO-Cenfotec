package jenxi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Menu extends BurgerControl implements Initializable
{            
    public Menu(JFXDrawer pdrawer, JFXHamburger pburger)
    {
        super(pdrawer, pburger);
    }
    
    @FXML private   JFXButton btnProductos;
 
    @FXML private   JFXButton btnClientes;
    
    @FXML private   JFXButton btnInstalaciones;
    
    @FXML private   JFXButton btnEmpleados;
    
    @FXML private   JFXButton btnSalir;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
            btnProductos . setOnAction(e->  navegarProductos());
             btnClientes . setOnAction(e->  navegarClientes());
        btnInstalaciones . setOnAction(e->  navegarClientes());
            btnEmpleados . setOnAction(e->  navegarEmpleados());
                btnSalir . setOnAction(e->  salirDeAplicacion());
    }
    public void navegarProductos() {    navegar(Ventana.PRODUCTOS); }
    
    public void navegarClientes()  {    navegar(Ventana.CLIENTES);  }
    
    public void navegarInstalaciones(){ navegar(Ventana.INSTALACS); }
    
    public void navegarEmpleados() {    navegar(Ventana.EMPLEADOS); }
    
    public void salirDeAplicacion(){    Ventana.escenario.close();  }
}
