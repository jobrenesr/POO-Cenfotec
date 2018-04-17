package jenxi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXListView;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import jenxi.acceso_datos.ClienteListado;
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
    public void actualizar(Object cliente) {
         seleccionado = (String)cliente;
    }

    @Override
    public void dormir() {
        lista = null;
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
        ObservableList<ClienteListado> listaObservable = gestor.obtenerListaClientes();
        lista = new FilteredList<>(gestor.obtenerListaClientes());
        listaClientes.setCellFactory(param -> ponerStringAdapter());       
        listaClientes.setItems(lista);
        listaClientes.setOnMouseClicked(event ->
        {
            ClienteListado selecc = listaClientes.getSelectionModel().getSelectedItem();
            if(selecc == null){
                
            }else{
            Aplicacion.control.navegarDerecha(Bundle.CLIENTE_VER, selecc.getCedulaJuridica());
            }
            });
        
        btnRegistrarCliente.setOnAction(event ->
        {
            formularioRegistrar = Aplicacion.control.get(Bundle.CLIENTE_REGIS).getController();
            Aplicacion.control.navegarPop(Bundle.CLIENTE_REGIS, null);
      
        });
        filtrarTabla.setOnKeyPressed(filtrarLista());
        
        seleccionarCliente(listaObservable);
    }    

  public void seleccionarCliente(ObservableList<ClienteListado> lista)
    {
        for(ClienteListado cliente : lista)
            
            if(cliente.getCedulaJuridica().equals(seleccionado))
            {
                listaClientes.getSelectionModel().select(cliente);
                break;
            }
    }
}
