package Core;

/**
 * @author Torri
 */
public class Main {
    public static Game g;
    public static void main(String[] args){
        g = new Game(750,500);
    }
    public static Game getGame(){
        return g;
    }
}