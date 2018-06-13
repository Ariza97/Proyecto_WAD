package entity;

public class Usuarios implements java.io.Serializable {

    private Integer idUsuarios;
    private Rol rol;
    private String nombre;
    private String apellido;
    private String idLog;
    private String correo;
    private String pass;
    private Profesor profesor;
    private Alumno alumno;
    private boolean editable;
    private Administrador administrador;

    public Usuarios() {
    }

    public Usuarios(Rol rol, String nombre, String apellido, String idLog, String correo, String pass) {
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idLog = idLog;
        this.correo = correo;
        this.pass = pass;
    }

    public Usuarios(Rol rol, String nombre, String apellido, String idLog, String correo, String pass, Profesor profesor, Alumno alumno, Administrador administrador) {
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idLog = idLog;
        this.correo = correo;
        this.pass = pass;
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

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
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
