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
    public static void createDynamicFact(String fact){
        Query q = new Query(fact);
        if (q.hasSolution()) {
            System.out.println("Hecho dinamico agregado: " + fact);
        }
    }
    
    
    public static List<Enfermedad> getEnfermedades(String rule) {
        List<Enfermedad> lista = new ArrayList<>();
        Query q = new Query(rule); //Crear consultas y hechos
        
        while (q.hasMoreSolutions()) {
            //quiero que metas la consulta de el query
            Map<String, Term> sol = q.nextSolution();//Es como un diccionario (sol= solucion)

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

            // Especie sí viene
            String categoria = null;
            Term categoT = sol.get("Categoria");
            if (categoT != null) {
                categoria = categoT.toString();
            }
            
            String recomendacion = null;
            Term recoT = sol.get("Recomendacion");
            if (recoT != null) {
                recomendacion = recoT.toString();
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

        // JPL representa listas como pares [Head|Tail]
        while (list.isListPair()) {
            Term head = list.arg(1);   // Extrae el primer elemento
            lista.add(head.toString()); // Convierte a String Java
            list = list.arg(2);        // Avanza al resto de la lista
        }
        return lista;
    }
    public static List<Enfermedad> getDiagnosticos(List<String> sintomasPaciente) {
        List<Enfermedad> lista = new ArrayList<>();

        // Convertir lista Java a formato Prolog: [fiebre, tos, dolor_cabeza]
        String sintomasProlog = "[";
        for (int i = 0; i < sintomasPaciente.size(); i++) {
            sintomasProlog += sintomasPaciente.get(i);
            if (i < sintomasPaciente.size() - 1) {
                sintomasProlog += ", ";
            }
        }
        sintomasProlog += "]";

        // Hacer la consulta: diagnostico([sintomas], Nombre)
        String consulta = "diagnostico(" + sintomasProlog + ", Nombre)";
        System.out.println("Consulta Prolog: " + consulta);

        Query q = new Query(consulta);

        while (q.hasMoreSolutions()) {
            Map<String, Term> sol = q.nextSolution();
            String nombreEnfermedad = sol.get("Nombre").toString();

            // Ahora obtener los detalles de esa enfermedad
            String consulta2 = "enfermedad(" + nombreEnfermedad + ", sintomas(Sintomas), categoria(Categoria), recomendaciones(Recomendacion))";
            Query q2 = new Query(consulta2);

            if (q2.hasSolution()) {
                Map<String, Term> sol2 = q2.nextSolution();

                // Extraer sintomas
                Term sintoT = sol2.get("Sintomas");
                List<String> sintomas = proListToJavaList(sintoT);

                // Extraer categoria
                String categoria = sol2.get("Categoria").toString();

                // Extraer recomendacion
                Term recoT = sol2.get("Recomendacion");
                List<String> recomendaciones = proListToJavaList(recoT);
                String recomendacion = String.join(", ", recomendaciones);

                Enfermedad e = new Enfermedad(nombreEnfermedad, sintomas, categoria, recomendacion);
                lista.add(e);
            }
            q2.close();
        }
        q.close();

        return lista;
    }
    /**
     * Obtiene enfermedades por categoría usando la regla diagnostico_categoria
     * que ya tienes
     */
    public static List<Enfermedad> getEnfermedadesPorCategoria(String categoria) {
        List<Enfermedad> lista = new ArrayList<>();

        // Usar la regla diagnostico_categoria que ya tienes en Prolog
        String consulta = "diagnostico_categoria(" + categoria + ", Nombre)";
        System.out.println("Consultando Prolog: " + consulta);

        Query q = new Query(consulta);

        while (q.hasMoreSolutions()) {
            Map<String, Term> sol = q.nextSolution();
            String nombreEnfermedad = sol.get("Nombre").toString();
            System.out.println("Encontrada enfermedad: " + nombreEnfermedad);

            // Ahora obtener los detalles completos de esa enfermedad
            String consultaDetalles = "enfermedad(" + nombreEnfermedad
                    + ", sintomas(Sintomas), categoria(Categoria), "
                    + "recomendaciones(Recomendacion))";
            Query q2 = new Query(consultaDetalles);

            if (q2.hasSolution()) {
                Map<String, Term> sol2 = q2.nextSolution();

                // Extraer síntomas
                List<String> sintomas = new ArrayList<>();
                Term sintoT = sol2.get("Sintomas");
                if (sintoT != null) {
                    sintomas = proListToJavaList(sintoT);
                }

                // Extraer categoría
                String cat = "";
                Term categoT = sol2.get("Categoria");
                if (categoT != null) {
                    cat = categoT.toString();
                }

                // Extraer recomendaciones
                String recomendacion = "";
                Term recoT = sol2.get("Recomendacion");
                if (recoT != null) {
                    List<String> recomendacionesList = proListToJavaList(recoT);
                    recomendacion = String.join(", ", recomendacionesList);
                }

                // Crear objeto Enfermedad
                Enfermedad e = new Enfermedad();
                e.setNombre(nombreEnfermedad);
                e.setListaSintomas(sintomas);
                e.setNombreCategoria(cat);
                e.setRecomendacion_basica(recomendacion);

                lista.add(e);
                System.out.println("Enfermedad añadida: " + nombreEnfermedad + " - " + cat);
            }
            q2.close();
        }
        q.close();

        System.out.println("Total enfermedades encontradas: " + lista.size());
        return lista;
    }

    /**
     * Obtiene todas las categorías únicas usando los hechos existentes
     */
    public static List<String> getTodasCategorias() {
        List<String> categorias = new ArrayList<>();
        Set<String> categoriasUnicas = new HashSet<>();

        // Consultar todas las enfermedades y extraer sus categorías
        String consulta = "enfermedad(Nombre, _, categoria(Categoria), _)";
        Query q = new Query(consulta);

        while (q.hasMoreSolutions()) {
            Map<String, Term> sol = q.nextSolution();
            String categoria = sol.get("Categoria").toString();

            if (!categoriasUnicas.contains(categoria)) {
                categoriasUnicas.add(categoria);
                categorias.add(categoria);
                System.out.println("Categoría encontrada: " + categoria);
            }
        }
        q.close();

        System.out.println("Total categorías encontradas: " + categorias.size());
        return categorias;
    }
}
