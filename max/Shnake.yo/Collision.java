public class Collision {

    static int gameOver;
    static int cooX;
    static int cooY;

    HpUp green = new HpUp(Game.hpx, Game.hpy, Game.hpUpdate, Game.hpTotal);
    Player p = new Player(Game.px, Game.py);
    AttackUp red= new AttackUp();

    public void autoCollision(){
        gameOver= 0;
        for(int i= 5; i< Player.numberOftiles; i++){
            int index= Player.arrayTileX.size()-i;
            cooX= Player.arrayTileX.get(index);
            cooY= Player.arrayTileY.get(index);
            OutOfMap out = new OutOfMap();
            out.ifOutOfMap();
            if( cooX+10 >  p.playerX-5 && p.playerX+5 > cooX-10 &&
                cooY+10 > p.playerY-5 && p.playerY+5 > cooY-10){
                System.out.println("cooX "+ cooX+ " cooy "+ cooY+ " playerX "+ p.playerX+ " playerY "+ p.playerY+ " i "+i);
                gameOver= 1;
                Game.score= 0;
            }
        }
    }
    public void hpCollision(){
        if(green.cox+8 > p.playerX-10 && p.playerX+10 > green.cox-8 &&
            green.coy+8 > p.playerY-10 && p.playerY+10 > green.coy-8){
            green.total+= green.update;
            Player.numberOftiles+=10;
            Game.score+= 100;
            HpUp.a++;
            HpUp.randomHpCoord();
        }
    }
    public void  attackCollision(){
            if(red.cox+15 > p.playerX-10 && p.playerX+10 > red.cox-15 &&
        red.coy+15 > p.playerY-10 && p.playerY+10 > red.coy-15){
                red.total+= red.update;
                AttackUp.randomAttackCoord();
                AttackUp.a++;
            }
        }
    // public void  numberOfAttackCollision(){
    //     if(numberOfAttackX == playerX && numberOfAttackY == playerY){
    //         numberOfAttack+= updateNumberOfAttack;
    //         randomNumberOfAttackCoord();
    //         z++;
    //     }
    // }
}