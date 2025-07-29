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
        double pMen = 0;
        Factura f = new Factura();
        if (!cdao.Buscar(c.getCedula())) {
            est = c;
            est.setPlanesActivos(planes.size());
            est.setPlan(planes);
            for (int i = 0; i < planes.size(); i++) {
                pMen += planes.get(i).getpagoMensual();
            }
            est.setPagoMensual(pMen);

            if (planes.size() == 2) {
                pdao.insertar(planes.get(0), est.getCedula());
                f.setCedula(est.getCedula());
                f.setPlan(planes.get(0).getNombrePlan());
                f.setCategoriaPlan(planes.get(0).getCategoriaPlan());
                f.setSubtotal(planes.get(0).getpagoMensual());
                f.calcularIva();
                f.calculartotal();
                f.setNumFactura(fdao.numeroFactura());
                fdao.insertar(f);
                pdao.insertar(planes.get(1), est.getCedula());
                f.setCedula(est.getCedula());
                f.setPlan(planes.get(1).getNombrePlan());
                f.setCategoriaPlan(planes.get(1).getCategoriaPlan());
                f.setSubtotal(planes.get(1).getpagoMensual());
                f.calcularIva();
                f.calculartotal();
                f.setNumFactura(fdao.numeroFactura());
                fdao.insertar(f);
            } else {
                pdao.insertar(planes.get(0), est.getCedula());
                f.setCedula(est.getCedula());
                f.setPlan(planes.get(0).getNombrePlan());
                f.setCategoriaPlan(planes.get(0).getCategoriaPlan());
                f.setSubtotal(planes.get(0).getpagoMensual());
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
        Factura f = new Factura();
        List<PlanPostPago> planuevo = new ArrayList<>();
        est = cdao.estudiante(cedula);
        est.setPlan(pdao.listarPlanes(cedula));
        if (est == null) {
            vmu.error("Esta persona no se encuentra registrada....");
        } else if (est.getPlanesActivos() == 2) {
            vmu.error("Esta persona ya tiene la cantidad maxima de planes, elimine uno para agregar uno nuevo");
        } else if (repetido(cedula, ppp.getNombrePlan(), ppp.getCategoriaPlan())) {
            vmu.error("Esta persona ya tiene ese metodo, escoga uno distinto");
        } else {
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

    public void eliminarPlan(String nombrePlan, String cedula) {
        est = cdao.estudiante(cedula);
        est.setPlan(pdao.listarPlanes(cedula));
        if (est.getPlanesActivos() == 0) {
            vmu.advertencias("No se puede eliminar ya que esta persona no tiene planes..");
        } else {
            for (int i = 0; i < 2; i++) {
                if (est.getPlan().get(i).getNombrePlan().equals(nombrePlan)) {
                    pdao.eliminar(cedula, nombrePlan);
                    fdao.eliminar(cedula, nombrePlan);
                    cdao.actualizar(est);
                    vmu.informacion("Plan de Estudiante Eliminado con exito");
                } else {
                    vmu.advertencias("El estudiante no cuenta con nigun plan con ese nombre");
                }
            }
        }

    }

    public void eliminarEstudiante(String cedula) {
        est = cdao.estudiante(cedula);
        est.setPlan(pdao.listarPlanes(cedula));
        if (est != null) {
            if (!est.getPlan().isEmpty()) {
                if (est.getPlan().size() == 2) {
                    fdao.eliminar(cedula, est.getPlan().get(0).getNombrePlan());
                    eliminarPlan(est.getPlan().get(0).getNombrePlan(), est.getCedula());
                    fdao.eliminar(cedula, est.getPlan().get(1).getNombrePlan());
                    eliminarPlan(est.getPlan().get(1).getNombrePlan(), est.getCedula());
                } else {
                    fdao.eliminar(cedula, est.getPlan().get(0).getNombrePlan());
                    eliminarPlan(est.getPlan().get(0).getNombrePlan(), est.getCedula());
                }
                cdao.eliminar(cedula);
            } else {
                vmu.error("Este usuario no cuenta con planes activos");
            }
        } else {
            vmu.error("No se encontro una Persona con esta Cedula");
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

    public void actualizarEstudiante(String cedula, Cliente c) {
        if (cdao.Buscar(c.getCedula())) {
            est = cdao.estudiante(cedula);
            c.setCedula(est.getCedula());
            cdao.actualizar(c);
        } else {
            vmu.error("Este Estudiante no existe");
        }
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
