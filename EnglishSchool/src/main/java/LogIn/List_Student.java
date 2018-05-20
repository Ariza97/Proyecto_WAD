package LogIn;

import entity.Profesor;
import entity.Usuarios;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
@Named(value = "list_Teacher")
@SessionScoped

public class List_Student implements Serializable {
    private SignIn_Bean persona =new SignIn_Bean();
    private static List<SignIn_Bean> lstpersona =new ArrayList<>();

    //Con esta funcion la cargas de las personas que son maestros en la base de datos
    //y ya llenas la lista
    public void agregarPersona(){
        System.err.println("AVAS");
        List_Student.lstpersona.add(this.persona);       
    }
    
    public void eliminarPersona(SignIn_Bean per){
        List_Student.lstpersona.remove(per);
    }
    
    public void modificarPersona(SignIn_Bean per){
        
    }
    
    public List<SignIn_Bean> getLstpersona() {
        return lstpersona;
    }
    public void setLstpersona(List<SignIn_Bean> lstpersona) {
        List_Student.lstpersona = lstpersona;
    }    
    public SignIn_Bean getPersona() {
        return persona;
    }
    public void setPersona(SignIn_Bean persona) {
        this.persona = persona;
    }
}
