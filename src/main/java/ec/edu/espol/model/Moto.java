/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;

/**
 *
 * @author camil
 */
public class Moto extends Vehiculo{

    public Moto(int id, String placa, String marca, String modelo, String tipo_motor, String year, double recorrido, String color, String tipo_combustible, double precio, ArrayList<Oferta> ofertas) {
        super(id, placa, marca, modelo, tipo_motor, year, recorrido, color, tipo_combustible, precio, ofertas);
    }
    
    
}
