package Controlador;

import Modelo.*;

public class AsignadorPlanes {

    public PlanPostPago Asignar(String tipo, String categoria) {
        PlanPostPago p;
        switch (tipo) {
            case "Megas":
                p = AsignadorMegas(categoria);
                break;
            case "Minutos":
                p = AsignadorMinutos(categoria);
                break;
            case "MinutosMegas":
                p = AsignadorMinutosMegas(categoria);
                break;
            default:
                p = AsignadorMinutosMegasEconomico(categoria);
                break;
        }
        return p;
    }

    private Megas AsignadorMegas(String categoria) {
        Megas m = new Megas();
        m.setCategoriaPlan(categoria);
        m.setNombrePlan("Megas");
        switch (categoria) {
            case "Economica" -> {
                m.setTarifaBase(10);
                m.setGigas(5);
                m.setCostGiga(1.1);
            }
            case "Balanceada" -> {
                m.setTarifaBase(11);
                m.setGigas(10);
                m.setCostGiga(1);
            }
            case "Premium" -> {
                m.setTarifaBase(12);
                m.setGigas(20);
                m.setCostGiga(0.9);
            }
        }
        m.calcularPagoMensaul();
        return m;
    }

    private Minutos AsignadorMinutos(String categoria) {
        Minutos m = new Minutos();
        m.setCategoriaPlan(categoria);
        m.setNombrePlan("Minutos");
        m.setCostoMinInter(0.14);
        switch (categoria) {
            case "Economica" -> {
                m.setMinutosNacio(50);
                m.setCostoMinNac(0.05);
                m.setMinutosInterNa(20);
            }
            case "Balanceada" -> {
                m.setMinutosNacio(100);
                m.setCostoMinNac(0.04);
                m.setMinutosInterNa(40);
            }
            case "Premium" -> {
                m.setMinutosNacio(200);
                m.setCostoMinNac(0.04);
                m.setMinutosInterNa(60);
            }
        }
        m.calcularPagoMensaul();
        return m;
    }

    private MinutosMegas AsignadorMinutosMegas(String categoria) {
        MinutosMegas mm = new MinutosMegas();
        mm.setCategoriaPlan(categoria);
        mm.setNombrePlan("MinutosMegas");
        switch (categoria) {
            case "Economica" -> {
                mm.setGigas(5);
                mm.setCostGiga(0.8);
                mm.setMinutos(40);
                mm.setCostoMin(0.05);
            }
            case "Balanceada" -> {
                mm.setGigas(10);
                mm.setCostGiga(0.9);
                mm.setMinutos(50);
                mm.setCostoMin(0.04);
            }
            case "Premium" -> {
                mm.setGigas(20);
                mm.setCostGiga(0.8);
                mm.setMinutos(80);
                mm.setCostoMin(0.04);
            }
        }
        mm.calcularPagoMensaul();
        return mm;
    }

    private MinutosMegasEconomico AsignadorMinutosMegasEconomico(String categoria) {
        MinutosMegasEconomico mme = new MinutosMegasEconomico();
        mme.setCategoriaPlan(categoria);
        mme.setNombrePlan("MinutosMegasEconomico");
        switch (categoria) {
            case "Economica" -> {
                mme.setGigas(4);
                mme.setCostGiga(0.81);
                mme.setMinutos(30);
                mme.setCostoMin(0.051);
                mme.setPorcDesc(10);
            }
            case "Balanceada" -> {
                mme.setGigas(8);
                mme.setCostGiga(0.99);
                mme.setMinutos(40);
                mme.setCostoMin(0.045);
                mme.setPorcDesc(12);
            }
            case "Premium" -> {
                mme.setGigas(16);
                mme.setCostGiga(0.9);
                mme.setMinutos(60);
                mme.setCostoMin(0.05);
                mme.setPorcDesc(15);
            }
        }
        mme.calcularPagoMensaul();
        return mme;
    }

}
