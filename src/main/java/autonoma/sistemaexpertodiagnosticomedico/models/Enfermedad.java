/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.sistemaexpertodiagnosticomedico.models;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Enfermedad {
    
    private int id;
    private String nombre;
    private String recomendacion_basica;
    private String nombreCategoria;
    private ArrayList<String> listaSintomas;
    
    public Enfermedad(){
        
    }

    public Enfermedad(int id, String nombre, String recomendacion_basica, String nombreCategoria, ArrayList<String> listaSintomas) {
        this.nombre = nombre;
        this.recomendacion_basica = recomendacion_basica;
        this.nombreCategoria = nombreCategoria;
        this.listaSintomas = listaSintomas;
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

    public String getRecomendacion_basica() {
        return recomendacion_basica;
    }

    public void setRecomendacion_basica(String recomendacion_basica) {
        this.recomendacion_basica = recomendacion_basica;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public ArrayList<String> getListaSintomas() {
        return listaSintomas;
    }

    public void setListaSintomas(ArrayList<String> listaSintomas) {
        this.listaSintomas = listaSintomas;
    }
    
    
}
