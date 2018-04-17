package jenxi.gestores;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import jenxi.acceso_datos.Producto;

public class GestorProducto extends Gestor
{
    public GestorProducto()
    {
        super();
    }
    
    public ObservableList<String> obtenerListaProductos()
    {
        return getAccesoDatos().obtenerListadoProductos(new ArrayList<String>());
    }
    
    public Producto obtenerProducto(String nombre)
    {
        return getAccesoDatos().obtenerProducto(new Producto(), nombre);
    }

    public boolean validaProductoPrevio(String nombre)
    {
        return getAccesoDatos().validarSiProductoPrevio(nombre);
    }
    
    public void registrarProducto(InputStream imagen, String nombre, String descripcion)
    {
        getAccesoDatos().registrarProducto(imagen, nombre, descripcion);
    }
    
    public void modificarProducto(InputStream imagen, String nombre, String descripcion)
    {
        getAccesoDatos().actualizarProducto(imagen, nombre, descripcion);
    }
    
    public String getNombreUltimaVersion(String idProducto)
    {
        return getAccesoDatos().validarNombreVersion(idProducto);
    }
    
    public void registrarVersion(String idProducto, String nombre, LocalDate fecha)
    {
        getAccesoDatos().registrarVersion(idProducto, nombre, fecha.toString());
    }
}
