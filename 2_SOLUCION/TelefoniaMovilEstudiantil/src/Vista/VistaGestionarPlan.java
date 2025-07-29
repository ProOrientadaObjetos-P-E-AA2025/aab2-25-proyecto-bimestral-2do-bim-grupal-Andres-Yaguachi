package Vista;

import Controlador.*;
import Modelo.PlanPostPago;
import java.awt.*;
import javax.swing.*;

public class VistaGestionarPlan extends JPanel {

    public VistaGestionarPlan(VistaPrincipal base, ControladorVista cv) {
        setLayout(new BorderLayout(10, 10));
        JLabel titulo = new JLabel("Gestionar Planes", SwingConstants.CENTER);
        JButton insertarPlan = new JButton("Insertar Plan");
        JButton eliminarPlan = new JButton("Eliminar Plan");
        JButton remplazarPlan = new JButton("Remplazar Plan");
        JButton listarPlan = new JButton("Listar Planes por Estudiante");

        insertarPlan.addActionListener(e -> {
            VistaIngresoCedula ci = new VistaIngresoCedula(base);
            VistaIngresoPlanes vip = new VistaIngresoPlanes(base);
            mostrarComoDialogo(this, vip, "Ingreso de Plan");
            cv.nuevoPlan(vip.getPPP(), ci.mostrarYObtenerCedula());
        });

        eliminarPlan.addActionListener(e -> {
            VistaIngresoCedula ci = new VistaIngresoCedula(base);
            VistaIngresoPlanes vip = new VistaIngresoPlanes(base);
            mostrarComoDialogo(this, vip, "Ingreso de Plan");
            cv.eliminarPlan(vip.getPPP().getNombrePlan(), ci.mostrarYObtenerCedula());
        });
        remplazarPlan.addActionListener(e -> {
            VistaIngresoCedula ci = new VistaIngresoCedula(base);
            String ced = ci.mostrarYObtenerCedula();
            JOptionPane.showMessageDialog(this,
                    "Ingreso de datos del nuevo plan",
                    "Informacion",
                    JOptionPane.INFORMATION_MESSAGE);

            VistaIngresoPlanes vip = new VistaIngresoPlanes(base);
            mostrarComoDialogo(this, vip, "Ingreso de Plan");
            PlanPostPago p = vip.getPPP();
            JOptionPane.showMessageDialog(this,
                    "Seleccione el nombre del plan a remplazar",
                    "Informacion",
                    JOptionPane.INFORMATION_MESSAGE);

            VistaIngresoPlanes rem = new VistaIngresoPlanes(base);
            mostrarComoDialogo(this, rem, "Ingreso de Plan");
            String viejo = rem.getPPP().getNombrePlan();
            cv.reemplazarPlan(ced, viejo, p);
        });
        listarPlan.addActionListener(e -> {
            VistaIngresoCedula ci = new VistaIngresoCedula(base);
            String ced = ci.mostrarYObtenerCedula();
            cv.mostrarPlanes(ced);
        });

        JPanel botones = new JPanel(new GridLayout(4, 1, 10, 10));
        botones.add(insertarPlan);
        botones.add(eliminarPlan);
        botones.add(remplazarPlan);
        botones.add(listarPlan);

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
