/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package autonoma.sistemaexpertodiagnosticomedico.main;

import autonoma.sistemaexpertodiagnosticomedico.models.PrologQueryExecutor;
import java.util.List;
import org.jpl7.Query;

/**
 *
 * @author Asus
 */
public class main {

    public static void main(String[] args) {
        String rules = "consult('prologPF.pl')";
       
        Query q = new Query(rules);

        if (q.hasSolution()) {
            System.out.println("Archivo Prolog cargado correctamente.");
        }
        FactsBuilder.construirFactsOrganismo();
        List<Organismo> lista = PrologQueryExecutor.getAnimals("organismo(Id, jaguar, Especie)");
        for(Organismo o : lista){
            System.out.println("Nombre: " + o.getId());
            System.out.println("Nombre: " + o.getNombre());
            System.out.println("Nombre: " + o.getEspecie());
        }      
        List<Depredacion> depredaciones = PrologQueryExecutor.getDepredaciones("depreda(Depredador, Presa).");
        for(Depredacion d : depredaciones){
            System.out.println("Depredador: " + d.getDepredador());
            System.out.println("Presa: " + d.getPresa());
        }   
    }
}
