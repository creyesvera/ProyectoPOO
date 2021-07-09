/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;
import ec.edu.espol.model.Oferta;
import javax.swing.JOptionPane;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Vendedor;
import java.util.ArrayList;

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
                            Usuario.nextUsuario("vendedores.txt");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Aquí se ingresa un nuevo vehículo.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                            String clave, correo_elec;
                            /*do{*/
                            correo_elec = JOptionPane.showInputDialog(null, "Por favor ingrese su correo electrónico: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);                            
                            clave = JOptionPane.showInputDialog(null, "Por favor ingrese su clave: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);
                            /*}while()*/
                            ArrayList<Usuario> usuarios = Usuario.readFile("vendedores.txt");
                            Vendedor vendedor = (Vendedor) Usuario.searchByCorreoYClave(usuarios, correo_elec, clave);
                            Vehiculo.nextVehiculo("vendedores.txt", vendedor);                            
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Aquí se acepta la oferta.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                            /*do{*/
                            correo_elec = JOptionPane.showInputDialog(null, "Por favor ingrese su correo electrónico: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);                            
                            clave = JOptionPane.showInputDialog(null, "Por favor ingrese su clave: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);
                            /*}while()*/
                            ArrayList<Usuario> usuarios2 = Usuario.readFile("vendedores.txt");
                            Vendedor vendedor2 = (Vendedor) Usuario.searchByCorreoYClave(usuarios2, correo_elec, clave);
                            
                            /*Validar placa*/
                            String placa = JOptionPane.showInputDialog(null, "Por favor ingrese el numero de placa: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);
                            
                            ArrayList<Vehiculo> vehiculos = Vehiculo.readFile("vehiculos.txt");
                            Vehiculo vehiculo =  Vehiculo.searchByPlaca(vehiculos, placa);
                            
                            for (Oferta offer: vehiculo.getOfertas()){                            
                                int resp=JOptionPane.showConfirmDialog(null,"Usas mucho el JOptionPane?");
                            
                                    if (JOptionPane.OK_OPTION == resp){
                                            Vendedor.vender(vehiculo, "vehiculos.txt", "ofertas.txt");
                                            /*Funcion enviarCorreo*/
                                            
                                        }
                                    else{
                                            
                                        }                            
                            }
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
                            Usuario.nextUsuario("compradores.txt");                            
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Aquí se oferta un nuevo vehículo.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                            String clave, correo_elec1;
                            int opcion1;
                            int i = 0;
                            /*do{*/
                            correo_elec1 = JOptionPane.showInputDialog(null, "Por favor ingrese su correo electrónico: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);                            
                            clave = JOptionPane.showInputDialog(null, "Por favor ingrese su clave: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);
                            /*}while()*/
                            
                            do{
                                
                                
                            }while(opcion1 !=4 );
                            
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
