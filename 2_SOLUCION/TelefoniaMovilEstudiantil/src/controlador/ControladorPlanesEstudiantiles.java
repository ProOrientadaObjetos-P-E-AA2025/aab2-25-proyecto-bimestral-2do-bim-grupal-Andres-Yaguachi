package controlador;

import Modelo.Cliente;
import Modelo.Factura;
import Modelo.PlanPostPago;

public class ControladorPlanesEstudiantiles {

    Cliente persona;
    Factura factura;

    public ControladorPlanesEstudiantiles() {
        factura = null;
    }

    public void nuevoUsuario() {
        /*
        //comprobar que en la base de datos no este este id;        
        if (!bd.buscar(persona.ci_pas)) {
            persona = new Cliente();
        }else {
            //esta persona ya existe
        }*/

    }

    public void nuevoPlan(PlanPostPago ppp) {
        //llamara a base de datos y instanciar el objeto persona
        //persona = bd.persona();

        /*verificar si tiene ya un plan si no 
        if(persona.plan[0] != null && persona.plan[1] != null){
            //System.out.println("Esta persona ya tiene la cantidad maxima de planes, elimine uno para agregar uno nuevo");
        } else {
            for (PlanPostPago plan : persona.plan) {
                if (plan == null) {
                    //bd.create();
                    persona.plan[] = ppp;
                }
            }*/
    }

    public void eliminarPlan(String nombrePlan) {
        /*
        if (persona.plan[0] == null && persona.plan[1] == null) {
            System.out.println("No se puede eliminar ya que esta persona no tiene planes..");
        } else {
            for (PlanPostPago plan : persona.plan) {
                if (plan.nombrePlan.equals(nombrePlan)) {
                    //bd.delete();
                }
            }
        }*/

    }

    public void reemplazarPlan() {

    }

    public void generarFactura() {
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
