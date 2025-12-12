package autonoma.sistemaexpertodiagnosticomedico.models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jpl7.Query;
import org.jpl7.Term;

/**
 *
 * @author Juan
 */
public class PrologQueryExecutor {
    
    //ejecuta los assertz en prolog con el queryy
    public static void createDynamicFact(String fact){
        Query q = new Query(fact);
        if (q.hasSolution()) {
            System.out.println("Hecho dinamico agregado: " + fact);
        }
    }
    
    //ejecuta consulta en prolog, mapea
    public static List<Enfermedad> getEnfermedades(String rule) {
        List<Enfermedad> lista = new ArrayList<>();
        Query q = new Query(rule); //Crear consultas y hechos
        
        while (q.hasMoreSolutions()) {
            //quiero que metas la consulta de el query
            Map<String, Term> sol = q.nextSolution();//Es como un diccionario (sol= solucion)
            //El nombre de la variable de prolog debe coincidir exactamente con la clave de sol.get()
            String nombre = null;
            Term nombreT = sol.get("Nombre");
            if (nombreT != null) {
                nombre = nombreT.toString();
            }
            
            List<String> sintomas = null;
            Term sintoT = sol.get("Sintomas");
            if(sintoT != null){
                sintomas = proListToJavaList(sintoT);
                
            }

            
            String categoria = null;
            Term categoT = sol.get("Categoria");
            if (categoT != null) {
                categoria = categoT.toString();
            }
            
            String recomendacion = null;
            Term recoT = sol.get("Recomendacion");
            if (recoT != null) {
                List<String> recomendacionesList = proListToJavaList(recoT);
                recomendacion = String.join(", ", recomendacionesList);
            }
            
            Enfermedad e = new Enfermedad(nombre, sintomas,categoria, recomendacion);
            lista.add(e);
        }

        q.close();
        return lista;
    }
    
    private static List<String> proListToJavaList(Term t) {
        List<String> lista = new ArrayList<>();
        Term list = t; 

        
        while (list.isListPair()) {
            Term head = list.arg(1);   // Extrae el primer elemento
            lista.add(head.toString()); // Convierte a String Java
            list = list.arg(2);        // Avanza al resto de la lista
        }
        return lista;
    }
    
}
