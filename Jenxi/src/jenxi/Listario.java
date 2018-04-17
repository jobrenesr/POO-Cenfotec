package jenxi;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;


public class Listario
{
    JFXTextField txtInput;
    JFXListView listaView;
    FilteredList<?> filtro;

    public Listario(JFXTextField pinput, JFXListView plista, ObservableList<?> observableList)
    {
        txtInput = pinput;
        listaView = plista;
        filtro = new FilteredList<>(observableList);
        listaView.setItems(filtro);
    }
}
