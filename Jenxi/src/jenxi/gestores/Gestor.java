package jenxi.gestores;

import jenxi.acceso_datos.AccesoDatos;

public class Gestor
{
    protected static AccesoDatos baseDatos;

    public Gestor()
    {
        baseDatos = new AccesoDatos();
    }
    
    AccesoDatos getAccesoDatos()
    {
        return baseDatos;
    }
}
