/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Bejarano
 */
public class Menu {

    private int opcionSubmenu;
    
    public void SubMenuVendedor(){
       do{
           opcionSubmenu = Integer.parseInt(JOptionPane.showInputDialog(null, "Vendedor"
                            + "\n1. Registrar un nuevo vendedor."
                            + "\n2. Ingresar un nuevo vehículo."
                            + "\n3. Aceptar oferta."
                            + "\n4. Regresar."
                            + "\nUna vez escrita la opción, pulse la tecla Enter", "CompraVende", JOptionPane.QUESTION_MESSAGE));                    
                    switch (opcionSubmenu){
                        case 1:
                            JOptionPane.showMessageDialog(null, "Aquí se registra un nuevo vendedor.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Aquí se ingresa un nuevo vehículo.","CompraVende", JOptionPane.INFORMATION_MESSAGE);                            
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Aquí se acepta la oferta.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "Regresando . . .","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "No se ha elegido una opción válida","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                            break;
                    }
                }while(opcionSubmenu != 4);        
    }
    
    public void SubMenuComprador(){
       do{
           opcionSubmenu = Integer.parseInt(JOptionPane.showInputDialog(null, "Comprador"
                            + "\n1. Registrar un nuevo comprador."
                            + "\n2. Ofertar por un vehículo."
                            + "\n3. Regresar ."
                            + "\nUna vez escrita la opción, pulse la tecla Enter", "CompraVende", JOptionPane.QUESTION_MESSAGE));                    
                    switch (opcionSubmenu){
                        case 1:
                            JOptionPane.showMessageDialog(null, "Aquí se registra un nuevo compador.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Aquí se oferta un nuevo vehículo.","CompraVende", JOptionPane.INFORMATION_MESSAGE);                            
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Regresando....","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "No se ha elegido una opción válida","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                            break;
                    }
                }while(opcionSubmenu != 3);        
    }    
}
