package Modelo;

import Util.ConexionSQLite;
import java.sql.*;
import java.util.*;

public class ClienteDAO {

    PlanesDAO pd;

    public ClienteDAO() {
        pd = new PlanesDAO();
    }

    public void insertar(Cliente e) {
        String sql = "INSERT INTO Estudiantes (nombre, apellido, cedula, ciudad, email, numCelular, planesActivos, pagoMensual) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getCedula());
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

    public void eliminar(String cedula) {
        String sql = "DELETE FROM Estudiantes WHERE cedula = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar " + ex.getMessage());
        }
    }

    public void actualizar(Cliente e) {

        String sql = "UPDATE Estudiantes SET nombre = ?, apellido = ?, ciudad = ?, email = ?, numCelular = ?, planesActivos = ?, pagoMensual = ? WHERE cedula = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getCiudad());
            ps.setString(4, e.getEmail());
            ps.setLong(5, e.getNumCelular());
            ps.setInt(6, e.getPlanesActivos());
            ps.setDouble(7, e.getPagoMensual());
            ps.setString(8, e.getCedula());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar cliente...." + ex.getMessage());
        }
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Estudiantes";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente e = new Cliente();
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setCedula(rs.getString("cedula"));
                e.setCiudad(rs.getString("ciudad"));
                e.setEmail(rs.getString("email"));
                e.setNumCelular(rs.getLong("numCelular"));
                e.setPlanesActivos(rs.getInt("planesActivos"));
                e.setPagoMensual(rs.getDouble("pagoMensual"));
                e.setPlan(pd.listarPlanes(e.getCedula()));
                lista.add(e);
            }
            ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al Listar...." + ex.getMessage());
        }
        return lista;
    }

    public Boolean Buscar(String cedula) {
        String sql = "SELECT cedula FROM Estudiantes WHERE cedula = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar cliente por cedula...." + ex.getMessage());
            return false;
        }
    }

    public Cliente estudiante(String cedula) {
        Cliente e = null;
        String sql = "SELECT * FROM Estudiantes WHERE cedula = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    e = new Cliente();
                    e.setNombre(rs.getString("nombre"));
                    e.setApellido(rs.getString("apellido"));
                    e.setCedula(rs.getString("cedula"));
                    e.setCiudad(rs.getString("ciudad"));
                    e.setEmail(rs.getString("email"));
                    e.setNumCelular(rs.getLong("numCelular"));
                    e.setPlanesActivos(rs.getInt("planesActivos"));
                    e.setPagoMensual(rs.getDouble("pagoMensual"));
                    e.setPlan(pd.listarPlanes(e.getCedula()));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener estudiante por cedula...." + ex.getMessage());
        }
        return e;
    }

}
