package Controlador;

import Vista.*;
import Modelo.*;
import java.util.*;

public class ControladorPlanesEstudiantiles {

    Cliente est;
    FacturaDAO fdao;
    ClienteDAO cdao;
    PlanesDAO pdao;
    VistaMensajesUsuario vmu;

    public ControladorPlanesEstudiantiles() {
        cdao = new ClienteDAO();
        fdao = new FacturaDAO();
        pdao = new PlanesDAO();
        vmu = new VistaMensajesUsuario();
    }

    public void nuevoEstudiante(Cliente c, List<PlanPostPago> planes) {
        if (!cdao.Buscar(c.getCedula())) {
            est = c;
            est.setPlanesActivos(planes.size());
            est.setPlan(planes);
            cdao.insertar(est);
            if (planes.size() == 2) {
                pdao.insertar(planes.get(0), est.getCedula());
                pdao.insertar(planes.get(1), est.getCedula());
            } else {
                pdao.insertar(planes.get(0), est.getCedula());
            }
            vmu.informacion("Estudiante Agregado Correctamente");

        } else {
            vmu.advertencias("Ya existe un Estudiante registrado con esa cedula");
        }

    }

    public void nuevoPlan(PlanPostPago ppp, String cedula) {
        List<PlanPostPago> planuevo = new ArrayList<>();
        est = cdao.estudiante(cedula);
        if (est.getPlanesActivos() == 2) {
            vmu.error("Esta persona ya tiene la cantidad maxima de planes, elimine uno para agregar uno nuevo");
        } else {
            planuevo = est.getPlan();
            planuevo.add(ppp);
            est.setPlan(planuevo);
            pdao.insertar(ppp, cedula);
            vmu.informacion("Plan Asignado con exito");
        }
    }

    public void eliminarPlan(String nombrePlan, String cedula) {
        est = cdao.estudiante(cedula);
        if (est.getPlanesActivos() == 0) {
            vmu.advertencias("No se puede eliminar ya que esta persona no tiene planes..");
        } else {
            for (int i = 0; i < 2; i++) {
                if (est.getPlan().get(i).getNombrePlan().equals(nombrePlan)) {
                    pdao.eliminar(cedula, nombrePlan);
                    fdao.eliminar(cedula, nombrePlan);
                    vmu.informacion("Estudiante Eliminado con exito");
                } else {
                    vmu.advertencias("El estudiante no cuenta con nigun plan con ese nombre");
                }
            }
        }

    }

    public void reemplazarPlan(String cedula, String nomPElim, PlanPostPago ppp) {
        if (cdao.Buscar(cedula)) {
            eliminarPlan(nomPElim, cedula);
            nuevoPlan(ppp, cedula);
        } else {
            vmu.advertencias("No existe un Estudiante registrado con esa cedula");
        }
    }

    public void mostrarEstudiantes() {

    }

    public void mostrarPlanesdEstudiante() {

    }

    public void actualizarEstudiante(String cedula, Cliente c) {
        if (cdao.Buscar(c.getCedula())) {
            est = cdao.estudiante(cedula);
            c.setCedula(est.getCedula());
            cdao.actualizar(c);
        } else {
            System.out.println("Este Estudiante no existe");
        }
    }

    public void mostrarFactura() {
        double subtotal;
        /*
        if (persona.planesActivos == 2) {
            subtotal = persona.plan[0].calcularPagoMensaul() + persona.plan[1].calcularPagoMensaul();
            factura = new Factura(persona, subtotal);
        } else if (persona.planesActivos == 1) {
            subtotal = persona.plan[0].calcularPagoMensaul();
            factura = new Factura(persona, subtotal);
        } else {
            System.out.println("Esta persona no tiene planes asociados aun....");
        }
        //mostar en pantalla la factura
        System.out.println(factura);
        //guardar la factura en base de datos;
        //bd.guardar(factura);
         */
    }
}
