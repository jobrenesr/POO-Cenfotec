package jenxi;

import java.io.ByteArrayInputStream;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import jenxi.acceso_datos.Producto;
import java.net.URL;

public class ProductoModificar extends ProductoRegis implements Initializable, Controlable, Popable
{    
    private Producto productoModificar;

    public ProductoModificar()
    {
        super();
    }
    
    @Override
    public void actualizar(Object vector)

    {
        productoModificar = (Producto)vector;
    }

    @Override
    public void dormir()
    {
        borrarFormulario();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        setModulo(   IMG, new FMImagen(imagenView, btnBuscar)); 
        setModulo(   NOM, new FMNombreProductoModificar(txtNombre));
        setModulo(DESCRP, new FMTexto(txtDescripcion));
        
        ponerModIficar(   IMG, productoModificar.getImagen());
        ponerModIficar(   NOM, productoModificar.getNombre());
        inactivarModulo( NOM);
        ponerModIficar(DESCRP, productoModificar.getDescripcion());
        btnRegistrar.setText("Actualizar");
        btnRegistrar.setOnAction(event -> registrar());
        btnCancelar.setOnAction(event -> {escenario.close();});
    }
    
    @Override
    public void registrar()
    {
        if(validarFormulario())
        {
            String nombre = (String)getDato(NOM);
            Productos.gestor.modificarProducto(
                (ByteArrayInputStream)getDato(IMG), nombre,(String)getDato(DESCRP));
            
            Aplicacion.control.navegarPop(Bundle.POP, new DatosPop(
                    Bundle.PRODUCTOS, nombre, "El producto ha sido modificado"));   
            
            escenario.close();
        }
    }
}
