package Vista;

import java.awt.*;
import javax.swing.*;
import Controlador.*;

public class VistaPrincipal extends JFrame {

    private CardLayout layout;
    private JPanel contenedor;

    public VistaPrincipal(ControladorVista cv) {
        setTitle("Inicio");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        layout = new CardLayout();
        contenedor = new JPanel(layout);

        VistaInicio vi = new VistaInicio(this);
        VistaMenuPrincipal vmp = new VistaMenuPrincipal(this);
        VistaGestionarEstudiante vge = new VistaGestionarEstudiante(this, cv);
        VistaGestionarFacturas vgf = new VistaGestionarFacturas(this, cv);
        VistaGestionarPlan vgp = new VistaGestionarPlan(this, cv);

        contenedor.add(vi, "INICIO");
        contenedor.add(vmp, "MENU");
        contenedor.add(vge, "ESTUDIANTE");
        contenedor.add(vgp, "PLAN");
        contenedor.add(vgf, "FACTURA");

        cambiarVista("INICIO");
        add(contenedor);
        setVisible(true);
    }

    public void cambiarVista(String clave) {
        layout.show(contenedor, clave);
    }

}
