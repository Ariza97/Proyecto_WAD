package LogIn;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.PrimeFaces;

@ManagedBean
@RequestScoped

public class SignIn_Bean implements Serializable{
    private String Name;
    private String LastName;
    private String Id;
    private String Email;
    private String Password, RPassword;
    private String Cargo;

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
            
    public String validate() {
        //Revisamos que todos los campos esten llenos
        if(Name.equals("")||LastName.equals("")||Id.equals("")||Email.equals("")||Password.equals("")||RPassword.equals("")){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Debe llenar todos los campos.");
            PrimeFaces.current().dialog().showMessageDynamic(message);  
            return null;
        }
        else if(!Password.equals(RPassword)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Las constraseñas no coinciden.");
            PrimeFaces.current().dialog().showMessageDynamic(message);  
            return null;
        }
        //Mandar los datos de ID, EMAIL a la clase de la base datos
        //para descartar la existencia de otro usuario con los mismos datos
        int estado=7;
        //Si se retorno 0, es que existe la Id ya utilazada
        if(estado == 0){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Ese Id ya se encuentra en uso.");
            PrimeFaces.current().dialog().showMessageDynamic(message);  
            return null;
        //Si se retorno un 1, es que ya esta alguien usando ese email
        }else if (estado == 1) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Ese correo ya se encuentra en uso.");
            PrimeFaces.current().dialog().showMessageDynamic(message);  
            return null;            
        }
        //Si los campos anteriores cumplen redireccionamos a la siguiente pagina para que el alumno trabaje
        return "P_Alumnos/WelcomeStudents";
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
}
