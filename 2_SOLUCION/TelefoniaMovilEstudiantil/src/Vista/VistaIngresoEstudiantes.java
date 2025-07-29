package Vista;

import Modelo.*;
import java.awt.*;
import javax.swing.*;

public class VistaIngresoEstudiantes extends JPanel {

    private VistaMensajesUsuario vmu;
    private Cliente estu;
    private JTextField nombre;
    private JTextField cedula;
    private JTextField apellido;
    private JTextField ciudad;
    private JTextField email;
    private JTextField numeroCelular;

    private JButton registrar;

    public VistaIngresoEstudiantes(VistaPrincipal base) {
        setPreferredSize(new Dimension(400, 300));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        vmu = new VistaMensajesUsuario();
        nombre = new JTextField();
        cedula = new JTextField();
        apellido = new JTextField();
        ciudad = new JTextField();
        email = new JTextField();
        numeroCelular = new JTextField();

        registrar = new JButton("Registrar");

        registrar.addActionListener(e -> registrarEstudiante());

        JPanel formulario = new JPanel();
        formulario.setLayout(new BoxLayout(formulario, BoxLayout.Y_AXIS));
        formulario.setPreferredSize(new Dimension(600, 400));

        formulario.add(crearCampo("Nombre:", nombre));
        formulario.add(crearCampo("Cedula:", cedula));
        formulario.add(crearCampo("Apellido:", apellido));
        formulario.add(crearCampo("Ciudad:", ciudad));
        formulario.add(crearCampo("Email:", email));
        formulario.add(crearCampo("Numero Celular:", numeroCelular));

        add(formulario, BorderLayout.CENTER);

        JPanel footer = new JPanel();
        footer.add(registrar);
        add(footer, BorderLayout.SOUTH);

    }

    private JPanel crearCampo(String etiqueta, JTextField campo) {
        JPanel fila = new JPanel(new BorderLayout(10, 10));
        JLabel label = new JLabel(etiqueta);
        label.setPreferredSize(new Dimension(120, 30));
        fila.add(label, BorderLayout.WEST);
        fila.add(campo, BorderLayout.CENTER);
        fila.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return fila;
    }

    public void registrarEstudiante() {
        String nom = nombre.getText();
        String ci = cedula.getText();
        String apl = apellido.getText();
        String city = ciudad.getText();
        String eml = email.getText();
        Long numC = Long.parseLong(numeroCelular.getText().trim());
        if (nom.isEmpty() || ci.isEmpty()) {
            vmu.advertencias("Nombre y cedula son campos obligatorios...");
            return;
        }
        if (!ci.matches("\\d+")) {
            vmu.error("La cedula solo admite valores numericos");
            return;
        }
        if (cedula == null) {
            vmu.error("Cédula inválida o ingreso cancelado.");
            return;
        }

        setEstudiante(nom, ci, apl, city, eml, numC);

        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof JDialog jDialog) {
            jDialog.dispose();
        }

    }

    public void setEstudiante(String nom, String ci, String apl, String city, String eml, Long numC) {
        estu = new Cliente();
        estu.setNombre(nom);
        estu.setCedula(ci);
        estu.setApellido(apl);
        estu.setCiudad(city);
        estu.setEmail(eml);
        estu.setNumCelular(numC);
    }

    public Cliente getEstudiante() {
        return estu;
    }

}
