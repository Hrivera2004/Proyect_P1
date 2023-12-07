
package proyecto_final;

public class Proyecto_Final {

    public static void main(String[] args) {
        int[][] tab = new int[6][7];
        
        Connect4 game = new Connect4(tab);
        game.c4();
    }
}
