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
import jenxi.acceso_datos.Cliente;
import jenxi.acceso_datos.ClienteListado;

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
    
    public Cliente obtenerCliente(String razonSocial)
    {
        return getAccesoDatos().obtenerCliente(new Cliente(),razonSocial);
    }
    
    public void registrarCliente(InputStream imagen, String cedulaJuridica, String razonSocial , String telefono, String ubicacion, String direccionExacta){
        getAccesoDatos().registrarCliente(imagen, cedulaJuridica, razonSocial, telefono, ubicacion, direccionExacta);
    }
    
    public void registrarContacto(String CedulaEmpleado, String nombreEmpleado, String telefonoEmpleado, String puestoEmpleado, String correoElectronico){
        getAccesoDatos().registrarContacto(CedulaEmpleado, nombreEmpleado, telefonoEmpleado, puestoEmpleado, correoElectronico);
    }
}