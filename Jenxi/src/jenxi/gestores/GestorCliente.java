/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenxi.gestores;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import jenxi.acceso_datos.Cliente;
import jenxi.acceso_datos.ClienteListado;
import jenxi.acceso_datos.Contacto;
import jenxi.acceso_datos.InstalacListable;

/**
 *
 * @author jobre
 */
public class GestorCliente extends Gestor{
    
        public GestorCliente()
    {
        super();
    }
     public ObservableList<ClienteListado> obtenerListaClientes()
    {
        return getAccesoDatos().obtenerListadoClientes(new ArrayList<ClienteListado>());
    }
    
    public Cliente obtenerCliente(String cedulaJuridica)
    {
        return getAccesoDatos().obtenerCliente(new Cliente(), cedulaJuridica);
    }
    
    public void registrarCliente(InputStream imagen, String cedulaJuridica, String razonSocial , String telefono, String ubicacion, String direccionExacta){
        getAccesoDatos().registrarCliente(imagen, cedulaJuridica, razonSocial, telefono, ubicacion, direccionExacta);
    }
    
    public void registrarContactoLider(String cedulaEmpleado, String nombreEmpleado, String telefonoEmpleado, String correoEmpleado, String cedulaJuridica){
        getAccesoDatos().registrarContactoLider(cedulaEmpleado, nombreEmpleado, telefonoEmpleado, correoEmpleado, cedulaJuridica);
    }
    public void registrarContactoTI(String cedulaEmpleado, String nombreEmpleado, String telefonoEmpleado, String correoEmpleado, String cedulaJuridica){
        getAccesoDatos().registrarContactoTI(cedulaEmpleado, nombreEmpleado, telefonoEmpleado, correoEmpleado, cedulaJuridica);
    }
    
    public void modificarCliente(InputStream imagen, String cedulaJuridica, String razonSocial , String telefono, String ubicacion, String direccionExacta){
        getAccesoDatos().actualizarCliente(imagen, cedulaJuridica, razonSocial, telefono, ubicacion, direccionExacta);
    }
    
    public boolean validarClienteCedPrevio(String cedulaJuridica)
    {
        return getAccesoDatos().validarClienteCedPrevio(cedulaJuridica);
    }

    public void modificarContacto(int id, String cedulaEmpleado, String nombreEmpleado, String telefonoEmpleado, String puestoEmpleado, String correoEmpleado){
    //getAccesoDatos.actualizarContacto(id, cedulaEmpleado, telefonoEmpleado, puestoEmpleado, correoEmpleado)   
    }
    
    public ObservableList<InstalacListable> instalacionesCliente(String idCliente)
    {
        return getAccesoDatos().obtenerInstalacsPorCliente(idCliente);
    }
    
    public void registrarInstalacion(String idVersion, LocalDateTime tiempo, String idCliente)
    {
        getAccesoDatos().registrarInstalacion(idVersion, tiempo, idCliente);
    }
}