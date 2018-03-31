package navigatorlord;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application
{    
    public static void main(String[] args)
    {
            launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {                       
        FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource(Cxml.MENUPRINCIPAL));
        AnchorPane menu = loaderMenu.load();
                
        Scene scene = new Scene(menu);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(420);
        primaryStage.setMinHeight(550);
        
        primaryStage.show();
    }
}
