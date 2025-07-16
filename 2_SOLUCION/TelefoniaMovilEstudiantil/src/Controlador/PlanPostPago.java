package Controlador;

public abstract class PlanPostPago {

    String nombrePlan;

    public PlanPostPago(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public abstract double calcularPagoMensaul();
}
