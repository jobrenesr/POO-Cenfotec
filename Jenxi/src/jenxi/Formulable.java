package jenxi;

public interface Formulable
{   
    public Object getDato();

    public void setDato(Object dato);
            
    public void inactivarEntradaModulo();
    
    public boolean validarModulo();
    
    public boolean validarDatoIngresado();
}
