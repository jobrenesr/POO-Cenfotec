package jenxi;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import jenxi.acceso_datos.Cliente;
import jenxi.acceso_datos.Contacto;

/**
 *
 * @author jobre
 */
public class ClienteVer  extends Contacto implements Initializable,Controlable
{
    public static Cliente cliente;

    public ClienteVer()
    {
        super();
    }
        
    @Override
    public void actualizar(Object nombreSeleccionado)
    {
        cliente = Clientes.gestor.obtenerCliente((String)nombreSeleccionado);
    }
    
    @Override
    public void dormir()
    {
        cliente = null;
    }

    
    @FXML
    private Label labelCedulaJuridica;

    @FXML
    private ImageView imagenView;

    @FXML
    private Label labelTelefono;

    @FXML
    private JFXButton btnModificar;

    @FXML
    private Label labelUbicacion;

    @FXML
    private Label labelDireccion;

    @FXML
    private AnchorPane tabVersiones;

    @FXML
    private Label ContactoLider2;

    @FXML
    private Label txtNombreCompletoContactoLider;

    @FXML
    private Label ContactoLider1;

    @FXML
    private Label txtTelefonoLider;

    @FXML
    private Label ContactoLider;

    @FXML
    private Label txtCorreoLider;

    @FXML
    private JFXButton btnRegistrarContactoLider;

    @FXML
    private Label ContactoTI;

    @FXML
    private Label txtNombreCompletoContactoTI;

    @FXML
    private Label ContactoTI2;

    @FXML
    private Label txtTelefonoTI;

    @FXML
    private Label ContactoTI3;

    @FXML
    private Label txtCorreoTI;

    @FXML
    private JFXButton btnRegistrarContactoTI;

    @FXML
    private Label noHaycontactoLider;

    @FXML
    private Label noHaycontactoTI;

    @FXML
    private AnchorPane tabInstalaciones;

    @FXML
    private Label labelRazonSocial;



    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        labelRazonSocial.setText(cliente.getRazonSocial());
        labelCedulaJuridica.setText(cliente.getCedulaJuridica());
        labelTelefono.setText(cliente.getTelefono());
        labelUbicacion.setText(cliente.getUbicacion());
        labelDireccion.setText(cliente.getDireccionExacta());
        
        //obtiene los contactos de la empresa
        
