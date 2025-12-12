/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.sistemaexpertodiagnosticomedico.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Juan
 */
public class FactsBuilder {
    private Connection conn;
    
    public FactsBuilder(){
        this.conn = MySQLConnection.getInstance().getConnection();
    }
    
    public static boolean construirFactsEnfermedad(){
        EnfermedadDAO dao = new EnfermedadDAO();
        try{
            List<Enfermedad> lista = dao.buscarTodos();//Le pido todas las enfermedades que saque de la BD
            
            for(Enfermedad t : lista){
                StringBuilder sb = new StringBuilder();
                sb.append("assertz(enfermedad(")
                        .append(t.getNombre()).append(", sintomas([");
                        for(int i =0 ; i<t.getListaSintomas().size(); i++){
                            sb.append(t.getListaSintomas().get(i));
                            if(i<t.getListaSintomas().size()-1){
                                sb.append(",");
                            }
                        }
                        sb.append("]), categoria(")
                        .append(t.getNombreCategoria()).append("), recomendaciones([")
                        .append(t.getRecomendacion_basica()).append("])))");
                PrologQueryExecutor.createDynamicFact(sb.toString());//Analiza 1 por 1, mete los hechos en prolog
            }
        }catch(SQLException e){
            System.out.println("Error retrieving data");
        }
        return true;
    }
    
}