package jenxi;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jenxi.gestores.Gestor;

public class Ventana extends HashMap<Character , Fxmleador> implements Initializable
{    
    static Gestor gestor;
    static Stage escenario;
    
    Character activaDER;
    Character activaIZQ;
            
    public final static Character PRODUCTOS = 'p';
    public final static Character V_PRODUCTO = 'q';
    
    public final static Character CLIENTES = 'c';
    public final static Character V_CLIENTE = 'l';
    
    public final static Character INSTALACS = 'i';
    public final static Character V_INSTALAC = 'y';
    
    public final static Character EMPLEADOS = 'e';
    public final static Character BACK = 'b';
    
    public Ventana(Stage pescenario)
    {
        super();
        gestor = new Gestor();
        escenario = pescenario;
        
        put(BACK     ,  new Fxmleador(Xml.BACK     , new Back()));
        put(PRODUCTOS,  new Fxmleador(Xml.PRODUCTOS, new Productos()));
        put(CLIENTES ,  new Fxmleador(Xml.CLIENTES , new Clientes()));
        put(INSTALACS,  new Fxmleador(Xml.PRODUCTOS, new Productos()));
        put(EMPLEADOS,  new Fxmleador(Xml.CLIENTES , new Clientes()));
        
        put(V_PRODUCTO, new Fxmleador(Xml.VER_PRODUCTO, new ProductoVer()));
        put(V_CLIENTE , new Fxmleador(Xml.VCLIENTE    , new ClienteVer()));

        activaIZQ = PRODUCTOS;
        activaDER = BACK;
    }

    @FXML private   JFXDrawer drawer;

    @FXML private   JFXHamburger hamburger;
            
    @FXML private   AnchorPane anchorIZQ;

    @FXML private   AnchorPane anchorDER;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Fxmleador menu = new Fxmleador(Xml.MENU, new Menu(drawer, hamburger));
        drawer.setSidePane(menu.cargarNodo());

        get(PRODUCTOS).actualizarse(null);
        anchorIZQ.getChildren().add(get(PRODUCTOS).cargarNodo());
    }

    public void navegarIzquierda(Character vector, String contenido)
    {
        anchorDER.getChildren().clear();
        get(activaDER).dormir();

        anchorIZQ.getChildren().clear();
        get(activaIZQ).dormir();
        
        activaIZQ = vector;
        Fxmleador prontoActiva = get(activaIZQ);
        prontoActiva.setRoot(null);
        prontoActiva.actualizarse(contenido);
        
        anchorIZQ.getChildren().add(prontoActiva.cargarNodo());
    }
    
    public void navegarDerecha(Character vector, String contenido)
    {
        anchorDER.getChildren().clear();
        get(activaDER).dormir();


        activaDER = vector;
        Fxmleador prontoActiva = get(activaDER);
        prontoActiva.setRoot(null);
        prontoActiva.actualizarse(contenido);
        
        anchorDER.getChildren().add(prontoActiva.cargarNodo());
    }
}
