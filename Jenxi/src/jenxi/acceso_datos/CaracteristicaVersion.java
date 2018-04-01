package jenxi.acceso_datos;

public abstract class CaracteristicaVersion
{
    private String descripcion;

    public CaracteristicaVersion() {
    }

    public CaracteristicaVersion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
