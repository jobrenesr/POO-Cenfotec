package jenxi;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import jenxi.acceso_datos.Producto;

public class ProductoModificar extends ProductoRegis implements Initializable
{    
    private Producto productoModificar;

    public ProductoModificar()
    {
        super();
    }
    
    public void inyectarProducto(Producto producto)
    {
        productoModificar = producto;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        setModulo(IMG, new FModImagen(imagenView, btnBuscar)); 
        setModulo(NOM, new FMNombreProductoModificar(txtNombre));
        setModulo(DESCRP, new FModTexto(txtDescripcion));
        
        ponerModIficar(IMG, productoModificar.getImagen());
        ponerModIficar(NOM, productoModificar.getNombre());
        inactivarModulo(NOM);
        ponerModIficar(DESCRP, productoModificar.getDescripcion());
        
        btnRegistrar.setOnAction(event -> registrar());
        btnCancelar.setOnAction(event -> {popUp.close();});
    }
    
    @Override
    public void registrar()
    {
        if(validarFormulario())
        {
            String nombre = (String)getDato(NOM);
            Productos.gestor.modificarProducto
            (
                (ByteArrayInputStream)getDato(IMG), nombre,(String)getDato(DESCRP)
            );

            PopRegistro pop = new PopRegistro
                (nombre+ " ha sido registrado", Ventana.PRODUCTOS, nombre);
            
            Fxmleador loader = new Fxmleador(Xml.POP_UNO, pop);
            pop.inyectarEscenario(loader.cargarPop());
            popUp.close();
        }
    }
}
