package navigatorlord.gestores;

import navigatorlord.acceso_datos.AccesoDatos;

public class GestorPrincipal
{
    protected static AccesoDatos baseDatos;

    public GestorPrincipal() {
        baseDatos = new AccesoDatos();
    }
    
    AccesoDatos getAccesoDatos()
    {
        return baseDatos;
    }
}
