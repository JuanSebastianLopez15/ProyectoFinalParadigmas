package autonoma.sistemaexpertodiagnosticomedico.main;

import autonoma.sistemaexpertodiagnosticomedico.models.Enfermedad;
import autonoma.sistemaexpertodiagnosticomedico.models.FactsBuilder;
import autonoma.sistemaexpertodiagnosticomedico.models.PrologQueryExecutor;
import autonoma.sistemaexpertodiagnosticomedico.views.VentanaPrincipal;
import java.util.List;
import org.jpl7.Query;

public class main {

    public static void main(String[] args) {
        // Cargar Prolog
        Query q = new Query("consult('prologPF.pl')");

        if (q.hasSolution()) {
            System.out.println("Prolog cargado.");

            // Cargar enfermedades desde BD a Prolog
            FactsBuilder.construirFactsEnfermedad();
            
            //Consultas Enfermedades
            List<Enfermedad> lista = PrologQueryExecutor.getEnfermedades("enfermedad(Nombre,sintomas(Sintomas),categoria(Categoria),recomendaciones(Recomendaciones))");
            for (Enfermedad e : lista) {
                System.out.println("Nombre: " + e.getNombre());
                System.out.println("Sintomas: " + e.getListaSintomas());
                System.out.println("Categoria: " + e.getNombreCategoria());
                System.out.println("Recomendaciones: " + e.getRecomendacion_basica());
            }
            
            // Abrir ventana
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);

        } else {
            System.out.println("Error cargando Prolog.");
        }
    }
}
