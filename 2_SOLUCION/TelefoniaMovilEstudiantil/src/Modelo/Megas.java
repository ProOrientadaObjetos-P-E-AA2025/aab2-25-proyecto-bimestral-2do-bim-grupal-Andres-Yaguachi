package Modelo;

public class Megas extends PlanPostPago {

    protected int gigas;
    protected double costGiga;
    protected double tarifaBase;

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

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
    

    @Override
    public void calcularPagoMensaul() {
        pagoMensual = ((gigas * costGiga) + tarifaBase);
    }
}
