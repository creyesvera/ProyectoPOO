/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author camil
 */
public class Vendedor {
    private int id;
    private String nombres;
    private String apellidos;
    private String organizacion;
    private String correo_elec;
    private String clave;
    private ArrayList<Vehiculo> vehiculos;

    public Vendedor(int id, String nombres, String apellidos, String organizacion, String correo_elec, String clave, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correo_elec = correo_elec;
        this.clave = clave;
        this.vehiculos = vehiculos;
    }

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

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getCorreo_elec() {
        return correo_elec;
    }

    public void setCorreo_elec(String correo_elec) {
        this.correo_elec = correo_elec;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }


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
        final Vendedor other = (Vendedor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.organizacion, other.organizacion)) {
            return false;
        }
        if (!Objects.equals(this.correo_elec, other.correo_elec)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.vehiculos, other.vehiculos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", organizacion=" + organizacion + ", correo_elec=" + correo_elec + ", clave=" + clave + ", vehiculos=" + vehiculos + '}';
    }
    
    

}
