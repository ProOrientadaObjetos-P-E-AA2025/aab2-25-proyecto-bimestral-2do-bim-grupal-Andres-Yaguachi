package Vista;

import Modelo.*;
import java.awt.*;
import javax.swing.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VistaFacturasTodas extends JPanel {

    public VistaFacturasTodas(VistaPrincipal base, List<Factura> facturas) {
        setLayout(new BorderLayout());

        String[] columnas = {
            "Cedula", "Plan", "Categoria Plan", "Costo",
            "Subtotal", "IVA", "Total", "N° Factura"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        for (Factura f : facturas) {
            Object[] fila = {
                f.getCedula(),
                f.getPlan(),
                f.getCategoriaPlan(),
                f.getSubtotal(),
                f.getSubtotal(),
                f.getIva(),
                f.getTotal(),
                f.getNumFactura()
            };
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        JLabel titulo = new JLabel("Tabla de Facturas", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        add(titulo, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

}
