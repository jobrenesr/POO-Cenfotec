package jenxi;

import com.jfoenix.controls.JFXButton;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

public class FMImagen extends Validador implements Formulable
{
    private ByteArrayInputStream imagen;
    
    private ImageView imagenView;

    private JFXButton btnBuscar;

    public FMImagen(ImageView pimagenView, JFXButton pbtnBuscar)
    {
        super(pbtnBuscar);
        imagenView = pimagenView;
        
        btnBuscar = pbtnBuscar;
        btnBuscar . setOnAction(event -> buscarImagen());
    }
    
    public void buscarImagen()
    {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG"),
            new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG"));

        File file = chooser.showOpenDialog(null);
        
        if(file != null)
        try
        {
            String path = file.getAbsolutePath();
            imagenView.setImage(new Image(new FileInputStream(path)));
            
            FileInputStream input = new FileInputStream(path);
            byte[] buffer = new byte[(int) file.length()];
            input.read(buffer);
            imagen = new ByteArrayInputStream(buffer);
            
            input.close();
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(FMImagen.class.getName()).log(Level.SEVERE, null, ex);} 
        catch (IOException ex) {
            Logger.getLogger(FMImagen.class.getName()).log(Level.SEVERE, null, ex);}
    }

    @Override
    public Object getDato()
    {
        return imagen;
    }

    @Override
    public void setDato(Object dato)
    {
        try
        {
            Image prontaImagen = (Image) dato;
            imagenView.setImage(prontaImagen);
            
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(SwingFXUtils.fromFXImage(prontaImagen, null),"png", output);
            imagen = new ByteArrayInputStream(output.toByteArray());
            
            output.close();
            
        } catch (IOException ex) {
            Logger.getLogger(FMImagen.class.getName()).log(Level.SEVERE, null, ex);}
    }

    @Override
    public void inactivarEntradaModulo()
    {
        btnBuscar.setDisable(true);
    }

    @Override
    public boolean validarModulo()
    {
        return validarDatoIngresado();
    }

    @Override
    public boolean validarDatoIngresado()
    {
        if(imagen == null)
        {
            ponerMensaje("Debe registrar una imagen");
            return false;
            
        } else 
        {
            quitarMensaje();
            return true;
        }
    }
}
