package Vista;

import Modelo.*;
import Controlador.*;
import java.awt.*;
import javax.swing.*;

public class VistaIngresoPlanes extends JPanel {

    private VistaMensajesUsuario vmu;
    private PlanPostPago ppp;
    private JComboBox<String> tipoPlan;
    private JComboBox<String> categoriaPlan;
    private JButton informacion;
    private JButton registrar;

    public VistaIngresoPlanes(VistaPrincipal base) {

        vmu = new VistaMensajesUsuario();

        tipoPlan = new JComboBox<>(new String[]{
            "Plan Megas", "Plan Minutos", "Plan MinutosMegas", "Plan MinutosMegasEconomico"
        });
        tipoPlan.setPreferredSize(new Dimension(200, 30));

        categoriaPlan = new JComboBox<>(new String[]{
            "Economica", "Balanceada", "Premium"
        });
        categoriaPlan.setPreferredSize(new Dimension(200, 30));

        informacion = new JButton("Información Planes");
        informacion.setPreferredSize(new Dimension(160, 35));

        registrar = new JButton("Registrar");
        registrar.setPreferredSize(new Dimension(160, 35));

        informacion.addActionListener(e -> mostrarInformacion());
        registrar.addActionListener(e -> {
            String tipoP = (String) tipoPlan.getSelectedItem();
            String catP = (String) categoriaPlan.getSelectedItem();
            if (tipoP == null || catP == null) {
                vmu.advertencias("Seleccione un tipo y categoría de plan... Datos incompletos.");
                return;
            }
            setPPP(tipoP, catP);
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window instanceof JDialog jDialog) {
                jDialog.dispose();
            }
        });

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 200));

        // Panel de contenido principal con layout vertical
        JPanel contenido = new JPanel();
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
        contenido.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        contenido.add(crearCampo("Seleccionar Plan:", tipoPlan));
        contenido.add(crearCampo("Categoría del Plan:", categoriaPlan));

        // Pie con los botones alineados
        JPanel footer = new JPanel();
        footer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        footer.add(registrar);
        footer.add(informacion);

        add(contenido, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    private JPanel crearCampo(String etiqueta, JComponent campo) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel label = new JLabel(etiqueta);
        label.setPreferredSize(new Dimension(140, 30));
        panel.add(label, BorderLayout.WEST);
        panel.add(campo, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
        return panel;
    }

    public void setPPP(String tipo, String categoria) {
        AsignadorPlanes ap = new AsignadorPlanes();
        ppp = ap.Asignar(tipo, categoria);
    }

    public PlanPostPago getPPP() {
        return ppp;
    }

    private void mostrarInformacion() {
        JDialog dialogo = new JDialog((Frame) null, "Detalles de los Planes", true);
        dialogo.setSize(400, 400);
        dialogo.setLocationRelativeTo(this);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setText("""
            Plan Megas:
              * Económica: 5GB
              * Balanceada: 10GB
              * Premium: 20GB

            Plan Minutos:
              * Económica: 50 Nacionales / 20 Internacionales
              * Balanceada: 100 Nacionales / 40 Internacionales
              * Premium: 200 Nacionales / 60 Internacionales

            Plan MinutosMegas:
              * Económica: 5GB + 40 minutos
              * Balanceada: 10GB + 50 minutos
              * Premium: 20GB + 80 minutos

            Plan MinutosMegas(Eco):
              * Económica: 4GB + 30 minutos
              * Balanceada: 8GB + 40 minutos
              * Premium: 16GB + 60 minutos
            """);

        JScrollPane scroll = new JScrollPane(areaTexto);
        dialogo.add(scroll);
        dialogo.setVisible(true);
    }
}
