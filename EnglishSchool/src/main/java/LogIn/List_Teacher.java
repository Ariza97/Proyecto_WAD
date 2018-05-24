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
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Teacher deleted", "Review changed");
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
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Change saved", "Verify that all is okey");
        PrimeFaces.current().dialog().showMessageDynamic(message);
        return null;
    }
    
    public String actualizar(){
        //Revisamos que todos los campos esten llenos
        if (this.persona.getName().equals("") || this.persona.getLastName().equals("") || this.persona.getId().equals("") || this.persona.getEmail().equals("") || this.persona.getPassword().equals("") || this.persona.getRPassword().equals("")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Check", "All fields must be full");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        } else if (!this.persona.getPassword().equals(this.persona.getRPassword())) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Check", "The passwords doesn't coincide");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        }
        
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

        if (consultaID != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Check", "This Id is used");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        }
        if (consultaM != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Check", "This E-mail is used");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        }
        
        if (this.persona.getCargo().equals("Teacher")) {
            user = new Usuarios(TRol, this.persona.getName(), this.persona.getLastName(), this.persona.getId(), this.persona.getEmail(), this.persona.getPassword());
            p = new Profesor(user);
            hibernateSession.save(user);
            hibernateSession.save(p);
        }
        else {
            user = new Usuarios(SRol, this.persona.getName(), this.persona.getLastName(), this.persona.getId(), this.persona.getEmail(), this.persona.getPassword());
            a = new Alumno(user);
            hibernateSession.save(user);
            hibernateSession.save(a);
        }
        
        hibernateSession.getTransaction().commit();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Register Succesfuly", "Reload the page");
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
