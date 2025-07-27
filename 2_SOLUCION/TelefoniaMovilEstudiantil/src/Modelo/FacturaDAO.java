package Modelo;

import Util.ConexionSQLite;
import java.sql.*;
import java.util.*;

public class FacturaDAO {

    public void insertar(Factura f) {
        String sql = "INSERT INTO Facturas (ci/pasp, plan, costo, subtotal, iva, total, numFactura) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, f.);
            ps.setString(2, e.getApellidos());
            ps.setString(3, e.getCedula());
            ps.setString(4, e.getCarrera());
            ps.setString(5, e.getSemestreApliacar());
            ps.setString(6, e.getBeca().getTipoBeca());
            ps.setDouble(7, e.getBeca().getMontoBeca());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar...." + ex.getMessage());
        } catch (Exception ed) {
            System.out.println("Error : " + ed.getMessage());
        }
    }
/*
    public void eliminar(String cedula) {
        String sql = "DELETE FROM Becas where cedula = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar " + ex.getMessage());
        }
    }

    public void actualizar(Estudiante e) {
        String sql = "UPDATE Becas set "
                + "nombres = ? , apellidos = ?, carrera = ?, semestreAplicar = ? , tipoBeca = ?, mensualBeca = ?, porcentajeBeca = ? WHERE cedula = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.getNombres());
            ps.setString(2, e.getApellidos());
            ps.setString(3, e.getCarrera());
            ps.setString(4, e.getSemestreApliacar());
            ps.setString(5, e.getBeca().getTipoBeca());
            ps.setDouble(6, e.getBeca().getMontoBeca());
            ps.setDouble(7, e.getBeca().getPorcentajeBeca());
            ps.setString(8, e.getCedula());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar...." + ex.getMessage());
        }
    }

    public List<Estudiante> listar() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM Becas";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Beca b = new Beca();
                Estudiante e = new Estudiante();
                e.setNombres(rs.getString("nombres"));
                e.setApellidos(rs.getString("apellidos"));
                e.setCedula(rs.getString("cedula"));
                e.setCarrera(rs.getString("carrera"));
                e.setSemestreApliacar(rs.getString("semestreAplicar"));
                b.setTipoBeca(rs.getString("tipoBeca"));
                b.setMontoBeca(rs.getDouble("mensualBeca"));
                b.setPorcentajeBeca(rs.getDouble("porcentajeBeca"));
                e.setBeca(b);
                lista.add(e);
            }
            ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al Listar...." + ex.getMessage());
        }
        return lista;
    }*/
}
