package Controlador;

public class Minutos extends PlanPostPago {

    protected int minutosNacio;
    protected double costoMinNac;
    protected int minutosInterNa;
    protected double costoMinInter;

    public Minutos(int minutosNacio, double costoMinNac, int minutosInterNa, double costoMinInter) {
        this.minutosNacio = minutosNacio;
        this.costoMinNac = costoMinNac;
        this.minutosInterNa = minutosInterNa;
        this.costoMinInter = costoMinInter;
    }

    @Override
    public double calcularPagoMensaul() {
        return ((costoMinNac * minutosNacio) + (costoMinInter * minutosInterNa));
    }
}
