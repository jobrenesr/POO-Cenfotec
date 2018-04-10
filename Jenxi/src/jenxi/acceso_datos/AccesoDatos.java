package jenxi.acceso_datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class AccesoDatos
{
    private String USERNAME;
    private String PASSWORD;
    private String CXN_STRING;

    public AccesoDatos()
    {
        USERNAME = "root";
        PASSWORD = "root";
        CXN_STRING = "jdbc:mysql://localHost:3306/db_jenxi";
    }

    public ObservableList<String> obtenerListadoProductos(ArrayList<String> productos)
    {
        Connection xion = null;
        ResultSet datos = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            datos = xion.prepareStatement(Sql.LPRODUCTOS).executeQuery();
            while(datos.next())
            {
                productos.add(datos.getString("nombre"));
            }
            xion.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}

        return FXCollections.observableArrayList(productos);
    }

    public Producto obtenerProducto(Producto producto, String nombre)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        ResultSet datos = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            stmt = xion.prepareStatement(Sql.PRODUCTO); 
            stmt.setString(1, nombre);
            
            datos = stmt.executeQuery();
            while(datos.next())
            {
                producto.setNombre(datos.getString("nombre"));
                producto.setDescripcion(datos.getString("descripcion"));
                producto.setImagen(new Image(datos.getBinaryStream("imagen")));
            }
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}

        return producto;
    }

    public boolean validarSiProductoPrevio(String nombre)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        ResultSet datos = null;
        boolean validacion = false;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            
            stmt = xion.prepareStatement(Sql.PRODUCTO);  
            stmt.setString(1, nombre);         
            datos = stmt.executeQuery();
            
            if(datos.next()) validacion = true;    
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}   
        
        return validacion;
    }        
    
        
    public void registrarProducto(InputStream imagen, String nombre, String descripcion)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            
            stmt = xion.prepareStatement(Sql.REGIS_PRODUCTO);  
            stmt.setString(1, nombre);         
            stmt.setString(2, descripcion);
            stmt.setBinaryStream(3, imagen);

            stmt.executeUpdate();
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}
        
    }
    
    public void actualizarProducto(InputStream imagen, String nombre, String descripcion)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            
            stmt = xion.prepareStatement(Sql.UPDATE_PRODUCTO);  
            stmt.setString(3, nombre);         
            stmt.setString(1, descripcion);
            stmt.setBinaryStream(2, imagen);

            stmt.executeUpdate();
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}
        
    }        

       //Clientes 
    
    public ObservableList<ClienteListado> obtenerListadoClientes(ArrayList<ClienteListado> clientes)
    {
        Connection conexion = null;
        ResultSet datos = null;
        try
        {
            conexion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            datos = conexion.prepareStatement(Sql.LCLIENTES).executeQuery();
            while(datos.next())
            {
                String cedulaJuridica = datos.getString("cedulaJuridica");
                String razonSocial = datos.getString("razonSocial");
                               
                clientes.add(new ClienteListado(cedulaJuridica,razonSocial));
            }
            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}

        return FXCollections.observableArrayList(clientes);
    }
    
    
    public Cliente obtenerCliente(Cliente cliente, String razonSocial)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        ResultSet datos = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            stmt = xion.prepareStatement(Sql.CLIENTE); 
            stmt.setString(1, razonSocial);
            
            datos = stmt.executeQuery();
            while(datos.next())
            {
                cliente.setRazonSocial(datos.getString("razonSocial"));
                cliente.setCedulaJuridica(datos.getString("cedulaJuridica"));
                cliente.setImagen(datos.getBinaryStream("imagen"));
                cliente.setTelefono(datos.getString("telefono"));
            }
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}

        return cliente;
    }
    
    public void registrarCliente(InputStream imagen, String cedulaJuridica, String razonSocial , String telefono, String ubicacion, String direccionExacta)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            
            stmt = xion.prepareStatement(Sql.REGIS_CLIENTE);  
            stmt.setString(1, cedulaJuridica);         
            stmt.setString(2, razonSocial);
            stmt.setString(3, telefono);
            stmt.setString(4, ubicacion);
            stmt.setString(5, direccionExacta);                
            stmt.setBinaryStream(6, imagen);

            stmt.executeUpdate();
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    //finaliza clientes
    
    //Contactos 
    public void registrarContacto(String CedulaEmpleado, String nombreEmpleado, String telefonoEmpleado, String puestoEmpleado, String correoElectronico){
        
    }
}