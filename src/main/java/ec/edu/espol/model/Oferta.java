/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.Objects;

/**
 *
 * @author camil
 */
public class Oferta {
    private int id;
    private Comprador comprador;
    private int id_comprador;
    private Vehiculo vehiculo;
    private int id_vehiculo;
    private double precio;

    public Oferta(int id, Comprador comprador, int id_comprador, Vehiculo vehiculo, int id_vehiculo, double precio) {
        this.id = id;
        this.comprador = comprador;
        this.id_comprador = id_comprador;
        this.vehiculo = vehiculo;
        this.id_vehiculo = id_vehiculo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public int getId_comprador() {
        return id_comprador;
    }

    public void setId_comprador(int id_comprador) {
        this.id_comprador = id_comprador;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
        final Oferta other = (Oferta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_comprador != other.id_comprador) {
            return false;
        }
        if (this.id_vehiculo != other.id_vehiculo) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.comprador, other.comprador)) {
            return false;
        }
        if (!Objects.equals(this.vehiculo, other.vehiculo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Oferta{" + "id=" + id + ", comprador=" + comprador + ", id_comprador=" + id_comprador + ", vehiculo=" + vehiculo + ", id_vehiculo=" + id_vehiculo + ", precio=" + precio + '}';
    }
 
    
    
 
}
