package jenxi;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FazInstalacion
{
    String idVersion;
    String idCliente;
    LocalDateTime tiempoInstalacion;
    ArrayList<FazTareaInstalacion> tareasInstalacion;

    public FazInstalacion() {
    }

    public String getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(String idVersion) {
        this.idVersion = idVersion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getTiempoInstalacion() {
        return tiempoInstalacion;
    }

    public void setTiempoInstalacion(LocalDateTime tiempoInstalacion) {
        this.tiempoInstalacion = tiempoInstalacion;
    }

    public ArrayList<FazTareaInstalacion> getTareasInstalacion() {
        return tareasInstalacion;
    }

    public void setTareasInstalacion(ArrayList<FazTareaInstalacion> tareasInstalacion) {
        this.tareasInstalacion = tareasInstalacion;
    }
}
