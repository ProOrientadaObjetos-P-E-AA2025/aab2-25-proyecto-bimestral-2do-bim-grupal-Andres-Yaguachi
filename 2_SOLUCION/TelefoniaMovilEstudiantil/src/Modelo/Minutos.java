package Modelo;

public class Minutos extends PlanPostPago {

    protected int minutosNacio;
    protected double costoMinNac;
    protected int minutosInterNa;
    protected double costoMinInter;

    public int getMinutosNacio() {
        return minutosNacio;
    }

    public void setMinutosNacio(int minutosNacio) {
        this.minutosNacio = minutosNacio;
    }

    public double getCostoMinNac() {
        return costoMinNac;
    }

    public void setCostoMinNac(double costoMinNac) {
        this.costoMinNac = costoMinNac;
    }

    public int getMinutosInterNa() {
        return minutosInterNa;
    }

    public void setMinutosInterNa(int minutosInterNa) {
        this.minutosInterNa = minutosInterNa;
    }

    public double getCostoMinInter() {
        return costoMinInter;
    }

    public void setCostoMinInter(double costoMinInter) {
        this.costoMinInter = costoMinInter;
    }

    @Override
    public void calcularPagoMensaul() {
        pagoMensual = ((costoMinNac * minutosNacio) + (costoMinInter * minutosInterNa));
    }
}
