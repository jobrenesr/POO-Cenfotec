/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenxi.gestores;

import javafx.collections.ObservableList;
import jenxi.acceso_datos.Cliente;

/**
 *
 * @author jobre
 */
public class GestorClientes extends GestorPrincipal{
    
     public GestorClientes()
    {
        super();
    }
     public ObservableList<String> obtenerListaClientes()
    {
        return getAccesoDatos().obtenerListadoClientes();
    }
    
    public Cliente obtenerCliente(String razonSocial)
    {
        return getAccesoDatos().obtenerCliente(razonSocial);
    }
}
