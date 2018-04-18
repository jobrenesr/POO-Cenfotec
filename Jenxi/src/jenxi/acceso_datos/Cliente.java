package jenxi.acceso_datos;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class Cliente {

    private String cedulaJuridica;
    private String razonSocial;
    private String ubicacion;
    private String telefono;
    private String direccionExacta;
    private Image imagen;
    private String idContactoTI;
    private String idContactoLider;

    private Contacto contactoLider;
    private Contacto contactoTI;
    

    public Cliente() {
    }


    public Cliente(String cedulaJuridica, String razonSocial, String ubicacion, String telefono, String direccionExacta, Image imagen, String idContactoTI, String idContactoLider, Contacto contactoLider, Contacto contactoTI) {

        this.cedulaJuridica = cedulaJuridica;
        this.razonSocial = razonSocial;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.direccionExacta = direccionExacta;
        this.imagen = imagen;
        this.idContactoTI = idContactoTI;
        this.idContactoLider = idContactoLider;
        this.contactoLider = contactoLider;
        this.contactoTI = contactoTI;
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

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getIdContactoTI() {
        return idContactoTI;
    }

    public void setIdContactoTI(String idContactoTI) {
        this.idContactoTI = idContactoTI;
    }

    public String getIdContactoLider() {
        return idContactoLider;
    }

    public void setIdContactoLider(String idContactoLider) {
        this.idContactoLider = idContactoLider;
    }

    public Contacto getContactoLider() {
        return contactoLider;
    }

    public void setContactoLider(Contacto contactoLider) {
        this.contactoLider = contactoLider;
    }

    public Contacto getContactoTI() {
        return contactoTI;
    }

    public void setContactoTI(Contacto contactoTI) {
        this.contactoTI = contactoTI;
    }   
}
