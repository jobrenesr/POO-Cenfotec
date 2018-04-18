package jenxi.acceso_datos;

public class TareasInstalacion
{
    String idTarea;
    String cedulaEncargado;
    String nombre;
    String estado;

    public TareasInstalacion() {
    }

    public String getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }

    public String getCedulaEncargado() {
        return cedulaEncargado;
    }

    public void setCedulaEncargado(String cedulaEncargado) {
        this.cedulaEncargado = cedulaEncargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
