import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.*;


public class Player extends JPanel{

    static int numberOftiles= 0;
    static String direction;

    int playerX;
    int playerY;
    public static ArrayList<Integer> arrayTileX = new ArrayList<>();
    public static ArrayList<Integer> arrayTileY = new ArrayList<>();


    public Player(int x, int y){
        this.playerX= x;
        this.playerY= y;
    }

    public void autoMoov(){

        int slowSpeed= 10;
        int fastSpeed= 20;
        int megaSpeed= 25;

        int speed;

        if(Game.score< 500){
            speed= slowSpeed;
        }
        else if(Game.score< 1000){
            speed= fastSpeed;
        }
        else{
            speed= megaSpeed;
        }

        int tileX1= Game.px; //x
        int tileY1= Game.py; //y
        if (arrayTileX.size()<2){
        }
        else{
            int index= arrayTileX.size()-2;
            int tileX2= arrayTileX.get(index);
            int tileY2= arrayTileY.get(index);


            if(tileX1== tileX2 && tileY1+800< tileY2){
                Game.py+= speed; //y
                arrayTileX.add(Game.px);
                arrayTileY.add(Game.py);
                direction="down";
            }
            else if(tileX1== tileX2 && tileY1 > tileY2+800){
                Game.py-= speed; //y
                arrayTileY.add(Game.py);
                arrayTileX.add(Game.px);
                direction= "up";
            }
            else if(tileY1== tileY2 && tileX1+1000< tileX2){
                Game.px+= speed; //x
                arrayTileY.add(Game.py);
                arrayTileX.add(Game.px);
                direction="right";
            }
            else if(tileY1== tileY2 && tileX1 > tileX2+1000){
                Game.px-= speed; //x
                arrayTileX.add(Game.px);
                arrayTileY.add(Game.py);
                direction="left";
            }
            
            else{

             if(tileX1== tileX2 && tileY1< tileY2){
                Game.py-= speed; //y
                arrayTileY.add(Game.py);
                arrayTileX.add(Game.px);
                direction= "up";
             }
             else if(tileX1== tileX2 && tileY1> tileY2){
                Game.py+= speed;  //y
                arrayTileX.add(Game.px);
                arrayTileY.add(Game.py);
                direction="down";
             }
             else if(tileX1> tileX2 && tileY1== tileY2){
                Game.px+= speed; //x
                arrayTileY.add(Game.py);
                arrayTileX.add(Game.px);
                direction="right";
             }
             else if(tileX1< tileX2 && tileY1== tileY2){
                Game.px-= speed; //x
                arrayTileX.add(Game.px);
                arrayTileY.add(Game.py);
                direction="left";
             }
            }
        }
    }  
   
    
}