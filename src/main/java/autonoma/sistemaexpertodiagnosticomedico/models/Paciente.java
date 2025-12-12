/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.sistemaexpertodiagnosticomedico.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Paciente {
    private int id;
    private String nombre;
    private int edad;
    private List<String> sintomas;
    
    public Paciente(){
        this.sintomas = new ArrayList<>();
    }

    public Paciente(String nombre, int edad, List<String> sintomas) {
        this.nombre = nombre;
        this.edad = edad;
        this.sintomas = sintomas;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<String> sintomas) {
        this.sintomas = sintomas;
    }    
    
    // Metodo para registrar el paciente en la base de datos
    public int registrarEnBaseDatos() throws Exception {
        PacienteDAO pacienteDAO = new PacienteDAO();

        
        Paciente existente = pacienteDAO.buscarPorNombre(this.nombre);
        if (existente != null) {
            throw new Exception("Ya existe un paciente con ese nombre");
        }

        
        if (this.nombre == null || this.nombre.trim().isEmpty()) {
            throw new Exception("El nombre del paciente es requerido");
        }

        if (this.edad <= 0 || this.edad > 120) {
            throw new Exception("La edad debe ser un valor válido (1-120)");
        }

        // Insertar en la base de datos
        int pacienteId = pacienteDAO.insertarPaciente(this);
        this.id = pacienteId;

        return pacienteId;
    }

    @Override
    public String toString() {
        return nombre + " (Edad: " + edad + ")";
    }
    
}
