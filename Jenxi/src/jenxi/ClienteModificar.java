package jenxi;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import jenxi.acceso_datos.Cliente;

public class ClienteModificar extends ClienteRegis implements Initializable, Controlable, Popable {
    
    private Cliente clienteModificar;
    
    public ClienteModificar(){
        super();
    }
    
       @Override
    public void actualizar(Object vector)
    {
        clienteModificar = (Cliente)vector;
    }

    @Override
    public void dormir()
    {
        borrarFormulario();
    }
    
  
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        
        setModulo(IMG, new FMImagen(imagenView, btnBuscar));
        setModulo(CDJ, new FMNombreProductoModificar(txtCedulaJuridica));
        setModulo("razonSocial", new FMTexto(txtRazonSocial));
        setModulo("telefono", new FMTelefono(txtTelefono));
        setModulo("ubicacion", new FMTexto(txtUbicacion));
        setModulo("direccionExacta", new FMTexto(txtDireccionExacta));
        
        
        ponerModIficar(IMG, clienteModificar.getImagen());
        ponerModIficar(CDJ, clienteModificar.getCedulaJuridica());
        inactivarModulo(CDJ);
        ponerModIficar("razonSocial", clienteModificar.getRazonSocial());
        inactivarModulo("razonSocial");
        ponerModIficar("telefono", clienteModificar.getTelefono());
        ponerModIficar("ubicacion", clienteModificar.getUbicacion());
        ponerModIficar("direccionExacta", clienteModificar.getDireccionExacta());
        
        mensaje1.setText("Actualizar Cliente");
        btnRegistrar.setText("Actualizar");
        btnRegistrar.setOnAction(event -> registrar());
        btnCancelar.setOnAction(event -> {escenario.close();});
        
    }
    
    public void registrar()
    {
        if(validarFormulario())
        {
            String cedulaJuridica = (String)getDato(CDJ);
            String razonSocial = (String)getDato("razonSocial");
            Clientes.gestor.modificarCliente
            (
                (ByteArrayInputStream)getDato(IMG), cedulaJuridica,razonSocial, (String)getDato("telefono"), (String)getDato("ubicacion"), (String)getDato("direccionExacta")
            );
            
            Aplicacion.control.navegarPop(Bundle.POP, new DatosPop(
                    Bundle.CLIENTES, razonSocial, "El Cliente ha sido modificado")); 
            escenario.close();
        }
    }
}
