package jenxi;

import jenxi.acceso_datos.*;

public class FazVersionMejora implements FazInterCualidad
{
    private String errorCorrespondiente;
    private String descripcion;
    private String nombre;

    public FazVersionMejora()
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
}
