package jenxi.acceso_datos;

import jenxi.FazVersion;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class Producto
{
    private String idem;
    private String nombre;
    private Image imagen;
    private String descripcion ;
    private ObservableList<Version> versiones;
    
    public Producto() {
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public ObservableList<Version> getVersiones() {
        return versiones;
    }

    public void setVersiones(ObservableList<Version> versiones) {
        this.versiones = versiones;
    }

    public String getNombre() {
        return nombre;
    }

    public Image getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getIdem() {
        return idem;
    }

    public void setIdem(String idem) {
        this.idem = idem;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
