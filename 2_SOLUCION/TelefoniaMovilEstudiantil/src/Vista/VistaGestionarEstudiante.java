package Vista;

import Controlador.*;
import Modelo.Cliente;
import Modelo.PlanPostPago;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class VistaGestionarEstudiante extends JPanel {

    VistaMensajesUsuario vmu;

    public VistaGestionarEstudiante(VistaPrincipal base, ControladorVista cv) {
        setLayout(new BorderLayout(10, 10));
        vmu = new VistaMensajesUsuario();
        JLabel titulo = new JLabel("Gestionar Estudiantes", SwingConstants.CENTER);
        JButton insertarEstudiante = new JButton("Insertar Estudiante");
        JButton eliminarEstudiante = new JButton("Eliminar Estudiante");
        JButton actualizarEstudiante = new JButton("Actualizaar Estudiante");
        JButton listarEstudiantes = new JButton("Listar Estudiantes");
        JButton btnVolver = new JButton("Volver");

        eliminarEstudiante.addActionListener(e -> {
            VistaIngresoCedula ci = new VistaIngresoCedula(base);
            String cedula = ci.mostrarYObtenerCedula();
            if (cedula == null) {
                vmu.error("Cédula inválida o ingreso cancelado.");
                return;
            }
            if (confirmarAccion(this, "¿Desea eliminar al estudiante con cédula " + cedula + "?")) {
                cv.eliminarEstudiante(cedula);
            }
        });

        insertarEstudiante.addActionListener(e -> {
            List<PlanPostPago> lista = new ArrayList<>();

            VistaIngresoEstudiantes datos = new VistaIngresoEstudiantes(base);
            mostrarComoDialogo(this, datos, "Ingreso de Estudiante");
            Cliente c = datos.getEstudiante();
            if (c == null) {
                vmu.error("Cédula inválida o ingreso cancelado.");
                return;
            }

            VistaIngresoPlanes vip = new VistaIngresoPlanes(base);
            mostrarComoDialogo(this, vip, "Ingreso de Plan");
            PlanPostPago p = vip.getPPP();
            if (p == null) {
                vmu.error("Ingreso cancelado.");
                return;
            }

            lista.add(p);

            cv.nuevoEstudiante(c, lista);
        });

        actualizarEstudiante.addActionListener(e -> {
            VistaIngresoCedula ci = new VistaIngresoCedula(base);
            String cedula = ci.mostrarYObtenerCedula();
            if (cedula == null) {
                vmu.error("Cédula inválida o ingreso cancelado.");
                return;
            }
            VistaIngresoEstudiantes datos = new VistaIngresoEstudiantes(base);
            mostrarComoDialogo(this, datos, "Ingreso de Estudiante");
            Cliente c = datos.getEstudiante();
            if (c == null) {
                vmu.error("Cédula inválida o ingreso cancelado.");
                return;
            }
            cv.actualizarEstudiante(cedula, c);

        });

        listarEstudiantes.addActionListener(e -> {
            cv.mostrarEstudiantes();
        });
        btnVolver.addActionListener(e -> base.cambiarVista("MENU"));

        JPanel botones = new JPanel(new GridLayout(4, 1, 10, 10));
        botones.add(insertarEstudiante);
        botones.add(eliminarEstudiante);
        botones.add(actualizarEstudiante);
        botones.add(listarEstudiantes);

        JPanel footer = new JPanel();
        footer.add(btnVolver);
        add(footer, BorderLayout.SOUTH);

        add(titulo, BorderLayout.NORTH);
        add(botones, BorderLayout.CENTER);
    }

    private boolean confirmarAccion(Component parent, String mensaje) {
        int opcion = JOptionPane.showConfirmDialog(
                parent,
                mensaje,
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        return opcion == JOptionPane.YES_OPTION;
    }

    public boolean agregarPlan(Component parent) {
        int opcion = JOptionPane.showConfirmDialog(
                parent,
                "¿Desea ingresar otro plan?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        return opcion == JOptionPane.YES_OPTION;

    }

    public <T extends JPanel> T mostrarComoDialogo(Component parent, T panel, String titulo) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(parent);
        JDialog dialogo = new JDialog(frame, titulo, true);
        dialogo.getContentPane().add(panel);
        dialogo.pack();
        dialogo.setLocationRelativeTo(frame);
        dialogo.setVisible(true);
        return panel;
    }
}
