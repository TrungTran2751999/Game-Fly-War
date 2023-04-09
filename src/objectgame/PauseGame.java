package objectgame;

import mainGame.GameFrame;
import mainGame.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class PauseGame extends Panel{
    private double x;
    private double y = 200;
    private double w = 300;
    private double h = 300;
    private Rectangle buttonResume;
    private Rectangle buttonExit;
    private double wButton = 200;
    private double hButton = 50;
    private Font resumeFont;
    private Font exitFont;
    private BackGround backGround;
    public static boolean isPause;
    public static boolean showPausePanel;
    public PauseGame(){
        super();
        backGround = new BackGround(true);
        x = (backGround.getWidth() - this.w)/2;
        double xButton = x + (w-wButton)/2;;
        resumeFont = new Font("Arial", 1, 20);
        buttonResume = new Rectangle((int) xButton, (int) y+100, (int) wButton, (int) hButton);
        exitFont = new Font("Arial", 1, 20);
        buttonExit = new Rectangle((int) xButton, (int) y+200, (int) wButton, (int) hButton);
    }
    public void paintPausePanel(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect((int) x, (int) y, (int) w, (int) h);
        paintButtonResume(g);
        paintButtonExit(g);
    }
    public void paintButtonResume(Graphics g){
        g.setColor(Color.red);
        g.fillRect(buttonResume.x, buttonResume.y, buttonResume.width, buttonResume.height);
        g.setFont(resumeFont);
        g.setColor(Color.black);
        g.drawString("RESUME", buttonResume.x+60, buttonResume.y+30);
    }
    public void paintButtonExit(Graphics g){
        g.setColor(Color.red);
        g.fillRect(buttonExit.x, buttonExit.y, buttonExit.width, buttonExit.height);
        g.setFont(exitFont);
        g.setColor(Color.black);
        g.drawString("EXIT", buttonExit.x+75, buttonExit.y+35);
    }
    public void clickButton(int x, int y){
        if(showPausePanel){
            if(clickButton(x, y, buttonResume)){
                isPause = false;
                showPausePanel = false;
            }
            if(clickButton(x, y, buttonExit)){
                GamePanel.pauseGame = true;
                GamePanel.gameStart = true;
                GamePanel.gameRun = false;
                GamePanel.gameEnd = false;
                showPausePanel = false;
                isPause = false;
            }
        }
    }
    public void keyPause(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            if(isPause){
                isPause = false;
            }else{
                isPause = true;
            }
            if(showPausePanel){
                showPausePanel = false;
            }else{
                showPausePanel = true;
            }
        }
    }

}
