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
public class Vehiculo {
    protected int id;
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String tipo_motor;
    protected String year;
    protected double recorrido;
    protected String color;
    protected String tipo_combustible;
    protected double precio;
    protected ArrayList<Oferta> ofertas;

    public Vehiculo(int id, String placa, String marca, String modelo, String tipo_motor, String year, double recorrido, String color, String tipo_combustible, double precio, ArrayList<Oferta> ofertas) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_motor = tipo_motor;
        this.year = year;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.precio = precio;
        this.ofertas = ofertas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo_motor() {
        return tipo_motor;
    }

    public void setTipo_motor(String tipo_motor) {
        this.tipo_motor = tipo_motor;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
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
        final Vehiculo other = (Vehiculo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.recorrido) != Double.doubleToLongBits(other.recorrido)) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.tipo_motor, other.tipo_motor)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.tipo_combustible, other.tipo_combustible)) {
            return false;
        }
        if (!Objects.equals(this.ofertas, other.ofertas)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", tipo_motor=" + tipo_motor + ", year=" + year + ", recorrido=" + recorrido + ", color=" + color + ", tipo_combustible=" + tipo_combustible + ", precio=" + precio + ", ofertas=" + ofertas + '}';
    }
}
