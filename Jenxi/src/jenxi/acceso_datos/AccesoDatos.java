package jenxi.acceso_datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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
    private static final String USERNAME= "root";
    private static final String PASSWORD= "root";
    private static final String CXN_STRING= "jdbc:mysql://localHost:3306/Jenxi";

    public AccesoDatos() {}
    
    private ResultSet ejecutarQuery(String sentenciaSQL)
    {
        ResultSet datos = null;
        try
        {
            Connection conexion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            datos = conexion.createStatement().executeQuery(sentenciaSQL);
            
        } catch (SQLException ex) {System.err.println(ex);}
        
        return datos;
    }
    
    public ObservableList<String> obtenerListadoProductos()
    {
        ResultSet semilla = ejecutarQuery("SELECT nombre FROM tb_productos");
        ArrayList<String> listaClientes = new ArrayList<>();
        try
        {
            while(semilla.next())
            {
                listaClientes.add(semilla.getString("nombre"));
            }

        } catch (SQLException ex) {System.err.println(ex);}
        
        return FXCollections.observableArrayList(listaClientes);
    }
    
    
    
    public Producto obtenerProducto(String nombre)
    {
        Producto producto = new Producto();
        try {
            ResultSet semilla = ejecutarQuery(
                    "SELECT * FROM tb_productos WHERE nombre = '" + nombre +"';");

            while(semilla.next())
            {
                producto.setNombre(semilla.getString("nombre"));
                producto.setDescripcion(semilla.getString("descripcion"));
                hacerImagen(semilla.getBinaryStream("descripcion"),"imagen.jpg");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }
    
    private void hacerImagen(InputStream imgInput, String fileName)
    {
        OutputStream fileImagen = null;
        try {
            fileImagen = new FileOutputStream(new File("file:"+fileName));
            byte[] imagenBytes = new byte[1024];
            int size = 0;
            while((size = imgInput.read(imagenBytes)) != -1)
            {
                fileImagen.write(imagenBytes, 0, size);
            }   Image imagen = new Image("file:"+fileName, 125, 180, true, true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


//public Producto obtenerProducto(String nombre)
//    {
//        Producto producto = new Producto();
//        try {
//            ResultSet semilla = ejecutarQuery(
//                    "SELECT * FROM tb_productos WHERE nombre = '" + nombre +"';");
//
//            while(semilla.next())
//            {
//                producto.setNombre(semilla.getString("nombre"));
//                producto.setDescripcion(semilla.getString("descripcion"));
//                producto.setImagen(semilla.getString("imagen"));
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return producto;
//    }