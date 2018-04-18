/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenxi.gestores;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import jenxi.acceso_datos.Cliente;
import jenxi.acceso_datos.ClienteListado;
import jenxi.acceso_datos.Contacto;

/**
 *
 * @author jobre
 */
public class GestorCliente extends Gestor{
    
        public GestorCliente()
    {
        super();
    }
     //Listar 
        //Cliente
     public ObservableList<ClienteListado> obtenerListaClientes()
    {
        return getAccesoDatos().obtenerListadoClientes(new ArrayList<ClienteListado>());
    }
    
    public Cliente obtenerCliente(String cedulaJuridica)
    {
        return getAccesoDatos().obtenerCliente(new Cliente(), cedulaJuridica);
    }
    
    //Registrar 
        //Cliente
    public void registrarCliente(InputStream imagen, String cedulaJuridica, String razonSocial , String telefono, String ubicacion, String direccionExacta){
        getAccesoDatos().registrarCliente(imagen, cedulaJuridica, razonSocial, telefono, ubicacion, direccionExacta);
    }
        //Contacto
            //Lider
    public void registrarContactoLider(String cedulaEmpleado, String nombreEmpleado, String telefonoEmpleado, String correoEmpleado, String cedulaJuridica){
        getAccesoDatos().registrarContactoLider(cedulaEmpleado, nombreEmpleado, telefonoEmpleado, correoEmpleado, cedulaJuridica);
    }       //TI
    public void registrarContactoTI(String cedulaEmpleado, String nombreEmpleado, String telefonoEmpleado, String correoEmpleado, String cedulaJuridica){
        getAccesoDatos().registrarContactoTI(cedulaEmpleado, nombreEmpleado, telefonoEmpleado, correoEmpleado, cedulaJuridica);
    }
    
    //Validación
    public boolean validarClienteCedPrevio(String cedulaJuridica)
    {
        return getAccesoDatos().validarClienteCedPrevio(cedulaJuridica);
    }
    //Modificar
        //Cliente
    public void modificarCliente(InputStream imagen, String cedulaJuridica, String razonSocial , String telefono, String ubicacion, String direccionExacta){
        getAccesoDatos().actualizarCliente(imagen, cedulaJuridica, razonSocial, telefono, ubicacion, direccionExacta);
    }
        //Contacto
    public void modificarContacto(String id, String cedulaEmpleado, String nombreEmpleado, String telefonoEmpleado, String correoEmpleado){
        getAccesoDatos().actualizarContacto(id, cedulaEmpleado, nombreEmpleado, telefonoEmpleado, correoEmpleado);   
    }
    
}