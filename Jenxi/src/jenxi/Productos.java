package jenxi;

import javafx.collections.transformation.FilteredList;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXButton;
import javafx.scene.control.ListCell;
import jenxi.gestores.GestorProducto;
import javafx.scene.input.KeyEvent;
import jenxi.acceso_datos.Producto;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.net.URL;
import javafx.collections.ObservableList;

public class Productos implements Initializable, Controlable
{    
    static GestorProducto gestor;
        
    private FilteredList<String> listaProductos;
    
    private String seleccionado;

    public Productos()
    {
        gestor = new GestorProducto();
        listaProductos = new FilteredList<>(gestor.obtenerListaProductos());
    }

    @Override
    public void actualizar(Object producto)
    {
        seleccionado = (String)producto;
    }

    @Override
    public void dormir()
    {
        listaProductos = null;
    }

    @FXML
    private JFXTextField  txtFiltrar;

    @FXML
    private JFXListView<String> viewProductos;

    @FXML
    private JFXButton btnRegistrar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ObservableList<String> lista = gestor.obtenerListaProductos();
                        
        if(!lista.isEmpty())
        {
            viewProductos.setOnMouseClicked(event -> navegarVerProducto());
        }
        else lista.add("No hay productos");

        listaProductos = new FilteredList<>(lista);
        viewProductos.setItems(listaProductos);

        if(seleccionado != null)
            viewProductos.getSelectionModel().select(seleccionado);
        
        btnRegistrar.setOnAction(event -> navegarRegisProducto());
        txtFiltrar.setOnKeyPressed(filtrarLista());
    }
    
    public void navegarVerProducto()
    {
        Aplicacion.control.navegarDerecha
        (
            Bundle.PRODUCTO_VER, viewProductos.getSelectionModel().getSelectedItem()
        );
    }
    
    public void navegarRegisProducto()
    {
        Aplicacion.control.navegarPop(Bundle.PRODUCTO_REGIS, null);
    }
    
    public ListCell<Producto> ponerStringAdapter()
    {
        return new ListCell<Producto>()
        {
            @Override
            protected void updateItem(Producto item, boolean empty)
            {
                super.updateItem(item, empty);
                if (empty || item == null || item.getNombre()== null)
                     setText("");
                
                else setText(item.getNombre());
            }
        };
    }
    
    public EventHandler<KeyEvent> filtrarLista()
    {
        return new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent key)
            {
                if (key.getCode().equals(KeyCode.ENTER))
                {
                    String filter = txtFiltrar.getText(); 
                    
                    if(filter == null || filter.length() == 0)
                        listaProductos.setPredicate(null); 
                    
                    else listaProductos.setPredicate
                        (producto -> producto.toLowerCase().contains(filter.toLowerCase()));
                }
            };
        };
    }
}
