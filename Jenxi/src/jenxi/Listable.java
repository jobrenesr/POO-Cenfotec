package jenxi;

public class Listable
{
    private String valorMostrado;
    private String identificador;

    public Listable() {
    }

    public Listable(String valorMostrado, String identificador) {
        this.valorMostrado = valorMostrado;
        this.identificador = identificador;
    }

    public String getValorMostrado() {
        return valorMostrado;
    }

    public String getIdentificador() {
        return identificador;
    }
}
