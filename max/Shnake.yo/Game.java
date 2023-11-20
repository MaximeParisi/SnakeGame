
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
// import java.util.*;


public class Game extends JFrame implements KeyListener {
    
    private JFrame frame;
    private JLabel displayScore;

    public static int page;

    public ImageIcon icon;

    static int easterEgg;
    static int score;
    static String leScore;

    static int hpx = 100;
    static int hpy = 100;
    static int hpUpdate;
    static int hpTotal;

    static int px;
    static int py;

    public Game(){

        
        frame= new JFrame("Bootstrap");
        
        frame.setSize(1500, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.addKeyListener(this);
        if(page== 0){
            Acceuil.designButton();
            frame.setLayout(new GridLayout(3, 1));
            frame.add(Acceuil.buttonPlay);
            frame.add(Acceuil.buttonSetting);
            frame.add(Acceuil.buttonLevel);
            Acceuil.addAction();
        }
        if(Collision.gameOver == 1){
            frame.add(Acceuil.buttonReplay);
        }
        frame.setVisible(true);
        
        HpUp green = new HpUp(hpx, hpy, hpUpdate, hpTotal);

        Timer timer= new Timer(50, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Collision.gameOver == 0){
                    
                    if(page == 2){
                        frame.setContentPane(new Display());
                        frame.getContentPane().removeAll();
                        frame.revalidate();
                        frame.repaint();
                        
                        // try{
                        //     JPanel bg = new JPanel();
                        //     bg.setBounds(100, 100, 500, 500);
                        //     BufferedImage img = ImageIO.read( new File("snakeHead.png"));
                        //     JLabel pic = new JLabel(new ImageIcon(img));
                        //     bg.add(pic);
                        //     frame.add(bg);

                        // }
                        // catch (IOException d){}
                        if(score< 500){
                            frame.setBackground(Color.GREEN);
                        }
                        else if(score< 1000){
                            frame.setBackground(Color.GRAY);
                        }
                        else{
                            frame.setBackground(Color.ORANGE);
                        }
                        
                        frame.setLayout(new GridLayout(1, 1));
                        leScore= "score: "+ score;
                        displayScore = new JLabel(leScore);
                        displayScore.setBounds(1400,0,100,100);
                        frame.add(displayScore);
                        System.out.print(displayScore);
                    }
                    else if(page == 0){
                        int t= 0;
                        if(t!= 1){
                            frame.getContentPane().removeAll();
                            Acceuil.designButton();
                            frame.setLayout(new GridLayout(3, 1));
                            frame.add(Acceuil.buttonPlay);
                            frame.add(Acceuil.buttonSetting);
                            frame.add(Acceuil.buttonLevel);
                            frame.setVisible(true);
                            Acceuil.addAction();
                            t++;
                        }
                    }
                    OutOfMap out = new OutOfMap();
                    out.ifOutOfMap();
                    Player p = new Player(px, py);
                    p.autoMoov();
                    // System.out.println("\n\n\n\n\n\n\n\n\n...");
                    System.out.println("HP: "+ green.cox);
                    System.out.println("Attack: "+ AttackUp.attack);
                    System.out.println("coor px: "+ px);
                    System.out.println("coor py: "+ py);
                    // System.out.println("Number of attack: "+ Display.numberOfAttack);
                }
                else{

                    System.out.print("Game Over");
                    frame.getContentPane().removeAll();
                    Acceuil.designButton();
                    frame.setLayout(new GridLayout(1, 1));
                    frame.add(Acceuil.buttonReplay);
                    frame.setVisible(true);
                    Acceuil.addAction();
                }
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
            if(Player.direction!= "down"){
                py-= 10;
                Player.arrayTileY.add(py);
                Player.arrayTileX.add(px);
            }
        }
        else if(e.getKeyCode()== KeyEvent.VK_DOWN){
            if(Player.direction!= "up"){
                py+= 10;
                Player.arrayTileX.add(px);
                Player.arrayTileY.add(py);
            }
        }
        else if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            if(Player.direction!= "left"){
                px+= 10;
                Player.arrayTileY.add(py);
                Player.arrayTileX.add(px);
            }
        }
        else if(e.getKeyCode()== KeyEvent.VK_LEFT){
            if(Player.direction!= "right"){
                px-= 10;
                Player.arrayTileX.add(px);
                Player.arrayTileY.add(py);  
            }
        }
        else if(e.getKeyChar()== 'e'){
            if(easterEgg== 0){
                easterEgg=1;
            }
            else{
                easterEgg= 0;
            }
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}


    public static void main(String[] args){
        new Game();
    }
}