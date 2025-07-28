package Modelo;

import Util.ConexionSQLite;
import java.sql.*;
import java.util.*;

public class FacturaDAO {

    public void insertar(Factura f) {
        String sql = "INSERT INTO Facturas (cedula, plan, categoriaPlan, costo, subtotal, iva, total, numFactura) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, f.getCedula());
            ps.setString(2, f.getPlan());
            ps.setString(3, f.getCategoriaPlan());
            ps.setDouble(4, f.getSubtotal());
            ps.setDouble(5, f.getSubtotal());
            ps.setDouble(6, f.getIva());
            ps.setDouble(7, f.getTotal());
            ps.setLong(8, f.getNumFactura());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar...." + ex.getMessage());
        } catch (Exception ed) {
            System.out.println("Error : " + ed.getMessage());
        }
    }

    public void eliminar(String cedula, String plan) {
        String sql = "DELETE FROM Facturas WHERE cedula = ? AND plan = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ps.setString(2, plan);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar " + ex.getMessage());
        }
    }

    public List<Factura> listar(String cedula) {
        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT * FROM Facturas WHERE ci/pasap = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            ps.setString(1, cedula);
            while (rs.next()) {
                Factura f = new Factura();
                f.setCedula(rs.getString("cedula"));
                f.setPlan(rs.getString("plan"));
                f.setCategoriaPlan(rs.getString("categoriaPlan"));
                f.setSubtotal(rs.getDouble("subtotal"));
                f.setIva(rs.getDouble("iva"));
                f.setTotal(rs.getDouble("total"));
                f.setNumFactura(rs.getLong("numFactura"));
                lista.add(f);
            }
            ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al Listar...." + ex.getMessage());
        }
        return lista;

    }
}
