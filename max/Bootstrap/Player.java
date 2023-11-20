
import javax.swing.JPanel;


public class Player extends JPanel{

    String name;
    int hp;
    int attack;
    int numberOfAttack;

    public Player(){
        this.name= "hp";
        this.hp= 100;
        this.attack= 20;
        this.numberOfAttack= 5;
       
    }

    public String getName(){
        return name;
    }
    public int getBonus(){
        return hp;
    }
   
    
}
