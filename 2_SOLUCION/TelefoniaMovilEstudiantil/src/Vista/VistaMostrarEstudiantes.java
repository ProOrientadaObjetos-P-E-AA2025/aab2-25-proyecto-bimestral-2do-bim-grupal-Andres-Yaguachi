package Vista;

import Modelo.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class VistaMostrarEstudiantes extends JPanel {

    public VistaMostrarEstudiantes(List<Cliente> estudiantes, VistaPrincipal base) {
        setLayout(new BorderLayout());

        String[] columnas = {"Nombre", "Apellido", "Cedula", "Ciudad", "Email", "Celular", "Planes Activos", "Pago Mensual"};
        Object[][] datos = new Object[estudiantes.size()][columnas.length];

        for (int i = 0; i < estudiantes.size(); i++) {
            Cliente c = estudiantes.get(i);
            datos[i] = new Object[]{
                c.getNombre(), c.getApellido(), c.getCedula(),
                c.getCiudad(), c.getEmail(), c.getNumCelular(),
                c.getPlanesActivos(), c.getPagoMensual()
            };
        }

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
    }

}
