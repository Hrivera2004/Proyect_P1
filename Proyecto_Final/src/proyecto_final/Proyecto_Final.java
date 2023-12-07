/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class Proyecto_Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[][] matriz = new int[7][6];
        boolean tuWin, ganaAI;
        do {
            System.out.println("Ingrese 1 para que el jugador comience, o 2 para que la computadora comience: ");
            int turnoInicial = sc.nextInt();
            if (turnoInicial == 1) {
                tuWin = jugar(sc, matriz, 1);
                ganaAI = compPlay(sc, matriz, 2);
            } else {
                ganaAI = compPlay(sc, matriz, 2);
                tuWin = jugar(sc, matriz, 1);
            }
            System.out.println("¿Desea continuar jugando? Ingrese 1 para sí, 2 para no.");
        } while (sc.nextInt() == 1);

        if (tuWin) {
            System.out.println("¡Felicidades! Has ganado.");
        } else if (ganaAI) {
            System.out.println("Has perdido. La computadora ha ganado.");
        } else {
            System.out.println("El juego ha terminado en empate.");
        }
    }

    public static boolean jugar(Scanner sc, int[][] matriz, int turno) {
        System.out.println("Turno del jugador " + turno);
        verificarPosicion(sc, matriz);
        return verificarGanador(matriz, turno);
    }

    public static void verificarPosicion(Scanner sc, int[][] matriz) {
        boolean esValido;
        int col, fila;
        do {
            System.out.println("Escoge una columna para poner tu punto: (0-6): ");
            col = sc.nextInt();
            esValido = col >= 0 && col <= 6;
            if (!esValido) {
                System.out.println("Posicion invalida o tomada, escoge otra");
            }
        } while (!esValido);

        for (fila = 5; fila >= 0; fila--) {
            if (matriz[col][fila] == 0) {
                matriz[col][fila] = turno; 
                break;
            }
        }
    }

    public static boolean verificarGanador(int[][] matriz, int turno) {
        
        return false;
        
    }

    public static boolean compPlay(Scanner sc, Random rand, int[][] matriz, int turno) {
        int pos_ai=rand.nextInt(7);
        verificarPosicion(sc, matriz, pos_ai, turno);
        return verificarGanador(matriz, turno);
    }

    public static void verificarPosicion(Scanner sc, int[][] matriz, int x, int turno) {
        int y;
        for (y = 5; y >= 0; y--) {
            if (matriz[x][y] == 0) {
                matriz[x][y] = turno; 
                break;
            }
        }
    }
}
