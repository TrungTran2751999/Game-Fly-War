package objectgame;

import CacheLoader.DataHistory;
import mainGame.GamePanel;
import mainGame.History;

import java.awt.*;

public class StartPanel extends Panel {
    private Rectangle buttonStart;
    private Rectangle buttonInfor;
    private Rectangle buttonEnd;
    private History history;
    private int widthButton = 200;
    private int heightButton =50;
    private Font fontStatrt;
    private Font fontEnd;
    private Font fontInfor;
    public StartPanel(boolean status){
        super(status);
        double x = (getW()-widthButton)/2;
        history= new History();
        buttonStart = new Rectangle((int) x, (int) (getPanelY()+200), widthButton, heightButton);
        fontStatrt = new Font("Arial", 1, 20);
        buttonInfor = new Rectangle((int) x, (int) (getPanelY()+300), widthButton, heightButton);
        fontInfor = new Font("Arial", 1, 20);
        fontEnd = new Font("Arial", 1, 20);
        buttonEnd = new Rectangle((int) x, (int) (getPanelY()+400), widthButton, heightButton);
    }
    @Override
    public void paintPanel(Graphics g) {
        if(this.isStatus()){
            super.paintPanel(g);
            paintTitle(g);
            paintButtonStart(g);
            paintButtonInfor(g);
            paintButtonEnd(g);
        }
    }
    public void clickButtons(int x, int y) {
        if(GamePanel.gameStart){
            if(clickButton(x, y, buttonStart)){
                GamePanel.pauseGame = false;
                GamePanel.gameStart = false;
                GamePanel.gameRun = true;
                GamePanel.gameEnd = false;
                DataHistory.isInterrupt = false;
            }
            if(clickButton(x, y, buttonInfor)){
                history.showTable();
            }
            if(clickButton(x, y, buttonEnd)){
                System.exit(0);
            }
        }
    }
    public void paintTitle(Graphics g){
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", 1, 40));
        g.drawString("FLY WAR", 150, 150);
    }
    public void paintButtonStart(Graphics g){
        g.setColor(Color.red);
        g.fillRect(buttonStart.x, buttonStart.y, buttonStart.width, buttonStart.height);
        g.setFont(fontStatrt);
        g.setColor(Color.BLACK);
        g.drawString("START", buttonStart.x + 70, buttonStart.y+32);
    }
    public void paintButtonEnd(Graphics g){
        g.setColor(Color.red);
        g.fillRect(buttonEnd.x, buttonEnd.y, buttonEnd.width, buttonEnd.height);
        g.setFont(fontEnd);
        g.setColor(Color.BLACK);
        g.drawString("END", buttonEnd.x + 75, buttonEnd.y+32);
    }
    public void paintButtonInfor(Graphics g){
        g.setColor(Color.red);
        g.fillRect(buttonInfor.x, buttonInfor.y, buttonInfor.width, buttonInfor.height);
        g.setFont(fontEnd);
        g.setColor(Color.BLACK);
        g.drawString("HISTORY", buttonInfor.x + 60, buttonInfor.y+32);
    }

}
