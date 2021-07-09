/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author camil
 */
public class Comprador extends Usuario{
    private ArrayList<Oferta> ofertas;

    public Comprador(int id, String nombres, String apellidos, String correo_elec, String organizacion, String clave) {
        super(id, nombres, apellidos, correo_elec, organizacion, clave);
        this.ofertas = new ArrayList<>();
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        Comprador other = (Comprador) other_u;
        if (!Objects.equals(this.ofertas, other.ofertas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comprador{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo_elec=" + correo_elec + ", organizacion=" + organizacion + ", clave=" + clave + "ofertas=" + ofertas + '}';
    }
        
    
    public static void comprar(Vehiculo v, String nomfile){ //ofertas.txt
        int id_oferta = Util.nextID(nomfile);
        double precio = JOptionPane.showInputDialog(null, "Por favor ingrese su correo electrónico: ", "CompraVende", JOptionPane.QUESTION_MESSAGE); 
        Oferta new_oferta = Oferta(id_oferta, this.id, v.getId, precio);
        new_oferta.saveFile(nomfile);
    }
    
}
