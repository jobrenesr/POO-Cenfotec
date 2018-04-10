package jenxi;

import javafx.application.Application;
import java.io.IOException;
import javafx.stage.Stage;

public class Aplicacion extends Application
{    
    static Ventana control;

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        control = new Ventana(primaryStage);
        Fxmleador ventana = new Fxmleador(Xml.PRINCIPAL, control);
   
        primaryStage.setScene(ventana.cargarEscena());
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args){     launch(args);   }
}
