package Controlador;

public class Factura {

    Cliente persona;
    double subtotal;
    double total;
    double iva;

    public Factura(Cliente persona, double subtotal) {
        this.persona = persona;
        this.subtotal = subtotal;
        this.iva = 15;
    }

    public void calculartotal() {
        total = subtotal * ((iva / 100) + 1);
    }
}
