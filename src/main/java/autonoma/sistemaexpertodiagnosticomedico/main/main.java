package autonoma.sistemaexpertodiagnosticomedico.main;

import autonoma.sistemaexpertodiagnosticomedico.models.FactsBuilder;
import autonoma.sistemaexpertodiagnosticomedico.views.VentanaPrincipal;
import org.jpl7.Query;

public class main {

    public static void main(String[] args) {
        // Cargar Prolog
        Query q = new Query("consult('prologPF.pl')");

        if (q.hasSolution()) {
            System.out.println("Prolog cargado.");

            // Cargar enfermedades desde BD a Prolog
            FactsBuilder.construirFactsEnfermedad();

            // Abrir ventana
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);

        } else {
            System.out.println("Error cargando Prolog.");
        }
    }
}
