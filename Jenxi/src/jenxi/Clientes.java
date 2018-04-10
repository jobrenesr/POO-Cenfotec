package jenxi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXListView;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import jenxi.acceso_datos.ClienteListado;
import jenxi.acceso_datos.Producto;
import jenxi.gestores.GestorCliente;

public class Clientes implements Initializable,Controlable
{
    
      static GestorCliente gestor;
    
    static ClienteRegis formularioRegistrar;
    
    private String seleccionado;

    
    public Clientes()
    {
        gestor = new GestorCliente();
        lista = new FilteredList<>(gestor.obtenerListaClientes());
    }
    
      @Override
    public void actualizar(String cliente) {
         seleccionado = cliente;
    }

    @Override
    public void dormir() {
        listaClientes = null;
    }
   
    @FXML
    private TextField filtrarTabla;

    @FXML
    private JFXListView<ClienteListado> listaClientes;

    @FXML
    private Button btnRegistrarCliente;

    private FilteredList<ClienteListado> lista;
    
    public ListCell<ClienteListado> ponerStringAdapter()
    {
        return new ListCell<ClienteListado>()
        {
            @Override
            protected void updateItem(ClienteListado item, boolean empty)
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
                    String filter = filtrarTabla.getText(); 
                    
                    if(filter == null || filter.length() == 0)
                        lista.setPredicate(null); 
                    
                    else lista.setPredicate
                        (cliente -> cliente.getNombre().toLowerCase().contains(filter.toLowerCase()));
                }
            };
        };
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {    
        listaClientes.setCellFactory(param -> ponerStringAdapter());       
         listaClientes.setItems(lista);
        listaClientes.setOnMouseClicked(event ->
        {
            String selecc = listaClientes.getSelectionModel().getSelectedItem().getCedulaJuridica();
            Aplicacion.control.navegarDerecha(Ventana.V_CLIENTE, selecc);
        });
        btnRegistrarCliente.setOnAction(event ->
        {
            formularioRegistrar = new ClienteRegis();
            Fxmleador ClienteRegis = new Fxmleador(Xml.RCLIENT, formularioRegistrar);
            formularioRegistrar.inyectarEscenario(ClienteRegis.cargarPop());
      
        });
        filtrarTabla.setOnKeyPressed(filtrarLista());
    }    

  
}
