package LogIn;

import entity.Profesor;
import entity.Usuarios;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@Named(value = "list_Teacher")
@SessionScoped
public class List_Teacher implements Serializable {
    
    private String Name, Last_Name, Id;
    private ArrayList <Usuarios> lst= null;
    private Usuarios ms;


    public List_Teacher() {
    }

    //Esta funcion recibe los datos que el usuario selecciono para eliminar
    public void recibirDatos(){
                Usuarios U =new Usuarios();
                U.setNombre("Nombre #");
                U.setApellido("Apellido #");
                U.setIdLog("Id");
                lst.add(U);
        System.out.print("ssssssssssss");        
    }
    public void deleteTeacher(){
        System.out.println("#############DDDDDDDDDDD");
    }
    
    public ArrayList<Usuarios> getLst() {        
            lst =new ArrayList<>();
            //Aqui es donde debemos llenar la lista con la consulta
            //por ahora lo hago manual
            for(int i=0; i<10; i++){                
                Usuarios U =new Usuarios();
                U.setNombre("Nombre #"+i);
                U.setApellido("Apellido #"+i);
                U.setIdLog("Id" +i);
                lst.add(U);
            }
        
        return lst;
    }

    public void setLst(ArrayList<Usuarios> lst) {
        this.lst = lst;
    }

        public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
  
    public Usuarios getMs() {
        return ms;
    }

    public void setMs(Usuarios ms) {
        this.ms = ms;
    }  
}
