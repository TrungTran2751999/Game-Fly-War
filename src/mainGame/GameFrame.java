package mainGame;


import objectgame.PauseGame;
import objectgame.Player;

import javax.swing.*;
import java.io.IOException;

public class GameFrame  implements Runnable {
    private Screen screen;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final double FPS_SET = 80;
    public GameFrame() throws IOException {
        gamePanel = new GamePanel();
        screen = new Screen(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        while (true){
            double timePerFrame = 1000000000.0 / FPS_SET;
            long lastFrame = System.nanoTime();
            long now = System.nanoTime();

            int frames = 0;
            long lastCheck = System.currentTimeMillis();

            while (true) {
                now = System.nanoTime();
                if (now - lastFrame >= timePerFrame) {
                    gamePanel.repaint();
                    gamePanel.runGame();
                    lastFrame = now;
                    frames++;
                }

                if (System.currentTimeMillis() - lastCheck >= 1000) {
                    lastCheck = System.currentTimeMillis();
                    System.out.println("FPS: " + frames);
                    frames = 0;
                }
            }
        }
    }
}

