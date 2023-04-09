package mainGame;



import objectgame.PauseGame;

import javax.swing.*;

public class Screen extends JFrame {
    private final int WIDTH_SCREEN =500;
    private final int HEIGHT_SCREEN = 1000;
    private final double SCREEN_X = 0;
    private final double SCREEN_Y = 0;
    public Screen(GamePanel gamePanel){
        setSize(getWIDTH_SCREEN(), getHEIGHT_SCREEN());
        setVisible(true);
        add(gamePanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
    }
    public Screen(){

    }
    public int getWIDTH_SCREEN() {
        return WIDTH_SCREEN;
    }

    public int getHEIGHT_SCREEN() {
        return HEIGHT_SCREEN;
    }

    public double getSCREEN_X() {
        return SCREEN_X;
    }

    public double getSCREEN_Y() {
        return SCREEN_Y;
    }
}
