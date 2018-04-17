package jenxi.acceso_datos;

import java.time.LocalDate;
import javafx.collections.ObservableList;

public class Version
{
    private int idVersion;
    private String nombre;
    private LocalDate fecha;
    private ObservableList<CualidadVersion> cualidades;

    public Version() {
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Version(String pnombre)
    {
        nombre = pnombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObservableList<CualidadVersion> getCaracteristicas() {
        return cualidades;
    }

    public void setCaracteristicas(ObservableList<CualidadVersion> pcaracteristicas) {
        this.cualidades = pcaracteristicas;
    }

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }
}
