package Modelo;

import Util.ConexionSQLite;
import Controlador.AsignadorPlanes;
import java.sql.*;
import java.util.*;

public class ClienteDAO {

    public void insertarEst(Cliente e) {
        String sql = "INSERT INTO Estudiantes (nombre, apellido, ci/pasap, ciudad, email, numCelular, planesActivos, pagoMensual) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getCi_pas());
            ps.setString(4, e.getCiudad());
            ps.setString(5, e.getEmail());
            ps.setLong(6, e.getNumCelular());
            ps.setInt(7, e.getPlanesActivos());
            ps.setDouble(8, e.getPagoMensual());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar...." + ex.getMessage());
        } catch (Exception ed) {
            System.out.println("Error : " + ed.getMessage());
        }
    }

    public void eliminarEst(String cedula) {
        String sql = "DELETE FROM Estudiantes where ci/pasap = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar " + ex.getMessage());
        }
    }

    public void actualizarEst(Cliente e) {
        String sql = "UPDATE Estudiantes set "
                + "nombre = ?, apellido = ?, ci/pasap = ?, ciudad = ?, email = ?, numCelular = ?, planesActivos = ?, pagoMensual = ? WHERE cedula = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getCiudad());
            ps.setString(4, e.getEmail());
            ps.setLong(5, e.getNumCelular());
            ps.setInt(6, e.getPlanesActivos());
            ps.setDouble(7, e.getPagoMensual());
            ps.setString(8, e.getCi_pas());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar...." + ex.getMessage());
        }
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Becas";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente e = new Cliente();
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setCi_pas(rs.getString("ci/pasap"));
                e.setCiudad(rs.getString("ciudad"));
                e.setEmail(rs.getString("email"));
                e.setNumCelular(rs.getLong("numCelular"));
                e.setPlanesActivos(rs.getInt("planesActivos"));
                e.setPagoMensual(rs.getDouble("pagoMensual"));
                e.setPlan(listarPlanes(e.getCi_pas()));
                lista.add(e);
            }
            ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al Listar...." + ex.getMessage());
        }
        return lista;
    }

    public List<PlanPostPago> listarPlanes(String cedula) {
        List<PlanPostPago> lista = new ArrayList<>();
        PlanPostPago p;
        AsignadorPlanes ap = new AsignadorPlanes();
        String sql = "SELECT FROM Planes where ci/pasap = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String tipo = rs.getString("nombrePlan");
                String plan = rs.getString("categoriaPlan");
                p = ap.Asignar(tipo, plan);
                lista.add(p);
            }
            ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al Listar...." + ex.getMessage());
        }
        return lista;
    }
}
