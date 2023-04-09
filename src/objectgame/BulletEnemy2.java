package objectgame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BulletEnemy2{
    private double x;
    private double y;
    private double w = 10;
    private double h = 20;
    private double speedY = 4;
    private BufferedImage imageBullet;
    private BackGround backGround;
    public static ArrayList<BulletEnemy2> bullets1;
    public static ArrayList<BulletEnemy2> bullets2;

    public static ArrayList<Rectangle> collsionBound1;
    public static ArrayList<Rectangle> collsionBound2;
    public static ArrayList[] bulletsBounds;
    public static ArrayList[] collisionBounds;
    public static double damage =2;
    public BulletEnemy2(double x, double y, double w, double h, double speedY){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.speedY = speedY;
    }
    public BulletEnemy2() throws IOException {
        bullets1 = new ArrayList<>();
        bullets2 = new ArrayList<>();
        collsionBound1 = new ArrayList<>();
        collsionBound2 = new ArrayList<>();
        collisionBounds = new ArrayList[]{collsionBound1, collsionBound2};
        bulletsBounds = new ArrayList[]{bullets1, bullets2};
        importImage();
        backGround = new BackGround();
    }
    public void bullet1Move(int i){
        if(PauseGame.isPause == false){
            bullets1.get(i).y+=this.speedY;
            collsionBound1.get(i).setLocation((int) collsionBound1.get(i).x, (int) bullets1.get(i).y);
            bulletsBounds[0] = bullets1;
        }
    }
    public void bullet2Move(int i) {
        if(PauseGame.isPause == false){
            bullets2.get(i).y+=this.speedY;
            collsionBound2.get(i).setLocation((int) collsionBound2.get(i).x, (int) bullets2.get(i).y);
            bulletsBounds[1] = bullets2;
        }
    }
    public void paintBullet(Graphics g){
        for(int i=0; i<bullets1.size(); i++){
            g.drawImage(imageBullet, (int) bullets1.get(i).x, (int) bullets1.get(i).y, (int) bullets1.get(i).w, (int) bullets1.get(i).h, null);
            bullet1Move(i);
            bullet1NoTarget(i);
        }
        for(int i=0; i<bullets2.size(); i++){
            g.drawImage(imageBullet, (int) bullets2.get(i).x, (int) bullets2.get(i).y, (int) bullets2.get(i).w, (int) bullets2.get(i).h, null);
            bullet2Move(i);
            bullet2NoTarget(i);
        }
    }
    public void bullet1NoTarget(int i){
        double yScreen = backGround.getPosY1();
        double hScreen = backGround.getHeight();
        if(bullets1.get(i).y >= yScreen+hScreen){
            bullets1.remove(i);
            collsionBound1.remove(i);
            bulletsBounds[0] = bullets1;
            collisionBounds[0] = collsionBound1;
        }
    }
    public void bullet2NoTarget(int i){
        double yScreen = backGround.getPosY1();
        double hScreen = backGround.getHeight();
        if(bullets2.get(i).y >= yScreen+hScreen) {
            bullets2.remove(i);
            collsionBound2.remove(i);
            bulletsBounds[1] = bullets2;
            collisionBounds[1] = collsionBound2;
        }
    }
    public void importImage() throws IOException {
        String path = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\source\\bullet.png";
        imageBullet = ImageIO.read(new File(path));
    }
    public void fireBullet(double x, double y){
        bullets1.add(new BulletEnemy2(x+29, y+113, this.w, this.h, this.speedY));
        collsionBound1.add(new Rectangle((int) x+29, (int) y+113, (int) this.w, (int) this.h));
        bullets2.add(new BulletEnemy2(x+132, y+112, this.w, this.h, this.speedY));
        collsionBound2.add(new Rectangle((int) x+132, (int) y+112, (int) this.w, (int) this.h));
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public BufferedImage getImageEnemy() {
        return imageBullet;
    }

    public void setImageEnemy(BufferedImage imageEnemy) {
        this.imageBullet = imageEnemy;
    }
}

