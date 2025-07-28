package Vista;

import Modelo.*;
import java.awt.*;
import javax.swing.*;

public class VistaFacturaPersona extends JPanel {

    public VistaFacturaPersona(Factura factura, Cliente estudiante) {
        setLayout(new GridLayout(0, 1, 5, 5));
        add(new JLabel("FACTURA N° " + factura.getNumFactura()));
        add(new JLabel("Cliente: " + estudiante.getNombre() + " " + estudiante.getApellido()));
        add(new JLabel("Cédula: " + factura.getCedula()));
        add(new JLabel("Email: " + estudiante.getEmail()));
        add(new JLabel("Teléfono: " + estudiante.getNumCelular()));
        add(new JLabel("--------------------------------------------"));

        add(new JLabel("Plan Contratado: " + factura.getPlan()));
        add(new JLabel("Categoría del Plan: " + factura.getCategoriaPlan()));

        add(new JLabel("--------------------------------------------"));
        add(new JLabel(String.format("Subtotal: $%.2f", factura.getSubtotal())));
        add(new JLabel(String.format("IVA (12%%): $%.2f", factura.getIva())));
        add(new JLabel(String.format("Total a Pagar: $%.2f", factura.getTotal())));

    }
}
