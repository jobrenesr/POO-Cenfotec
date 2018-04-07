package jenxi.acceso_datos;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

public class AccesoDatos {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
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
        String nombre = null;
        try {
            while (semilla.next()) {
                nombre = semilla.getString("nombre");
                listaClientes.add(nombre);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return FXCollections.observableArrayList(listaClientes);
    }

    public Producto obtenerProducto(String nombre) {
        ResultSet semilla = ejecutarQuery(
                "SELECT * FROM tb_productos WHERE nombre = '" + nombre + "';");
        Producto producto = new Producto();
        try {
            while (semilla.next()) {
                producto.setNombre(semilla.getString("nombre"));
                producto.setDescripcion(semilla.getString("descripcion"));
                producto.setImagen(semilla.getBinaryStream("imagen"));
            }

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
    }
}
