public class OutOfMap {
    
    public void ifOutOfMap(){
        if(Game.px> 1500){
            Game.px=1;
            Player.arrayTileY.add(Game.py);
            Player.arrayTileX.add(Game.px);
        }
        else if(Game.px< 0){
            Game.px= 1495;
            Player.arrayTileY.add(Game.py);
            Player.arrayTileX.add(Game.px);
        }
        if(Game.py> 900){
            Game.py= 1;
            Player.arrayTileY.add(Game.py);
            Player.arrayTileX.add(Game.px);
        }
        else if(Game.py< 0){
            Game.py= 895;
            Player.arrayTileY.add(Game.py);
            Player.arrayTileX.add(Game.px);
        }
    }
}