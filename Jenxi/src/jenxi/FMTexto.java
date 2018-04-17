package jenxi;

import javafx.scene.control.TextInputControl;

public class FMTexto extends Validador implements Formulable
{
    protected TextInputControl input;

    public FMTexto(TextInputControl pinput)
    {
        super(pinput);
        input = pinput;
        input.focusedProperty().addListener((obs, oldVal, newVal) ->{
            if(newVal != null) validarModulo();});
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
