package ChangeToTeacher;

import entity.HibernateUtil;
import entity.Usuarios;
import entity.Grupo;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.Serializable;
import org.hibernate.Query;

@ManagedBean
@ViewScoped
public class GroupStudents implements Serializable {

    private final FacesContext fc;
    private final HttpServletRequest request;
    private String id;
    private String nombre;
    private List lstStudents;

    public GroupStudents() {
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) fc.getExternalContext().getRequest();
        if (request.getSession().getAttribute("sesionusuario") != null) {
            id = (String) request.getSession().getAttribute("sesionusuario");
            nombre = (String) request.getSession().getAttribute("nombre");
        }
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
        Usuarios p = (Usuarios) hibernateSession.createQuery("from Usuarios where idLog = '" + id + "' ").uniqueResult();
        Grupo g = (Grupo) hibernateSession.createQuery("from Grupo where idUsuarios = " + p.getIdUsuarios() + "").uniqueResult();
        String hql = "select u.idUsuarios,u.nombre,u.apellido,u.correo,u.contraseña from alumno_grupo a, usuarios u where a.idGrupo = " + g.getIdGrupo() + " and a.idUsuarios=u.idUsuarios;";
        Query consulta = hibernateSession.createSQLQuery(hql);
        lstStudents = consulta.list();
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

    public List getLstStudents() {
        return lstStudents;
    }

    public void setLstStudents(List lstStudents) {
        this.lstStudents = lstStudents;
    }

}
