package Taller;

import java.util.Scanner;

public class TallerEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int DIAS_SEMANA = 5;
        final int NUM_ESTUDIANTES = 4;

        String[] nombres = new String[NUM_ESTUDIANTES];
        String[][] asistencia = new String[NUM_ESTUDIANTES][DIAS_SEMANA];

        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
        }

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Registrar asistencia");
            System.out.println("2. Ver asistencia individual");
            System.out.println("3. Ver resumen general");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
                        System.out.println("\nAsistencia de " + nombres[i] + ":");
                        for (int j = 0; j < DIAS_SEMANA; j++) {
                            String valor;
                            do {
                                System.out.print("Día " + (j + 1) + " (P/A): ");
                                valor = sc.nextLine().toUpperCase();
                            } while (!valor.equals("P") && !valor.equals("A"));
                            asistencia[i][j] = valor;
                        }
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
                        if (nombres[i].equalsIgnoreCase(buscar)) {
                            encontrado = true;
                            System.out.print("Asistencia de " + nombres[i] + ": ");
                            for (int j = 0; j < DIAS_SEMANA; j++) {
                                System.out.print(asistencia[i][j] + " ");
                            }
                            System.out.println();
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Resumen General ---");

                    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
                        int totalP = 0;
                        for (int j = 0; j < DIAS_SEMANA; j++) {
                            if (asistencia[i][j].equals("P")) {
                                totalP++;
                            }
                        }
                        System.out.println(nombres[i] + " asistió " + totalP + " veces.");
                    }
                    
                    System.out.print("Estudiantes que asistieron todos los días: ");
                    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
                        boolean todos = true;
                        for (int j = 0; j < DIAS_SEMANA; j++) {
                            if (asistencia[i][j].equals("A")) {
                                todos = false;
                                break;
                            }
                        }
                        if (todos) {
                            System.out.print(nombres[i] + " ");
                        }
                    }
                    System.out.println();

                    int maxAusencias = -1;
                    int diaMax = -1;
                    for (int j = 0; j < DIAS_SEMANA; j++) {
                        int ausencias = 0;
                        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
                            if (asistencia[i][j].equals("A")) {
                                ausencias++;
                            }
                        }
                        if (ausencias > maxAusencias) {
                            maxAusencias = ausencias;
                            diaMax = j + 1;
                        }
                    }
                    System.out.println("Día con mayor número de ausencias: Día " + diaMax);
                    break;

                case 4:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}