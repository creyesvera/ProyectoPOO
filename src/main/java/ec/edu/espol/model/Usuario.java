/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Usuario {
    protected int id;
    protected String nombres;
    protected String apellidos;
    protected String correo_elec;
    protected String organizacion;
    protected String clave;


    public Usuario(int id, String nombres, String apellidos, String correo_elec, String organizacion, String clave) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo_elec = correo_elec;
        this.organizacion = organizacion;
        this.clave = clave;
    }
    
    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo_elec() {
        return correo_elec;
    }

    public void setCorreo_elec(String correo_elec) {
        this.correo_elec = correo_elec;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.correo_elec, other.correo_elec)) {
            return false;
        }
        if (!Objects.equals(this.organizacion, other.organizacion)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo_elec=" + correo_elec + ", organizacion=" + organizacion + ", clave=" + clave + '}';
    }
    
    public static void nextUsuario(Scanner sc, String nomfile)
    {
        
        System.out.println("Por favor ingrese sus nombres: ");
        String nombres = sc.next();
        System.out.println("Por favor ingrese sus apellidos: ");
        String apellidos = sc.next();
            System.out.println("Por favor ingrese su correo electronico: ");
            String correo_elec = sc.next();
            //poner al inicio
        System.out.println("Por favor ingrese su organizacion: ");
        String organizacion = sc.next();
        
            System.out.println("Por favor ingrese su clave: ");
            String clave = sc.next();
            //poner al inicion
            //usar validacion para ver si esta o no registrado en caso de que si no permitir la realizacion de las otras funciones
       
        int id = Util.nextID(nomfile);
        Usuario user = new Usuario(id, nombres, apellidos, correo_elec, organizacion,clave);
        user.saveFile(nomfile);
    }
    
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.nombres+"|"+this.apellidos+"|"+this.correo_elec+"|"+this.organizacion+"|"+this.clave);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Usuario> readFile(String nomfile){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                // linea = "1|20201010|eduardo|cruz"
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Usuario user = new Usuario(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                usuarios.add(user);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return usuarios;
        
    }
    
    
    public static Usuario searchByID(ArrayList<Usuario> usuarios, int id)
    {
        for(Usuario user : usuarios)
        {
            if(user.id == id)
                return user;
        }
        return null;
    }    
    
    public static Usuario searchByCorreoYClave(ArrayList<Usuario> usuarios, String correo,String clave)
    {
        for(Usuario user : usuarios)
        {
            if(user.correo_elec.equals(correo) && user.clave.equals(clave) )
                return user;
        }
        return null;
    }
   
}
