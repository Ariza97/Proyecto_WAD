package entity;
// Generated 21/05/2018 07:31:20 PM by Hibernate Tools 4.3.1



/**
 * Alumno generated by hbm2java
 */
public class Alumno  implements java.io.Serializable {


     private int idUsuarios;
     private Usuarios usuarios;

    public Alumno() {
    }

    public Alumno(Usuarios usuarios) {
       this.usuarios = usuarios;
    }
   
    public int getIdUsuarios() {
        return this.idUsuarios;
    }
    
    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }




}


