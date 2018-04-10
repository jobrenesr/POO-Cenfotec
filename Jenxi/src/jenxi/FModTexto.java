package jenxi;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputControl;

public class FModTexto extends Validador implements Formulable
{
    protected TextInputControl input;

    public FModTexto(TextInputControl pinput)
    {
        super(pinput);
        input = pinput;
        input . focusedProperty().addListener((obs, oldVal, newVal) ->{
            if(!newVal) validarModulo();});
    }

    @Override
    public Object getDato()
    {
        return input.getText().trim();
    }

    @Override
    public void setDato(Object dato)
    {
        input.setText((String) dato);
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
        if(getDato().toString().isEmpty())
        {
            ponerMensaje("Este dato es olbigatorio registrar");
            return false;
            
        } else
        {
            quitarMensaje();
            return true;
        }
    }
}
