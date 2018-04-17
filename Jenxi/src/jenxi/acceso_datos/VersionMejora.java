
package jenxi.acceso_datos;

import java.util.Date;

public class VersionMejora implements CualidadVersion
{
    private int idem;
    private String errorCorrespondiente;
    private String descripcion;
    private String nombre;

    public VersionMejora()
    {
        
    }

    @Override
    public String getNombre()
    {
        return nombre;
    }

    @Override
    public String getDatoExtra()
    {
       return errorCorrespondiente;
    }

    @Override
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public void setErrorCorrespondiente(String errorCorrespondiente)
    {
        this.errorCorrespondiente = errorCorrespondiente;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setIdem(int idem) {
        this.idem = idem;
    }

    public int getIdem() {
        return idem;
    }
}
