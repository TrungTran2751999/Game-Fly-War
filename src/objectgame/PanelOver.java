package objectgame;

import CacheLoader.DataHistory;
import mainGame.GamePanel;

import javax.xml.crypto.Data;
import java.awt.*;

public class PanelOver extends Panel {
    private double x;
    private double y ;
    private double w = 400;
    private double h = 350;
    private BackGround backGround;
    private Rectangle buttonRestart;
    private Rectangle buttonExit;
    private double wButton = 200;
    private double hButton = 50;
    private Font font;
    public static boolean gameOver;
    public static boolean showPanelOver;
    public PanelOver(){
        font = new Font("Arial", 1, 20);
        backGround = new BackGround(true);
        x = (backGround.getWidth() - w)/2;
        y = 150;
        double xButton = x+(w - wButton)/2;
        buttonRestart = new Rectangle((int) xButton, (int) (y+150), (int) wButton, (int) hButton);
        buttonExit = new Rectangle((int) xButton, (int) (y + 250), (int) wButton, (int) hButton);
    }
    public void paintPanelOver(Graphics g){
            g.setColor(Color.BLACK);
            g.fillRect((int) x, (int) y, (int) w, (int) h);
            g.setColor(Color.ORANGE);
            g.setFont(new Font("Arial", 1, 30));
            g.drawString("GAME OVER", (int) (x+100), (int) (y+80));
            paintButtonRestart(g);
            paintButtonExit(g);
            PauseGame.isPause = true;
    }
    public void paintButtonRestart(Graphics g){
        g.setColor(Color.red);
        g.fillRect(buttonRestart.x, buttonRestart.y, buttonRestart.width, buttonRestart.height);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("RESTART", buttonRestart.x + 50, buttonRestart.y + 33);
    }
    public void paintButtonExit(Graphics g){
        g.setColor(Color.red);
        g.fillRect(buttonExit.x, buttonExit.y, buttonExit.width, buttonExit.height);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("EXIT", buttonExit.x + 75, buttonExit.y + 33);
    }
    public void clickButton(int x, int y){
        if(showPanelOver){
            if(clickButton(x, y, buttonRestart)){
                gameOver = true;
                GamePanel.gameEnd = false;
                PauseGame.isPause = false;
                showPanelOver = false;
                DataHistory.isInterrupt = false;
            }
            if(clickButton(x, y, buttonExit)){
                GamePanel.pauseGame = true;
                GamePanel.gameStart = true;
                GamePanel.gameRun = false;
                GamePanel.gameEnd = false;
                PauseGame.showPausePanel = false;
                PauseGame.isPause = false;
                showPanelOver = false;
                DataHistory.isInterrupt = false;
            }
        }
    }

}
