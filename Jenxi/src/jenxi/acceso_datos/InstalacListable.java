package jenxi.acceso_datos;

public class InstalacListable
{
    private String idInstalacion;
    private String productoVersionInstalado;
    private String versionInsta;

    public InstalacListable() {
    }

    public String getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(String idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getProductoInsta() {
        return productoVersionInstalado;
    }

    public void setProductoInsta(String productoInsta) {
        this.productoVersionInstalado = productoInsta;
    }

    public String getVersionInsta() {
        return versionInsta;
    }

    public void setVersionInsta(String versionInsta) {
        this.versionInsta = versionInsta;
    }

}
