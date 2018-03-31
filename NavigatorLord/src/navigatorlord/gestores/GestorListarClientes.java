package navigatorlord.gestores;

import javafx.collections.ObservableList;
import navigatorlord.acceso_datos.ClienteListado;

public class GestorListarClientes extends GestorPrincipal
{
    public GestorListarClientes()
    {
        super();
    }
    
    public ObservableList<String> obtenerListaProductos()
    {
        return getAccesoDatos().obtenerListadoProductos();
    }
}
