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
    private Menu(){}

    public static void SubMenuVendedor() {
        int opcionSubmenu;
        do{
            
            opcionSubmenu = Integer.parseInt(JOptionPane.showInputDialog(null, "Vendedor"
                    + "\n1. Registrar un nuevo vendedor."
                    + "\n2. Ingresar un nuevo vehículo."
                    + "\n3. Aceptar oferta."
                    + "\n4. Regresar."
                    + "\nUna vez escrita la opción, pulse la tecla Enter", "CompraVende", JOptionPane.QUESTION_MESSAGE));
            switch (opcionSubmenu){
                case 1:
                    Menu.registrarVendedor();
                    break;
                case 2:
                    Menu.ingresarNuevoVehiculo();
                    break;
                case 3:
                    Menu.aceptarOferta();
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
    
    public static void SubMenuComprador(){
        int opcionSubmenu;
        do{
           opcionSubmenu = Integer.parseInt(JOptionPane.showInputDialog(null, "Comprador"
                            + "\n1. Registrar un nuevo comprador."
                            + "\n2. Ofertar por un vehículo."
                            + "\n3. Regresar ."
                            + "\nUna vez escrita la opción, pulse la tecla Enter", "CompraVende", JOptionPane.QUESTION_MESSAGE));                    
                    switch (opcionSubmenu){
                        case 1:
                            Menu.registrarNuevoComprador();
                            break;
                        case 2:
                            Menu.ofertarPorUnVehiculo();
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

public static void registrarVendedor(){
    JOptionPane.showMessageDialog(null, "Aquí se registra un nuevo vendedor.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
    Usuario.nextUsuario("vendedores.txt","claveHashVendededores.txt");
}

public static void ingresarNuevoVehiculo(){
    JOptionPane.showMessageDialog(null, "Aquí se ingresa un nuevo vehículo.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
    String clave, correo_elec;
    ArrayList<Usuario> vendedores = Usuario.readFile("vendedores.txt");
    do{/**/
    correo_elec = JOptionPane.showInputDialog(null, "Por favor ingrese su correo electrónico: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);                            
    clave = JOptionPane.showInputDialog(null, "Por favor ingrese su clave: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);
    }while(Util.validacionClaveCorreo(correo_elec, clave,"claveHashVendedores.txt",vendedores));/**/
    Vendedor vendedor = (Vendedor) Usuario.searchByCorreoYClave(vendedores, correo_elec, clave);
    Vehiculo.nextVehiculo("vendedores.txt", vendedor);
}

public static void aceptarOferta(){
    JOptionPane.showMessageDialog(null, "Aquí se acepta la oferta.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
    ArrayList<Usuario> vendedores = Usuario.readFile("vendedores.txt");
    String correo_elec,clave;
    do{/**/
        correo_elec = JOptionPane.showInputDialog(null, "Por favor ingrese su correo electrónico: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);                            
        clave = JOptionPane.showInputDialog(null, "Por favor ingrese su clave: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);
    }while(Util.validacionClaveCorreo(correo_elec, clave,"claveHashVendedores.txt",vendedores));/**/
    Vendedor vendedor = (Vendedor) Usuario.searchByCorreoYClave(vendedores, correo_elec, clave);
    
    /*Validar placa*/
    String placa;
    ArrayList<Vehiculo> vehiculos = Vehiculo.readFile("vehiculos.txt");        
    do{       
           placa= JOptionPane.showInputDialog(null, "Por favor ingrese el numero de placa: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);
    }while(Util.validacionPlaca(placa, vehiculos));
    
    Vehiculo vehiculo =  Vehiculo.searchByPlaca(vehiculos, placa);
    
                            
    for (Oferta offer: vehiculo.getOfertas()){                            
        int resp=JOptionPane.showConfirmDialog(null,"Usas mucho el JOptionPane?");
                            
    if (JOptionPane.OK_OPTION == resp){
        Vendedor.vender(vehiculo, "vehiculos.txt", "ofertas.txt");
        /*Funcion enviarCorreo*/
        Util.enviarConGMail(offer.getComprador().getCorreo_elec(),vendedor.getCorreo_elec(), "Aceptacion Oferta de vehículo", "Buenas " + offer.getComprador().getNombres()+ " " + offer.getComprador().getApellidos() + " mediante la presente le informamos que su oferta por el vehículo con placa: " + offer.getVehiculo().getPlaca() + " ha sido aceptada. A continuación se presenta la oferta aceptada: \n" + offer,vendedor.getClave() );
        
    }
    else{
                                            
    }                            
     }
}

public static void registrarNuevoComprador(){
    JOptionPane.showMessageDialog(null, "Aquí se registra un nuevo compador.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
    Usuario.nextUsuario("compradores.txt","claveHashCompradores.txt");  
}

public static void ofertarPorUnVehiculo(){
    JOptionPane.showMessageDialog(null, "Aquí se oferta un nuevo vehículo.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
    String clave, correo_elec1;
    int opcion1 = 0;
    ArrayList<Usuario> compradores = Usuario.readFile("compradores.txt");
    do{/**/
    correo_elec1 = JOptionPane.showInputDialog(null, "Por favor ingrese su correo electrónico: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);                            
    clave = JOptionPane.showInputDialog(null, "Por favor ingrese su clave: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);
    }while(Util.validacionClaveCorreo(correo_elec1, clave,"claveHashCompradores.txt",compradores));/**/
    
    ArrayList<Oferta> ofertas = Oferta.readFile("ofertas.txt");
    int i = 0;
    int ventana = 0, ventana2 = 0, ventana3 = 0;
    do{
            
       if ( i==0 ){
           String[] botonesInicio = {"Siguiente", "Comprar", "Volver al Menú"};
           ventana = JOptionPane.showOptionDialog(null,
                          "Seleccione una opcion:\n"
                           + ofertas.get(i),
                           "CompraVenta",
                           JOptionPane.DEFAULT_OPTION,
                           JOptionPane.QUESTION_MESSAGE, null,
                           botonesInicio, botonesInicio[0]);
                
           switch(ventana){
               case 0:
                  i+=1;
                  break;
               case 1:
                  JOptionPane.showMessageDialog(null, "Usted ha adquirido la oferta, felicidades.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                  break;
               case 2:
                  JOptionPane.showMessageDialog(null, "Regresando. . .","CompraVende", JOptionPane.INFORMATION_MESSAGE);                        
           }
                
       }else if(i==(ofertas.size()-1)){   
            String[] botones = {"Anterior", "Comprar", "Volver al Menú"};
            ventana2 = JOptionPane.showOptionDialog(null,
                            "Seleccione una opcion:\n"
                            + ofertas.get(i),
                            "CompraVenta",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null,
                            botones, botones[0]);
                
           switch(ventana2){
               case 0:
                  i-=1;
                  break;
               case 1:
                  JOptionPane.showMessageDialog(null, "Usted ha adquirido la oferta, felicidades.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                  break;
               case 2:
                  JOptionPane.showMessageDialog(null, "Regresando. . .","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                  break;
                }                
                
       }else{
           String[] botones = {"Anterior", "Siguiente", "Comprar", "Volver al Menú"};
           ventana3 = JOptionPane.showOptionDialog(null,
                           "Seleccione una opcion: \n"
                           + ofertas.get(i),
                           "CompraVenta",
                           JOptionPane.DEFAULT_OPTION,
                           JOptionPane.QUESTION_MESSAGE, null,
                           botones, botones[0]);
           switch(ventana3){
               case 0:
                  i -= 1;
                  break;
               case 1:
                  i += 1;
                  break;
               case 2:
                  JOptionPane.showMessageDialog(null, "Usted ha adquirido la oferta, felicidades.", "CompraVende", JOptionPane.INFORMATION_MESSAGE);
                  break;
               case 3:
                  JOptionPane.showMessageDialog(null, "Regresando. . .", "CompraVende", JOptionPane.INFORMATION_MESSAGE);                        
                }
        }
        }while((ventana != 1) && (ventana != 2) && (ventana2 != 1) && (ventana2 != 2) && (ventana3 !=2) && (ventana3 != 3));
                            
}
}
