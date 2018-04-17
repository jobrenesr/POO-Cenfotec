package jenxi.acceso_datos;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}
        
        USERNAME = "root";
        PASSWORD = "root";
        CXN_STRING = "jdbc:mysql://localHost:3306/db_jenxi?autoReconnect=true&useSSL=false";
    }

//tproductos    
    public ObservableList<String> obtenerListadoProductos(ArrayList<String> productos)
    {
        Connection xion = null;
        ResultSet datos = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            datos = xion.prepareStatement(Sql.PRODUCTOS).executeQuery();
            while(datos.next())
            {
                productos.add(datos.getString("nombre"));
            }
            xion.close();

        } catch (SQLException ex) {
            
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return FXCollections.observableArrayList(productos);
    }
    
    public Producto obtenerProducto(Producto producto, String idProducto)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        ResultSet datos = null;
        ObservableList<Version> versiones = FXCollections.observableArrayList();
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            stmt = xion.prepareStatement(Sql.PRODUCTO_VER); 
            stmt.setString(1, idProducto);
            
            datos = stmt.executeQuery();
            while(datos.next())
            {
                producto.setIdem(datos.getString("id"));
                producto.setNombre(datos.getString("nombre"));
                producto.setDescripcion(datos.getString("descripcion"));
                producto.setImagen(new Image(datos.getBinaryStream("imagen")));
            }
            
            /**/
            stmt = xion.prepareStatement(Sql.VERSIONES); 
            stmt.setString(1, producto.getIdem());
            datos = stmt.executeQuery();
            while(datos.next())
            {
                Version version = new Version();
                version.setIdVersion(datos.getInt("id_version"));
                version.setNombre(datos.getString("nombre"));
                versiones.add(version);
            }
            producto.setVersiones(versiones);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return producto;
    }
    
