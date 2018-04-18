/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenxi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import jenxi.acceso_datos.Contacto;

/**
 *
 * @author jobre
 */
public class ContactoLiderModificar extends ContactoRegisLider implements Initializable, Controlable, Popable{
    private Contacto contactoModificar;
    
    public ContactoLiderModificar(){
        super();
    }
    
     @Override
    public void actualizar(Object vector)
    {
        contactoModificar = (Contacto)vector;    
    }
    
     @Override
    public void dormir()
    {
        borrarFormulario();
    }
      @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        setModulo("cedulaEmpleado", new FMCedulaPersona(txtCedulaEmpleado));
        setModulo("nombreEmpleado", new FMTexto(txtNombreEmpleado));
        setModulo("telefonoEmpleado", new FMTelefono(txtTelefonoEmpleado));
        setModulo("correoEmpleado", new FMCorreo(txtCorreoElectronico));
        
        ponerModIficar("cedulaEmpleado", contactoModificar.getCedulaContacto());
        ponerModIficar("nombreEmpleado", contactoModificar.getNombreContacto());
        ponerModIficar("telefonoEmpleado", contactoModificar.getTelefonoContacto());
        ponerModIficar("correoEmpleado", contactoModificar.getCorreoElectronicoContacto());
        
        txtCedulaJuridica.setVisible(false);
        btnRegistrar.setText("Actualizar");
        btnRegistrar.setOnAction(event -> registrarContacto());
        btnCancelarRegisContacto.setOnAction(event ->{
            Aplicacion.control.terminarPop(Bundle.CONTACTO_MODLIDER, escenario);
        });
    }
     public void registrarContacto() {
        if (validarFormulario()) {
            
            
                Clientes.gestor.modificarContacto(
                        contactoModificar.getId(),
                        (String) getDato("cedulaEmpleado"),
                        (String) getDato("nombreEmpleado"),
                        (String) getDato("telefonoEmpleado"),
                        (String) getDato("correoEmpleado")
                        );
           Aplicacion.control.navegarPop(
                Bundle.POP, new DatosPop(Bundle.CLIENTES, ClienteVer.cliente.getCedulaJuridica() ,"El contacto ha sido actualizado"));
            
            Aplicacion.control.terminarPop(Bundle.CONTACTO_REGISLIDER, escenario);
            escenario.close();
        }
}
}
