package Core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Torri
 */
public class KeyboardInput implements KeyListener{
    public boolean[] keys = new boolean[10000];
    public int[] keyn;
    public boolean up=false,down=false,left=false,right=false,spell=false,eat=false;
    public KeyboardInput(int[] keys){
        keyn=keys;
        System.out.println("init");
    }
    public void checkSettings(int[] keys){
        keyn=keys;
        for(int i=0;i<keys.length;i++){
            System.out.println(Cast.inttoString(keys[i]));
        }
    }
    public boolean turn(){
        boolean out = true;
        for(int i=0;i<keyn.length;i++){
            if(keys[keyn[i]]==true){
                out=true;
                MainMenu.display.gp.update();
                break;
            }else{
                out=false;
            }
        }
        return out;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        turn();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
        up=keys[keyn[0]];
        down=keys[keyn[1]];
        left=keys[keyn[2]];
        right=keys[keyn[3]];
        spell=keys[keyn[4]];
        eat=keys[keyn[5]];
    }
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
        up=keys[keyn[0]];
        down=keys[keyn[1]];
        left=keys[keyn[2]];
        right=keys[keyn[3]];
        spell=keys[keyn[4]];
        eat=keys[keyn[5]];
    }
}
