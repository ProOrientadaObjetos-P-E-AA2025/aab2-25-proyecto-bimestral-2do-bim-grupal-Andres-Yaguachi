package Controlador;

public class Megas extends PlanPostPago {

    protected int gigas;
    protected double costGiga;
    protected double tarifaBase;

    public Megas(int gigas, double costGiga, double tarifaBase, String nombrePlan) {
        super(nombrePlan);
        this.gigas = gigas;
        this.costGiga = costGiga;
        this.tarifaBase = tarifaBase;

    }

    @Override
    public double calcularPagoMensaul() {
        return ((gigas * costGiga) + tarifaBase);
    }
}
