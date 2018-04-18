package jenxi;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class FMSelectString extends Validador implements Formulable
{
    ChoiceBox<String> input;

    public FMSelectString(ChoiceBox<String> reference)
    {
        super(reference);
        input = reference;
        
    }

    @Override
    public Object getDato()
    {
        return input.getValue();
    }

    @Override
    public void setDato(Object dato)
    {
        if(dato instanceof String)
        {
            input.getSelectionModel().select((String) dato);
        }
        else
        {
            input.setItems((ObservableList<String>)dato);
        }
    }

    @Override
    public void inactivarEntradaModulo()
    {
        input.setDisable(true);
    }

    @Override
    public boolean validarModulo()
    {
        return validarDatoIngresado();
    }

    @Override
    public boolean validarDatoIngresado()
    {
        if(getDato() == null )
        {
            ponerMensaje("Este dato debe ser registrado");
            return false;
        } else
            {
                quitarMensaje();
                return true;   
            }
    }
}
