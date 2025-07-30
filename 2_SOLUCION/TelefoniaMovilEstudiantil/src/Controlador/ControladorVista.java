package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class ControladorVista {
    
    ControladorPlanesEstudiantiles cpe;
    VistaPrincipal vp;
    VistaMensajesUsuario vmu;
    
    public ControladorVista() {
        cpe = new ControladorPlanesEstudiantiles();
        vmu = new VistaMensajesUsuario();
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
    
    public void eliminarPlan(String nombrePlan, String catPlan, String cedula) {
        cpe.eliminarPlan(nombrePlan, catPlan, cedula);
    }
    
    public void reemplazarPlan(String cedula, String nomPElim, String catPlan, PlanPostPago ppp) {
        cpe.reemplazarPlan(cedula, nomPElim, catPlan, ppp);
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
        if (est == null) {
            vmu.error("Estudiante no encontrado con la cédula proporcionada.");
            return;
        }
        
        if (facturas != null && !facturas.isEmpty()) {
            for (Factura factura : facturas) {
                VistaFacturaPersona vfp = new VistaFacturaPersona(vp, factura, est);
                mostrarComoDialogo(vp, vfp, "Factura para " + est.getNombre());
            }
            
        } else {
            vmu.advertencias("No hay facturas para este estudiante.");
        }
        
    }
    
    public void mostrarEstudiantes() {
        List<Cliente> estudiantes = cpe.listarEstudiantes();
        VistaMostrarEstudiantes vme = new VistaMostrarEstudiantes(estudiantes, vp);
        mostrarComoDialogo(vp, vme, "Listado de Estudiantes");
        
    }
    
    public void mostrarPlanes(String cedula) {
        Cliente es = cpe.estudiante(cedula);
        if (es == null) {
            vmu.error("Este estudiante no esta registrado");
            return;
        }
        List<PlanPostPago> planes = cpe.listarPlanes(cedula);
        es.setPlan(planes);
        VistaPlanesPEstudiantes vppe = new VistaPlanesPEstudiantes(vp, es, es.getPlan());
        mostrarComoDialogo(vp, vppe, "Listado de Planes para " + es.getNombre());
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
