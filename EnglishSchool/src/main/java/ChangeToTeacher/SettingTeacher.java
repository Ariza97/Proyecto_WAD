package ChangeToTeacher;

import entity.HibernateUtil;
import entity.Usuarios;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;

@ManagedBean
@RequestScoped

public class SettingTeacher implements Serializable{
    private Profesor NProfesor =new Profesor();
    private final FacesContext fc;
    private final HttpServletRequest request;
    private String id;
    private String nombre;
    
    public SettingTeacher(){
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) fc.getExternalContext().getRequest();
        if (request.getSession().getAttribute("sesionusuario") != null) {
            id = (String) request.getSession().getAttribute("sesionusuario");
            nombre = (String) request.getSession().getAttribute("nombre");
        }
        
        System.out.println("Nombre: "+nombre);
        NProfesor.setName("Aris");
        NProfesor.setLast_name("Ariza");
        NProfesor.setUser_name("IdMalo");
        NProfesor.setPassword("123");
        NProfesor.setEmail("ariza@gmail.com");
        //Session hibernateSession;
        //Usuarios user;
        //hibernateSession = HibernateUtil.getSessionFactory().openSession();
        //hibernateSession.beginTransaction();
        //    user = (Usuarios) hibernateSession.createQuery("from Usuarios where nombre = '" + name + "'");
    }

    public Profesor getNProfesor() {
        return NProfesor;
    }

    public void setNProfesor(Profesor NProfesor) {
        this.NProfesor = NProfesor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
