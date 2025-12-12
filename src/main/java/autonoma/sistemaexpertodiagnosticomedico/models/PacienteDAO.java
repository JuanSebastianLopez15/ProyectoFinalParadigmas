package autonoma.sistemaexpertodiagnosticomedico.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    private Connection conn;

    public PacienteDAO() {
        this.conn = MySQLConnection.getInstance().getConnection();
    }

    // Método para insertar un nuevo paciente
    public int insertarPaciente(Paciente paciente) throws SQLException {
        
        String sqlMaxId = "SELECT COALESCE(MAX(pac_id), 0) + 1 as next_id FROM pacientes";
        int nextId;

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sqlMaxId)) {
            if (rs.next()) {
                nextId = rs.getInt("next_id");
            } else {
                nextId = 1;
            }
        }

        // Insertar con el ID obtenido
        String sqlInsert = "INSERT INTO pacientes (pac_id, pac_nombre, edad) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
            ps.setInt(1, nextId);
            ps.setString(2, paciente.getNombre());
            ps.setInt(3, paciente.getEdad());

            ps.executeUpdate();
            return nextId;
        }
    }

    // Método para buscar paciente por ID
    public Paciente buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM pacientes WHERE pac_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Paciente paciente = new Paciente();
                    paciente.setNombre(rs.getString("pac_nombre"));
                    paciente.setEdad(rs.getInt("edad"));
                    return paciente;
                }
            }
        }
        return null;
    }

    public List<Paciente> buscarTodos() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM pacientes ORDER BY pac_id";

        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("pac_id"));
                paciente.setNombre(rs.getString("pac_nombre"));
                paciente.setEdad(rs.getInt("edad"));
                pacientes.add(paciente);
            }
        }
        return pacientes;
    }

    // Método para buscar paciente por nombre
    public Paciente buscarPorNombre(String nombre) throws SQLException {
        String sql = "SELECT * FROM pacientes WHERE pac_nombre = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Paciente paciente = new Paciente();
                    paciente.setNombre(rs.getString("pac_nombre"));
                    paciente.setEdad(rs.getInt("edad"));
                    return paciente;
                }
            }
        }
        return null;
    }
}
