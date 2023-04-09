package inputmanage;

import objectgame.PanelClear;
import objectgame.PanelOver;
import objectgame.PauseGame;
import objectgame.StartPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class MouseAdapter implements MouseListener {
    private StartPanel startPanel;
    private PauseGame pauseGame;
    private PanelOver panelOver;
    private PanelClear panelClear;
    public MouseAdapter(StartPanel startPanel, PauseGame pauseGame, PanelOver panelOver, PanelClear panelClear){
        this.startPanel = startPanel;
        this.pauseGame = pauseGame;
        this.panelOver = panelOver;
        this.panelClear = panelClear;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        startPanel.clickButtons(e.getX(), e.getY());
        pauseGame.clickButton(e.getX(), e.getY());
        panelOver.clickButton(e.getX(), e.getY());
        panelClear.clickButton(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
