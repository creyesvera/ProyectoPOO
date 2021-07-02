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
public class Camioneta extends Vehiculo {
    private double traccion;
    private int vidrios;
    private String transmicion;

    public Camioneta(double traccion, int vidrios, String transmicion, int id, String placa, String marca, String modelo, String tipo_motor, String year, double recorrido, String color, String tipo_combustible, double precio, ArrayList<Oferta> ofertas) {
        super(id, placa, marca, modelo, tipo_motor, year, recorrido, color, tipo_combustible, precio, ofertas);
        this.traccion = traccion;
        this.vidrios = vidrios;
        this.transmicion = transmicion;
    }

    public double getTraccion() {
        return traccion;
    }

    public void setTraccion(double traccion) {
        this.traccion = traccion;
    }

    public int getVidrios() {
        return vidrios;
    }

    public void setVidrios(int vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmicion() {
        return transmicion;
    }

    public void setTransmicion(String transmicion) {
        this.transmicion = transmicion;
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
        final Camioneta other = (Camioneta) obj;
        if (Double.doubleToLongBits(this.traccion) != Double.doubleToLongBits(other.traccion)) {
            return false;
        }
        if (this.vidrios != other.vidrios) {
            return false;
        }
        if (!Objects.equals(this.transmicion, other.transmicion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Camioneta{" + "traccion=" + traccion + ", vidrios=" + vidrios + ", transmicion=" + transmicion + '}';
    }

    
    
}
