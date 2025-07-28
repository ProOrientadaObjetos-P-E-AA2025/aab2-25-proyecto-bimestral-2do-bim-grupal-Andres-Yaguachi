package Vista;

import java.awt.*;
import javax.swing.*;

public class VistaPrincipal extends JFrame {

    private CardLayout layout;
    private JPanel contenedor;

    public VistaPrincipal() {
        setTitle("Inicio");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        layout = new CardLayout();
        contenedor = new JPanel(layout);

        VistaInicio vi = new VistaInicio(this);
        VistaMenuPrincipal vmp = new VistaMenuPrincipal(this);

        contenedor.add(vi, "INICIO");
        contenedor.add(vmp, "MENU");

        add(contenedor);
        setVisible(true);
    }

    public void cambiarVista(String nombreVista) {
        layout.show(this, nombreVista);
    }
}
