package jenxi.acceso_datos;

import java.awt.Image;
import java.io.InputStream;
import java.util.ArrayList;

public class Producto
{
    private String nombre;
    private InputStream imagen;
    private String descripcion ;
    private ArrayList<VersionProducto> versiones;
    
    public Producto() {
    }

    public Producto(String nombre, InputStream imagen, String descripcion, ArrayList<VersionProducto> versiones) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.versiones = versiones;
    }

    public ArrayList<VersionProducto> getVersiones() {
        return versiones;
    }

    public void setVersiones(ArrayList<VersionProducto> versiones) {
        this.versiones = versiones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream pimagen) {
        imagen = pimagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
