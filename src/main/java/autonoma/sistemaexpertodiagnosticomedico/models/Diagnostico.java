/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.sistemaexpertodiagnosticomedico.models;

import java.util.List;

/**
 *
 * @author Asus
 */
public class Diagnostico {
    private int id;
    private Paciente paciente;
    private List<Enfermedad> enfermedadesPosibles;
    private String sintomasIngresados;

    public Diagnostico(int id, Paciente paciente, List<Enfermedad> enfermedadesPosibles, String sintomasIngresados) {
        this.id = id;
        this.paciente = paciente;
        this.enfermedadesPosibles = enfermedadesPosibles;
        this.sintomasIngresados = sintomasIngresados;
    }
    public Diagnostico(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Enfermedad> getEnfermedadesPosibles() {
        return enfermedadesPosibles;
    }

    public void setEnfermedadesPosibles(List<Enfermedad> enfermedadesPosibles) {
        this.enfermedadesPosibles = enfermedadesPosibles;
    }

    public String getSintomasIngresados() {
        return sintomasIngresados;
    }

    public void setSintomasIngresados(String sintomasIngresados) {
        this.sintomasIngresados = sintomasIngresados;
    }
    
}
