//
// Programación orientada a objetos
// Sección 20
// Ejercicio 1
// 
// Hugo Méndez - 241265
//

// Importar las librerias necesarias 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        //Set datos de la ubicación
        int aforo = 100;
        int limitePorArea = aforo / 3;
        Ubicacion balcon2 = new Ubicacion("Balcón 2", 300, limitePorArea);
        Ubicacion platea = new Ubicacion("Platea", 600, limitePorArea);
        Ubicacion vip = new Ubicacion("VIP", 1800, limitePorArea);
        int maxBoletos = 6;

        //Obtener la fecha del día
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");
        String fecha = fechaActual.format(formato);

        Scanner scanner = new Scanner(System.in); //Abrir scanner   
        
        //Variables para contar los tickets vendidos por área
        int totalVentas = 0;
        int noCliente = 0;
        int ticketsVendidosBalcon2 = 0;
        int ticketsVendidosPlatea = 0;
        int ticketsVendidosVip = 0;

        int control = 0; //Variable para romper el while principal

        while (control == 0){ //Menú principal del programa
            System.out.println("¿Qué desea hacer?");
            System.out.println("Comprar boletos : 1 | Ver disponibilidad : 2 | Ver disponibilidad de un área: 3 | Reporte de caja: 4 | Salir: 5");
            int opcion1 = scanner.nextInt();
            scanner.nextLine();
            switch (opcion1) {
                case 1: //Realizar una compra
                //Pedir datos del cliente
                    System.out.println("Ingrese su nombre:");
                    String nombre = scanner.nextLine();
                    System.out.println("Bienvenido " + nombre + " ingrese su correo:");
                    String correo = scanner.nextLine();
                    System.out.println("Ingrese su presupuesto:");
                    int presupuesto = scanner.nextInt();

                    int control2 = 0; //Control del segundo ciclo while 
                    Ubicacion ubicacionSeleccionada = new Ubicacion("", 0, 0); //Definir default
                    while (control2 == 0) { //Ciclo para salida si el usuario ingresa una opción incorrecta
                        System.out.println("Ingrese la opción del área donde desea comprar los boletos:");
                        System.out.println("Balcón 2: 1 | Platea: 2 | VIP: 3");
                        int area = scanner.nextInt();
                       switch (area) {
                            case 1: //Usuario elige primera área
                                ubicacionSeleccionada = balcon2;
                                control2 = 1;
                                break;
                            
                            case 2: //Usuario elige segunda área
                                ubicacionSeleccionada = platea;
                                control2 = 1;
                                break;
                            
                            case 3: //Usuario elige tercera área
                                ubicacionSeleccionada = vip;
                                control2 = 1;
                                break;
                            default:
                                System.out.println("Error, ingrese una opción válida."); //Salida para otro valor no definido
                        }
                    }
                    int control3 = 0; //Control para tercer ciclo while
                    while (control3 == 0) { //Ciclo para validar la compra
                        System.out.println("Ingrese el número de boletos que desea comprar: ");
                        int numBoletos = scanner.nextInt();
                        if (ubicacionSeleccionada.getBoletosDisponibles() >= numBoletos){ //Validar que hay disponibilidad en el área
                            if (numBoletos <= maxBoletos){ //Validar que el usuario no exceda el límite de boletos permitido por persona
                                int total = numBoletos * ubicacionSeleccionada.getPrecio();
                                if (total <= presupuesto){ //Validar que el presupuesto es suficiente para realizar la compra
                                    Comprador cliente = new Comprador(nombre, correo, presupuesto, numBoletos, noCliente); //Crear un comprador
                                    Ventas orden = new Ventas(cliente, ubicacionSeleccionada, ""); //Crear la orden
                                    orden.setTicket(fecha, noCliente); //Generar el número de ticket
                                    //Validación de la compra 
                                    System.out.println("Transacción completada con éxito");
                                    System.out.println("Resumen de la orden: área: " + ubicacionSeleccionada.getNombre() + " número de boletos: " + numBoletos + " total: Q" + total + ".00");
                                    System.out.println("Número de ticket: " + orden.getTicket());

                                    //Ajustar los valores 
                                    noCliente += 1;
                                    totalVentas += total;
                                    if (ubicacionSeleccionada.getNombre() == balcon2.getNombre()){
                                        int disponibles = balcon2.getBoletosDisponibles();
                                        balcon2.setBoletosDisponibles(disponibles - numBoletos);
                                        ticketsVendidosBalcon2 += numBoletos;
                                    } else if (ubicacionSeleccionada.getNombre() == platea.getNombre()){
                                        int disponibles = platea.getBoletosDisponibles();
                                        platea.setBoletosDisponibles(disponibles - numBoletos);
                                        ticketsVendidosPlatea += numBoletos;
                                    } else {
                                        int disponibles = vip.getBoletosDisponibles();
                                        vip.setBoletosDisponibles(disponibles - numBoletos);
                                        ticketsVendidosVip += numBoletos;
                                    }
                                    control3 = 1; //Romper ciclo while

                                } else {
                                    System.out.println("Error el total de la compra excede el presupuesto ingresado"); //Salida por si el presupuesto no es suficiente
                                }
                            } else {
                                System.out.println("Error, límite de boletos disponible por persona: " + maxBoletos); //Salida por si se excede el límite de boletos por persona
                            }
                        } else {
                            System.out.println("Error, número de boletos disponibles en el área: " + ubicacionSeleccionada.getBoletosDisponibles()); //Salida por si se excede la disponibilidad de boletos
                        }
                    }                

                    break;

                case 2: //Mostrar los boletos vendidos en las 3 áreas
                    System.out.println("Boletos disponibles en: " + balcon2.getNombre() + ": " + balcon2.getBoletosDisponibles()+ ", boletos vendidos: " + ticketsVendidosBalcon2);
                    System.out.println("Boletos disponibles en: " + platea.getNombre() + ": " + platea.getBoletosDisponibles()+ ", boletos vendidos: " + ticketsVendidosPlatea);
                    System.out.println("Boletos disponibles en: " + vip.getNombre() + ": " + vip.getBoletosDisponibles()+ ", boletos vendidos: " + ticketsVendidosVip);
                    break;
                
                case 3:
                    int control4 = 0; //Control cuarto ciclo while
                    while (control4 == 0) { //Ciclo while para evitar que el usuario ingrese una opción inválida
                        System.out.println("Ingrese la opción del área donde desea ver la disponibilidad:");
                        System.out.println("Balcón 2: 1 | Platea: 2 | VIP: 3");
                        int area = scanner.nextInt();
                       switch (area) {
                            case 1: //El usuario elige ver disponibilidad del área 1
                                System.out.println("Boletos disponibles en: " + balcon2.getNombre() + ": " + balcon2.getBoletosDisponibles()+ ", boletos vendidos: " + ticketsVendidosBalcon2);
                                control4 = 1;
                                break;
                            
                            case 2: //El usuario elige ver disponibilidad del área 2
                                System.out.println("Boletos disponibles en: " + platea.getNombre() + ": " + platea.getBoletosDisponibles()+ ", boletos vendidos: " + ticketsVendidosPlatea);
                                control4 = 1;
                                break;
                            
                            case 3: //El usuario elige ver disponibilidad del área 3
                                System.out.println("Boletos disponibles en: " + vip.getNombre() + ": " + vip.getBoletosDisponibles()+ ", boletos vendidos: " + ticketsVendidosVip);
                                control4 = 1;
                                break;
                            default:
                                System.out.println("Error, ingrese una opción válida."); //Salida si el usuario ingresa un valor inválido
                        }
                    }
                    break;
                
                case 4: //Mostrar total de ventas
                    System.out.println("Ventas totales: Q" + totalVentas + ".00");
                    break;

                case 5: //Salir del programa
                //Confirmación de salida
                    System.out.println("Saliendo...");
                    System.out.println("Programa terminado.");
                    control = 1; //Romper ciclo while principal
                    break;
                default:
                    System.out.println("Error, ingrese una opción válida."); //Salida por si el usuario ingresa una opción inválida
            }
        }

    }
}