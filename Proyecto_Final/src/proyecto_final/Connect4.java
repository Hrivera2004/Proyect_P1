
package proyecto_final;
    import java.util.*;
    import javax.swing.JOptionPane;

public class Connect4 {
    Random rd = new Random();
    static Scanner sc = new Scanner(System.in);
    boolean campeon=false;
    int turn;
    int x;
    int y;
    int[][] tab;
    
    public Connect4(){
    }
    public Connect4(int[][] tab,int x, int y,int turn) {
        this.tab = tab;
        this.x = x;
        this.y = y;
        this.turn = turn;
    }
    public Connect4(int[][] tab) {
        this.tab = tab;
    }
    
    public int[][] getTab() {
        return tab;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getTurn() {
        return turn;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setTab(int[][] tab) {
        this.tab = tab;
    }
    public void setTurn(int turn) {
        this.turn = turn;
    }

    
    public void c4(){
        options();
    }
    
    public void options(){
        String[] choose = {"2 Players","AI"};
        int option=JOptionPane.showOptionDialog(null, "Eliga la modalidad de juego"
                ,"Connect4", 0, 3, null, choose, choose[0]);
        turn=0;
        while(turn<42 && campeon==false){ 
            turn++;
            play(option);
            System.out.println("------------------------");
            flip();
        }
        if (campeon==true) {
            if (turn%2!=0) {
                System.out.println("Jugador 1 gano");
            }else if(option==0){
                System.out.println("Jugador 2 gano");
            }else{
                System.out.println("AI gano");
            }
        }
    }
    
    public void play(int option){
        if (option==0) {
            if (turn%2!=0) {
                System.out.println("Turno jugador 1");
                jugador1();
                print(tab);
                System.out.println("-----------------");
            }else{
                System.out.println("Turno jugador 2");
                jugador2();
                print(tab);
                System.out.println("-----------------");
            }
            if (turn>=0) {
                System.out.println("-------------");
                System.out.println(x+" :x");
                System.out.println(y+" :y");
                System.out.println("-------------");
                //campeon=Ver(tab,x,y);
            }
            
        }else{
            if (turn%2!=0) {
                System.out.println("Turno jugador 1");
                jugador1();
                print(tab);
                System.out.println("-----------------");
            }else{
                System.out.println("Turno AI");
                AI();
                print(tab);
                System.out.println("-----------------");
            }
            if (turn>=0) {
                System.out.println("-------------");
                System.out.println(x+" :x");
                System.out.println(y+" :y");
                System.out.println("-------------");
                //campeon=Ver(tab,x,y);
            }
        }
    }    
    public void jugador1(){
        System.out.println("Ingrese columna(1-7): ");
        x = sc.nextInt()-1;
        boolean found=false;
        while(found==false){
            for (int i = 5; i >= 0 && found==false; i--) {
                if (tab[i][x]==0) {
                    found=true;
                    tab[i][x]=1;
                    y=i;
                }
            }
            if (found==false) {
                System.out.println("No se encontro el espacio que desea ingrese ptra columna");
                x = sc.nextInt()-1;
            }
        }
        
    }
    public void jugador2(){
        System.out.println("Ingrese columna(1-7): ");
        x = sc.nextInt()-1;
        boolean found=false;
        while(found==false){
            for (int i = 5; i >= 0 && found==false; i--) {
                if (tab[i][x]==0) {
                    found=true;
                    tab[i][x]=2;
                    y=i;
                }
            }
            if (found==false) {
                System.out.println("No se encontro el espacio que desea ingrese ptra columna");
                x = sc.nextInt()-1;
            }
        }
    }
    public void AI(){
        x = rd.nextInt(7);
        boolean found=false;
        while(found==false){
            for (int i = 5; i >= 0 && found==false; i--) {
                if (tab[i][x]==0) {
                    found=true;
                    tab[i][x]=2;
                    y=i;
                }
            }
            if (found==false) {
                x = rd.nextInt(7);
            }
        }
    }
    public boolean Ver(int[][] mat, int x, int y) {
        ArrayList<Integer> pos = pos(tab,x,y);
        
        int diaP1=0,diaP2=0,diaN1 = 0,diaN2 = 0,rectH1=0,rectH2=0,rectV=0;
        for (int i = 0; i < pos.size(); i++) {
            int win = pos.get(i);
            System.out.println("----------------------"+win);
            boolean proximity=true;
            if (win==1) {
                for (int j = 0; j < 4 ; j++) {
                    
                    if (mat[y][x]==mat[y-j][x+j] &&  proximity==true) {
                        System.out.println("1");
                        diaP1++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }else if(win==2) {
                for (int j = 0; j < 4 ; j++) {
                    
                    if (mat[y][x]==mat[y][x+j]&& proximity==true) {
                        System.out.println("2");
                        rectH1++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }else if(win==3) {
                for (int j = 0; j < 4; j++) {
                    
                    if (mat[y][x]==mat[y+j][x+j]&&proximity==true) {
                        System.out.println("3");
                        diaN1++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }else if(win==4) {
                for (int j = 0; j < 4; j++) {
                    
                    if (mat[y][x]==mat[y+j][x]&& proximity==true) {
                        System.out.println("4");
                        rectV++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }else if(win==5) {
                for (int j = 0; j < 4; j++) {
                    
                    if (mat[y][x]==mat[y+j][x-j]&&proximity==true) {
                        System.out.println("5");
                        diaP2++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }else if(win==6) {
                for (int j = 0; j < 4; j++) {
                    if (mat[y][x]==mat[y][x-j]&&proximity==true) {
                        System.out.println("6---------");
                        rectH2++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }else if(win==7) {
                for (int j = 0; j < 4; j++) {
                    
                    if (mat[y][x]==mat[y-j][x-j]&&proximity==true) {
                        System.out.println("7----------");
                        diaN2++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }
            
        }
        System.out.println("---------------------------");
        
        int diaP= diaP1+diaP2 ;
        int diaN = diaN1+diaN2;
        int rectH= rectH1+rectH2;
        
        if (diaN<4&&diaP<4&&rectH<4) {
            int[] rem = {4-diaN,4-diaP,4-rectH};
            int menor=4;
            int posM=0; 
            for (int i = 0; i < rem.length; i++) {
                if (rem[i]<menor) {
                    menor=rem[i];
                    posM=i;
                }
                
            }
            
            if (posM==0 &&y!=0&&y!=mat.length-1 && x!=0 && x!=mat.length) {
                if (diaN1==0) {
                    for (int i = 1; i <= menor; i++) {
                        if (mat[y][x]==mat[y+i][x+i]) {
                            diaN++;
                        }
                    }    
                }else if (diaN2==0){
                    for (int i = 1; i <= menor; i++) {
                        if (mat[y][x]==mat[y-i][x-i]) {
                            diaN++;
                        }
                    }
                }
                
            }
            else if (posM==1 &&y!=0&&y!=mat.length-1 && x!=0 && x!=mat.length) {
                if (diaP1==0) {
                    for (int i = 1; i <= menor; i++) {
                        if (mat[y][x]==mat[y-i][x+i]) {
                            diaP++;
                        }
                    }    
                }else if (diaP2==0){
                    for (int i = 1; i <= menor; i++) {
                        if (mat[y][x]==mat[y+i][x-i]) {
                            diaP++;
                        }
                    }
                }
                

            }
            else if (posM==2 &&y!=0&&y!=mat.length-1 && x!=0 && x!=mat.length) {
                if (rectH1==0) {
                    for (int i = 1; i <= menor; i++) {
                        if (mat[y][x]==mat[y][x-i]) {
                            rectH++;
                        }
                    }    
                }else if (rectH2==0){
                    for (int i = 1; i <= menor; i++) {
                        if (mat[y][x]==mat[y][x+i]) {
                            rectH++;
                        }
                    }
                }
            }
        }
         System.out.println("--------VErificacion-------");
        if (diaN>=4||diaP>=4||rectH>=4||rectV>=4) {
            return true;
        }else{
            return false;
        }
       
    }//hector
    public ArrayList<Integer> pos(int[][] mat, int x, int y) {
        ArrayList<Integer> pos = new ArrayList<Integer>();
        if (mat.length+1-x>3 && y>3) {//diagonal positiva
            pos.add(1);
            System.out.println("1+");
        }
        if (mat.length+1-x>3) {//recta horizontal positiva
            pos.add(2);
            System.out.println("2+");
        }
        if (mat.length+1-x>3 && mat.length-y>3) {//diagonal inversa negativa 
            pos.add(3);
            System.out.println("3+");
        }
        if (mat.length-y>3) {//recta vertical 
            pos.add(4);
            System.out.println("4+");
        }
        if (x>3 && mat.length-y>3) {//diagonal Abajo negativa 
            pos.add(5);
            System.out.println("5+");
        }
        if (x>3) {//recta horizontal negativa 
            pos.add(6);
            System.out.println("6+");
        }
        if (x>3 && y>3) {//diagonal Arriba negativa
            pos.add(7);
            System.out.println("7+");
        }
        return pos;
    }//hector
    public void flip(){
        
        int chance = rd.nextInt(101);
        ArrayList<Integer> flip = new ArrayList<Integer>();
        
        if (chance<5) {
            boolean ver = true;
            for (int i = 0; i<6 ; i++) {
                if (tab[tab.length-1-i][x]==0) {
                }else{
                    flip.add(tab[tab.length-1-i][x]);
                }
                    
            }
            int cont=0;
            for (int i = tab.length-flip.size(); i <= tab.length-1; i++) {
                int num = flip.get(cont);
                tab[i][x]= num;
                cont++;
            }
            JOptionPane.showMessageDialog(null, "Hubo un flip en"+x);
            System.out.println("-------------------");
            print(tab);
            System.out.println("-------------------");
        }
    }

    public void print(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(" ["+x[i][j]+"] ");
            }
            System.out.println("");
        }
    }
}
