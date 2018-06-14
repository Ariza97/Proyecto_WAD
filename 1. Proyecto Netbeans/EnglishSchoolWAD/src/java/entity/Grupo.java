package entity;

import java.util.HashSet;
import java.util.Set;


public class Grupo  implements java.io.Serializable {


     private Integer idGrupo;
     private Profesor profesor;
     private String nombre;
     private String pass;
     private Set peticions = new HashSet(0);
     private Set ejercicios = new HashSet(0);
     private Set alumnos = new HashSet(0);

    public Grupo() {
    }

    public Grupo(Profesor profesor, String nombre, String pass, Set peticions, Set ejercicios, Set alumnos) {
       this.profesor = profesor;
       this.nombre = nombre;
       this.pass = pass;
       this.peticions = peticions;
       this.ejercicios = ejercicios;
       this.alumnos = alumnos;
    }
   
    public Integer getIdGrupo() {
        return this.idGrupo;
    }
    
    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }
    public Profesor getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public Set getPeticions() {
        return this.peticions;
    }
    
    public void setPeticions(Set peticions) {
        this.peticions = peticions;
    }
    public Set getEjercicios() {
        return this.ejercicios;
    }
    
    public void setEjercicios(Set ejercicios) {
        this.ejercicios = ejercicios;
    }
    public Set getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Set alumnos) {
        this.alumnos = alumnos;
    }




}


