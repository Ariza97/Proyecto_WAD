package ChangeToTeacher;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class navigationBetweenPages implements Serializable {

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
}
