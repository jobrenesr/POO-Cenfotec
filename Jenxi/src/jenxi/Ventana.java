package jenxi;

import javafx.scene.Parent;

public abstract class Ventana
{
    private Parent raizXml;
    private String nombre;
    private PrincipalController controlador;

    public Parent getRaizXml() {
        return raizXml;
    }

    public void setRaizXml(Parent praizXml) {
        raizXml = praizXml;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String pnombre) {
        nombre = pnombre;
    }

    public PrincipalController getControlador() {
        return controlador;
    }

    public void setControlador(PrincipalController pcontrolador) {
        controlador = pcontrolador;
    }
}
