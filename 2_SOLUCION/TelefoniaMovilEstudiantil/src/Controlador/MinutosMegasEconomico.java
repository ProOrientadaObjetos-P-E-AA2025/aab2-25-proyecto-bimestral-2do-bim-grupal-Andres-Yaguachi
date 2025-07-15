package Controlador;

public class MinutosMegasEconomico extends MinutosMegas {

    protected int porcDesc;

    public MinutosMegasEconomico(int porcDesc, int minutos, double costoMin, int gigas, double costGiga) {
        super(minutos, costoMin, gigas, costGiga);
        this.porcDesc = porcDesc;
    }

}
