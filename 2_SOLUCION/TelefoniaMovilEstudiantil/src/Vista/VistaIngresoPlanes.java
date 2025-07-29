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
        categoriaPlan = new JComboBox<>(new String[]{
            "Economica", "Balanceada ", "Premium"
        });

        informacion = new JButton("Informacion Planes");
        registrar = new JButton("Registrar");

        informacion.addActionListener(e -> mostrarInformacion());
        registrar.addActionListener(e -> {
            String tipoP = (String) tipoPlan.getSelectedItem();
            String catP = (String) categoriaPlan.getSelectedItem();
            if (tipoP == null || catP == null) {
                vmu.advertencias("Seleccione un tipo y categoria de plan.....Datos Incompletos");
                return;
            }
            setPPP(tipoP, catP);
        });

        add(new JLabel("Seleccionar Plan: "));
        add(tipoPlan);
        add(new JLabel("Seleccionar Cateogira del Plan: "));
        add(categoriaPlan);
        add(new JLabel());
        add(registrar);
    }

    public void setPPP(String tipo, String Categoria) {
        AsignadorPlanes ap = new AsignadorPlanes();
        ppp = ap.Asignar(tipo, Categoria);
    }

    public PlanPostPago getPPP() {
        return ppp;
    }

    private void mostrarInformacion() {
        JDialog dialogo = new JDialog((Frame) null, "Detalles de los Planes", true);
        dialogo.setSize(400, 300);
        dialogo.setLocationRelativeTo(this);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setText("""
                          Plan Megas: *Economico:  5GB. 
                                      *Balanceada: 10GB. 
                                      *Premium:    20GB.
                          Plan Minutos: *Economico:  50 MinutosNacionales  - 20 MinutosInter, 
                                        *Balanceada: 100 MinutosNacionales - 40 MinutosInter, 
                                        *Premium:    200 MinutosNacionales - 60 MinutosInter
                          Plan MinutosMegas: *Economico:  5GB  - 40 minutos.
                                             *Balanceada: 10GB - 50 minutos.
                                             *Premium:    20GB - 80 minutos.
                          Plan MinutosMegas(Eco): *Economico:  4GB  - 30 minutos.
                                                  *Balanceada: 8GB  - 40 minutos.
                                                  *Premium:    16GB - 60 minutos.
                          """);

        JScrollPane scroll = new JScrollPane(areaTexto);
        dialogo.add(scroll);
        dialogo.setVisible(true);

    }

}
