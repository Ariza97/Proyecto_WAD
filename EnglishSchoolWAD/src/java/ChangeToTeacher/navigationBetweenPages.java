package ChangeToTeacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class navigationBetweenPages implements Serializable {

    String jdom;
    File file =new File("");
    String nameFile;
    final String basic_canva ="{\"version\":\"2.2.4\",\"objects\":[]}";
    
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
//Deleted Exercices
    public void deletedExercises(String num_ejercicio){
        System.out.println("Borrando");
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
            deleted_file(grupo, num_ejercicio);
        }  
    }
    public void deleted_file(String Grupo, String Nivel){
        switch (Grupo) {
            case "1CM1":
                switch (Nivel) {
                    case "uno":
                            fileWritter(file.getAbsolutePath()+"\\1CM1_Uno.txt", basic_canva);
                        break;
                    case "dos":
                            fileWritter(file.getAbsolutePath()+"\\1CM1_Dos.txt", basic_canva);
                            break;
                    default:
                            fileWritter(file.getAbsolutePath()+"\\1CM1_Tres.txt", basic_canva);
                        break;
                }   
                break;
            case "1CM2":
                switch (Nivel) {
                    case "uno":
                            fileWritter(file.getAbsolutePath()+"\\1CM2_Uno.txt", basic_canva);
                        break;
                    case "dos":
                            fileWritter(file.getAbsolutePath()+"\\1CM2_Dos.txt", basic_canva);
                            break;
                    default:
                            fileWritter(file.getAbsolutePath()+"\\1CM2_Tres.txt", basic_canva);
                        break;
                }   
                break;
            case "1CM3":
                switch (Nivel) {
                    case "uno":
                            fileWritter(file.getAbsolutePath()+"\\1CM3_Uno.txt", basic_canva);
                        break;
                    case "dos":
                            fileWritter(file.getAbsolutePath()+"\\1CM3_Dos.txt", basic_canva);                  
                            break;
                    default:
                            fileWritter(file.getAbsolutePath()+"\\1CM3_Tres.txt", basic_canva);
                        break;
                }   
                break;
            case "1CM4":
                switch (Nivel) {
                    case "uno":
                            fileWritter(file.getAbsolutePath()+"\\1CM4_Uno.txt", basic_canva);
                        break;
                    case "dos":
                            fileWritter(file.getAbsolutePath()+"\\1CM4_Dos.txt", basic_canva);
                            break;
                    default:
                            fileWritter(file.getAbsolutePath()+"\\1CM4_Tres.txt", basic_canva);
                        break;
                }   
                break;
            case "1CM5":
                switch (Nivel) {
                    case "uno":
                            fileWritter(file.getAbsolutePath()+"\\1CM5_Uno.txt", basic_canva);
                        break;
                    case "dos":
                            fileWritter(file.getAbsolutePath()+"\\1CM5_Dos.txt", basic_canva);
                            break;
                    default:
                            fileWritter(file.getAbsolutePath()+"\\1CM5_Tres.txt", basic_canva);
                        break;
                }   
                break;
            default:
                switch (Nivel) {
                    case "uno":
                            fileWritter(file.getAbsolutePath()+"\\1CM6_Uno.txt", basic_canva);
                        break;
                    case "dos":
                            fileWritter(file.getAbsolutePath()+"\\1CM6_Dos.txt", basic_canva);
                            break;
                    default:
                            fileWritter(file.getAbsolutePath()+"\\1CM6_Tres.txt", basic_canva);
                        break;
                }   
                break;
        }
        
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
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM1_Uno.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM1_Uno.txt");
                        break;
                    case "dos":
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM1_Dos.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM1_Dos.txt");                        
                            break;
                    default:
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM1_Tres.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM1_Tres.txt");
                        break;
                }   
                break;
            case "1CM2":
                switch (Nivel) {
                    case "uno":
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM2_Uno.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM2_Uno.txt");
                        break;
                    case "dos":
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM2_Dos.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM2_Dos.txt");                        
                            break;
                    default:
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM2_Tres.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM2_Tres.txt");
                        break;
                }   
                break;
            case "1CM3":
                switch (Nivel) {
                    case "uno":
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM3_Uno.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM3_Uno.txt");
                        break;
                    case "dos":
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM3_Dos.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM3_Dos.txt");                        
                            break;
                    default:
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM3_Tres.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM3_Tres.txt");
                        break;
                }   
                break;
            case "1CM4":
                switch (Nivel) {
                    case "uno":
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM4_Uno.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM4_Uno.txt");
                        break;
                    case "dos":
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM4_Dos.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM4_Dos.txt");                        
                            break;
                    default:
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM4_Tres.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM4_Tres.txt");
                        break;
                }   
                break;
            case "1CM5":
                switch (Nivel) {
                    case "uno":
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM5_Uno.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM5_Uno.txt");
                        break;
                    case "dos":
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM5_Dos.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM5_Dos.txt");                        
                            break;
                    default:
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM5_Tres.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM5_Tres.txt");
                        break;
                }   
                break;
            default:
                switch (Nivel) {
                    case "uno":
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM6_Uno.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM6_Uno.txt");
                        break;
                    case "dos":
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM6_Dos.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM6_Dos.txt");                        
                            break;
                    default:
                            fileWritter(file.getAbsolutePath()+"\\Datos.txt", file.getAbsolutePath()+"\\1CM6_Tres.txt");
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM6_Tres.txt");
                        break;
                }   
                break;
        }
    }
    public String getJdom() {
        return jdom;
    }    
    public void getjdom(){
        System.out.println("JDOM: "+jdom);
        System.out.println("Ruta: "+fileReader(file.getAbsolutePath()+"\\Datos.txt"));
        fileWritter(fileReader(file.getAbsolutePath()+"\\Datos.txt"),jdom);
    }
    public void setJdom(String jdom) {
        this.jdom = jdom;
    }
//Use of file
    public String fileReader(String direccion){
        String respuesta ="";
        try{
            BufferedReader bf =new BufferedReader(new FileReader(direccion));
            String temp ="";
            String bfRead;
            while((bfRead= bf.readLine()) != null){
                temp =temp +bfRead;
            }
            
            respuesta =temp;
        }catch(IOException e){
            respuesta =basic_canva;
        }
        
        return respuesta;
    }
    public void fileWritter(String direccion, String contenido){
        File miArchivo;
        PrintWriter escribir;
        
        miArchivo =new File(direccion);
        try {
            miArchivo.createNewFile();
            escribir =new PrintWriter(miArchivo);
            escribir.println(contenido); 
            escribir.close();
        } catch (IOException ex) {
            Logger.getLogger(navigationBetweenPages.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    //Student
    public String toHomework(String num_ejercicio) {
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
            cargarJDOM_student(num_ejercicio);
        }
        return "Homework";
    }
    public void cargarJDOM_student(String Nivel){        
                switch (Nivel) {
                    case "uno":
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM1_Uno.txt");
                            System.out.println("JDOM: " +jdom);
                        break;
                    case "dos":
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM1_Dos.txt");                        
                            break;
                    default:
                            jdom =fileReader(file.getAbsolutePath()+"\\1CM1_Tres.txt");
                        break;
                }   
    }
}
