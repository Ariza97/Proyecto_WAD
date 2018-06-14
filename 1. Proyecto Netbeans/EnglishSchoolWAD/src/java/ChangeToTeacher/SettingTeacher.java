package ChangeToTeacher;

import entity.HibernateUtil;
import entity.Usuarios;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@SessionScoped

public class SettingTeacher implements Serializable {

    private Usuarios NProfesor;
    private final FacesContext fc;
    private final HttpServletRequest request;
    private String id;
    private String nombre;

    public SettingTeacher() {
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) fc.getExternalContext().getRequest();
        if (request.getSession().getAttribute("sesionusuario") != null) {
            id = (String) request.getSession().getAttribute("sesionusuario");
            nombre = (String) request.getSession().getAttribute("nombre");
        }
        String hql = "from Usuarios where idLog = '" + id + "' ";
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
        this.NProfesor = (Usuarios) hibernateSession.createQuery(hql).uniqueResult();
        System.out.println(hql);
        t.commit();
    }

    public String saveChanges(Usuarios u) {
        u.setEditable(false);
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
        String hql = "update Usuarios set nombre = :nombre, apellido = :apellido, idLog = :idLog, correo = :correo, pass = :pass where idUsuarios=" + u.getIdUsuarios() + "";
        Query guarda = hibernateSession.createQuery(hql);
        guarda.setParameter("nombre", u.getNombre());
        guarda.setParameter("apellido", u.getApellido());
        guarda.setParameter("idLog", u.getIdLog());
        guarda.setParameter("correo", u.getCorreo());
        guarda.setParameter("pass", u.getPass());
        guarda.executeUpdate();
        t.commit();
        return null;
    }

    public Usuarios getNProfesor() {
        return NProfesor;
    }

    public void setNProfesor(Usuarios NProfesor) {
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

    public String editAction(Usuarios u) {
        u.setEditable(true);
        return null;
    }
}
