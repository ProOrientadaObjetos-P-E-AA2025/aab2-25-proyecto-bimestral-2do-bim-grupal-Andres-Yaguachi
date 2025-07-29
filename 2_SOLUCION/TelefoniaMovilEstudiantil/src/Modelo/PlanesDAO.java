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
        String sql = "INSERT INTO Planes (nombrePlan, categoriaPlan, cedula, pagoMensual) VALUES (?,?,?,?)";
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

    public void eliminar(String cedula, String nombrePlan, String categoriaPlan) {
        String sql = "DELETE FROM Planes WHERE cedula = ? AND nombrePlan = ?AND categoriaPlan = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ps.setString(2, nombrePlan);
            ps.setString(3, categoriaPlan);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar " + ex.getMessage());
        }
    }

    public List<PlanPostPago> listarPlanes(String cedula) {
        List<PlanPostPago> lista = new ArrayList<>();
        String sql = "SELECT * FROM Planes WHERE cedula = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            try (ResultSet rs = ps.executeQuery()) {
                AsignadorPlanes ap = new AsignadorPlanes();
                while (rs.next()) {
                    String tipo = rs.getString("nombrePlan");
                    String planCategoria = rs.getString("categoriaPlan");
                    PlanPostPago p = ap.Asignar(tipo, planCategoria);
                    if (p != null) {
                        lista.add(p);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al Listar planes...." + ex.getMessage());
        }
        return lista;
    }
}
