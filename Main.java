//
// Programación orientada a objetos
// Sección 20
// Ejercicio 1
// 
// Hugo Méndez - 241265
//

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

        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");
        String fecha = fechaActual.format(formato);

        Scanner scanner = new Scanner(System.in); //Abrir scanner   

        int control = 0;
        int totalVentas = 0;
        int noCliente = 0;
        int ticketsVendidos = 0;
        int ticketsVendidosBalcon2 = 0;
        int ticketsVendidosPlatea = 0;
        int ticketsVendidosVip = 0;

        while (control == 0){
            System.out.println("¿Qué desea hacer?");
            System.out.println("Comprar boletos : 1 | Ver disponibilidad : 2 | Ver disponibilidad de un área: 3 | Reporte de caja: 4 | Salir: 5");
            int opcion1 = scanner.nextInt();
            scanner.nextLine();
            switch (opcion1) {
                case 1:
                    System.out.println("Ingrese su nombre:");
                    String nombre = scanner.nextLine();
                    System.out.println("Bienvenido " + nombre + " ingrese su correo:");
                    String correo = scanner.nextLine();
                    System.out.println("Ingrese su presupuesto:");
                    int presupuesto = scanner.nextInt();

                    int control2 = 0;
                    Ubicacion ubicacionSeleccionada = new Ubicacion("", 0, 0);
                    while (control2 == 0) {
                        System.out.println("Ingrese la opción del área donde desea comprar los boletos:");
                        System.out.println("Balcón 2: 1 | Platea: 2 | VIP: 3");
                        int area = scanner.nextInt();
                       switch (area) {
                            case 1:
                                ubicacionSeleccionada = balcon2;
                                control2 = 1;
                                break;
                            
                            case 2:
                                ubicacionSeleccionada = platea;
                                control2 = 1;
                                break;
                            
                            case 3:
                                ubicacionSeleccionada = vip;
                                control2 = 1;
                                break;
                            default:
                                System.out.println("Error, ingrese una opción válida.");
                        }
                    }
                    int control3 = 0;
                    while (control3 == 0) {
                        System.out.println("Ingrese el número de boletos que desea comprar: ");
                        int numBoletos = scanner.nextInt();
                        if (ubicacionSeleccionada.getBoletosDisponibles() >= numBoletos){
                            if (numBoletos <= maxBoletos){
                                int total = numBoletos * ubicacionSeleccionada.getPrecio();
                                if (total <= presupuesto){
                                    Comprador cliente = new Comprador(nombre, correo, presupuesto, numBoletos, noCliente);
                                    Ventas orden = new Ventas(cliente, ubicacionSeleccionada, "");
                                    orden.setTicket(fecha, noCliente);
                                    System.out.println("Transacción completada con éxito");
                                    System.out.println("Resumen de la orden: área: " + ubicacionSeleccionada.getNombre() + " número de boletos: " + numBoletos + " total: Q" + total + ".00");
                                    System.out.println("Número de ticket: " + orden.getTicket());
                                    noCliente += 1;
                                    totalVentas += total;
                                    ticketsVendidos += numBoletos;
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
                                    control3 = 1;

                                } else {
                                    System.out.println("Error el total de la compra excede el presupuesto ingresado");
                                }
                            }
                        } else {
                            System.out.println("Error, número de boletos disponibles en el área: " + ubicacionSeleccionada.getBoletosDisponibles());
                        }
                    }                

                    break;

                case 2:
                    System.out.println("Boletos disponibles en: " + balcon2.getNombre() + ": " + balcon2.getBoletosDisponibles()+ ", boletos vendidos: " + ticketsVendidosBalcon2);
                    System.out.println("Boletos disponibles en: " + platea.getNombre() + ": " + platea.getBoletosDisponibles()+ ", boletos vendidos: " + ticketsVendidosPlatea);
                    System.out.println("Boletos disponibles en: " + vip.getNombre() + ": " + vip.getBoletosDisponibles()+ ", boletos vendidos: " + ticketsVendidosVip);
                    break;
                
                case 3:
                    int control4 = 0;
                    while (control4 == 0) {
                        System.out.println("Ingrese la opción del área donde desea ver la disponibilidad:");
                        System.out.println("Balcón 2: 1 | Platea: 2 | VIP: 3");
                        int area = scanner.nextInt();
                       switch (area) {
                            case 1:
                                System.out.println("Boletos disponibles en: " + balcon2.getNombre() + ": " + balcon2.getBoletosDisponibles()+ ", boletos vendidos: " + ticketsVendidosBalcon2);
                                control4 = 1;
                                break;
                            
                            case 2:
                                System.out.println("Boletos disponibles en: " + platea.getNombre() + ": " + platea.getBoletosDisponibles()+ ", boletos vendidos: " + ticketsVendidosPlatea);
                                control4 = 1;
                                break;
                            
                            case 3:
                                System.out.println("Boletos disponibles en: " + vip.getNombre() + ": " + vip.getBoletosDisponibles()+ ", boletos vendidos: " + ticketsVendidosVip);
                                control4 = 1;
                                break;
                            default:
                                System.out.println("Error, ingrese una opción válida.");
                        }
                    }
                    break;
                
                case 4:
                    System.out.println("Ventas totales: Q" + totalVentas + ".00");
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    System.out.println("Programa terminado.");
                    control = 1;
                    break;
                default:
                    System.out.println("Error, ingrese una opción válida.");
            }
        }

    }
}