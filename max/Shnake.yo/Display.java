import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Color;

public class Display extends JPanel {
 

    public void paintComponent(Graphics g){

        Collision collision = new Collision(); 
        Player p = new Player(Game.px, Game.py);
        AttackUp red= new AttackUp();
        HpUp green = new HpUp(Game.hpx, Game.hpy, Game.hpUpdate, Game.hpTotal);

        if(Game.easterEgg== 1){
            g.setColor(Color.PINK);
        }
        else{
            g.setColor(Color.YELLOW);
        }
        g.fillOval(p.playerX, p.playerY, 30, 30);
        collision.autoCollision();

        int colorTile= 0;
        for ( int i=2; i<Player.numberOftiles; i++){
            if(Game.easterEgg== 1){
                g.setColor(Color.PINK);
            }
            else{
                if(colorTile== 0){
                    g.setColor(Color.YELLOW);
                    colorTile++;
                }
                else{
                    g.setColor(Color.ORANGE);
                    colorTile--;
                }
                
            }
            int index= Player.arrayTileX.size()-i;
            int cooX = Player.arrayTileX.get(index);
            int cooY = Player.arrayTileY.get(index);
            g.fillOval(cooX, cooY, 30, 30);
        }
        if(Game.easterEgg== 1){
            if(Player.direction== "up"){
                g.setColor(Color.BLACK);
                g.fillRect(p.playerX+14, p.playerY, 2, 10);
                g.setColor(Color.BLACK);
                g.fillRect(p.playerX, p.playerY+15, 30, 2);
            }
            else if(Player.direction== "down"){
                g.setColor(Color.BLACK);
                g.fillRect(p.playerX+15, p.playerY+17, 2, 10);
                g.setColor(Color.BLACK);
                g.fillRect(p.playerX, p.playerY+10, 30, 2);
            }
            else if(Player.direction== "right"){
                g.setColor(Color.BLACK);
                g.fillRect(p.playerX+18, p.playerY+15, 10, 2);
                g.setColor(Color.BLACK);
                g.fillRect(p.playerX+12, p.playerY, 2, 30);
            }
            else if(Player.direction== "left"){
                g.setColor(Color.BLACK);
                g.fillRect(p.playerX, p.playerY+15, 10, 2);
                g.setColor(Color.BLACK);
                g.fillRect(p.playerX+13, p.playerY, 2, 30);
            }
        }

        g.setColor(Color.BLUE);
        g.fillOval(green.cox, green.coy, 30, 30);
        green.total+= green.update;
        collision.hpCollision();

        g.setColor(Color.RED);
        g.fillOval(red.cox, red.coy, 30, 30);
        red.total= red.update;
        collision.attackCollision();

        // g.setColor(Color.PINK);
        // g.fillOval(numberOfAttackX, numberOfAttackY, 30, 30);
        // NumberOfAttackUp n = new NumberOfAttackUp();
        // updateNumberOfAttack= n.bonus;
        // numberOfAttackCollision();
    }

    // public void  numberOfAttackCollision(){
    //     if(numberOfAttackX == playerX && numberOfAttackY == playerY){
    //         numberOfAttack+= updateNumberOfAttack;
    //         randomNumberOfAttackCoord();
    //         z++;
    //     }
    // }
   
}
