package Vista;

import Controlador.*;
import java.awt.*;
import javax.swing.*;

public class VistaGestionarFacturas extends JPanel {

    public VistaGestionarFacturas(VistaPrincipal base, ControladorVista cv) {
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Mostrar Facturas", SwingConstants.CENTER);
        JButton facturaIndividual = new JButton("Factura por Persona");
        JButton listarFacturas = new JButton("Lista de Facturas");

        facturaIndividual.addActionListener(e -> {
            VistaIngresoCedula ci = new VistaIngresoCedula(base);
            String ced = ci.mostrarYObtenerCedula();
            cv.mostrarFacturasIndividuales(ced);
        });

        listarFacturas.addActionListener(e -> {
            cv.mostrarFacturas();
        });
        add(titulo, BorderLayout.NORTH);

        JPanel botones = new JPanel(new GridLayout(1, 2, 10, 0));
        botones.add(facturaIndividual);
        botones.add(listarFacturas);

        add(botones, BorderLayout.CENTER);

    }

}
