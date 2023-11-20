public class HpUp extends Item {

    static int a;
    static double random;

    public HpUp(int x, int y, int updateHp, int hp){
        super(x, y, updateHp, hp );
    }

    public static void randomHpCoord(){
        if(a< 3){
            random = Math.random();
            if(random< 0.25){
                Game.hpx+= 150*(a+1) ;
                Game.hpx+= 100*(a+1);
            }
            else if(random< 0.5 && random>= 0.25){
                Game.hpy+= 150*(a+1) ;
                Game.hpx+= 100*(a+1);
            }
            else if(random< 0.75 && random>= 0.5){
                Game.hpx+= 150*(a+1) ;
            }
            else if(random< 1 && random>= 0.75){
                Game.hpy+= 150*(a+1) ;
            }
        }
        else {
            Game.hpx= 100;
            Game.hpy= 100;
            a = 0;
        }
    }

    public int getCox(){
        return cox;
    } 
    public int getCoy(){
        return coy;
    }   
}