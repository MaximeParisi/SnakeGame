import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Display extends JPanel {

    static double x= 0;
    static int y;
    static int z;
    static double randomAttack;
    int hpX1= 10;
    int hpY1= 10;
    int hpX2= 100;
    int hpY2= 10;
    int hpX;
    int hpY;
    int updateHp;
    static int hp;

    static int attackX;
    static int attackY;
    int updateAttack;
    static int attack;

    static int numberOfAttackX;
    static int numberOfAttackY;
    int updateNumberOfAttack;
    static int numberOfAttack;

    static int playerX;
    static int playerY= 20;

    
    public static void randomAttackCoord(){
        attackY = 30;
        if(y< 3){
            randomAttack = Math.random();
            if(randomAttack< 0.25){
                attackX+= 50*(y+1) ;
            }
            else if(randomAttack< 0.5 && randomAttack>= 0.25){
                attackY+= 50*(y+1) ;
            }
            else if(randomAttack< 0.75 && randomAttack>= 0.5){
                attackX+= 50*(y+1) ;
            }
            else if(randomAttack< 1 && randomAttack>= 0.75){
                attackY+= 50*(y+1) ;
            }
        }
        else {
            attackX= 100;
            attackY= 100;
             y = 0;
        }
    }
    public static void randomNumberOfAttackCoord(){
        numberOfAttack= 60;
        if(z< 3){
            randomAttack = Math.random();
            if(randomAttack< 0.25){
                numberOfAttackX+= 50*(z+1) ;
                
            }
            else if(randomAttack< 0.5 && randomAttack>= 0.25){
                numberOfAttackY+= 50*(z+1) ;
            }
            else if(randomAttack< 0.75 && randomAttack>= 0.5){
                numberOfAttackX+= 50*(z+1) ;
            }
            else if(randomAttack< 1 && randomAttack>= 0.75){
                numberOfAttackY+= 50*(z+1) ;
            }
        }
        else {
            attackX= 100;
            attackY= 100;
             z = 0;
        }
    }

    public void paintComponent(Graphics g){
        
        if(x%2 == 0){
            g.setColor(Color.GREEN);
            g.fillOval(hpX1, hpY1, 10, 10);
            HpUp h = new HpUp();
            hpX= hpX1;
            hpY= hpY1;
            updateHp= h.bonus;
        }else {
            g.setColor(Color.GREEN);
            g.fillOval(hpX2, hpY2, 10, 10);
            HpUp h = new HpUp();
            hpX= hpX2;
            hpY= hpY2;
            updateHp= h.bonus;
        }
        itemCollision();

        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, 10, 10);

        g.setColor(Color.RED);
        g.fillOval(attackX, attackY, 10, 10);
        AttackUp a = new AttackUp();
        updateAttack= a.bonus;
        attackCollision();

        g.setColor(Color.PINK);
        g.fillOval(numberOfAttackX, numberOfAttackY, 10, 10);
        NumberOfAttackUp n = new NumberOfAttackUp();
        updateNumberOfAttack= n.bonus;
        numberOfAttackCollision();
    }

    public void itemCollision(){
        if(hpX == playerX && hpY == playerY){
            hp+= updateHp;
            x++;
        }
    }
    public void  attackCollision(){
        if(attackX == playerX && attackY == playerY){
            attack+= updateAttack;
            randomAttackCoord();
            y++;
        }
    }
    public void  numberOfAttackCollision(){
        if(numberOfAttackX == playerX && numberOfAttackY == playerY){
            numberOfAttack+= updateNumberOfAttack;
            randomNumberOfAttackCoord();
            z++;
        }
    }
   
}
