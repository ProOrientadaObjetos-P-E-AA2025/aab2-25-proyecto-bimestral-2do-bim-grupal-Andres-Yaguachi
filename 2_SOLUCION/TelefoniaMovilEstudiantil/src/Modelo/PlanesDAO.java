package Modelo;

import Controlador.AsignadorPlanes;
import Util.ConexionSQLite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanesDAO {

    public void insertar(PlanPostPago ppp, String cedula) {
        String sql = "INSERT INTO Planes (nombrePlan, categoriaPlan, cedula, pagoMensaul) VALUES (?,?,?,?)";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ppp.getNombrePlan());
            ps.setString(2, ppp.getCategoriaPlan());
            ps.setString(3, cedula);
            ps.setDouble(4, ppp.getpagoMensual());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar...." + ex.getMessage());
        } catch (Exception ed) {
            System.out.println("Error : " + ed.getMessage());
        }
    }

    public void eliminar(String cedula, String nombrePlan) {
        String sql = "DELETE FROM Planes WHERE cedula = ? AND nombrePlan = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ps.setString(2, nombrePlan);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar " + ex.getMessage());
        }
    }

    public List<PlanPostPago> listarPlanes(String cedula) {
        List<PlanPostPago> lista = new ArrayList<>();
        PlanPostPago p;
        AsignadorPlanes ap = new AsignadorPlanes();
        String sql = "SELECT * FROM Planes WHERE cedulas = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String tipo = rs.getString("nombrePlan");
                    String plan = rs.getString("categoriaPlan");
                    p = ap.Asignar(tipo, plan);
                    lista.add(p);
                }
            } catch (SQLException es) {
                System.out.println("Error" + es.getMessage());
            }

        } catch (SQLException ex) {
            System.out.println("Error al Listar...." + ex.getMessage());
        }
        return lista;
    }
}
