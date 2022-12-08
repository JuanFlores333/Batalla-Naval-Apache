/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.batalla_naval_apache;
import java.util.Scanner;

public class Batalla_Naval_Apache {
public static void main(String[] args) throws Exception {
        int[][] tableroJugador1 = new int[10][10];
        int[][] tableroJugador2 = new int[10][10];
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador 1");
        String nombreJugador1 = sc.nextLine();
        int numeroBarcos1 = 0;
        int numeroBarcos2 = 0;
        boolean numeroBarcosValido1 = false;
        boolean numeroBarcosValido2 = false;
        do {
            try {
                System.out.println("Ingrese el numero de barcos que desea colocar de 1 a 4");
                numeroBarcos1 = sc.nextInt();
                if (numeroBarcos1 >= 1 && numeroBarcos1 <= 4) {
                    numeroBarcosValido1 = true;
                } else {
                    System.out.println("El numero de barcos debe ser de 1 a 4");
                }
            } catch (Exception e) {
                System.out.println("caracter invalido");
                sc.nextLine();
            }
        } while (!numeroBarcosValido1);
        for (int i = 0; i < numeroBarcos1; i++) {
            System.out.println("Ingrese la posicion del barco " + (i + 1) + " en el eje X (0-9)");
            int posicionX1 = sc.nextInt();
            System.out.println("Ingrese la posicion del barco " + (i + 1) + " en el eje Y (0-9)");
            int posicionY1 = sc.nextInt();
            tableroJugador1[posicionX1][posicionY1] = 1;
        }
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Ingrese el nombre del jugador 2");
        String nombreJugador2 = sc2.nextLine();
        numeroBarcos2 = 0;
        numeroBarcosValido2 = false;
        do {
            try {
                System.out.println("Ingrese el numero de barcos que desea colocar de 1 a 4");
                numeroBarcos2 = sc2.nextInt();
                if (numeroBarcos2 >= 1 && numeroBarcos2 <= 4) {
                    numeroBarcosValido2 = true;
                } else {
                    System.out.println("El numero de barcos debe ser de 1 a 4");
                }
            } catch (Exception e) {
                System.out.println("El numero de barcos debe ser de 1 a 4");
                sc2.nextLine();
            }
        } while (!numeroBarcosValido2);
        for (int i = 0; i < numeroBarcos2; i++) {
            System.out.println("Ingrese la posicion del barco " + (i + 1) + " en el eje X (0-9)");
            int posicionX2 = sc2.nextInt();
            System.out.println("Ingrese la posicion del barco " + (i + 1) + " en el eje Y (0-9)");
            int posicionY2 = sc2.nextInt();
            tableroJugador2[posicionX2][posicionY2] = 1;
        }
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        boolean ganador = false;
        int puntosJugador1 = 0;
        int puntosJugador2 = 0;
        int[][] tirosJugador1 = new int[10][10];
        int[][] tirosJugador2 = new int[10][10];
        int turno = 1;
        while (!ganador) {
            if (turno == 1) {
                System.out.println("Turno de " + nombreJugador1);
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (tirosJugador2[i][j] == 1) {
                            if (tableroJugador1[i][j] == 1) {
                                System.out.print("2");
                            } else {
                                System.out.print("X");
                            }
                        } else {
                            if (tableroJugador1[i][j] == 1) {
                                System.out.print("1");
                            } else {
                                System.out.print("0");
                            }
                        }
                    }
                    System.out.println();
                }
                System.out.println("Puntaje de " + nombreJugador1 + ": " + puntosJugador1);
                System.out.println("Barcos por hundir de " + nombreJugador2 + ": " + numeroBarcos2);
                System.out.println("Ingrese la posicion del tiro en el eje X (0-9)");
                int posicionX1 = sc.nextInt();
                System.out.println("Ingrese la posicion del tiro en el eje Y (0-9)");
                int posicionY1 = sc.nextInt();
                if (tirosJugador1[posicionX1][posicionY1] == 1) {
                    System.out.println("tiro repetido, vuelve a tirar");
                } else {
                    tirosJugador1[posicionX1][posicionY1] = 1;
                    if (tableroJugador2[posicionX1][posicionY1] == 1) {
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        System.out.println("Barco hundido");
                        puntosJugador1 += 10;
                        numeroBarcos2--;
                        if (numeroBarcos2 == 0) {
                            System.out.println("Ganaste " + nombreJugador1);
                            System.out.println("Puntaje de " + nombreJugador1 + ": " + puntosJugador1);
                            System.out.println("Barcos por hundir de " + nombreJugador2 + ": " + numeroBarcos2);
                            System.out.println("Se muestra tablero de " + nombreJugador2 + " con sus barcos hunidos y tus tiros fallidos:");
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 10; j++) {
                                    if (tirosJugador1[i][j] == 1) {
                                        if (tableroJugador2[i][j] == 1) {
                                            System.out.print("2");
                                        } else {
                                            System.out.print("X");
                                        }
                                    } else {
                                        if (tableroJugador2[i][j] == 1) {
                                            System.out.print("1");
                                        } else {
                                            System.out.print("0");
                                        }
                                    }
                                }
                                System.out.println();
                            }
                            ganador = true;
                        }
                    } else {
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        System.out.println("Tiro al agua");
                    }
                    turno = 2;
                }
            } else {
                System.out.println("Turno de " + nombreJugador2);
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (tirosJugador1[i][j] == 1) {
                            if (tableroJugador2[i][j] == 1) {
                                System.out.print("2");
                            } else {
                                System.out.print("X");
                            }
                        } else {
                            if (tableroJugador2[i][j] == 1) {
                                System.out.print("1");
                            } else {
                                System.out.print("0");
                            }
                        }
                    }
                    System.out.println();
                }
                System.out.println("Puntaje de " + nombreJugador2 + ": " + puntosJugador2);
                System.out.println("Barcos por hundir de " + nombreJugador1 + ": " + numeroBarcos1);
                System.out.println("Ingrese la posicion del tiro en el eje X (0-9)");
                int posicionX2 = sc2.nextInt();
                System.out.println("Ingrese la posicion del tiro en el eje Y (0-9)");
                int posicionY2 = sc2.nextInt();
                if (tirosJugador2[posicionX2][posicionY2] == 1) {
                    System.out.println("tiro repetido, vuelve a tirar");
                } else {
                    tirosJugador2[posicionX2][posicionY2] = 1;
                    if (tableroJugador1[posicionX2][posicionY2] == 1) {
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        System.out.println("Barco hundido");
                        puntosJugador2 += 10;
                        numeroBarcos1--;
                        if (numeroBarcos1 == 0) {
                            System.out.println("Ganaste " + nombreJugador2);
                            System.out.println("Puntaje de " + nombreJugador2 + ": " + puntosJugador2);
                            System.out.println("Barcos por hundir de " + nombreJugador1 + ": " + numeroBarcos1);
                            System.out.println("Se muestra tablero de " + nombreJugador1 + " con sus barcos hunidos y tus tiros fallidos:");
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 10; j++) {
                                    if (tirosJugador2[i][j] == 1) {
                                        if (tableroJugador1[i][j] == 1) {
                                            System.out.print("2");
                                        } else {
                                            System.out.print("X");
                                        }
                                    } else {
                                        if (tableroJugador1[i][j] == 1) {
                                            System.out.print("1");
                                        } else {
                                            System.out.print("0");
                                        }
                                    }
                                }
                                System.out.println();
                            }
                            ganador = true;
                        }
                    } else {
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        System.out.println("Tiro al agua");
                    }
                    turno = 1;
                }
            }
        }
    }
}
