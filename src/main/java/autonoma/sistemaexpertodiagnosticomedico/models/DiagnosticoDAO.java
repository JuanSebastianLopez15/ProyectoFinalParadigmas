package autonoma.sistemaexpertodiagnosticomedico.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticoDAO {

    private Connection conn;

    public DiagnosticoDAO() {
        this.conn = MySQLConnection.getInstance().getConnection();
    }

    public List<Diagnostico> buscarTodos() throws SQLException {
        String sql = """
                     select pac_nombre as 'nombre_paciente',
                         sintomas as 'sintomas',
                         enfermedades as 'enfermedades',
                         recomendaciones as 'recomendaciones'
                         from diagnosticos as d
                         join pacientes as pac on pac.pac_id = d.pac_id;
                     """;
        List<Diagnostico> diagnosticos;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            diagnosticos = mapearDiagnosticoDAO(rs);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) {
                    System.out.println("Error");
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignored) {
                    System.out.println("Error");
                }
            }
        }

        return diagnosticos;
    }

    private List<Diagnostico> mapearDiagnosticoDAO(ResultSet rs) {
        List<Diagnostico> diagnosticos = new ArrayList<>();
        try {
            while (rs.next()) {
                Diagnostico d = new Diagnostico();
                d.setNombre_paciente(rs.getString("nombre_paciente"));
                d.setSintomas(rs.getString("sintomas"));
                d.setEnfermedades(rs.getString("enfermedades"));
                d.setRecomendaciones(rs.getString("recomendaciones"));
                diagnosticos.add(d);
            }
        } catch (SQLException ex) {
            System.getLogger(EnfermedadDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return diagnosticos;
    }
    
    public boolean insertarDiagnosticoCompleto(int pacienteId, String sintomas, String enfermedad, String recomendaciones) throws SQLException {
        String sql = "INSERT INTO diagnosticos (pac_id, sintomas, enfermedades, recomendaciones) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pacienteId);
            ps.setString(2, sintomas);
            ps.setString(3, enfermedad);
            ps.setString(4, recomendaciones);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignored) {
                    System.out.println("Error closing prepared statement");
                }
            }
        }
    }
}
