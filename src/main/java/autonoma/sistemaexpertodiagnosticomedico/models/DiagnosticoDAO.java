package autonoma.sistemaexpertodiagnosticomedico.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticoDAO {
    private Connection conn;

    public DiagnosticoDAO() {
        this.conn = MySQLConnection.getInstance().getConnection();
    }

    /**
     * Guarda un diagnóstico en la tabla diagnostics
     */
    public int guardarDiagnostico(int pacienteId, String sintomasTexto, int enfermedadId) throws SQLException {
        // Usamos el primer síntoma como sin_id (esto podría mejorarse)
        int primerSintomaId = obtenerPrimerSintomaId(sintomasTexto);
        
        String sql = "INSERT INTO diagnostics (pac_id, sin_id, enf_id, sintomas) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, pacienteId);
            ps.setInt(2, primerSintomaId);
            ps.setInt(3, enfermedadId);
            ps.setString(4, sintomasTexto);
            
            int affectedRows = ps.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
            return -1;
        }
    }

    private int obtenerPrimerSintomaId(String sintomasTexto) throws SQLException {
        // Extraer el primer síntoma del texto
        String primerSintoma = sintomasTexto.split(",")[0].trim();
        
        String sql = "SELECT sin_id FROM sintomas WHERE sin_nombre = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, primerSintoma);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("sin_id");
                }
            }
        }
        return 1; // Valor por defecto si no se encuentra
    }

    /**
     * Obtiene los diagnósticos de un paciente específico
     */
    public List<String> obtenerDiagnosticosPorPaciente(int pacienteId) throws SQLException {
        List<String> diagnosticos = new ArrayList<>();
        String sql = """
            SELECT d.dia_id, e.enf_nombre, d.sintomas, e.enf_recomendacion_basica, c.cat_nombre
            FROM diagnostics d
            INNER JOIN enfermedades e ON d.enf_id = e.enf_id
            INNER JOIN categorias c ON e.cat_id = c.cat_id
            WHERE d.pac_id = ?
            ORDER BY d.dia_id DESC
            """;
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pacienteId);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String diagnostico = String.format(
                        "Diagnóstico ID: %d\nEnfermedad: %s\nSíntomas: %s\nCategoría: %s\nRecomendación: %s\n",
                        rs.getInt("dia_id"),
                        rs.getString("enf_nombre"),
                        rs.getString("sintomas"),
                        rs.getString("cat_nombre"),
                        rs.getString("enf_recomendacion_basica")
                    );
                    diagnosticos.add(diagnostico);
                }
            }
        }
        return diagnosticos;
    }
}