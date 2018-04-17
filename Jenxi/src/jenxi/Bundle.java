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

public class Bundle extends HashMap<Character , Ventana> implements Initializable
{    
    static Gestor gestor;
    static Stage escenario;
    
    //banderas de ventanas activas
    Character activaDER;
    Character activaIZQ;
            
    //mapa de caracteres para disponer de las ventanas
         public final static Character PRODUCTOS = 'p';
      public final static Character PRODUCTO_VER = 'q';  
    public final static Character PRODUCTO_REGIS = 'P';
      public final static Character PRODUCTO_MOD = 'u';
      public final static Character VERSION_REGIS = 'v';
      public final static Character CUALIDAD_REGIS = 'u';
    
          public final static Character CLIENTES = 'c';
       public final static Character CLIENTE_VER = 'l';  
     public final static Character CLIENTE_REGIS = 'C';
       public final static Character CLIENTE_MOD = 'm';
  public final static Character CONTACTO_REGISTI = 'n';
public final static Character CONTACTO_REGISLider = 'j';
     
         public final static Character INSTALACS = 'i';
        public final static Character V_INSTALAC = 'y';
    
         public final static Character EMPLEADOS = 'e';
               public final static Character POP = 'O';
    
    public Bundle(Stage pescenario)
    {
        super();
           gestor = new Gestor();
        escenario = pescenario;
        activaIZQ = PRODUCTOS;
        activaDER = PRODUCTOS;
        
        //carga las ventanas al mapa
        put(           POP, new Ventana(           Xml.POP, new Pop()));
            //productos
        put(     PRODUCTOS, new Ventana(     Xml.PRODUCTOS, new Productos()));
        put(  PRODUCTO_VER, new Ventana(  Xml.PRODUCTO_VER, new ProductoVer()));
        put(PRODUCTO_REGIS, new Ventana(Xml.PRODUCTO_REGIS, new ProductoRegis()));
        put(  PRODUCTO_MOD, new Ventana(Xml.PRODUCTO_REGIS, new ProductoModificar()));
            //clientes
        put(      CLIENTES, new Ventana(      Xml.CLIENTES, new Clientes()));
        put(   CLIENTE_VER, new Ventana(   Xml.CLIENTE_VER, new ClienteVer()));
        put( CLIENTE_REGIS, new Ventana( Xml.CLIENTE_REGIS, new ClienteRegis()));
        put(CONTACTO_REGISTI, new Ventana(Xml.CONTACTO_REGIS, new ContactoRegisTI()));
        put(CONTACTO_REGISLider, new Ventana(Xml.CONTACTO_REGIS, new ContactoRegisLider()));
            //instalaciones
        put(     INSTALACS, new Ventana(     Xml.PRODUCTOS, new Productos()));
            //empleados
        put(     EMPLEADOS, new Ventana(      Xml.CLIENTES, new Clientes()));
        put( VERSION_REGIS, new Ventana( Xml.VERSION_REGIS, new VersionRegis()));
        put(CUALIDAD_REGIS, new Ventana( Xml.CUALIDAD_REGIS, new VCualidadRegis()));
        
    }
    
    @FXML private   JFXDrawer drawer;

    @FXML private   JFXHamburger hamburger;
            
    @FXML private   AnchorPane anchorIZQ;

    @FXML private   AnchorPane anchorDER;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //inicializa menu
        Ventana menu = new Ventana(Xml.MENU, new Menu(drawer, hamburger));
        drawer.setSidePane(menu.cargarNodo());

        //carga primera pantalla
        anchorIZQ.getChildren().add(get(PRODUCTOS).cargarNodo());
        //navegarPopUp(Bundle.POP, new datosPop(Bundle.CLIENTES, null, "hola"));
    }

    public void navegarIzquierda(Character vector, Object contenido)
    {
        //limpia pantallas anteriores
        anchorDER.getChildren().clear();
        get(activaDER).dormir();
        
        anchorIZQ.getChildren().clear();
        get(activaIZQ).dormir();
        
        //prepara pantalla nueva
        Ventana prontoActiva = get(vector);
            prontoActiva.getControlable().actualizar(contenido);
        
        //carga pantalla y actualiza bandera "activa"
        anchorIZQ.getChildren().add(prontoActiva.cargarNodo());
        activaIZQ = vector;
    }
    
    public void navegarDerecha(Character vector, Object contenido)
    {
        //limpia pantalla anterior
        anchorDER.getChildren().clear();
        get(activaDER).dormir();
        
        //prepara pantalla nueva
        Ventana prontoActiva = get(vector);
            prontoActiva.getControlable().actualizar(contenido);
            prontoActiva.setRoot(null);
        
        //carga pantalla y actualiza bandera "activa"
        anchorDER.getChildren().add(prontoActiva.cargarNodo());
        activaDER = vector;
    }
    
    public void navegarPop(Character vector, Object contenido)
    {
        //prepara pantalla
        Ventana nuevoPop = get(vector);
            nuevoPop.getControlable().actualizar(contenido);
            nuevoPop.setRoot(null);
        
        //carga el stage luego inyecta referencia
        nuevoPop.getPopControl().inyectarEscenario(nuevoPop.cargarPop(contenido));
    }
    
    public void terminarPop(Character vector, Stage stage)
    {
        get(vector).getControlable().dormir();
        stage.close();
    }
}
