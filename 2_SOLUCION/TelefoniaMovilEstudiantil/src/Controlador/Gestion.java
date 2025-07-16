package Controlador;

public class Gestion {

    Cliente persona;
    Factura factura;

    public Gestion() {
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
        //verificar si tiene ya un plan si no 
        if (persona.plan[0] == null)) {
            persona.plan[0] = ppp;
        } else if () {
            persona.plan[0] = ppp;
        }
        persona.plan[0] = ppp;
    }

    public void eliminarPlan() {

    }

    public void reemplazarPlan() {

    }

    public void generarFactura() {

    }

}
