package LogIn;

import entity.Alumno;
import entity.HibernateUtil;
import entity.Profesor;
import entity.Rol;
import entity.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.PrimeFaces;

@ManagedBean
@SessionScoped

public class List_Teacher implements Serializable {

    private SignIn_Bean persona = new SignIn_Bean();
    private List lstpersona;

    //Con esta funcion la cargas de las personas que son maestros en la base de datos
    //y ya llenas la lista
    public List_Teacher() {
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query consulta = hibernateSession.createQuery("from Usuarios where idRol = 2");
        lstpersona = consulta.list();
    }

    public String eliminarPersona(int id) {
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
        Usuarios user = (Usuarios) hibernateSession.load(Usuarios.class, id);
        hibernateSession.delete(user);
        t.commit();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario profesor eliminado", "Revise cambios");
        PrimeFaces.current().dialog().showMessageDynamic(message);
        
        lstpersona.clear();
        Query consulta = hibernateSession.createQuery("from Usuarios where idRol = 2");
        lstpersona = consulta.list();
        
        return null;
    }

    public String guardar(Usuarios u) {
        u.setEditable(false);
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
        String hql = "update Usuarios set nombre = :nombre, apellido = :apellido, idLog = :idLog where idUsuarios=" + u.getIdUsuarios() + "";
        System.out.println(hql);
        Query guarda = hibernateSession.createQuery(hql);
        guarda.setParameter("nombre", u.getNombre());
        guarda.setParameter("apellido", u.getApellido());
        guarda.setParameter("idLog", u.getIdLog());
        guarda.executeUpdate();
        t.commit();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion realizada", "Revise cambios");
        PrimeFaces.current().dialog().showMessageDynamic(message);
        return null;
    }
    
    public String actualizar(){

        //Mandar los datos de ID, EMAIL a la clase de la base datos
        //para descartar la existencia de otro usuario con los mismos datos
        int estado = 7;
        String Rmail, Rid;
        Rol TRol = new Rol(2);
        Rol SRol = new Rol(3);
        Profesor p;
        Alumno a;
        Session hibernateSession;
        Usuarios user, consultaID, consultaM;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        consultaID = (Usuarios) hibernateSession.createQuery("from Usuarios where idLog = '" + this.persona.getId() + "'").uniqueResult();
        consultaM = (Usuarios) hibernateSession.createQuery("from Usuarios where correo = '" + this.persona.getEmail() + "'").uniqueResult();

               System.out.println(this.persona.getCargo());

        if (this.persona.getCargo().equals("Teacher")) {
            user = new Usuarios(TRol, this.persona.getName(), this.persona.getLastName(), this.persona.getId(), this.persona.getEmail(), this.persona.getPassword());
            p = new Profesor(user);
            hibernateSession.save(user);
            hibernateSession.save(p);
        }
        hibernateSession.getTransaction().commit();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Inicie sesión para comenzar");
        PrimeFaces.current().dialog().showMessageDynamic(message);

        lstpersona.clear();
        Query consulta = hibernateSession.createQuery("from Usuarios where idRol = 2");
        lstpersona = consulta.list();
        
        return null;
    }

    public List getLstpersona() {
        return lstpersona;
    }

    public void setLstpersona(List lstpersona) {
        this.lstpersona = lstpersona;
    }

    public SignIn_Bean getPersona() {
        return persona;
    }

    public void setPersona(SignIn_Bean persona) {
        this.persona = persona;
    }

    public String editAction(Usuarios u) {
        u.setEditable(true);
        return null;
    }
    public void agregarPersona(){
        System.out.println(this.persona.getEmail());
        this.lstpersona.add(this.persona);
    }

}
