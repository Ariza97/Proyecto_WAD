package LogIn;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped

public class Administrator_Bean implements Serializable {

    private final FacesContext fc;
    private final HttpServletRequest request;
    private String id ="Feo";
    private String nombre ="Perro";
    private String mail ="e@gmail.com";

    public Administrator_Bean() {        
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) fc.getExternalContext().getRequest();
        if (request.getSession().getAttribute("sesionusuario") != null) {
            id = (String) request.getSession().getAttribute("sesionusuario");
            nombre = (String) request.getSession().getAttribute("nombre");
        }
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
