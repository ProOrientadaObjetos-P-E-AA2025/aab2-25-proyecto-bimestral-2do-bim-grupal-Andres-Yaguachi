package Controlador;

public class MinutosMegas extends PlanPostPago {

    protected int minutos;
    protected double costoMin;
    protected int gigas;
    protected double costGiga;

    public MinutosMegas(int minutos, double costoMin, int gigas, double costGiga, String nombrePlan) {
        super(nombrePlan);
        this.minutos = minutos;
        this.costoMin = costoMin;
        this.gigas = gigas;
        this.costGiga = costGiga;

    }

    @Override
    public double calcularPagoMensaul() {
        return ((minutos * costoMin) + (gigas * costGiga));
    }

}
