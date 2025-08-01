package Vista;

import Controlador.*;
import Modelo.PlanPostPago;
import java.awt.*;
import javax.swing.*;

public class VistaGestionarPlan extends JPanel {

    VistaMensajesUsuario vmu;

    public VistaGestionarPlan(VistaPrincipal base, ControladorVista cv) {
        setLayout(new BorderLayout(10, 10));
        vmu = new VistaMensajesUsuario();
        JLabel titulo = new JLabel("Gestionar Planes", SwingConstants.CENTER);
        JButton insertarPlan = new JButton("Insertar Plan");
        JButton eliminarPlan = new JButton("Eliminar Plan");
        JButton remplazarPlan = new JButton("Remplazar Plan");
        JButton listarPlan = new JButton("Listar Planes por Estudiante");
        JButton btnVolver = new JButton("Volver");

        insertarPlan.addActionListener(e -> {
            VistaIngresoCedula ci = new VistaIngresoCedula(base);
            String cedula = ci.mostrarYObtenerCedula();
            if (cedula == null) {
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
            cv.nuevoPlan(p, cedula);
        });

        eliminarPlan.addActionListener(e -> {
            VistaIngresoCedula ci = new VistaIngresoCedula(base);
            String cedula = ci.mostrarYObtenerCedula();
            if (cedula == null) {
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
            cv.eliminarPlan(p.getNombrePlan(), p.getCategoriaPlan(), cedula);
        });

        remplazarPlan.addActionListener(e -> {
            VistaIngresoCedula ci = new VistaIngresoCedula(base);
            String cedula = ci.mostrarYObtenerCedula();
            if (cedula == null) {
                vmu.error("Cédula inválida o ingreso cancelado.");
                return;
            }
            JOptionPane.showMessageDialog(this,
                    "Ingreso de datos del Nuevo plan",
                    "Informacion",
                    JOptionPane.INFORMATION_MESSAGE);

            VistaIngresoPlanes vip = new VistaIngresoPlanes(base);
            mostrarComoDialogo(this, vip, "Ingreso de Plan");
            PlanPostPago p = vip.getPPP();
            if (p == null) {
                vmu.error("Ingreso cancelado.");
                return;
            }
            JOptionPane.showMessageDialog(this,
                    "Seleccione el nombre del plan a remplazar",
                    "Informacion",
                    JOptionPane.INFORMATION_MESSAGE);

            VistaIngresoPlanes rem = new VistaIngresoPlanes(base);
            mostrarComoDialogo(this, rem, "Ingreso de Plan");
            PlanPostPago v = vip.getPPP();
            if (v == null) {
                vmu.error("Ingreso cancelado.");
                return;
            }
            String viejo = v.getNombrePlan();
            cv.reemplazarPlan(cedula, viejo, v.getCategoriaPlan(), p);
        });
        listarPlan.addActionListener(e -> {
            VistaIngresoCedula ci = new VistaIngresoCedula(base);
            String cedula = ci.mostrarYObtenerCedula();
            if (cedula == null) {
                vmu.error("Cédula inválida o ingreso cancelado.");
                return;
            }
            cv.mostrarPlanes(cedula);
        });

        btnVolver.addActionListener(e -> base.cambiarVista("MENU"));

        JPanel botones = new JPanel(new GridLayout(4, 1, 10, 10));
        botones.add(insertarPlan);
        botones.add(eliminarPlan);
        botones.add(remplazarPlan);
        botones.add(listarPlan);

        JPanel footer = new JPanel();
        footer.add(btnVolver);
        add(footer, BorderLayout.SOUTH);
        add(titulo, BorderLayout.NORTH);
        add(botones, BorderLayout.CENTER);

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
