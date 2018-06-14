package LogIn;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped

public class Teacher_Bean implements Serializable {

    private final FacesContext fc;
    private final HttpServletRequest request;
    private String id;
    private String nombre;
    private String grupo;

    public Teacher_Bean() {
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) fc.getExternalContext().getRequest();
        if (request.getSession().getAttribute("sesionusuario") != null) {
            id = (String) request.getSession().getAttribute("sesionusuario");
            nombre = (String) request.getSession().getAttribute("nombre");
            grupo = (String) request.getSession().getAttribute("grupo");
        }
    }

    public String cerrarSession() {
        try {
            request.getSession().removeAttribute("sesionusuario");
            request.getSession().removeAttribute("nombre");
            request.getSession().removeAttribute("mail");
            request.getSession().removeAttribute("grupo");
        } catch (Exception e) {
        }
        return "/index";
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

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
