package jenxi;
    import java.util.HashMap;

public abstract class Formulario extends HashMap <String , Formulable>
{
    public Formulario()
    {
        super();
    }
    
    public void setModulo(String nombre, Formulable modulo)
    {
        put(nombre, modulo);
    }
    
    public void ponerModIficar(String vector, Object dato)
    {
        get(vector).setDato(dato);
    }
    
    public void inactivarModulo(String vector)
    {
        get(vector).inactivarEntradaModulo();
    }
       
    public boolean validarModulo(String vector)
    {
        return get(vector).validarModulo();
    }
    
    public boolean validarFormulario()
    {
        boolean bError = true;
        
        for(Formulable modulo : values())

            if(!modulo.validarModulo()) 
                bError = false;

        return bError;
    }
    
    public Object getDato(String vector)
    {
        return get(vector).getDato();
    }
}
