package LogIn;


import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.PrimeFaces;

@ManagedBean
@RequestScoped

public class LogIn_Bean implements Serializable {

    private String id;
    private String psw;

    public LogIn_Bean(){
    }

    public String validate() {
        //Aqui obtendremos el valor que retorne la clase que se conecte a la base de datos
        int estado=2;
        if(psw.equals("")||id.equals("")){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Llenar ambos campos");
            PrimeFaces.current().dialog().showMessageDynamic(message);  
            return null;        
        }
        else{
            switch (estado) {
                //Estado igual a 0, es que la cuenta es de un admin
                case 0:        
                    return "Prueba";
                //Estado igual a 1, es que la cuenta es de un profesor
                case 1:    
                    return "Prueba";
                //Estado igual a 2, es que la cuenta es de un alumno
                case 2:
                    return "P_Alumnos/WelcomeStudents";
                default:
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Constraseña o Usuario incorrecto");
                    PrimeFaces.current().dialog().showMessageDynamic(message);  
                    return null;
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
