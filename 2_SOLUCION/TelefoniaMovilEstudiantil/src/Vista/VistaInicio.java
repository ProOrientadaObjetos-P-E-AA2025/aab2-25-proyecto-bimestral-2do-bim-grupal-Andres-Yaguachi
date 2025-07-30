package Vista;

import java.awt.*;
import javax.swing.*;

public class VistaInicio extends JPanel {

    public VistaInicio(VistaPrincipal base) {
        setLayout(new BorderLayout(20, 20));

        JPanel tituloPanel = new JPanel();
        JLabel titulo = new JLabel("GESTION DE PLANES DE TELEFONIA ESTUDIANTIL");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        tituloPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        tituloPanel.setBackground(new Color(70, 130, 180));
        tituloPanel.setForeground(Color.WHITE);
        tituloPanel.add(titulo);

        JButton continuar = new JButton("Continuar al Menú");
        continuar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        continuar.setPreferredSize(new Dimension(180, 40));
        continuar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton salir = new JButton("Salir de la Aplicación");
        salir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        salir.setPreferredSize(new Dimension(180, 40));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));

        continuar.addActionListener(e -> base.cambiarVista("MENU"));
        salir.addActionListener(e -> System.exit(0));

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new BoxLayout(botonesPanel, BoxLayout.Y_AXIS));
        botonesPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        continuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        salir.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonesPanel.add(continuar);
        botonesPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        botonesPanel.add(salir);

        add(tituloPanel, BorderLayout.CENTER);
        add(botonesPanel, BorderLayout.SOUTH);

        setBackground(new Color(240, 248, 255));
        setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
    }

}
