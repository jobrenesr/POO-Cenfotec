package jenxi.acceso_datos;

import java.util.ArrayList;

public class VersionProducto
{
    private String nombre;
    private ArrayList<CaracteristicaVersion> caracteriscticas;

    public VersionProducto(String nombre, ArrayList<CaracteristicaVersion> caracteriscticas) {
        this.nombre = nombre;
        this.caracteriscticas = caracteriscticas;
    }

    public VersionProducto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<CaracteristicaVersion> getCaracteriscticas() {
        return caracteriscticas;
    }

    public void setCaracteriscticas(ArrayList<CaracteristicaVersion> caracteriscticas) {
        this.caracteriscticas = caracteriscticas;
    }
}
