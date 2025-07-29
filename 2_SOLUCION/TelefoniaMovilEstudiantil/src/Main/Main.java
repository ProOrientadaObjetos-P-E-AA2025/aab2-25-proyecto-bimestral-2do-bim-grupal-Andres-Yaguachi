package Main;

import Controlador.*;
import Vista.*;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ControladorVista controlador = new ControladorVista();
            VistaPrincipal vista = new VistaPrincipal(controlador);
            controlador.setVp(vista);
            
        });

    }
}
