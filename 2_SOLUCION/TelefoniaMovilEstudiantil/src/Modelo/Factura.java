package Modelo;

import Controlador.AsignadorPlanes;

public class Factura {

    protected String cedula;
    protected String plan;
    protected String categoriaPlan;
    protected long numFactura;
    protected double subtotal;
    protected double total;
    protected double iva;

    public Factura() {
        this.iva = 15;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getCategoriaPlan() {
        return categoriaPlan;
    }

    public void setCategoriaPlan(String categoriaPlan) {
        this.categoriaPlan = categoriaPlan;
    }

    public long getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(long numFactura) {
        this.numFactura = numFactura;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void calcularSubtotal() {
        AsignadorPlanes ap = new AsignadorPlanes();
        PlanPostPago p;
        p = ap.Asignar(plan, categoriaPlan);
        subtotal = p.getpagoMensual();
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void calculartotal() {
        total = subtotal * ((iva / 100) + 1);
    }

}
