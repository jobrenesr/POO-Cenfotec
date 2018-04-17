package jenxi;

import java.util.regex.Pattern;
import javafx.scene.control.TextInputControl;

public class FMNombreVersion extends FMTexto
{
    private final String M_MENOR = "el nombre es menor al de la ultima versión";
    
    public FMNombreVersion(TextInputControl pinput)
    {
        super(pinput);
    }

    @Override
    public boolean validarModulo()
    {
        if(!validarDatoIngresado()) return false;
        else
        {
            String nombreVersion = (String)getDato();
            if(!validarNombreCorrecto(nombreVersion))
            {
                return false;
                
            } else
                if(!compararConUltimaVersion(asIntArray(nombreVersion.split(Pattern.quote(".")))))
                {
                    return false;
                    
                }else
                {
                    quitarMensaje();
                    return true;
                }
        }
    }

    public boolean validarNombreCorrecto(String nombre)
    {
        String[] partes = nombre.split(Pattern.quote("."));
        
        for(byte i = 0; i < partes.length; i++)
            
            if(!partes[i].matches("[0-9]+"))
            {
                ponerMensaje("el nombre no puede tener mas que números y puntos");
                return false;
                
            } 
            else
            {
                int numero = Integer.parseInt(partes[i]);
                if(numero > 126)
                {
                    ponerMensaje("el número del campo"+(i+1)+" no es válido");
                    return false;
                }
                else
                {
                    ponerMensaje("");
                    return true;
                }
            }
        return true;
    }    
    
    public int[] asIntArray(String[] datos)
    {
        int[] output = new int[datos.length];
        
        for(int j = 0 ; j < output.length; j++)
            output[j] = Integer.parseInt(datos[j]);
        
        return output;
    }
    
    public boolean compararConUltimaVersion(int[] nuevoNombre)
    {
        int[] ultimoNombre = null;
        String viejoNombre = null;
        
        viejoNombre = Productos.gestor.getNombreUltimaVersion(ProductoVer.producto.getIdem());
        if(viejoNombre == null) return true;
  
        ultimoNombre = asIntArray(viejoNombre.split(Pattern.quote(".")));
        int largoNuevo = nuevoNombre.length;
        int largoViejo = ultimoNombre.length;
        int largoMinimo = Long.signum((long)largoNuevo - largoViejo);
        int signum = 0;
        int flag = 0;
        
        for(byte j = 0; j < largoMinimo; j++)
        {
            flag = (j + 1);
            signum = Long.signum((long) nuevoNombre[j] - ultimoNombre[j]);
            
//A.es la ultima parte de alguno de los dos nombre?          
            if(flag == largoViejo || flag == largoNuevo)
            {
    //B.es la ultima parte de los dos nombres la que se analiza?
                if(flag == largoViejo && flag == largoNuevo)
                {
                    if(signum < 0 || signum == 0)
                    {
                        ponerMensaje(M_MENOR);
                        return false;
                    }
                    else
                    {
                        ponerMensaje("");
                        return true;
                    }
                } else
    //B.o, solo es la ultima parte del nombre nuevo, (el viejo todavia tiene partes por analizar)
                if(signum < 0)
                {
                    ponerMensaje(M_MENOR);
                    return false;
                    
                } else
                    if(signum > 0)
                    {
                        ponerMensaje("");
                        break;
                        
                    } else
                        if(revisarSiQuedanSoloCeros(flag, nuevoNombre))
                        {
                            ponerMensaje("la version no es mayor a la anterior");
                            return false;
                            
                        } else
                        {
                            ponerMensaje("");
                            break;
                        }
//A.o, todavia ambos nombres tienen partes por analizar.
            } else
//if para cuando hay nombre por analizar
                if(signum < 0)
                {
                    ponerMensaje(M_MENOR);
                    return false;
                }
        }
        return true;
    }
    
    public boolean revisarSiQuedanSoloCeros(final int cont, int[] datos)
    {
        for(int i = cont + 1; i < datos.length; i++)

            if(datos[i] > 0)
                
                return false;
        
        return true;
    }
}
