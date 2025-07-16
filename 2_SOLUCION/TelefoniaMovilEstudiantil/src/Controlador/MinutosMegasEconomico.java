package Controlador;

public class MinutosMegasEconomico extends PlanPostPago {

    protected int porcDesc;
    protected int minutos;
    protected double costoMin;
    protected int gigas;
    protected double costGiga;

    public MinutosMegasEconomico(int porcDesc, int minutos, double costoMin, int gigas, double costGiga, String nombrePlan) {
        super(nombrePlan);
        this.porcDesc = porcDesc;
        this.minutos = minutos;
        this.costoMin = costoMin;
        this.gigas = gigas;
        this.costGiga = costGiga;

    }

    @Override
    public double calcularPagoMensaul() {
        double subtotal = ((minutos * costoMin) + (gigas * costGiga));
        double descuento = ((porcDesc / 100) + 1);
        return subtotal + (subtotal * descuento);
    }

}
