package Vista;

import Controlador.*;
import java.awt.*;
import javax.swing.*;

public class VistaGestionarFacturas extends JPanel {

    VistaMensajesUsuario vmu;

    public VistaGestionarFacturas(VistaPrincipal base, ControladorVista cv) {
        setLayout(new BorderLayout(10, 10));
        vmu = new VistaMensajesUsuario();

        JLabel titulo = new JLabel("Mostrar Facturas", SwingConstants.CENTER);
        JButton facturaIndividual = new JButton("Factura por Persona");
        JButton listarFacturas = new JButton("Lista de Facturas");
        JButton btnVolver = new JButton("Volver");

        facturaIndividual.addActionListener(e -> {
            VistaIngresoCedula ci = new VistaIngresoCedula(base);
            String cedula = ci.mostrarYObtenerCedula();
            if (cedula == null) {
                vmu.error("Cédula inválida o ingreso cancelado.");
                return;
            }
            cv.mostrarFacturasIndividuales(cedula);
        });

        listarFacturas.addActionListener(e -> {
            cv.mostrarFacturas();
        });

        btnVolver.addActionListener(e -> base.cambiarVista("MENU"));

        add(titulo, BorderLayout.NORTH);

        JPanel botones = new JPanel(new GridLayout(1, 2, 10, 0));
        botones.add(facturaIndividual);
        botones.add(listarFacturas);
        JPanel footer = new JPanel();
        footer.add(btnVolver);
        add(footer, BorderLayout.SOUTH);

        add(botones, BorderLayout.CENTER);

    }

}
