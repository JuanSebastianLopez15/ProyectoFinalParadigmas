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
public class Enfermedad {
    
    private String nombre;
    private String recomendacion_basica;
    private String nombreCategoria;
    private List<String> listaSintomas;
    
    public Enfermedad(){
        this.listaSintomas = new ArrayList<>();
    }

    public Enfermedad(String nombre, List listaSintomas , String nombreCategoria,String recomendacion_basica) {
        this.nombre = nombre;
        this.listaSintomas = listaSintomas;
        this.nombreCategoria = nombreCategoria;
        this.recomendacion_basica = recomendacion_basica;
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

    public List<String> getListaSintomas() {
        return listaSintomas;
    }

    public void setListaSintomas(List<String> listaSintomas) {
        this.listaSintomas = listaSintomas;
    }

}
