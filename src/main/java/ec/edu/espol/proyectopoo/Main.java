/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectopoo;
import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("***MENÚ DE OPCIONES***");
            System.out.println("\t1. Vendedor");
            System.out.println("\t2. Comprador");
            System.out.println("\t3. Salir");
            System.out.println("Una vez escrita la opción, pulse la tecla Enter");

            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Usted ha elegido la opción Vendedor");
                    System.out.println("\t1. Registrar un nuevo vendedor");
                    System.out.println("\t2. Ingresar un nuevo vendedor");
                    System.out.println("\t3. Aceptar oferta");
                    System.out.println("\t4. Regresar");                    
                    break;
                case 2:
                    System.out.println("Usted ha elegido la opción Comprador");
                    System.out.println("\t1. Registrar un nuevo comprador");
                    System.out.println("\t2. Ofertar por un vehículo");                    
                    break;
                case 3:
                    System.out.println("Muchas gracias por usar nuestros servicios.");
                    break;
                default:
                    System.out.println("No ha elegido una opción válida. Ingrese una opción válida.");
                    break;
            }
        } while (opcion != 3);        
    }
    
}