//versiones    
    public ObservableList<CualidadVersion> ponerCualidadesDeVersion(Connection xion,
                                                                    PreparedStatement stmt,
                                                                    int indice)
    {
        ObservableList<CualidadVersion> cualidades = FXCollections.observableArrayList();
        ResultSet datos = null;
        try
        {
            stmt = xion.prepareStatement(Sql.VERSION_MEJORAS);  
            stmt.setInt(1, indice);
            while(datos.next()) 
            {
                VersionMejora mejora = new VersionMejora();
                mejora.setNombre(datos.getString("nombre"));
                mejora.setDescripcion(datos.getString("descripcion"));
                mejora.setErrorCorrespondiente("id_error");
                cualidades.add(mejora);
            }

            stmt = xion.prepareStatement(Sql.VERSION_ERRORES);  
            stmt.setInt(1, indice);
            while(datos.next()) 
            {
                VersionError error = new VersionError();
                error.setNombre(datos.getString("nombre"));
                error.setDescripcion(datos.getString("descripcion"));
                error.setFechaReporte(datos.getDate("fecha").toLocalDate());
                cualidades.add(error);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}

        return cualidades;
    }
    
    public String validarNombreVersion(String idProducto)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        ResultSet datos = null;
        String retorno = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            stmt = xion.prepareStatement(Sql.VERSION_ULTIMO_NOM);        
            stmt.setString(1, idProducto);
            
            datos = stmt.executeQuery();
            while(datos.next())
            {
                retorno = datos.getString("nombre");
            }
            xion.close();

        } catch (SQLException ex) {
            
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
    
    public void registrarVersion(String idProducto, String nombre, String fechaCreacion)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            stmt = xion.prepareStatement(Sql.VERSION_REGIS);  
            
            stmt.setString(1, idProducto);
            stmt.setString(2, fechaCreacion);
            stmt.setString(3, nombre);

            stmt.executeUpdate();
            xion.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}
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
            
            stmt = xion.prepareStatement(Sql.PRODUCTO_VER);  
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
            
            stmt = xion.prepareStatement(Sql.PRODUCTO_REGIS);  
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
            
            stmt = xion.prepareStatement(Sql.PRODUCTO_MOD);  
            stmt.setString(3, nombre);         
            stmt.setString(1, descripcion);
            stmt.setBinaryStream(2, imagen);

            stmt.executeUpdate();
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}
        
    }        
    
    public String obtenerNombreUltimaVersion(int indiceProducto)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        ResultSet datos = null;
        String nombre = "";
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            
            stmt = xion.prepareStatement(Sql.PRODUCTO_VER);  
            stmt.setInt(1, indiceProducto);         
            datos = stmt.executeQuery();
            
            if(datos.next()) nombre = datos.getString("nombre");
            
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}   
        
        return nombre;        
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
    
    
    public Cliente obtenerCliente(Cliente cliente, String cedulaJuridica)
    {
        ObservableList<Contacto> contactos =  FXCollections.observableArrayList();
        Connection xion = null;
        PreparedStatement stmt = null;
        ResultSet datos = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            stmt = xion.prepareStatement(Sql.CLIENTE); 
            stmt.setString(1, cedulaJuridica);
            
            datos = stmt.executeQuery();
            while(datos.next())
            {   cliente.setCedulaJuridica(datos.getString("cedulaJuridica"));
                cliente.setRazonSocial(datos.getString("razonSocial"));
                cliente.setImagen(new Image(datos.getBinaryStream("imagen")));
                cliente.setTelefono(datos.getString("telefono"));
                cliente.setUbicacion(datos.getString("ubicacion"));
                cliente.setDireccionExacta(datos.getString("direccionExacta"));
                cliente.setIdContactoLider(datos.getString("idContactoLider"));
                cliente.setIdContactoTI(datos.getString("idContactoTI"));
            }
            stmt = xion.prepareStatement(Sql.CONTACTOLIDER_LIST); 
                        
            stmt.setString(1, cedulaJuridica);
            datos = stmt.executeQuery();
            while(datos.next())
            {
                Contacto contactoLider = new Contacto();
                contactoLider.setId(datos.getString("id"));
                contactoLider.setCedulaContacto(datos.getString("cedulaEmpleado"));
                contactoLider.setNombreContacto(datos.getString("nombreEmpleado"));
                contactoLider.setTelefonoContacto(datos.getString("telefonoEmpleado"));
                contactoLider.setCorreoElectronicoContacto(datos.getString("correoEmpleado"));
                contactos.add(contactoLider);
            }
            cliente.setContacto(contactos);
            
            stmt = xion.prepareStatement(Sql.CONTACTOTI_LIST); 
            stmt.setString(1, cedulaJuridica);
            
            datos = stmt.executeQuery();
            while(datos.next())
            {
                Contacto contactoTI = new Contacto();
                contactoTI.setId(datos.getString("id"));
                contactoTI.setCedulaContacto(datos.getString("cedulaEmpleado"));
                contactoTI.setNombreContacto(datos.getString("nombreEmpleado"));
                contactoTI.setTelefonoContacto(datos.getString("telefonoEmpleado"));
                contactoTI.setCorreoElectronicoContacto(datos.getString("correoEmpleado"));
                contactos.add(contactoTI);
            }
            cliente.setContacto(contactos);
             
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
    
     public void actualizarCliente(InputStream imagen, String cedulaJuridica, String razonSocial ,
             String telefono, String ubicacion, String direccionExacta)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            
            stmt = xion.prepareStatement(Sql.CLIENTE_UPDATE);  
            stmt.setString(5, razonSocial);         
            stmt.setString(6, cedulaJuridica);
            stmt.setBinaryStream(4, imagen);
            stmt.setString(1, telefono);
            stmt.setString(2, ubicacion);
            stmt.setString(3, direccionExacta);

            stmt.executeUpdate();
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}
        
    }     
     
     public boolean validarClienteCedPrevio(String cedulaJuridica)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        ResultSet datos = null;
        boolean validacion = false;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            
            stmt = xion.prepareStatement(Sql.CLIENTE);  
            stmt.setString(1, cedulaJuridica);  
            datos = stmt.executeQuery();
            
            if(datos.next()) validacion = true;    
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}   
        
        return validacion;
    }      
     
     
    //finaliza clientes
    
    //Contactos 
     
     //Lider
    public void registrarContactoLider(String cedulaEmpleado, String nombreEmpleado, String telefonoEmpleado, String correoEmpleado, String cedulaJuridica){
        Connection xion = null;
        PreparedStatement stmt = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            
            stmt = xion.prepareStatement(Sql.REGIS_CONTACTO);  
            stmt.setString(1, cedulaEmpleado);         
            stmt.setString(2, nombreEmpleado);
            stmt.setString(3, telefonoEmpleado);
            stmt.setString(4, correoEmpleado);   
            stmt.executeUpdate();
            
            stmt = xion.prepareStatement(Sql.REGIS_CONTACTOLIDER); 
            stmt.setString(1, cedulaJuridica);
            
            
            stmt.executeUpdate();
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}
    }
    //Contacto TI
    
     public void registrarContactoTI(String cedulaEmpleado, String nombreEmpleado, String telefonoEmpleado,  String correoEmpleado, String cedulaJuridica){
        Connection xion = null;
        PreparedStatement stmt = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            
            stmt = xion.prepareStatement(Sql.REGIS_CONTACTO);  
            stmt.setString(1, cedulaEmpleado);         
            stmt.setString(2, nombreEmpleado);
            stmt.setString(3, telefonoEmpleado);
            stmt.setString(4, correoEmpleado);   
            stmt.executeUpdate();
            
            stmt = xion.prepareStatement(Sql.REGIS_CONTACTOTI); 
            stmt.setString(1, cedulaJuridica);
            
            
            stmt.executeUpdate();
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}
    }
     
     public void actualizarContacto(String id, String cedulaEmpleado, String nombreEmpleado, String telefonoEmpleado, String correoEmpleado)
    {
        Connection xion = null;
        PreparedStatement stmt = null;
        try
        {
            xion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            
            stmt = xion.prepareStatement(Sql.CONTACTO_UPDATE);  
            stmt.setString(1, cedulaEmpleado);         
            stmt.setString(2, nombreEmpleado);
            stmt.setString(3, telefonoEmpleado);
            stmt.setString(4, correoEmpleado);
            stmt.setString(5, id);

            stmt.executeUpdate();
            xion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);}
        
    }     
}