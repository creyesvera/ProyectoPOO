/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectopoo;
import ec.edu.espol.util.Menu;
import javax.swing.JOptionPane;

/**
 *
 * @author camil
 */
public class Main {
    
    public static void main(String[] args) {
        int opcionSeleccionada;
        int opcionSubmenu;
        ec.edu.espol.util.Menu OBJ=new Menu();
        do{
        opcionSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu"
                            + "\n1. Vendedor."
                            + "\n2. Comprador."
                            + "\n3. Salir."
                            + "\nUna vez escrita la opción, pulse la tecla Enter", "CompraVende", JOptionPane.QUESTION_MESSAGE));
            switch (opcionSeleccionada) {
                case 1: 
                    OBJ.SubMenuComprador();
                    break;
                case 2:
                    OBJ.SubMenuVendedor();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Muchas gracias por adquirir nuestros servicios.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No ha elegido una opción válida.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }while(opcionSeleccionada !=3);
    }   
}
