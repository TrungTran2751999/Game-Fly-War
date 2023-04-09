package inputmanage;

import objectgame.PanelOver;
import objectgame.PauseGame;
import objectgame.Player;
import objectgame.StartPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class AdapterGame extends KeyAdapter {
    private Player player;
    private PauseGame pauseGame;
    public AdapterGame(Player player, PauseGame pauseGame) {
        this.player = player;
        this.pauseGame = pauseGame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
        pauseGame.keyPause(e);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }
}
