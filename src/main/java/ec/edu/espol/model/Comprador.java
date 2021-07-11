/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
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
    public String toString() {
        return "Comprador{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo_elec=" + correo_elec + ", organizacion=" + organizacion + ", clave=" + clave + '}';
    }
        
    
    public void comprar(Vehiculo v, String nomfile){ //ofertas.txt
        int id_oferta = Util.nextID(nomfile);
        double precio = Double.parseDouble(JOptionPane.showInputDialog(null,"Por favor ingrese el precio de su oferta usando el '.' como separador decimal:", "CompraVende", JOptionPane.INFORMATION_MESSAGE)); 
        Oferta new_oferta = new Oferta(id_oferta, this.id, v.getId(), precio);
        new_oferta.saveFile(nomfile);
    }
    
}
