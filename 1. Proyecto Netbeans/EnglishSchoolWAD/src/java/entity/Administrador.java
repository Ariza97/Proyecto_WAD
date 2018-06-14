package entity;

public class Administrador  implements java.io.Serializable {


     private int idUsuarios;
     private Usuarios usuarios;

    public Administrador() {
    }

    public Administrador(Usuarios usuarios) {
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


