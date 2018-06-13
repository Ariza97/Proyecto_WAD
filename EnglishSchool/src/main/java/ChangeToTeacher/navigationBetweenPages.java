package ChangeToTeacher;

import java.io.Serializable;
import java.net.URL;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@ViewScoped
@RequestScoped
public class navigationBetweenPages implements Serializable {

    private String jdom;
    
    public navigationBetweenPages() {
    }
    
    public String studentSettings() {
        System.out.println("Cambiando a pagina Settings de Students");
        return "studentSettings";
    }
    
    public String studentExercises() {
        System.out.println("Cambiando a pagina Exercise de Students");
        return "studentExercises";
    }
    
    public String mainStudents() {
        System.out.println("Cambiando a pagina Exercise de Students");
        return "WelcomeStudents";
    }
    
    public String welcomeToSettings() {
        System.out.println("Cambiando a pagina Settings");
        return "Settings";
    }
    public String settingsToWelcome() {
        System.out.println("Cambiando a pagina WelcomeTeacher");
        return "WelcomeTeacher";
    }
    public String welcomeToStudents() {
        System.out.println("Cambiando a pagina Students");
        return "Students";
    }
    public String studentToWelcome() {
        System.out.println("Cambiando a pagina WelcomeTeacher");
        return "WelcomeTeacher";
    }
    public String welcomeToExercises(){
        System.out.println("Cambiando a pagina Exercices");
        return "Exercises";        
    }
    public String exercisestToWelcome() {
        System.out.println("Cambiando a pagina WelcomeTeacher");
        return "WelcomeTeacher";
    }

//HW1
    public String toExercises() {
        System.out.println("Cambiando a pagina WelcomeTeacher");
        return "Exercises";
    }
    public String toHW_1(String num_ejercicio) {
        System.out.println("Cambiando a pagina HW");
     FacesContext fc;
     HttpServletRequest request;
     String id;
     String nombre;
     String grupo;
    
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) fc.getExternalContext().getRequest();
        if (request.getSession().getAttribute("sesionusuario") != null) {
            id = (String) request.getSession().getAttribute("sesionusuario");
            nombre = (String) request.getSession().getAttribute("nombre");
            grupo = (String) request.getSession().getAttribute("grupo");
        System.out.println("Grupo:" +grupo);
        System.out.println("num ejercicio:" +num_ejercicio);
            cargarJDOM(grupo, num_ejercicio);
        }
        return "HW";
    }
    public void cargarJDOM(String Grupo, String Nivel){
        switch (Grupo) {
            case "1CM1":
                switch (Nivel) {
                    case "uno":
                        jdom ="{\"version\":\"2.2.4\",\"objects\":[]}";
                        System.out.println(jdom);
                        break;
                    case "dos":
                        //        File dir = new File(System.getProperty("user.dir")+"\\clientecanciones");
                        
                        break;
                    default:
                        break;
                }   break;
            case "1CM2":
                switch (Nivel) {
                    case "uno":
                        jdom ="{\"version\":\"2.2.4\",\"objects\":[]}";
                        System.out.println(jdom);
                        break;
                    case "dos":
                        break;
                    default:
                        break;
                }   break;
            case "1CM3":
                switch (Nivel) {
                    case "uno":
                        jdom ="{\"version\":\"2.2.4\",\"objects\":[]}";
                        System.out.println(jdom);
                        break;
                    case "dos":
                        break;
                    default:
                        break;
                }   break;
            case "1CM4":
                switch (Nivel) {
                    case "uno":
                        jdom ="{\"version\":\"2.2.4\",\"objects\":[]}";
                        System.out.println(jdom);
                        break;
                    case "dos":
                        break;
                    default:
                        break;
                }   break;
            case "1CM5":
                switch (Nivel) {
                    case "uno":
                        jdom ="{\"version\":\"2.2.4\",\"objects\":[]}";
                        System.out.println(jdom);
                        break;
                    case "dos":
                        break;
                    default:
                        break;
                }   break;
            default:
                switch (Nivel) {
                    case "uno":
                        jdom ="{\"version\":\"2.2.4\",\"objects\":[]}";
                        System.out.println(jdom);
                        break;
                    case "dos":
                        break;
                    default:
                        break;                 
                }   break;
        }
    }

    public String getJdom() {
        return jdom;
    }
    
    public void getjdom(){
        System.out.println("Gay: "+jdom);
         
        String directorioActual = System.getProperty("file.separator");
        System.out.println("Direccion: "+directorioActual);
    }

    public void setJdom(String jdom) {
        this.jdom = jdom;
    }

}
