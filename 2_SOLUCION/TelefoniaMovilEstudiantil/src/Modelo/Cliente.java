package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    protected String nombre;
    protected String apellido;
    protected String ci_pas;
    protected String ciudad;
    protected String email;
    protected long numCelular;
    protected List<PlanPostPago> plan;
    protected int planesActivos;
    protected double pagoMensual;

    public Cliente() {
        this.planesActivos = 0;
        plan = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCi_pas() {
        return ci_pas;
    }

    public void setCi_pas(String ci_pas) {
        this.ci_pas = ci_pas;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(long numCelular) {
        this.numCelular = numCelular;
    }

    public List<PlanPostPago> getPlan() {
        return plan;
    }

    public void setPlan(List<PlanPostPago> p) {
        plan = p;
    }

    public int getPlanesActivos() {
        return planesActivos;
    }

    public void setPlanesActivos(int planesActivos) {
        this.planesActivos = planesActivos;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

}
