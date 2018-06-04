package ChangeToTeacher;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class navigationBetweenPages {

    
    public navigationBetweenPages() {
    }
    
    public String welcomeToSettings(){
        System.out.println("Cambiando a pagina Settings");
        return "Settings";
    }
    public String settingsToWelcome(){
        System.out.println("Cambiando a pagina WelcomeTeacher");
        return "WelcomeTeacher";
    }
    public String welcomeToStudents(){
        System.out.println("Cambiando a pagina Students");
        return "Students";
    }
    public String studentToWelcome(){
        System.out.println("Cambiando a pagina WelcomeTeacher");
        return "WelcomeTeacher";
    }
}
