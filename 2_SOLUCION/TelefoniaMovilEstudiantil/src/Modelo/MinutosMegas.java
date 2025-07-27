package Modelo;

public class MinutosMegas extends PlanPostPago {

    protected int minutos;
    protected double costoMin;
    protected int gigas;
    protected double costGiga;

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public double getCostoMin() {
        return costoMin;
    }

    public void setCostoMin(double costoMin) {
        this.costoMin = costoMin;
    }

    public int getGigas() {
        return gigas;
    }

    public void setGigas(int gigas) {
        this.gigas = gigas;
    }

    public double getCostGiga() {
        return costGiga;
    }

    public void setCostGiga(double costGiga) {
        this.costGiga = costGiga;
    }

    @Override
    public void calcularPagoMensaul() {
        pagoMensual = ((minutos * costoMin) + (gigas * costGiga));
    }

}
