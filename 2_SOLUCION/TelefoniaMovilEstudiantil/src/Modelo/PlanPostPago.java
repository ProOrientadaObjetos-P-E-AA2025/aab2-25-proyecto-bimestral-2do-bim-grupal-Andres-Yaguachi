package Modelo;

public abstract class PlanPostPago {

    protected String nombrePlan;
    protected double pagoMensual;
    protected String categoriaPlan;

    public String getCategoriaPlan() {
        return categoriaPlan;
    }

    public void setCategoriaPlan(String categoriaPlan) {
        this.categoriaPlan = categoriaPlan;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public double getpagoMensual() {
        return pagoMensual;
    }

    public abstract void calcularPagoMensaul();
}
