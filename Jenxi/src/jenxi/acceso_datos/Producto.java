package jenxi.acceso_datos;


import java.io.InputStream;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class Producto
{
    private String nombre;
    private byte[] imagen;
    private String descripcion ;
    private ArrayList<VersionProducto> versiones;
    
    public Producto() {
    }

    public Producto(String nombre, byte[] imagen, String descripcion, ArrayList<VersionProducto> versiones) {
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] pimagen) {
        imagen = pimagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
