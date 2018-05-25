package LogIn;

import entity.Alumno;
import entity.HibernateUtil;
import entity.Profesor;
import entity.Rol;
import entity.Usuarios;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import org.primefaces.PrimeFaces;

@ManagedBean
@RequestScoped

public class SignIn_Bean implements Serializable {

    private String Name;
    private String LastName;
    private String Id;
    private String Email;
    private String Group;
    private String Password, RPassword;
    private String Cargo;

    public String getGroup() {
        return Group;
    }

    public void setGroup(String Group) {
        this.Group = Group;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRPassword() {
        return RPassword;
    }

    public void setRPassword(String RPassword) {
        this.RPassword = RPassword;
    }

    public String validate() {
        //Revisamos que todos los campos esten llenos
        if (Name.equals("") || LastName.equals("") || Id.equals("") || Email.equals("") || Password.equals("") || RPassword.equals("")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Debe llenar todos los campos.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        } else if (!Password.equals(RPassword)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Las constraseñas no coinciden.");
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
        consultaID = (Usuarios) hibernateSession.createQuery("from Usuarios where idLog = '" + Id + "'").uniqueResult();
        consultaM = (Usuarios) hibernateSession.createQuery("from Usuarios where correo = '" + Email + "'").uniqueResult();
        if (consultaID != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Ese Id ya se encuentra en uso.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        }

        if (consultaM != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Ese Correo ya se encuentra en uso.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        }

        if (Cargo.equals("Teacher")) {
            user = new Usuarios(TRol, Name, LastName, Id, Email, Password);
            p = new Profesor(user);
            hibernateSession.save(user);
            hibernateSession.save(p);
        } else {
            user = new Usuarios(SRol, Name, LastName, Id, Email, Password);
            a = new Alumno(user);
            hibernateSession.save(user);
            hibernateSession.save(a);
        }
        hibernateSession.getTransaction().commit();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Inicie sesión para comenzar");
        PrimeFaces.current().dialog().showMessageDynamic(message);
        return "index";
    }
}
