import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Color;
import java.awt.event.*;

public class Acceuil extends JPanel {
    
    static JPanel pan = new JPanel();
    static JButton buttonPlay = new JButton("Play");
    static JButton buttonSetting= new JButton("Settings");
    static JButton buttonLevel= new JButton("Level");
    static JButton buttonReplay= new JButton("Replay");

    public static void designButton(){
        buttonPlay.setBounds(100, 100, 300, 100);
        buttonSetting.setBounds(200, 200, 300, 100);
        buttonLevel.setBounds(300, 300, 300, 100);
        buttonReplay.setBounds(750, 750, 500, 200);
    }

    public static void addAction(){
        buttonPlay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Game.page=2;
            }
        });
        buttonSetting.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Game.page=3;
            }
        });
        buttonLevel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Game.page=4;
            }
        });
        buttonReplay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Collision.gameOver= 0;
                Player.numberOftiles= 0;
                Game.page=0;
                
            }
        });
    
    };
    
}
