package es.ciudadescolar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String ficheroBin = "modulos.dat";
        String ficheroTxt = "modulos.txt";
        Integer opc = 0;
        GestorTxt gt = new GestorTxt(ficheroTxt);
        GestorBinario gb = new GestorBinario(ficheroBin);

        do {
            try {
                opc = pedirEntero(
                        "Introduzca la instruccion(-1. Salir\n1. Introducir modulo en fichero de texto\n2. Introducir modulos en fichero binario\n3. Recuperar modulos del fichero de texto\n4. Recuperar modulos del fichero binario)");
                switch (opc) {
                    case -1:
                        System.out.println("Saliendo del programa. Adios");
                        break;
                    case 1:
                        gt.
                    generarModulo();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    default:
                        System.out.println("Valor no valido");
                }
            } catch (InputMismatchException e) {
                System.out.println("No has introducido un numero.");
            }
        } while (opc != -1);
    }

    public static Modulo generarModulo() {
        Modulo salida;
        Integer opc = 0;

        String modulo;
        Double horas;
        String profesor;
        Integer curso;
        String contrasena;

        System.out.print("Introduce el nombre del modulo profesional: ");
        modulo = sc.nextLine();
        horas = pedirDouble("Introduce el numero de horas: ");
        System.out.print("Introduce el profesor: ");
        profesor = sc.nextLine();
        curso = pedirEntero("Introduce el curso: ");
        System.out.print("Introduce la contraseña: ");
        contrasena = sc.nextLine();

        salida = new Modulo(modulo, horas, profesor, curso, contrasena);

        return salida;
    }

    public static Integer pedirEntero(String mensaje) {
        while (true) {
            Integer salida;
            String texto;
            System.out.print(mensaje);
            texto = sc.nextLine();
            try {
                salida = Integer.parseInt(texto);
                return salida;
            } catch (NumberFormatException e) {
                System.out.println("No has introducido un numero...");
            }
        }
    }
    public static Double pedirDouble(String mensaje) {
        while (true) {
            Double salida;
            String texto;
            System.out.print(mensaje);
            texto = sc.nextLine();
            try {
                salida = Double.parseDouble(texto);
                return salida;
            } catch (NumberFormatException e) {
                System.out.println("No has introducido un numero...");
            }
        }
    }
}
