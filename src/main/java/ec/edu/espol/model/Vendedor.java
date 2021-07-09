/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.util.ArrayList;
import java.util.Objects;


/**
 *
 * @author camil
 */
public class Vendedor extends Usuario{
    private ArrayList<Vehiculo> vehiculos;

    public Vendedor(int id, String nombres, String apellidos, String correo_elec, String organizacion, String clave) {
        super(id, nombres, apellidos, correo_elec, organizacion, clave);
        this.vehiculos = new ArrayList<>();
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {   
        this.vehiculos = vehiculos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        //comparar atributos que bienen de la clase padre
        Usuario este_u = this;
        Usuario other_u = (Usuario) obj;
        if (!Objects.equals(este_u, other_u))
            return false;
        //comparar atributo exclusivo de esta clase
        Vendedor other = (Vendedor) other_u;
        if (!Objects.equals(this.vehiculos, other.vehiculos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vendedor{" +"id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo_elec=" + correo_elec + ", organizacion=" + organizacion + ", clave=" + clave + "vehiculos=" + vehiculos + '}';
    }
    


    public static void vender(Vehiculo v,String nomfile_vehiculos, String nomfile_ofertas){       //lista de vehiculos del vendedor
        ArrayList<Vehiculo> vehiculos = Vehiculo.readFile(nomfile_vehiculos);
        vehiculos.remove(v);
        Vehiculo.saveFile(nomfile_vehiculos,vehiculos);
        ArrayList<Oferta> ofertas_v = v.getOfertas();
        ArrayList<Oferta> ofertas = Oferta.readFile(nomfile_ofertas);
        for(Oferta o : ofertas_v)
            ofertas.remove(o);
        Oferta.saveFile(nomfile_ofertas,ofertas);

        }
       

}
