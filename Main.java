//
// Programación orientada a objetos
// Sección 20
// Ejercicio 1
// 
// Hugo Méndez - 241265
//

import java.time.LocalDate;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        //Set datos de la ubicación
        int aforo = 100;
        int limitePorArea = aforo / 3;
        LocalDate fechaActual = LocalDate.now();
        Ubicacion balcon2 = new Ubicacion("Balcón 2", 300, limitePorArea);
        Ubicacion platea = new Ubicacion("Platea", 600, limitePorArea);
        Ubicacion vip = new Ubicacion("VIP", 1800, limitePorArea);

        Scanner scanner = new Scanner(System.in); //Abrir scanner

        int control = 0;

        while (control == 0){
            System.out.println("¿Qué desea hacer?");
            System.out.println("Comprar boletos : 1 | : 2 | : 3 | : 4 | : 5 | : 6 | Salir: 7");
            int opcion1 = scanner.nextInt();
            scanner.nextLine();
            switch (opcion1) {
                case 1:
                    System.out.println("Ingrese su nombre:");
                    String nombre = scanner.nextLine();
                    System.out.println("Bienvenido " + nombre + " ingrese su correo");
                    String correo = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Ingrese su presupuesto:");
                    int presupuesto = scanner.nextInt();

                    int control2 = 0;

                    while (control2 == 0) {
                        System.out.println("Ingrese la opción del área donde desa comprar los boletos:");
                        System.out.println("Balcón 2: 1 | Platea: 2 | VIP: 3");
                        int area = scanner.nextInt();
                        switch (area) {
                            case 1:
                                
                                
                                break;
                            
                            case 2:
                                
                                control2 = 1;
                                break;
                            
                            case 3:

                                control2 = 1;
                                break;
                            default:
                                System.out.println("Error, ingrese una opción válida.");
                        }
                    }                

                    break;

                case 2:

                    break;
                
                case 3:

                    break;
                
                case 4:

                    break;
                
                case 5:
                    
                    break;

                case 6:

                    break;

                case 7:
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