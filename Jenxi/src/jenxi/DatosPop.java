package jenxi;

public class DatosPop
{
    private String stringContenido;
    private Character direccionListado;
    private String direccionVer;

    public DatosPop(Character pdireccionListado, String pdireccionVer, String contenido)
    {
        direccionListado = pdireccionListado;
        direccionVer = pdireccionVer;
        stringContenido = contenido;
    }

    public String getDireccionVer()
    {
        return direccionVer;
    }

    public Character getDireccionListado()
    {
        return direccionListado;
    } 

    public String getContenido()
    {
        return stringContenido;
    }
}
