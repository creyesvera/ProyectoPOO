/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Oferta;
import javax.swing.JOptionPane;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Vendedor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel Bejarano
 */
public class Menu {
    Scanner sc = new Scanner(System.in);
    private Menu(){}

    public static void SubMenuVendedor(Scanner sc) {
        int opcionSubmenu;
        do{
               
            System.out.println("1. Registrar un nuevo vendedor.");
            System.out.println("2. Ingresar un nuevo vehículo.");
            System.out.println("3. Aceptar oferta.");
            System.out.println("4. Regresar.");
            
            opcionSubmenu = sc.next();
            
            switch (opcionSubmenu){
                case "1":
                    Menu.registrarVendedor(sc);
                    break;
                case "2":
                    Menu.ingresarNuevoVehiculo(sc);
                    break;
                case "3":
                    Menu.aceptarOferta(sc);
                    break;
                case "4":
                    System.out.println("Regresando. . .");                    
                    break;
                default:
                    System.out.println("No ha elegido una opción válida");             
                    break;
            }
        }while(!"4".equals(OpcionSubmenu));        
    }
    
    public static void SubMenuComprador(Scanner sc){
        int opcionSubmenu;
        do{

            System.out.println("1. Registrar un nuevo comprador.");
            System.out.println("2. Ofertar por un vehículo.");
            System.out.println("3. Regresar.");
            System.out.println("Una vez escrita la opción, pulse la tecla Enter.");
            
            opcionSubmenu = sc.next();            
            switch (opcionSubmenu){
                case "1":
                    Menu.registrarNuevoComprador(sc);
                    break;
                case "2":
                    Menu.ofertarPorUnVehiculo(sc);
                    break;
                case "3":
                    System.out.println("Regresando. . .");                             
                    break;
                default:
                    System.out.println("No se ha elegido una opción válida");                     
                    break;
                    }
        }while(!"3".equals(OpcionSubmenu));        
    }    

public static void registrarVendedor(Scanner sc){   
    System.out.println("Aquí se registra un nuevo vendedor.");
    vendedor = sc.nextLine();
    Usuario.nextUsuario("vendedores.txt","claveHashVendedores.txt",vendedor);
}

public static void ingresarNuevoVehiculo(Scanner sc){

    System.out.println("Aquí se ingresa un nuevo vendedor.");

    String clave, correo_elec;
    ArrayList<Vendedor> vendedores = Vendedor.readFile("vendedores.txt");
    do{/**/
        System.out.println("Por favor ingrese su correo electrónico: ");
        correo_elec = sc.nextLine();
        
        System.out.println("Por favor ingrese su clave: ");
        clave = sc.nextLine();      
    }while(!Util.validacionClaveCorreo(correo_elec, clave,"claveHashVendedores.txt","vendedores.txt")); // repetir mientras que  NO el correo y la clave existan en el archivo
    Vendedor vendedor = Vendedor.searchByCorreoYClave(vendedores, correo_elec, clave);
    vehiculo = sc.nextLine();
    Vehiculo.nextVehiculo("vehiculos.txt", vendedor.getId(), vehiculo,sc);
    Vehiculo.link(vendedores, Vehiculo.readFile("vehiculos.txt"));
}

public static void aceptarOferta(Scanner sc){
    System.out.println("Aquí se acepta la oferta. ");
    ArrayList<Vendedor> vendedores = Vendedor.readFile("vendedores.txt");
    String correo_elec,clave;
    do{
        System.out.println("Por favor ingrese su correo electrónico: ");
        correo_elec = sc.nextLine();
        
        System.out.println("Por favor ingrese su clave: ");
        clave = sc.nextLine();        
    }while(!Util.validacionClaveCorreo(correo_elec, clave,"claveHashVendedores.txt","vendedores.txt"));// repetir mientras que  NO el correo y la clave existan en el archivo
    Vendedor vendedor = Vendedor.searchByCorreoYClave(vendedores, correo_elec, clave);
    
    /*Validar placa*/
    String placa;
    ArrayList<Vehiculo> vehiculos = Vehiculo.readFile("vehiculos.txt");        
    do{       
        System.out.println("Por favor ingrese su placa: ");
        placa = sc.nextLine(); 
    }while(!Util.validacionPlaca(placa, vehiculos)); //repetir mientras que la placa no este en el archivo
    
    Vehiculo vehiculo =  Vehiculo.searchByPlaca(vehiculos, placa);
    
                            
    for (Oferta offer: vehiculo.getOfertas()){                            
        int resp=JOptionPane.showConfirmDialog(null, offer);
                            
    if (JOptionPane.OK_OPTION == resp){
        Vendedor.vender(vehiculo, "vehiculos.txt", "ofertas.txt");
        /*Funcion enviarCorreo*/
        Util.enviarConGMail(offer.getComprador().getCorreo_elec(),vendedor.getCorreo_elec(), "Aceptacion Oferta de vehículo", "Buenas " + offer.getComprador().getNombres()+ " " + offer.getComprador().getApellidos() + " mediante la presente le informamos que su oferta por el vehículo con placa: " + offer.getVehiculo().getPlaca() + " ha sido aceptada. A continuación se presenta la oferta aceptada: \n" + offer,vendedor.getClave() );
        
    }
    else{
                                            
    }                            
     }
}

public static void registrarNuevoComprador(Scanner sc){
    System.out.println("Aquí se registra un nuevo comprador");
    clave = sc.nextLine();     
    Usuario.nextUsuario("compradores.txt","claveHashCompradores.txt",sc);  
}

public static void ofertarPorUnVehiculo(Scanner sc){
    JOptionPane.showMessageDialog(null, "Aquí se oferta un nuevo vehículo.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
    String clave, correo_elec;
    do{/**/
    correo_elec = JOptionPane.showInputDialog(null, "Por favor ingrese su correo electrónico: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);                            
    clave = JOptionPane.showInputDialog(null, "Por favor ingrese su clave: ", "CompraVende", JOptionPane.QUESTION_MESSAGE);
    }while(!Util.validacionClaveCorreo(correo_elec, clave,"claveHashCompradores.txt","compradores.txt"));/// repetir mientras que  NO el correo y la clave existan en el archivo
    
    Comprador compradorOferta = Comprador.searchByCorreoYClave(Comprador.readFile("compradores.txt"), correo_elec, clave);    
    ArrayList<Vehiculo> vehiculo = Vehiculo.readFile("vehiculos.txt");
    
    String opcion_s, tipo;
        
        do{            
            System.out.println("Por favor digite:"
                            + "\n1. Si el vehículo es un carro."
                            + "\n2. Si el vehículo es una moto."
                            + "\n3. Si el vehículo es una camioneta."
                            + "\n4. Si no desea aplicar un filtro por tipo."   
                            + "\nUna vez escrita la opción, pulse la tecla Enter");
            opcion_s = sc.nextLine();                                                
        }while(!Util.isInt(opcion_s) || !(Integer.parseInt(opcion_s) <= 3 && Integer.parseInt(opcion_s) > 0));
        int opcion = Integer.parseInt(opcion_s);
    
           switch(opcion){
               case "1":
                       tipo = "carro";                   
                   break;
               case "2":
                       tipo = "camioneta";
                   break;
               case "3":
                       tipo = "moto";
                   break;
               case "4":
                       tipo = "nada";
                       break;
                }    
    
    ArrayList<Vehiculo> vehiculoFiltradoTipo = Vehiculo.searchByTipo(vehiculo, tipo);       
           
    String recorridoMin;
        do{
            System.out.println("Por favor ingrese el recorrido mínimo: ");
            recorridoMin = sc.nextLine(); 
        }while(!Util.isNumeric(recorridoMin));
        double recorridoMinD = Double.parseDouble(recorridoMin);    
        
    String recorridoMax;
        do{
            System.out.println("Por favor ingrese el recorrido máximo: ");
            recorridoMax = sc.nextLine(); 
        }while(!Util.isNumeric(recorridoMax));
        double recorridoMaxD = Double.parseDouble(recorridoMax);
        
    ArrayList<Vehiculo> vehiculoFiltradoRecorrido = Vehiculo.searchByRecorrido(vehiculo, recorridoMaxD, recorridoMinD);
           
    String yearMin;
        do{
            System.out.println("Por favor ingrese el año mínimo: ");
            yearMin = sc.nextLine();             
        }while(!Util.isInt(yearMin));
        int yearMinD = Integer.parseInt(yearMin);    
        
    String yearMax;
        do{
            yearMax =  JOptionPane.showInputDialog(null,"Por favor ingrese el precio máximo: ", "CompraVende", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Por favor ingrese el año máximo: ");
            yearMax = sc.nextLine();             
        }while(!Util.isNumeric(yearMax));
        int yearMaxD = Integer.parseInt(yearMax);    
        
    ArrayList<Vehiculo> vehiculoFiltradoYear = Vehiculo.searchByPrecio(vehiculo, yearMaxD, yearMinD);           
    
    
    String precioMin;
        do{
            System.out.println("Por favor ingrese el precio mínimo: ");
            precioMin = sc.nextLine();             
        }while(!Util.isNumeric(precioMin));
        double precioMinD = Double.parseDouble(precioMin);    
        
    String precioMax;
        do{
            System.out.println("Por favor ingrese el precio máximo: ");
            precioMax = sc.nextLine();             
        }while(!Util.isNumeric(precioMax));
        double precioMaxD = Double.parseDouble(precioMax);
    
    ArrayList<Vehiculo> vehiculoFiltradoPrecio = Vehiculo.searchByPrecio(vehiculo, precioMaxD, precioMinD);
    
    
    ArrayList<Vehiculo> vehiculosInterseccion1 = Vehiculo.interseccionList(vehiculoFiltradoRecorrido, vehiculoFiltradoYear);
    ArrayList<Vehiculo> vehiculosInterseccion2 = Vehiculo.interseccionList(vehiculoFiltradoTipo, vehiculoFiltradoPrecio);
    ArrayList<Vehiculo> vehiculosFiltradosTotal = Vehiculo.interseccionList(vehiculosInterseccion1, vehiculosInterseccion2);
    

    
    

    int i = 0;
    int ventana = 0, ventana2 = 0, ventana3 = 0;
    String precio_s = null;
    do{
            
       if ( i==0 ){
           String[] botonesInicio = {"Siguiente", "Comprar", "Volver al Menú"};
           ventana = JOptionPane.showOptionDialog(null,
                          "Seleccione una opcion:\n"
                           + vehiculosFiltradosTotal.get(i),
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
                  
                  do{
                  precio_s =  JOptionPane.showInputDialog(null,"Por favor ingrese el precio de su oferta usando el '.' como separador decimal: ", "CompraVende", JOptionPane.INFORMATION_MESSAGE);
                  }while(!Util.isNumeric(precio_s));
                  double precioOferta = Double.parseDouble(precio_s);
                  compradorOferta.comprar(vehiculosFiltradosTotal.get(i), "ofertas.txt",precioOferta);
                  Oferta oferta = new Oferta(Util.nextID("ofertas.txt"),compradorOferta.getId(),vehiculosFiltradosTotal.get(i).getId(),precioOferta);
                  break;
               case 2:
                  JOptionPane.showMessageDialog(null, "Regresando. . .","CompraVende", JOptionPane.INFORMATION_MESSAGE);                        
           }
                
       }else if(i==(vehiculosFiltradosTotal.size()-1)){   
            String[] botonesInicio1 = {"Anterior", "Comprar", "Volver al Menú"};
            ventana2 = JOptionPane.showOptionDialog(null,
                            "Seleccione una opcion:\n"
                            + vehiculosFiltradosTotal.get(i),
                            "CompraVenta",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null,
                            botonesInicio1, botonesInicio1[0]);
                
           switch(ventana2){
               case 0:
                  i-=1;
                  break;
               case 1:
                  JOptionPane.showMessageDialog(null, "Usted ha adquirido la oferta, felicidades.","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                  do{
                  precio_s =  JOptionPane.showInputDialog(null,"Por favor ingrese el precio de su oferta usando el '.' como separador decimal: ", "CompraVende", JOptionPane.INFORMATION_MESSAGE);
                  }while(!Util.isNumeric(precio_s));
                  double precioOferta = Double.parseDouble(precio_s);
                  Oferta oferta = new Oferta(Util.nextID("ofertas.txt"),compradorOferta.getId(),vehiculosFiltradosTotal.get(i).getId(),precioOferta);
                  break;
               case 2:
                  JOptionPane.showMessageDialog(null, "Regresando. . .","CompraVende", JOptionPane.INFORMATION_MESSAGE);
                  break;
                }                
                
       }else{
           String[] botonesInicio2 = {"Anterior", "Siguiente", "Comprar", "Volver al Menú"};
           ventana3 = JOptionPane.showOptionDialog(null,
                           "Seleccione una opcion: \n"
                           + vehiculosFiltradosTotal.get(i),
                           "CompraVenta",
                           JOptionPane.DEFAULT_OPTION,
                           JOptionPane.QUESTION_MESSAGE, null,
                           botonesInicio2, botonesInicio2[0]);
           switch(ventana3){
               case 0:
                  i -= 1;
                  break;
               case 1:
                  i += 1;
                  break;
               case 2:
                  JOptionPane.showMessageDialog(null, "Usted ha adquirido la oferta, felicidades.", "CompraVende", JOptionPane.INFORMATION_MESSAGE);
                  do{
                  precio_s =  JOptionPane.showInputDialog(null,"Por favor ingrese el precio de su oferta usando el '.' como separador decimal: ", "CompraVende", JOptionPane.INFORMATION_MESSAGE);
                  }while(!Util.isNumeric(precio_s));
                  double precioOferta = Double.parseDouble(precio_s);
                  Oferta oferta = new Oferta(Util.nextID("ofertas.txt"),compradorOferta.getId(),vehiculosFiltradosTotal.get(i).getId(),precioOferta);
                  break;
               case 3:
                  JOptionPane.showMessageDialog(null, "Regresando. . .", "CompraVende", JOptionPane.INFORMATION_MESSAGE);                        
                }
        }
        }while((ventana != 1) && (ventana != 2) && (ventana2 != 1) && (ventana2 != 2) && (ventana3 !=2) && (ventana3 != 3));
                   
    Oferta.link(Comprador.readFile("compradores.txt"),Vehiculo.readFile("vehiculos.txt"), Oferta.readFile("ofertas.txt"));
    
    
}
}
