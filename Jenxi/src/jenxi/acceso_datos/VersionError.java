
package jenxi.acceso_datos;

import java.time.LocalDate;

public class VersionError implements CualidadVersion
{
    private int idem;
    private LocalDate fechaReporte;
    private String descripcion;
    private String nombre;

    public VersionError()
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
       return fechaReporte.toString();
    }

    @Override
    public String getDescripcion()
    {
        return descripcion;
    }

    public void setFechaReporte(LocalDate fechaReporte)
    {
        this.fechaReporte = fechaReporte;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setIdem(int idem)
    {
        this.idem = idem;
    }

    public int getIdem() {
        return idem;
    }
}
