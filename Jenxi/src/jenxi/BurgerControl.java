package jenxi;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.scene.input.MouseEvent;

public class BurgerControl extends HamburgerBackArrowBasicTransition
{
    private JFXDrawer drawer;
    
    public BurgerControl(JFXDrawer pdrawer, JFXHamburger phamburger)
    {
        super(phamburger);
        drawer = pdrawer;
        phamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, event->
        {
            toggleBurger();
            if(drawer.isShown())
            {
                drawer.toBack();
                drawer.close();
            }               
                else
                {
                    drawer.toFront();
                    drawer.open();
                }
        });
        setRate(-1);
    }

    public void toggleBurger()
    {
        setRate(getRate() * -1);
        play();   
    }
   
    public void navegar(Character vector)
    {
        Aplicacion.control.navegarIzquierda(vector, null);
        drawer.close();
        toggleBurger();
    }
}
