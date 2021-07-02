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
public class Auto extends Vehiculo{
    private int vidrios;
    private String transmision;

    public Auto(int vidrios, String transmision, int id, String placa, String marca, String modelo, String tipo_motor, String year, double recorrido, String color, String tipo_combustible, double precio, ArrayList<Oferta> ofertas) {
        super(id, placa, marca, modelo, tipo_motor, year, recorrido, color, tipo_combustible, precio, ofertas);
        this.vidrios = vidrios;
        this.transmision = transmision;
    }

    public int getVidrios() {
        return vidrios;
    }

    public void setVidrios(int vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
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
        final Auto other = (Auto) obj;
        if (this.vidrios != other.vidrios) {
            return false;
        }
        if (!Objects.equals(this.transmision, other.transmision)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Auto{" + "vidrios=" + vidrios + ", transmision=" + transmision + '}';
    }
    
    
    
}
