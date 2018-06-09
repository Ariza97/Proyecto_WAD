package LogIn;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped

public class Administrator_Bean implements Serializable {

    private final FacesContext fc;
    private final HttpServletRequest request;
    private String id;
    private String nombre;
    private String mail;

    public Administrator_Bean() {
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) fc.getExternalContext().getRequest();
        if (request.getSession().getAttribute("sesionusuario") != null) {
            id = (String) request.getSession().getAttribute("sesionusuario");
            nombre = (String) request.getSession().getAttribute("nombre");
            mail = (String) request.getSession().getAttribute("mail");
        }
    }

    public String cerrarSession() {
        request.getSession().removeAttribute("sesionusuario");
        request.getSession().removeAttribute("nombre");
        request.getSession().removeAttribute("mail");
        return "/index";
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
