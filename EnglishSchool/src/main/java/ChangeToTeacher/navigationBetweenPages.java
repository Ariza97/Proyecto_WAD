package ChangeToTeacher;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@ViewScoped
@RequestScoped
public class navigationBetweenPages implements Serializable {

    private String jdom;
    
    public navigationBetweenPages() {
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
        if(Grupo.equals("1CM1")){
            switch (Nivel) {
                case "uno":
                    jdom ="{\"version\":\"2.2.4\",\"objects\":[]}";
                    System.out.println(jdom);
                    break;
                case "dos":
                    break;
                default:
                    break;
            }
        }
    }

    public String getJdom() {
        return jdom;
    }

    public void setJdom(String jdom) {
        this.jdom = jdom;
    }

}
