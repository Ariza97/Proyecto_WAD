package entity;
// Generated 16/05/2018 10:27:10 AM by Hibernate Tools 4.3.1



/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private Integer idUsuarios;
     private Rol rol;
     private String nombre;
     private String apellido;
     private String idLog;
     private String correo;
     private String contraseña;
     private Profesor profesor;
     private Alumno alumno;
     private Administrador administrador;

    public Usuarios() {
    }

	
    public Usuarios(Rol rol, String nombre, String apellido, String idLog, String correo, String contraseña) {
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idLog = idLog;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    public Usuarios(Rol rol, String nombre, String apellido, String idLog, String correo, String contraseña, Profesor profesor, Alumno alumno, Administrador administrador) {
       this.rol = rol;
       this.nombre = nombre;
       this.apellido = apellido;
       this.idLog = idLog;
       this.correo = correo;
       this.contraseña = contraseña;
       this.profesor = profesor;
       this.alumno = alumno;
       this.administrador = administrador;
    }
   
    public Integer getIdUsuarios() {
        return this.idUsuarios;
    }
    
    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getIdLog() {
        return this.idLog;
    }
    
    public void setIdLog(String idLog) {
        this.idLog = idLog;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContraseña() {
        return this.contraseña;
    }
    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public Profesor getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public Alumno getAlumno() {
        return this.alumno;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Administrador getAdministrador() {
        return this.administrador;
    }
    
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }




}

