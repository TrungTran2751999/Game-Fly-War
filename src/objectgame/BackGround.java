package objectgame;

import CacheLoader.CacheLoader;
import mainGame.GameFrame;
import mainGame.GamePanel;
import mainGame.Screen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class BackGround extends JPanel{
    public Screen screen = new Screen();
    private int posX1 = 0;
    private int posY1 = 0;
    private int posX2 = 0;
    private int posY2 = screen.getHEIGHT_SCREEN();
    private int width = 500;
    private double speed = 5;
    private int height = screen.getHEIGHT_SCREEN();
    private BufferedImage[] backGround;
    public CacheLoader cacheLoader;
    public BackGround() throws IOException {
        cacheLoader = new CacheLoader();
        importBackGround();
    }
    public BackGround(boolean fake){

    }
    public void importBackGround() throws IOException {
        backGround = new BufferedImage[2];
        String path = cacheLoader.getLinkBg();
        HashMap<String, HashMap<String, Integer>> hashBg = cacheLoader.getBackGroundList();
        System.out.println(hashBg);
        int xBg1 = hashBg.get("background1").get("x");
        int yBg1 = hashBg.get("background1").get("y");
        int wBg1 = hashBg.get("background1").get("w");
        int hBg1 = hashBg.get("background1").get("h");

        int xBg2 = hashBg.get("background2").get("x");
        int yBg2 = hashBg.get("background2").get("y");
        int wBg2 = hashBg.get("background2").get("w");
        int hBg2 = hashBg.get("background2").get("h");

        BufferedImage image = ImageIO.read(new File(path));
        BufferedImage bg1 = image.getSubimage(xBg1, yBg1, wBg1, hBg1);
        BufferedImage bg2 = image.getSubimage(xBg2, yBg2, wBg2, hBg2);
//        System.out.printf("x1: %s\n y1: %s\n w1: %s\n h1: %s\n", xBg1, yBg1, wBg1, hBg1);
//        System.out.printf("x2: %s\n y2: %s\n w2: %s\n h2: %s\n", xBg2, yBg2, wBg2, hBg2);
        backGround[0] = bg2; backGround[1]=bg1;
    }

    public void paintBackGround(Graphics g){
          g.drawImage(backGround[0], posX1, posY1, this.width, this.height,null);
          g.drawImage(backGround[1], posX2, posY2, this.width, this.height,null);
    }
    public void backgroundMove(){
        if(PauseGame.isPause == false){
            reverseBackGround();
            posY1+=speed;
            posY2+=speed;
        }
    }
    public void reverseBackGround(){
        if(posY1 >= screen.getHEIGHT_SCREEN()){
            posY1 = -screen.getHEIGHT_SCREEN();
        }
        if(posY2 >= screen.getHEIGHT_SCREEN()){
            posY2 = -screen.getHEIGHT_SCREEN();
        }
    }

    public int getPosX1() {
        return posX1;
    }

    public void setPosX1(int posX1) {
        this.posX1 = posX1;
    }

    public int getPosY1() {
        return posY1;
    }

    public void setPosY1(int posY1) {
        this.posY1 = posY1;
    }

    public int getPosX2() {
        return posX2;
    }

    public void setPosX2(int posX2) {
        this.posX2 = posX2;
    }

    public int getPosY2() {
        return posY2;
    }

    public void setPosY2(int posY2) {
        this.posY2 = posY2;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
