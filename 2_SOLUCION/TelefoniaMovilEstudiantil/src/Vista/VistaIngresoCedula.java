package Vista;

import java.awt.*;
import javax.swing.*;

public class VistaIngresoCedula extends JDialog {

    private VistaMensajesUsuario vmu;
    private JTextField campoCedula;
    private String cedulaValidada = null;

    public VistaIngresoCedula(Frame parent) {
        super(parent, "Ingreso de cédula", true);
        setLayout(new BorderLayout());
        vmu = new VistaMensajesUsuario();

        campoCedula = new JTextField(15);
        JButton btnValidar = new JButton("Validar");

        JPanel panelCentro = new JPanel();
        panelCentro.add(new JLabel("Ingrese la cédula:"));
        panelCentro.add(campoCedula);

        add(panelCentro, BorderLayout.CENTER);
        add(btnValidar, BorderLayout.SOUTH);

        btnValidar.addActionListener(e -> {
            String cedula = campoCedula.getText().trim();

            if (cedula.isEmpty()) {
                vmu.advertencias("La cédula es obligatoria.");
                return;
            }

            if (!cedula.matches("\\d{10}")) {
                vmu.error("La cédula debe tener 10 dígitos numéricos.");
                return;
            }

            cedulaValidada = cedula;
            dispose();
        });

        pack();
        setLocationRelativeTo(parent);
    }

    public String mostrarYObtenerCedula() {
        setVisible(true);
        return cedulaValidada;
    }

}
