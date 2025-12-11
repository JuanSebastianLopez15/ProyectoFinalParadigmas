/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package autonoma.sistemaexpertodiagnosticomedico.main;

import autonoma.sistemaexpertodiagnosticomedico.models.Enfermedad;
import autonoma.sistemaexpertodiagnosticomedico.models.FactsBuilder;
import autonoma.sistemaexpertodiagnosticomedico.models.PrologQueryExecutor;
import autonoma.sistemaexpertodiagnosticomedico.views.VentanaPrincipal;
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
        FactsBuilder.construirFactsEnfermedad();
        //Consulta
        List<Enfermedad> lista = PrologQueryExecutor.getEnfermedades("enfermedad(Nombre, sintomas(Sintomas), categoria(Categoria),recomendaciones(Recomendacion)).");
        for(Enfermedad e : lista){
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Sintomas: " + e.getListaSintomas());
            System.out.println("Categoria: " + e.getNombreCategoria());
            System.out.println("Recomendacion: " + e.getRecomendacion_basica());
        }      
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        
    }
}