        if(cliente.getIdContactoLider() == null   && cliente.getIdContactoTI() == null){
            noHaycontactoLider.setVisible(true);
            btnRegistrarContactoLider.setText("Registrar");
            txtNombreCompletoContactoLider.setVisible(false);
            txtTelefonoLider.setVisible(false);
            txtCorreoLider.setVisible(false);
            ContactoLider.setVisible(false);
            ContactoLider1.setVisible(false);
            ContactoLider2.setVisible(false);
             txtNombreCompletoContactoTI.setVisible(false);
            txtTelefonoTI.setVisible(false);
            txtCorreoTI.setVisible(false);
            ContactoTI.setVisible(false);
            ContactoTI2.setVisible(false);
            ContactoTI3.setVisible(false);
            noHaycontactoTI.setVisible(true);
            btnRegistrarContactoTI.setText("Registrar");                       
            btnRegistrarContactoLider.setOnAction(event ->navegarRegisContactoLider());
            btnRegistrarContactoTI.setOnAction(event ->navegarRegisContactoTI());
            
        }else{
            if(cliente.getIdContactoLider() == null && cliente.getIdContactoTI() != null){
              noHaycontactoLider.setVisible(true);
          btnRegistrarContactoLider.setText("Registrar");
            txtNombreCompletoContactoLider.setVisible(false);
            txtTelefonoLider.setVisible(false);
            txtCorreoLider.setVisible(false);
            ContactoLider.setVisible(false);
          ContactoLider1.setVisible(false);
            ContactoLider2.setVisible(false);
            btnRegistrarContactoTI.setText("Modificar");
         btnRegistrarContactoLider.setOnAction(event ->navegarRegisContactoLider());
        
                txtNombreCompletoContactoTI.setText(cliente.getContacto().get(0).getNombreContacto());
                txtTelefonoTI.setText(cliente.getContacto().get(0).getTelefonoContacto());
                txtCorreoTI.setText(cliente.getContacto().get(0).getCorreoElectronicoContacto());
                btnRegistrarContactoTI.setOnAction(event -> navegarModificaContacto());
            } else{
                
            
            if(cliente.getIdContactoTI() == null && cliente.getIdContactoLider() != null)
            {
                 noHaycontactoLider.setVisible(false);
                txtNombreCompletoContactoLider.setText(cliente.getContacto().get(0).getNombreContacto());
                txtTelefonoLider.setText(cliente.getContacto().get(0).getTelefonoContacto());
                txtCorreoLider.setText(cliente.getContacto().get(0).getCorreoElectronicoContacto());
                btnRegistrarContactoLider.setText("Modificar");
                 txtNombreCompletoContactoTI.setVisible(false);
            txtTelefonoTI.setVisible(false);
            txtCorreoTI.setVisible(false);
            ContactoTI.setVisible(false);
            ContactoTI2.setVisible(false);
            ContactoTI3.setVisible(false);
            noHaycontactoTI.setVisible(true);
            btnRegistrarContactoTI.setText("Registrar");
            btnRegistrarContactoTI.setOnAction(event ->navegarRegisContactoTI());  
            }
            else{
                noHaycontactoTI.setVisible(false);
                noHaycontactoLider.setVisible(false);
                txtNombreCompletoContactoLider.setText(cliente.getContacto().get(0).getNombreContacto());
                txtTelefonoLider.setText(cliente.getContacto().get(0).getTelefonoContacto());
                txtCorreoLider.setText(cliente.getContacto().get(0).getCorreoElectronicoContacto());
                txtNombreCompletoContactoTI.setText(cliente.getContacto().get(1).getNombreContacto());
                txtTelefonoTI.setText(cliente.getContacto().get(1).getTelefonoContacto());
                txtCorreoTI.setText(cliente.getContacto().get(1).getCorreoElectronicoContacto());
            }
            
        }
        }
        
        
  //      if(cliente.getIdContactoLider() == null && cliente.getIdContactoTI() != null)
//        {
//        noHaycontactoLider.setVisible(true);
//        btnRegistrarContactoLider.setText("Registrar");
//        txtNombreCompletoContactoLider.setVisible(false);
//        txtTelefonoLider.setVisible(false);
//        txtCorreoLider.setVisible(false);
//        ContactoLider.setVisible(false);
//        ContactoLider1.setVisible(false);
//        ContactoLider2.setVisible(false);
//        btnRegistrarContactoLider.setOnAction(event ->navegarRegisContactoLider());
//        
//                txtNombreCompletoContactoTI.setText(cliente.getContacto().get(0).getNombreContacto());
//                txtTelefonoTI.setText(cliente.getContacto().get(0).getTelefonoContacto());
//                txtCorreoTI.setText(cliente.getContacto().get(0).getCorreoElectronicoContacto());
//        }else
//            {
//                if(cliente.getIdContactoTI() == null && cliente.getIdContactoLider() != null)
//                {
//                noHaycontactoTI.setVisible(false);
//                txtNombreCompletoContactoLider.setText(cliente.getContacto().get(0).getNombreContacto());
//                txtTelefonoLider.setText(cliente.getContacto().get(0).getTelefonoContacto());
//                txtCorreoLider.setText(cliente.getContacto().get(0).getCorreoElectronicoContacto());
//                btnRegistrarContactoLider.setText("Modificar");
//                }
//                
               
             //   btnRegistrarContactoLider.setOnAction(event ->navegarRegisContactoLider()); 
               
                 // txtNombreCompletoContactoTI.setText(cliente.getContacto().get(1).getNombreContacto());
               // txtTelefonoTI.setText(cliente.getContacto().get(1).getTelefonoContacto());
               // txtCorreoTI.setText(cliente.getContacto().get(1).getCorreoElectronicoContacto());
            
            //}
        
        //Fin
        Image imagen = cliente.getImagen();
        if(imagen != null) imagenView.setImage(imagen);
        
        Ventana instalaciones = new Ventana(Xml.INSTALACIONES, new Instalacs());
        tabInstalaciones.getChildren().add(instalaciones.cargarNodo());
        
        //btnRegistrarContactoLider.setText("Modificar");
        
        btnRegistrarContactoLider.setOnAction(event ->navegarRegisContactoLider());  
       // btnRegistrarContactoTI.setOnAction(event ->navegarRegisContactoTI());  
        btnModificar.setOnAction(event -> navegarModCliente());
    }
    
    public void navegarModCliente()
    {
        Aplicacion.control.navegarPop(Bundle.CLIENTE_MOD, cliente);
    }
    
    public void navegarRegisContactoTI(){
        Aplicacion.control.navegarPop(Bundle.CONTACTO_REGISTI, cliente);
    }
    
    public void navegarRegisContactoLider(){
        Aplicacion.control.navegarPop(Bundle.CONTACTO_REGISLider, cliente);
    }
                  
    public void navegarModificaContacto(){
        Aplicacion.control.navegarPop(Bundle.CONTACTO_REGISLider, cliente);
    }
}
