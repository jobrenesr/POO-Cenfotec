/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenxi.acceso_datos;

import java.io.InputStream;
import java.util.ArrayList;

public class Contacto {
    private String id;
    private String cedulaContacto;
    private String nombreContacto;
    private String telefonoContacto;
    private String correoElectronicoContacto;

    
    
    

    public Contacto(String id,String cedulaEmpleado, String nombreEmpleado, String telefonoEmpleado, String correoElectronico) {
        this.id = id;
        this.cedulaContacto = cedulaEmpleado;
        this.nombreContacto = nombreEmpleado;
        this.telefonoContacto = telefonoEmpleado;
        this.correoElectronicoContacto = correoElectronico;
    }

    public String getCedulaContacto() {
        return cedulaContacto;
    }
    
    public void setCedulaContacto(String cedulaContacto) {
        this.cedulaContacto = cedulaContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getCorreoElectronicoContacto() {
        return correoElectronicoContacto;
    }

    public void setCorreoElectronicoContacto(String correoElectronicoContacto) {
        this.correoElectronicoContacto = correoElectronicoContacto;
    }

    public Contacto() {
    }   
    
      public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
