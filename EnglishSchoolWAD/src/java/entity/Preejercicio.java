package entity;

public class Preejercicio  implements java.io.Serializable {


     private Integer idPreEjercicio;
     private Profesor profesor;
     private String datos;

    public Preejercicio() {
    }

    public Preejercicio(Profesor profesor, String datos) {
       this.profesor = profesor;
       this.datos = datos;
    }
   
    public Integer getIdPreEjercicio() {
        return this.idPreEjercicio;
    }
    
    public void setIdPreEjercicio(Integer idPreEjercicio) {
        this.idPreEjercicio = idPreEjercicio;
    }
    public Profesor getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public String getDatos() {
        return this.datos;
    }
    
    public void setDatos(String datos) {
        this.datos = datos;
    }




}


