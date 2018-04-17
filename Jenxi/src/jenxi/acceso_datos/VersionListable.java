package jenxi.acceso_datos;

import java.time.LocalDate;
import javafx.collections.ObservableList;

public class VersionListable
{
    private int idVersion;
    private String nombre;

    public VersionListable() {
    }

    public VersionListable(String pnombre)
    {
        nombre = pnombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }
}
