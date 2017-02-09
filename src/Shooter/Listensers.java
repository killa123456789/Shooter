package Shooter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Ilya on 01.02.2017.
 */
public class Listensers implements KeyListener {




    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_UP){
            Player.up = true;
        }
        if(key == KeyEvent.VK_DOWN){
            Player.down = true;
        }
        if(key == KeyEvent.VK_LEFT){
            Player.left = true;
        }
        if(key == KeyEvent.VK_RIGHT){
            Player.right = true;
        }
        if(key == KeyEvent.VK_SPACE){
            Player.isFiring = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
            if(key == KeyEvent.VK_UP){
                Player.up = false;
            }
            if(key == KeyEvent.VK_DOWN){
                Player.down = false;
            }
            if(key == KeyEvent.VK_LEFT){
                Player.left = false;
            }
            if(key == KeyEvent.VK_RIGHT){
                Player.right = false;
            }
        if(key == KeyEvent.VK_SPACE){
            Player.isFiring = false;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }
}
