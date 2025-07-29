package Vista;

import java.awt.*;
import javax.swing.*;

public class VistaMenuPrincipal extends JPanel {

    public VistaMenuPrincipal(VistaPrincipal base) {
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Menú Principal", SwingConstants.CENTER);

        JButton estudiante = new JButton("Estudiante");
        JButton plan = new JButton("Plan");
        JButton factura = new JButton("Facturacion");

        estudiante.addActionListener(e -> base.cambiarVista("ESTUDIANTE"));
        plan.addActionListener(e -> base.cambiarVista("PLAN"));
        factura.addActionListener(e -> base.cambiarVista("FACTURA"));

        JPanel botonesPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        botonesPanel.add(estudiante);
        botonesPanel.add(plan);
        botonesPanel.add(factura);

        add(titulo, BorderLayout.NORTH);
        add(botonesPanel, BorderLayout.CENTER);

    }

}
