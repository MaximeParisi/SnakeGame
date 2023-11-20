public class Item {
    int cox;
    int coy;
    int total;
    int update;

    public Item(int x, int y, int update, int total){
        this.cox= x;
        this.coy= y;
        this.update= update;
        this.total= total;
    }

    public int getCox(){
        return cox;
    }
    public int getCoy(){
        return coy;
    }
    public int getTotal(){
        return total;
    }
}