package Vista;

import java.awt.*;
import javax.swing.*;

public class VistaInicio extends JPanel {

    public VistaInicio(VistaPrincipal base) {
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("GESTION DE PLANES DE TELEFONIA ESTUDIANTIL", SwingConstants.CENTER);

        JButton continuar = new JButton("Continuar");
        JButton salir = new JButton("Salir");

        continuar.addActionListener(e -> base.cambiarVista("MENU"));
        salir.addActionListener(e -> System.exit(0));

        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        botonesPanel.add(continuar);
        botonesPanel.add(salir);

        add(titulo, BorderLayout.CENTER);
        add(botonesPanel, BorderLayout.SOUTH);
    }

}
