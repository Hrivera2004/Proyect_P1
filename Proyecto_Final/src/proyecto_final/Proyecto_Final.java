
package proyecto_final;

public class Proyecto_Final {

    public static void main(String[] args) {
        int[][] tab = 
        {
            {9,0,0,0,0,0,2},
            {5,2,2,0,0,2,2},
            {4,0,2,0,2,0,0},
            {1,0,2,2,2,2,0},
            {1,2,0,2,1,2,0},
            {2,1,2,0,2,2,2},
        };
        int x=0,y=5;
        Connect4 game = new Connect4(tab,x,y);
        game.flip(tab, x);
    }
    
}
