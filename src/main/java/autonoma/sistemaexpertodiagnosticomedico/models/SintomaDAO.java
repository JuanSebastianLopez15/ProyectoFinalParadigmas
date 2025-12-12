/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.sistemaexpertodiagnosticomedico.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SintomaDAO {

    private Connection conn;

    public SintomaDAO() {
        this.conn = MySQLConnection.getInstance().getConnection();
    }

    /**
     * Obtiene todos los síntomas de la base de datos
     */
    public List<Sintoma> obtenerTodosSintomas() throws SQLException {
        List<Sintoma> sintomas = new ArrayList<>();
        String sql = "SELECT sin_id, sin_nombre FROM sintomas ORDER BY sin_nombre";

        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Sintoma sintoma = new Sintoma();
                sintoma.setId(rs.getInt("sin_id"));
                sintoma.setNombre(rs.getString("sin_nombre"));
                sintomas.add(sintoma);
            }
        }
        return sintomas;
    }

    /**
     * Obtiene un síntoma por su ID
     */
    public Sintoma obtenerSintomaPorId(int id) throws SQLException {
        String sql = "SELECT sin_id, sin_nombre FROM sintomas WHERE sin_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Sintoma sintoma = new Sintoma();
                    sintoma.setId(rs.getInt("sin_id"));
                    sintoma.setNombre(rs.getString("sin_nombre"));
                    return sintoma;
                }
            }
        }
        return null;
    }

    /**
     * Obtiene un síntoma por su nombre
     */
    public Sintoma obtenerSintomaPorNombre(String nombre) throws SQLException {
        String sql = "SELECT sin_id, sin_nombre FROM sintomas WHERE sin_nombre = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Sintoma sintoma = new Sintoma();
                    sintoma.setId(rs.getInt("sin_id"));
                    sintoma.setNombre(rs.getString("sin_nombre"));
                    return sintoma;
                }
            }
        }
        return null;
    }

    /**
     * Obtiene los síntomas asociados a una enfermedad específica
     */
    public List<Sintoma> obtenerSintomasPorEnfermedad(int enfermedadId) throws SQLException {
        List<Sintoma> sintomas = new ArrayList<>();
        String sql = """
            SELECT s.sin_id, s.sin_nombre 
            FROM sintomas s
            INNER JOIN sintoma_enfermedad se ON s.sin_id = se.sin_id
            WHERE se.enf_id = ?
            ORDER BY s.sin_nombre
            """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, enfermedadId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Sintoma sintoma = new Sintoma();
                    sintoma.setId(rs.getInt("sin_id"));
                    sintoma.setNombre(rs.getString("sin_nombre"));
                    sintomas.add(sintoma);
                }
            }
        }
        return sintomas;
    }

    /**
     * Inserta un nuevo síntoma en la base de datos
     */
    public int insertarSintoma(Sintoma sintoma) throws SQLException {
        // Primero obtener el próximo ID disponible
        String sqlMaxId = "SELECT COALESCE(MAX(sin_id), 0) + 1 as next_id FROM sintomas";
        int nextId;

        try (PreparedStatement ps = conn.prepareStatement(sqlMaxId); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                nextId = rs.getInt("next_id");
            } else {
                nextId = 1;
            }
        }

        // Insertar el nuevo síntoma
        String sqlInsert = "INSERT INTO sintomas (sin_id, sin_nombre) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
            ps.setInt(1, nextId);
            ps.setString(2, sintoma.getNombre());
            ps.executeUpdate();
            return nextId;
        }
    }

    /**
     * Busca síntomas por nombre (búsqueda parcial)
     */
    public List<Sintoma> buscarSintomasPorNombre(String busqueda) throws SQLException {
        List<Sintoma> sintomas = new ArrayList<>();
        String sql = "SELECT sin_id, sin_nombre FROM sintomas WHERE sin_nombre LIKE ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + busqueda + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Sintoma sintoma = new Sintoma();
                    sintoma.setId(rs.getInt("sin_id"));
                    sintoma.setNombre(rs.getString("sin_nombre"));
                    sintomas.add(sintoma);
                }
            }
        }
        return sintomas;
    }

    public boolean existeSintoma(String nombre) throws SQLException {
        String sql = "SELECT COUNT(*) as count FROM sintomas WHERE sin_nombre = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("count") > 0;
                }
            }
        }
        return false;
    }
}
