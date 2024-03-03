package Main;
import java.awt.event.*;


public class KeyHandler implements KeyListener {
    public boolean up,down,left,right;
    public int keyCount=0;
    @Override
    public void keyTyped(KeyEvent e){
        
    }
    @Override
    public void keyPressed(KeyEvent e){
        
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_UP){
            up=true;
            keyCount++;
        }
        
        if(code==KeyEvent.VK_DOWN){
            down=true;
            keyCount++;
        }
        if(code==KeyEvent.VK_LEFT){
            left=true;
            keyCount++;
        }
        if(code==KeyEvent.VK_RIGHT){
            right=true;
            keyCount++;
        }

    }
    @Override
    public void keyReleased(KeyEvent e){
        
        
        

    }
}
