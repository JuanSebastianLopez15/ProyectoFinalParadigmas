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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Juan
 */
public class EnfermedadDAO {
    private Connection conn;   // <–– the connection stays here as an attribute

    public EnfermedadDAO(){
        this.conn = MySQLConnection.getInstance().getConnection();
    }

    public List<Enfermedad> buscarTodos() throws SQLException {
        String sql = """
                     Select e.enf_nombre as "enf_nombre" , e.enf_recomendacion_basica as "recomendacion_basica",
                     s.sin_nombre as "nombre_sintoma" , 
                     c.cat_nombre as "nombre_categoria" 
                     from enfermedades as e join sintoma_enfermedad as se on e.enf_id = se.enf_id
                     join sintomas as s on s.sin_id = se.sin_id
                     join categorias as c on c.cat_id = e.cat_id;
                     """;
        List<Enfermedad> enfermedades;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            enfermedades = mapRow(rs);
        } finally {
            if (rs != null) {
                try {
                    rs.close(); 
                } catch (SQLException ignored) {
                    System.out.println("Error closing result set");
                }
            }
                
            if (ps != null){
                try {
                    ps.close(); 
                } catch (SQLException ignored) {
                    System.out.println("Error closing prepared statement");
                }
            }
        }

        return enfermedades;
    }
    
    //agrupa filas SQL en un objeto enfermedad sin duplicar
    private List<Enfermedad> mapRow(ResultSet rs) throws SQLException {
        List<Enfermedad> enfermedades = new ArrayList<>();
        Set<String> enfermedadesSinDuplicados = new HashSet<>();
        try {
            while(rs.next()){
                if(!enfermedadesSinDuplicados.contains(rs.getString("enf_nombre"))){
                    //Enfermedad aparece por primera vez
                    enfermedadesSinDuplicados.add(rs.getString("enf_nombre"));
                    enfermedadesSinDuplicados.add(rs.getString("nombre_categoria"));
                    enfermedadesSinDuplicados.add(rs.getString("recomendacion_basica"));
                    Enfermedad e = new Enfermedad();
                    e.setNombre(rs.getString("enf_nombre"));
                    e.getListaSintomas().add(rs.getString("nombre_sintoma"));
                    e.setNombreCategoria(rs.getString("nombre_categoria"));
                    e.setRecomendacion_basica(rs.getString("recomendacion_basica"));
                    enfermedades.add(e);
                    //No va sintomas porque los sintomas si se pueden repetir
                    //La lista de sintomas esta dentro de enfermedad, no es una clave duplicada
                }
                else{
                    //Ya vi la enfermedad antes, le agrego el nuevo sintoma
                    for(int i =0 ; i<enfermedades.size();i++){
                        if(enfermedades.get(i).getNombre().equals(rs.getString("enf_nombre"))){
                            enfermedades.get(i).getListaSintomas().add(rs.getString("nombre_sintoma"));
                            break;
                        }
                    }
                }
                
            }
        }
        catch (SQLException ex){ 
            System.getLogger(EnfermedadDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return enfermedades;
    }
}