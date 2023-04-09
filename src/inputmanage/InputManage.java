package inputmanage;

import objectgame.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class InputManage {
    public Player player;
    public InputManage() throws IOException {
       player = new Player();
    }
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:{
                player.setMoveLeft(true);
                break;
            }
            case KeyEvent.VK_RIGHT:{
                player.setMoveRight(true);
                break;
            }
            case KeyEvent.VK_UP:{
                player.setMoveUp(true);
                break;
            }
            case KeyEvent.VK_DOWN:{
                player.setMoveDown(true);
                break;
            }
        }
    }
    public void keyReleased(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:{
                player.setMoveLeft(false);
                break;
            }
            case KeyEvent.VK_RIGHT:{
                player.setMoveRight(false);
                break;
            }
            case KeyEvent.VK_UP:{
                player.setMoveUp(false);
                break;
            }
            case KeyEvent.VK_DOWN:{
                player.setMoveDown(false);
                break;
            }
        }
    }
}
