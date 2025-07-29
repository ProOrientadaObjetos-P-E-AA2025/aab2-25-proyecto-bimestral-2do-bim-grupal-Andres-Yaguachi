package Controlador;

import Vista.*;
import Modelo.*;
import java.util.*;

public class ControladorPlanesEstudiantiles {

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
        Cliente est;
        double pMen = 0;
        if (!cdao.Buscar(c.getCedula())) {
            est = c;
            est.setPlanesActivos(planes.size());
            est.setPlan(planes);
            for (int i = 0; i < planes.size(); i++) {
                pMen += planes.get(i).getpagoMensual();
            }
            est.setPagoMensual(pMen);
            for (PlanPostPago plan : planes) {
                Factura f = new Factura();
                pdao.insertar(plan, est.getCedula());
                f.setCedula(est.getCedula());
                f.setPlan(plan.getNombrePlan());
                f.setCategoriaPlan(plan.getCategoriaPlan());
                f.setSubtotal(plan.getpagoMensual());
                f.calcularIva();
                f.calculartotal();
                f.setNumFactura(fdao.numeroFactura());
                fdao.insertar(f);
            }

            cdao.insertar(est);
            vmu.informacion("Estudiante Agregado Correctamente");

        } else {
            vmu.advertencias("Ya existe un Estudiante registrado con esa cedula");
        }

    }

    public void nuevoPlan(PlanPostPago ppp, String cedula) {
        Cliente est;
        Factura f = new Factura();
        List<PlanPostPago> planuevo = new ArrayList<>();
        est = cdao.estudiante(cedula);
        if (est == null) {
            vmu.error("Esta persona no se encuentra registrada....");
        } else if (est.getPlanesActivos() == 2) {
            vmu.error("Esta persona ya tiene la cantidad maxima de planes, elimine uno para agregar uno nuevo");
        } else if (repetido(cedula, ppp.getNombrePlan(), ppp.getCategoriaPlan())) {
            vmu.error("Esta persona ya tiene ese metodo, escoga uno distinto");
        } else {
            est.setPlan(pdao.listarPlanes(cedula));
            est.setPlanesActivos(est.getPlanesActivos() + 1);
            planuevo = est.getPlan();
            planuevo.add(ppp);
            est.setPlan(planuevo);
            pdao.insertar(ppp, cedula);
            f.setCedula(est.getCedula());
            f.setPlan(ppp.getNombrePlan());
            f.setCategoriaPlan(ppp.getCategoriaPlan());
            f.setSubtotal(ppp.getpagoMensual());
            f.calcularIva();
            f.calculartotal();
            f.setNumFactura(fdao.numeroFactura());
            fdao.insertar(f);
            cdao.actualizar(est);
            vmu.informacion("Plan Asignado con exito");
        }
    }

    public void eliminarPlan(String nombrePlan, String catPlan, String cedula) {
        Cliente est;
        est = cdao.estudiante(cedula);
        est.setPlan(pdao.listarPlanes(cedula));
        est.setPlanesActivos(est.getPlan().size());
        if (est.getPlanesActivos() == 0) {
            vmu.advertencias("No se puede eliminar ya que esta persona no tiene planes..");
        } else {
            boolean encontrado = false;
            for (PlanPostPago plan : est.getPlan()) {
                if (plan.getNombrePlan().equals(nombrePlan)) {
                    pdao.eliminar(cedula, nombrePlan, catPlan);
                    fdao.eliminar(cedula, nombrePlan);
                    cdao.actualizar(est);
                    vmu.informacion("Plan eliminado correctamente.");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                vmu.advertencias("El estudiante no cuenta con ningún plan con ese nombre.");
            }

        }

    }

    public void eliminarEstudiante(String cedula) {
        Cliente est;
        est = cdao.estudiante(cedula);
        est.setPlan(pdao.listarPlanes(cedula));
        if (est != null) {
            if (!est.getPlan().isEmpty()) {
                if (est.getPlan().size() == 2) {
                    fdao.eliminar(cedula, est.getPlan().get(0).getNombrePlan());
                    eliminarPlan(est.getPlan().get(0).getNombrePlan(), est.getPlan().get(0).getCategoriaPlan(), est.getCedula());
                    fdao.eliminar(cedula, est.getPlan().get(1).getNombrePlan());
                    eliminarPlan(est.getPlan().get(1).getNombrePlan(), est.getPlan().get(1).getCategoriaPlan(), est.getCedula());
                } else {
                    fdao.eliminar(cedula, est.getPlan().get(0).getNombrePlan());
                    eliminarPlan(est.getPlan().get(0).getNombrePlan(), est.getPlan().get(0).getCategoriaPlan(), est.getCedula());
                }
                cdao.eliminar(cedula);
            } else {
                vmu.error("Este usuario no cuenta con planes activos");
            }
        } else {
            vmu.error("No se encontro una Persona con esta Cedula");
        }

    }

    public void reemplazarPlan(String cedula, String nombrePlanAEliminar, String categoriaPlanAEliminar, PlanPostPago nuevoPlan) {
        Cliente estudiante = cdao.estudiante(cedula);
        if (estudiante == null) {
            vmu.advertencias("No existe un estudiante registrado con la cédula: " + cedula);
            return;
        }
        eliminarPlan(nombrePlanAEliminar, categoriaPlanAEliminar, cedula);
        nuevoPlan(nuevoPlan, cedula);
    }

    public void actualizarEstudiante(String cedulaParaBuscar, Cliente datosActualizados) {
        Cliente estudianteExistente = cdao.estudiante(cedulaParaBuscar);
        if (estudianteExistente == null) {
            vmu.error("No se encontró un estudiante con la cédula: " + cedulaParaBuscar);
            return;
        }
        datosActualizados.setCedula(cedulaParaBuscar);
        cdao.actualizar(datosActualizados);
        vmu.informacion("Estudiantes actualizado correctamente.");
    }

    public List<Cliente> listarEstudiantes() {
        return cdao.listar();
    }

    public List<PlanPostPago> listarPlanes(String cedula) {
        return pdao.listarPlanes(cedula);
    }

    public List<Factura> mostrarFacturas() {
        return fdao.listarTodas();
    }

    public List<Factura> mostrarFacturaIndividual(String cedula) {
        return fdao.listarIndividual(cedula);
    }

    public Cliente estudiante(String cedula) {
        Cliente est;
        est = cdao.estudiante(cedula);
        return est;
    }

    public boolean repetido(String cedula, String tipoPlan, String catPlan) {
        List<PlanPostPago> lista = listarPlanes(cedula);
        boolean repetido = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombrePlan().equals(tipoPlan) && lista.get(i).getCategoriaPlan().equals(catPlan)) {
                repetido = true;
            }
        }
        return repetido;
    }
}
