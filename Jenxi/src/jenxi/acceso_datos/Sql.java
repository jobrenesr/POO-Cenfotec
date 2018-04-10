package jenxi.acceso_datos;

public class Sql
{
    public static final String LPRODUCTOS = 
    "SELECT nombre FROM tb_productos;";
            
    public static final String PRODUCTO =
    "SELECT * FROM tb_productos WHERE nombre = ?;";
    
    public static final String REGIS_PRODUCTO =
    "INSERT INTO tb_productos(nombre, descripcion, imagen) VALUES(?,?,?);";
    
    public static final String UPDATE_PRODUCTO =
    "UPDATE tb_productos SET descripcion = ?, imagen = ? where nombre = ?;";
    
    
    //clientes
    public static final String LCLIENTES = 
    "SELECT cedulaJuridica, razonSocial FROM tb_clientes;";
    
     public static final String CLIENTE =
    "SELECT * FROM tb_clientes WHERE cedulaJuridica = ?;";
    
    public static final String REGIS_CLIENTE =
    "INSERT INTO tb_clientes(cedulaJuridica, razonSocial, telefono, ubicacion, "
            + "direccionExacta, imagen) VALUES(?,?,?,?,?,?);";
}
