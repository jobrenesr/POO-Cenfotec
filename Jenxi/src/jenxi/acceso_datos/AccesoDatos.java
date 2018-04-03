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

public class AccesoDatos {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CXN_STRING = "jdbc:mysql://localHost:3306/Jenxi";

    public AccesoDatos() {
    }

    private ResultSet ejecutarQuery(String sentenciaSQL) {
        ResultSet datos = null;
        try {
            Connection conexion = DriverManager.getConnection(CXN_STRING, USERNAME, PASSWORD);
            datos = conexion.createStatement().executeQuery(sentenciaSQL);

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return datos;
    }

    public ObservableList<String> obtenerListadoProductos() {
        ResultSet semilla = ejecutarQuery("SELECT nombre FROM tb_productos");
        ArrayList<String> listaClientes = new ArrayList<>();
<<<<<<< HEAD
        try
        {
            while(semilla.next())
            {
                listaClientes.add(semilla.getString("nombre"));
=======
        String nombre = null;
        try {
            while (semilla.next()) {
                nombre = semilla.getString("nombre");
                listaClientes.add(nombre);
>>>>>>> POO-Josue
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return FXCollections.observableArrayList(listaClientes);
    }
<<<<<<< HEAD
    
    
    
    public Producto obtenerProducto(String nombre)
    {
        Producto producto = new Producto();
        try {
            ResultSet semilla = ejecutarQuery(
                    "SELECT * FROM tb_productos WHERE nombre = '" + nombre +"';");

            while(semilla.next())
            {
=======

    public Producto obtenerProducto(String nombre) {
        ResultSet semilla = ejecutarQuery(
                "SELECT * FROM tb_productos WHERE nombre = '" + nombre + "';");
        Producto producto = new Producto();
        try {
            while (semilla.next()) {
>>>>>>> POO-Josue
                producto.setNombre(semilla.getString("nombre"));
                producto.setDescripcion(semilla.getString("descripcion"));
                hacerImagen(semilla.getBinaryStream("descripcion"),"imagen.jpg");
            }
<<<<<<< HEAD
            
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
=======

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return producto;
    }

    public ObservableList<String> obtenerListadoClientes() {
        ResultSet semilla = ejecutarQuery("SELECT razonSocial FROM tb_clientes");
        ArrayList<String> listaClientes = new ArrayList<>();
        String razonSocial = null;
        try {
            while (semilla.next()) {
                razonSocial = semilla.getString("razonSocial");
                listaClientes.add(razonSocial);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return FXCollections.observableArrayList(listaClientes);
    }

    public Cliente obtenerCliente(String razonSocial) {
        ResultSet semilla = ejecutarQuery(
                "SELECT * FROM tb_clientes WHERE razonSocial = '" + razonSocial + "';");
        Cliente cliente = new Cliente();
        try {
            while (semilla.next()) {
                cliente.setRazonSocial(semilla.getString("razonSocial"));
                cliente.setCedulaJuridica(semilla.getString("cedulaJuridica"));
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return cliente;
>>>>>>> POO-Josue
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