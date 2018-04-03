package jenxi.acceso_datos;

import java.awt.Image;
import java.io.InputStream;
import java.util.ArrayList;

public class Cliente {

    private String cedulaJuridica;
    private String razonSocial;
    private String ubicacion;
    private String telefono;
    private String direccionExacta;

    public Cliente(String cedulaJuridica, String razonSocial, String ubicacion, String telefono, String direccionExacta) {
        this.cedulaJuridica = cedulaJuridica;
        this.razonSocial = razonSocial;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.direccionExacta = direccionExacta;
    }

    public Cliente() {
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

}
