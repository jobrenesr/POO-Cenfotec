package jenxi.acceso_datos;

public class ClienteListado
{
    private String cedulaJuridica;
    private String nombre;

    public ClienteListado(String cedulaJuridica, String nombre) {
        this.cedulaJuridica = cedulaJuridica;
        this.nombre = nombre;
    }

    public ClienteListado() {
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }


    public String getNombre() {
        return nombre;
    }
    
    

    
}
