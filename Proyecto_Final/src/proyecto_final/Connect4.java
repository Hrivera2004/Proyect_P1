/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;
    import java.util.*;

public class Connect4 {
    Random rd = new Random();
    
    int x;
    int y;
    int[][] tab;
    
    public Connect4(int[][] tab, int x, int y) {
        this.x = x;
        this.y = y;
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
    
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    
    
    public boolean Ver(int[][] mat, int x, int y) {
        ArrayList<Integer> pos = pos(tab,x,y);
        int diaP1=0,diaP2=0,diaN1 = 0,diaN2 = 0,rectH1=0,rectH2=0,rectV=0;
        
        for (int i = 0; i < pos.size(); i++) {
            int win = pos.get(i);

            boolean proximity=true;
            
            if (win==1) {
                for (int j = 0; j < 4 && proximity; j++) {
                    if (mat[y][x]==mat[y-j][x+j]) {
                        diaP1++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }else if(win==2) {
                for (int j = 0; j < 4 && proximity; j++) {
                    if (mat[y][x]==mat[y][x+j]) {
                        rectH1++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }else if(win==3) {
                for (int j = 0; j < 4&&proximity; j++) {
                    if (mat[y][x]==mat[y+j][x+j]) {
                        diaN1++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }else if(win==4) {
                for (int j = 0; j < 4&& proximity; j++) {
                    if (mat[y][x]==mat[y+j][x]) {
                        rectV++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }else if(win==5) {
                for (int j = 0; j < 4 && proximity; j++) {
                    if (mat[y][x]==mat[y+j][x-j]) {
                        diaP2++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }else if(win==6) {
                for (int j = 0; j < 4&& proximity; j++) {
                    if (mat[y][x]==mat[y][x-j]) {
                        rectH2++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }else if(win==7) {
                for (int j = 0; j < 4 && proximity; j++) {
                    if (mat[y][x]==mat[y-j][x-j]) {
                        diaN2++; 
                    }else{
                        proximity=false;
                    }
                    
                }
            }
            
        }

        
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
        if (diaN>=4||diaP>=4||rectH>=4||rectV>=4) {
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<Integer> pos(int[][] mat, int x, int y) {
        ArrayList<Integer> pos = new ArrayList<Integer>();
        if (mat.length+1-x>3 && y>3) {//diagonal positiva
            pos.add(1);
        }
        if (mat.length+1-x>3) {//recta horizontal positiva
            pos.add(2);
        }
        if (mat.length+1-x>3 && mat.length-y>3) {//diagonal inversa negativa 
            pos.add(3);
        }
        if (mat.length-y>3) {//recta vertical 
            pos.add(4);
        }
        if (x>3 && mat.length-y>3) {//diagonal Abajo negativa 
            pos.add(5);
        }
        if (x>3) {//recta horizontal negativa 
            pos.add(6);
        }
        if (x>3 && y>3) {//diagonal Arriba negativa
            pos.add(7);
        }
        return pos;
    }
    
    public void flip(int[][] tab,int x){
        
        int chance = rd.nextInt(101);
        ArrayList<Integer> flip = new ArrayList<Integer>();
        
        if (chance<200) {
            boolean ver = true;
            for (int i = 0; i<6 ; i++) {
                if (tab[tab.length-1-i][x]==0) {
                }else{
                    flip.add(tab[tab.length-1-i][x]);
                    System.out.println(tab[tab.length-1-i][x]);
                }
                    
            }
            System.out.println(flip.size());
            int cont=0;
            for (int i = tab.length-flip.size(); i <= tab.length-1; i++) {
                int num = flip.get(cont);
                tab[i][x]= num;
                cont++;
            }
        }
        print(tab);
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
