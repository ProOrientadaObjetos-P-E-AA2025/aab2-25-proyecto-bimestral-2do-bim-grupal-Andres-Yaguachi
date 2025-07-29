package Vista;

import Modelo.*;
import java.awt.*;
import javax.swing.*;
import java.util.List;

public class VistaPlanesPEstudiantes extends JPanel {

    public VistaPlanesPEstudiantes(VistaPrincipal base, Cliente cliente, List<PlanPostPago> planes) {
        setLayout(new BorderLayout());

        String[] columnas = {"Nombre Plan", "Categoria Plan", "Cedula", "Pago Mensual"};
        Object[][] datos = new Object[planes.size()][columnas.length];

        for (int i = 0; i < planes.size(); i++) {
            PlanPostPago p = planes.get(i);
            datos[i] = new Object[]{
                p.getNombrePlan(), p.getCategoriaPlan(), cliente.getCedula(), p.getpagoMensual()
            };
        }

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);

        JLabel infoCliente = new JLabel("Planes del cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        infoCliente.setHorizontalAlignment(SwingConstants.CENTER);

        add(infoCliente, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

}
