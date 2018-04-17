package jenxi;

import javafx.application.Application;
import java.io.IOException;
import javafx.stage.Stage;

public class Aplicacion extends Application
{    
    static Bundle control;

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        control = new Bundle(primaryStage);
        Ventana ventana = new Ventana(Xml.PRINCIPAL, control);
   
        primaryStage.setScene(ventana.cargarEscena());
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args){     launch(args);   }
}
