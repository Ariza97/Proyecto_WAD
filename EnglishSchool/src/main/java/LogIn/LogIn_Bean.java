package LogIn;

import entity.HibernateUtil;
import entity.Usuarios;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.primefaces.PrimeFaces;

@ManagedBean
@RequestScoped

public class LogIn_Bean implements Serializable {

    private final HttpServletRequest request;
    private String id;
    private String psw;
    private final FacesContext fc;

    public LogIn_Bean() {
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) fc.getExternalContext().getRequest();
    }

    public String validate() {
        int tipo;
        String nombre;
        Session hibernateSession;
        Usuarios user;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        if (psw.equals("") || id.equals("")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Llenar ambos campos");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return "index";
        } else {
            user = (Usuarios) hibernateSession.createQuery("from Usuarios where idLog = '" + id + "' and contraseña ='" + psw + "'").uniqueResult();

            if (user == null) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Constraseña o Usuario incorrecto");
                PrimeFaces.current().dialog().showMessageDynamic(message);
                return "index";
            }
            tipo = user.getRol().getIdRol();
            request.getSession().setAttribute("sesionusuario", id);
            nombre = ""+user.getNombre()+" "+user.getApellido();
            request.getSession().setAttribute("nombre", nombre);
            switch (tipo) {
                case 1:
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Entro", "Administrador");
                    PrimeFaces.current().dialog().showMessageDynamic(message);
                    return "index";
                case 2:
                    FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Entro", "Profesor");
                    PrimeFaces.current().dialog().showMessageDynamic(message1);
                    return "index";
                case 3:
                    return "P_Alumnos/WelcomeStudents";
                default:
                    FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Constraseña o Usuario incorrecto");
                    PrimeFaces.current().dialog().showMessageDynamic(message2);
                    return "index";
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

}
