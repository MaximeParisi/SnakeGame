public class AttackUp extends Item {

    static int a;
    static double randomAttack;

    static int x;
    static int y;
    static int updateAttack;
    static int attack;

   

    public AttackUp(){
        super(x, y, updateAttack, attack);
    }

    public static void randomAttackCoord(){
        if(a< 3){
            randomAttack = Math.random();
            if(randomAttack< 0.25){
                x+= 100*(a+1) ;
            }
            else if(randomAttack< 0.5 && randomAttack>= 0.25){
                y+= 100*(a+1) ;
            }
            else if(randomAttack< 0.75 && randomAttack>= 0.5){
                x+= 100*(a+1) ;
            }
            else if(randomAttack< 1 && randomAttack>= 0.75){
                y+= 100*(a+1) ;
            }
        }
        else {
            x= 100;
            y= 300;
            a = 0;
        }
    }


}