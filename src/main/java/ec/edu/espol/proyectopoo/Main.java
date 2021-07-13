/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectopoo;
import ec.edu.espol.util.Menu;
import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int opcionSeleccionada;
        do{
            
            System.out.println("1. Vendedor");
            System.out.println("2. Comprador");
            System.out.println("3. Salir");
            System.out.println("Una vez escrita la opción, pulse la tecla Enter");
            
            opcionSeleccionada = sn.next();
            
            switch (opcionSeleccionada) {
                case "1": 
                    Menu.SubMenuVendedor();
                    break;
                case "2":
                    Menu.SubMenuComprador();
                    break;
                case "3":
                    System.out.println("Muchas gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("No ha elegido una opción válida");
                    break;
            }
        }while(opcionSeleccionada !=3);
    }   
}
