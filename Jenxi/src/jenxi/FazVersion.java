package jenxi;

import java.time.LocalDate;
import javafx.collections.ObservableList;

public class FazVersion
{
    private String idVersion;
    private String nombre;
    private LocalDate fecha;
    private ObservableList<?> cualidades;

    public FazVersion() {
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public FazVersion(String pnombre)
    {
        nombre = pnombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObservableList<?> getCaracteristicas() {
        return cualidades;
    }

    public void setCaracteristicas(ObservableList<?> pcaracteristicas) {
        this.cualidades = pcaracteristicas;
    }

    public String getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(String idVersion) {
        this.idVersion = idVersion;
    }
}
