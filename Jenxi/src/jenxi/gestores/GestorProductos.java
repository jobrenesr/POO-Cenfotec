package jenxi.gestores;

import javafx.collections.ObservableList;
import jenxi.acceso_datos.Producto;

public class GestorProductos extends GestorPrincipal
{
    public GestorProductos()
    {
        super();
    }
    
    public ObservableList<String> obtenerListaProductos()
    {
        return getAccesoDatos().obtenerListadoProductos();
    }
    
    public Producto obtenerProducto(String nombre)
    {
        return getAccesoDatos().obtenerProducto(nombre);
    }
}
