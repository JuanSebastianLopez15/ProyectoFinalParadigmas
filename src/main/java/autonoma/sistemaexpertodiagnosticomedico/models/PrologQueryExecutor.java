package autonoma.sistemaexpertodiagnosticomedico.models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jpl7.Query;
import org.jpl7.Term;

/**
 *
 * @author Juan
 */
public class PrologQueryExecutor {
    public static void createDynamicFact(String fact){
        Query q = new Query(fact);
        if (q.hasSolution()) {
            System.out.println("Hecho dinamico agregado: " + fact);
        }
    }
    
    public static List<Organismo> getAnimals(String rule) {
        List<Organismo> lista = new ArrayList<>();

        Query q = new Query(rule);

        while (q.hasMoreSolutions()) {
            Map<String, Term> sol = q.nextSolution();

            // Id puede no venir (porque usaste _)
            Integer id = null;
            Term idT = sol.get("Id");     // no existirá en sol
            if (idT != null) {
                try {
                    id = Integer.parseInt(idT.toString());
                } catch (NumberFormatException e) {
                    // si no es número, déjalo nulo
                }
            }

            // Nombre puede no venir (porque usaste jaguar como átomo fijo)
            String nombre = null;
            Term nombreT = sol.get("Nombre");   // no existirá tampoco
            if (nombreT != null) {
                nombre = nombreT.toString();
            }

            // Especie sí viene
            String especie = null;
            Term especieT = sol.get("Especie"); // SÍ existirá
            if (especieT != null) {
                especie = especieT.toString();
            }

            Organismo o = new Organismo(id, nombre, especie);
            lista.add(o);
        }

        q.close();
        return lista;
    }
    public static List<Depredacion> getDepredaciones(String rule) {
        List<Depredacion> lista = new ArrayList<>();

        Query q = new Query(rule);

        while (q.hasMoreSolutions()) {
            Map<String, Term> sol = q.nextSolution();

            Term depT = sol.get("Depredador");
            Term preyT = sol.get("Presa");

            String dep = depT != null ? depT.toString() : null;
            String prey = preyT != null ? preyT.toString() : null;

            lista.add(new Depredacion(dep, prey));
        }

        q.close();
        return lista;
    }
    
}
