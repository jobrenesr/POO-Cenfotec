package navigatorlord.acceso_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AccesoDatos
{
    private static final String USERNAME= "root";
    private static final String PASSWORD= "";
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
        String nombre = null;
        try
        {
            while(semilla.next())
                nombre = semilla.getString("nombre");

        } catch (SQLException ex) {System.err.println(ex);}
        
        return FXCollections.observableArrayList(listaClientes);
    }
}
