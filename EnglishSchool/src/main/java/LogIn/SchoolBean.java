package LogIn;

import entity.Usuarios;
import entity.HibernateUtil;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@ViewScoped
public class SchoolBean implements Serializable {

    private String nombre;
    private String id;
    private String mail;
    private Usuarios estudiante;
    private final FacesContext fc;
    private final HttpServletRequest request;

    public SchoolBean() {
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) fc.getExternalContext().getRequest();
        if (request.getSession().getAttribute("sesionusuario") != null) {
            id = (String) request.getSession().getAttribute("sesionusuario");
            nombre = (String) request.getSession().getAttribute("nombre");
            mail = (String) request.getSession().getAttribute("mail");
        }
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        estudiante = (Usuarios) hibernateSession.createQuery("from Usuarios where idLog = '" + id + "' ").uniqueResult();
    }

    public String cerrarSession() {
        request.getSession().removeAttribute("sesionusuario");
        request.getSession().removeAttribute("nombre");
        request.getSession().removeAttribute("mail");
        return "/index";
    }

    public String saveChanges(Usuarios u) {
        u.setEditable(false);
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
        String hql = "update Usuarios set nombre = :nombre, apellido = :apellido, idLog = :idLog, correo = :correo, contraseña = :contraseña where idUsuarios=" + u.getIdUsuarios() + "";
        Query guarda = hibernateSession.createQuery(hql);
        guarda.setParameter("nombre", u.getNombre());
        guarda.setParameter("apellido", u.getApellido());
        guarda.setParameter("idLog", u.getIdLog());
        guarda.setParameter("correo", u.getCorreo());
        guarda.setParameter("contraseña", u.getContraseña());
        guarda.executeUpdate();
        t.commit();
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Usuarios getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Usuarios estudiante) {
        this.estudiante = estudiante;
    }

    public String editAction(Usuarios u) {
        u.setEditable(true);
        return null;
    }

}
