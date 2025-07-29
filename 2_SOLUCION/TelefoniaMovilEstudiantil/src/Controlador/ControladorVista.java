package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class ControladorVista {

    ControladorPlanesEstudiantiles cpe;
    VistaPrincipal vp;

    public ControladorVista() {
        cpe = new ControladorPlanesEstudiantiles();
    }

    public void setVp(VistaPrincipal vp) {
        this.vp = vp;
    }

    public void nuevoEstudiante(Cliente c, List<PlanPostPago> planes) {
        cpe.nuevoEstudiante(c, planes);
    }

    public void nuevoPlan(PlanPostPago ppp, String cedula) {
        cpe.nuevoPlan(ppp, cedula);
    }

    public void eliminarEstudiante(String cedula) {
        cpe.eliminarEstudiante(cedula);
    }

    public void eliminarPlan(String nombrePlan, String cedula) {
        cpe.eliminarPlan(nombrePlan, cedula);
    }

    public void reemplazarPlan(String cedula, String nomPElim, PlanPostPago ppp) {
        cpe.reemplazarPlan(cedula, nomPElim, ppp);
    }

    public void actualizarEstudiante(String cedula, Cliente c) {
        cpe.actualizarEstudiante(cedula, c);
    }

    public void mostrarFacturas() {
        List<Factura> facturas = cpe.mostrarFacturas();
        VistaFacturasTodas vft = new VistaFacturasTodas(vp, facturas);
        mostrarComoDialogo(vp, vft, "Listado de facturas");
    }

    public void mostrarFacturasIndividuales(String cedula) {
        List<Factura> facturas = cpe.mostrarFacturaIndividual(cedula);
        Cliente est = cpe.estudiante(cedula);
        VistaFacturaPersona vfp = new VistaFacturaPersona(vp, facturas.get(0), est);
        mostrarComoDialogo(vp, vfp, "Facturas Individuales");
    }

    public void mostrarEstudiantes() {
        List<Cliente> estudiantes = cpe.listarEstudiantes();
        VistaMostrarEstudiantes vme = new VistaMostrarEstudiantes(estudiantes, vp);
        mostrarComoDialogo(vp, vme, "Listado de Estudiantes");

    }

    public void mostrarPlanes(String cedula) {
        List<PlanPostPago> planes = cpe.listarPlanes(cedula);
        Cliente es = cpe.cdao.estudiante(cedula);
        es.setPlan(planes);
        VistaPlanesPEstudiantes vppe = new VistaPlanesPEstudiantes(vp, es, es.getPlan());
        mostrarComoDialogo(vp, vppe, "Listado de Planes");
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
