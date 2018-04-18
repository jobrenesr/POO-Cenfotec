package jenxi.acceso_datos;

public class Sql
{
/*********/
//productos
    public static final String PRODUCTOS = 
    "SELECT nombre FROM tb_productos;";
            
    public static final String PRODUCTO_VER =
    "SELECT * FROM tb_productos WHERE nombre = ?;";
    
    public static final String PRODUCTO_REGIS =
    "INSERT INTO tb_productos(nombre, descripcion, imagen) VALUES(?,?,?);";
    
    public static final String PRODUCTO_MOD =
    "UPDATE tb_productos SET descripcion = ?, imagen = ? where nombre = ?;";
    
/***************************/
//versiones y caracteristicas
    public static final String VERSION_REGIS = 
    "INSERT INTO t_versiones(id_producto, fecha_creacion, nombre) VALUES (?,?,?)";
    
    public static final String VERSION_ULTIMO_NOM =
    "SELECT nombre FROM t_versiones WHERE id_producto = ? ORDER BY fecha_creacion limit 1;";
    
    public static final String VERSIONES =
    "SELECT id_version, nombre FROM t_versiones WHERE id_producto = ? ORDER BY fecha_creacion DESC";
    
    public static final String VERSION_MEJORAS =
    "SELECT C.nombre, C.descripcion, M.id_error FROM t_mejoras as M INNER JOIN "+
        "t_caracteristicas AS C ON M.id_caracteristica = C.id INNER JOIN "+
        "t_versiones AS V ON C.id_version = V.id_version "+
        "WHERE V.nombre = ?";
    
    public static final String VERSION_ERRORES =
    "SELECT C.nombre, C.descripcion, E.fecha FROM t_errores as E INNER JOIN "+
        "t_caracteristicas AS C ON E.id_caracteristica = C.id INNER JOIN "+
        "t_versiones AS V ON C.id_version = V.id_version "+
        "WHERE V.nombre = ?";
 
    
    
    
    //clientes
    public static final String LCLIENTES = 
    "SELECT cedulaJuridica, razonSocial FROM tb_clientes;";
    
     public static final String CLIENTE =
    "SELECT * FROM tb_clientes  WHERE cedulaJuridica = ?;";
    
    public static final String REGIS_CLIENTE =
    "INSERT INTO tb_clientes(cedulaJuridica, razonSocial, telefono, ubicacion, "
            + "direccionExacta, imagen) VALUES(?,?,?,?,?,?);";
    
    public static final String CLIENTE_UPDATE =
    "UPDATE tb_clientes SET telefono = ?, ubicacion = ?, direccionExacta = ?, imagen =?,  razonSocial =? where  cedulaJuridica = ?;";
    
    //Contactos
    //Registrar
    public static final String REGIS_CONTACTO =
    "INSERT INTO tb_contactos(cedulaEmpleado, nombreEmpleado, telefonoEmpleado, correoEmpleado) VALUES(?, ? ,?, ?);";
                
    public static final String REGIS_CONTACTOLIDER =
            "UPDATE tb_clientes SET idContactoLider = LAST_INSERT_ID() WHERE cedulaJuridica = ?;";
    
    public static final String REGIS_CONTACTOTI =
            "UPDATE tb_clientes SET idContactoTI = LAST_INSERT_ID() WHERE cedulaJuridica = ?;";
    
    //Listar
    //TI
    public static final String CONTACTOTI_LIST =
    "SELECT cti.id, cti.cedulaEmpleado, cti.nombreEmpleado, cti.telefonoEmpleado, cti.correoEmpleado FROM tb_contactos as cti "
            + "inner join tb_clientes as ti on (cti.id = ti.idContactoTI)  "
            + "where ti.cedulaJuridica  = ?;";
    //Lider
     public static final String CONTACTOLIDER_LIST =
    "SELECT clider.id, clider.cedulaEmpleado, clider.nombreEmpleado, clider.telefonoEmpleado, clider.correoEmpleado FROM tb_contactos as clider "
            + "inner join tb_clientes as lider on (clider.id = lider.idContactoLider) where lider.cedulaJuridica  = ?;";
     //Update contacto
     public static final String CONTACTO_UPDATE =
    "UPDATE tb_contactos SET cedulaEmpleado = ?, nombreEmpleado = ?, telefonoEmpleado = ?, correoEmpleado =?  where  id = ?;";
}
