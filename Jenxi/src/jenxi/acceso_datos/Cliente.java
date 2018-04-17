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
    
    private ObservableList<Contacto> contacto;

    public Cliente() {
    }

    public Cliente(String cedulaJuridica, String razonSocial, String ubicacion, String telefono, String direccionExacta, Image imagen, String ContactoTI, String ContactoLider, ObservableList<Contacto> contacto) {
        this.cedulaJuridica = cedulaJuridica;
        this.razonSocial = razonSocial;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.direccionExacta = direccionExacta;
        this.imagen = imagen;
        this.idContactoTI = ContactoTI;
        this.idContactoLider = ContactoLider;
        this.contacto = contacto;
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

    public ObservableList<Contacto> getContacto() {
        return contacto;
    }

    public void setContacto(ObservableList<Contacto> contacto) {
        this.contacto = contacto;
    }

   

   

    
    
}
