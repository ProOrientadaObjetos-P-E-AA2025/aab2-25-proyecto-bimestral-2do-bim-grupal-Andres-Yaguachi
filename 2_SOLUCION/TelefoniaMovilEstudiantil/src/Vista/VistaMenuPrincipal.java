package Vista;

import java.awt.*;
import javax.swing.*;

public class VistaMenuPrincipal extends JPanel {

    public VistaMenuPrincipal(VistaPrincipal base) {
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Menú Principal", SwingConstants.CENTER);

        JButton nuevo = new JButton("Nuevo Estudiante-Plan");
        JButton eliminar = new JButton("Eliminar Estudiante-Plan");
        JButton actualizar = new JButton("Actualizar");
        JButton factura = new JButton("Facturacion");

        nuevo.addActionListener(e -> base.cambiarVista("NUEVO"));
        eliminar.addActionListener(e -> base.cambiarVista("ELIMINAR"));
        actualizar.addActionListener(e -> base.cambiarVista("ACTUALIZAR"));
        factura.addActionListener(e -> base.cambiarVista("FACTURA"));

        JPanel botonesPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        botonesPanel.add(nuevo);
        botonesPanel.add(eliminar);
        botonesPanel.add(actualizar);
        botonesPanel.add(factura);

        add(titulo, BorderLayout.NORTH);
        add(botonesPanel, BorderLayout.CENTER);

    }

}
