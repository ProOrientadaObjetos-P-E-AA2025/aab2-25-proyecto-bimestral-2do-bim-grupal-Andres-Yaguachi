package Vista;

import java.awt.*;
import javax.swing.*;

public class VistaIngresoEstudiantes extends JPanel {

    private VistaMensajesUsuario vmu;

    private JTextField nombre;
    private JTextField cedula;
    private JTextField apellido;
    private JTextField ciudad;
    private JTextField email;
    private JTextField numeroCelular;

    private JButton registrar;

    public VistaIngresoEstudiantes(VistaPrincipal base) {
        setLayout(new GridLayout(5, 2, 10, 10));

        vmu = new VistaMensajesUsuario();
        nombre = new JTextField();
        cedula = new JTextField();
        apellido = new JTextField();
        ciudad = new JTextField();
        email = new JTextField();
        numeroCelular = new JTextField();

        registrar = new JButton("Registrar");

        registrar.addActionListener(e -> registrarEstudiante());

        add(new JLabel("Nombre: "));
        add(nombre);
        add(new JLabel("Cedula: "));
        add(cedula);
        add(new JLabel("Apellido: "));
        add(apellido);
        add(new JLabel("Ciudad: "));
        add(ciudad);
        add(new JLabel("Email: "));
        add(email);
        add(new JLabel("Numero Celular: "));
        add(numeroCelular);
        add(new JLabel());
        add(registrar);

    }

    public void registrarEstudiante() {
        String nom = nombre.getText();
        String ci = cedula.getText();
        String apl = apellido.getText();
        String city = ciudad.getText();
        String eml = email.getText();
        String numC = numeroCelular.getText().trim();
        if (nom.isEmpty() || ci.isEmpty()) {
            vmu.advertencias("Nombre y cedula son campos obligatorios...");
            return;
        }
        if (!ci.matches("\\d+")) {
            vmu.error("La cedula solo admite valores numericos");
            return;
        }
        if (!numC.isEmpty() && !numC.matches("\\d{9}")) {
            vmu.error("Numero Celular invalido: Solo se pueden ingresar 9 numeros");
            return;
        }
        //base.registrarEstudiante();
    }

}
