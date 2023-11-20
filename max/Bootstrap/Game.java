import javax.swing.Timer;
import javax.swing.JFrame;
import java.awt.event.*;


public class Game extends JFrame implements KeyListener{

    // public List<T> NumberOfEnemies;
    private JFrame frame;

    public Game(){
        frame= new JFrame("Bootstrap");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.addKeyListener(this);

        Timer timer= new Timer(300, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setContentPane(new Display());
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                System.out.println("\n\n\n\n\n\n\n\n\n...");
                System.out.println("HP: "+ Display.hp);
                System.out.println("Attack: "+ Display.attack);
                System.out.println("Number of attack: "+ Display.numberOfAttack);
            }
        });
        timer.start();
    }

    // public List<T> getNumberOfEnemies(){
    //     return NumberOfEnemies;
    // }

        // while(Player.hp> 0 && getNumberOfEnemies() != null && x< 2){
        //     System.out.println("Ca continue");
        // }
        // System.out.println("GAME OVER");
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()== KeyEvent.VK_UP){
            Display.playerY-= 10;
        }
        else if(e.getKeyCode()== KeyEvent.VK_DOWN){
            Display.playerY+= 10;
        }
        else if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            Display.playerX+= 10;
        }
        else if(e.getKeyCode()== KeyEvent.VK_LEFT){
            Display.playerX-= 10;
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}


    public static void main(String[] args){
        
    }
}