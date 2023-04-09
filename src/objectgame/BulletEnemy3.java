package objectgame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BulletEnemy3{
    private double x;
    private double y;
    private double w = 10;
    private double h = 20;
    private double speedY = 4;
    private BufferedImage imageBullet;
    private BackGround backGround;
    public static ArrayList<BulletEnemy3> bullets1;
    public static ArrayList<BulletEnemy3> bullets2;
    public static ArrayList<BulletEnemy3> bullets3;
    public static ArrayList<BulletEnemy3> bullets4;
    public static ArrayList<Rectangle> collsionBound1;
    public static ArrayList<Rectangle> collsionBound2;
    public static ArrayList<Rectangle> collsionBound3;
    public static ArrayList<Rectangle> collsionBound4;
    public static ArrayList[] bulletsBounds;
    public static ArrayList[] collisionBounds;
    public static double damage =2;
    public BulletEnemy3(double x, double y, double w, double h, double speedY){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.speedY = speedY;
    }
    public BulletEnemy3() throws IOException {
        bullets1 = new ArrayList<>();
        bullets2 = new ArrayList<>();
        bullets3 = new ArrayList<>();
        bullets4 = new ArrayList<>();
        collsionBound1 = new ArrayList<>();
        collsionBound2 = new ArrayList<>();
        collsionBound3 = new ArrayList<>();
        collsionBound4 = new ArrayList<>();
        bulletsBounds = new ArrayList[]{bullets1, bullets2, bullets3, bullets4};
        collisionBounds = new ArrayList[]{collsionBound1, collsionBound2, collsionBound3, collsionBound4};
        importImage();
        backGround = new BackGround();
    }
    public void bullet1Move(int i){
        if(PauseGame.isPause == false){
            bullets1.get(i).y+=this.speedY;
            collsionBound1.get(i).setLocation((int) (int) bullets1.get(i).x, (int) bullets1.get(i).y);
            bulletsBounds[0] = bullets1;
            collisionBounds[0] = collsionBound1;
        }
    }
    public void bullet2Move(int i) {
        if(PauseGame.isPause == false){
            bullets2.get(i).y+=this.speedY;
            collsionBound2.get(i).setLocation((int) bullets2.get(i).x, (int) bullets2.get(i).y);
            bulletsBounds[1] = bullets2;
            collisionBounds[1] = collsionBound2;
        }
    }
    public void bullet3Move(int i) {
        if(PauseGame.isPause == false){
            bullets3.get(i).y+=this.speedY;
            collsionBound3.get(i).setLocation((int) bullets3.get(i).x, (int) bullets3.get(i).y);
            bulletsBounds[2] = bullets3;
            collisionBounds[2] = collsionBound3;
        }
    }
    public void bullet4Move(int i) {
        if(PauseGame.isPause == false){
            bullets4.get(i).y+=this.speedY;
            collsionBound4.get(i).setLocation((int) bullets4.get(i).x, (int) bullets4.get(i).y);
            bulletsBounds[3] = bullets4;
            collisionBounds[3] = collsionBound4;
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
        for(int i=0; i<bullets3.size(); i++){
            g.drawImage(imageBullet, (int) bullets3.get(i).x, (int) bullets3.get(i).y, (int) bullets3.get(i).w, (int) bullets3.get(i).h, null);
            bullet3Move(i);
            bullet3NoTarget(i);
        }
        for(int i=0; i<bullets4.size(); i++){
            g.drawImage(imageBullet, (int) bullets4.get(i).x, (int) bullets4.get(i).y, (int) bullets4.get(i).w, (int) bullets4.get(i).h, null);
            bullet4Move(i);
            bullet4NoTarget(i);
        }
    }
    public void bullet1NoTarget(int i){
        double yScreen = backGround.getPosY1();
        double hScreen = backGround.getHeight();
        if(bullets1.get(i).y >= yScreen+hScreen){
            bullets1.remove(i);
            collsionBound1.remove(i);
            collisionBounds[0] = collsionBound1;
            bulletsBounds[0] = bullets1;
        }
    }
    public void bullet2NoTarget(int i){
        double yScreen = backGround.getPosY1();
        double hScreen = backGround.getHeight();
        if(bullets2.get(i).y >= yScreen+hScreen) {
            bullets2.remove(i);
            collsionBound2.remove(i);
            collisionBounds[1] = collsionBound2;
            bulletsBounds[1] = bullets2;
        }
    }
    public void bullet3NoTarget(int i){
        double yScreen = backGround.getPosY1();
        double hScreen = backGround.getHeight();
        if(bullets3.get(i).y >= yScreen+hScreen) {
            bullets3.remove(i);
            collsionBound3.remove(i);
            collisionBounds[2] = collsionBound3;
            bulletsBounds[2] = bullets3;
        }
    }
    public void bullet4NoTarget(int i){
        double yScreen = backGround.getPosY1();
        double hScreen = backGround.getHeight();
        if(bullets4.get(i).y >= yScreen+hScreen) {
            bullets4.remove(i);
            collsionBound4.remove(i);
            collisionBounds[3] = collsionBound4;
            bulletsBounds[3] = bullets4;
        }
    }
    public void importImage() throws IOException {
        String path = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\source\\bullet.png";
        imageBullet = ImageIO.read(new File(path));
    }
    public void fireBullet(double x, double y){
        bullets1.add(new BulletEnemy3(x+31, y+91, this.w, this.h, this.speedY));
        collsionBound1.add(new Rectangle((int) x+31, (int) y+91, (int) this.w, (int) this.h));

        bullets2.add(new BulletEnemy3(x+125, y+89, this.w, this.h, this.speedY));
        collsionBound2.add(new Rectangle((int) x+125, (int) y+89, (int) this.w, (int) this.h));

        bullets3.add(new BulletEnemy3(x+139, y+ 85, this.w, this.h, this.speedY));
        collsionBound3.add(new Rectangle((int) x+139, (int) y+85, (int) this.w, (int) this.y ));

        bullets4.add(new BulletEnemy3(x+13, y+85, this.w, this.h, this.speedY));
        collsionBound4.add(new Rectangle((int) x+13, (int) y+85, (int) this.w, (int) this.h));

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
