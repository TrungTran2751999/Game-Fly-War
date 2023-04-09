package objectgame;

import objectgame.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Bullets {
    private double x;
    private double y;
    private double w = 10;
    private double h = 20;
    private double speed = 3;
    private Player player;
    private BufferedImage image;
    public static Stack<Rectangle> collisonBoundBullet1;
    public static Stack<Rectangle> collisonBoundBullet2;
    public static Stack<Bullets> bullets1;
    public static Stack<Bullets> bullets2;
    private Hit hit;
    public Bullets() throws IOException {
        importImage();
        hit = new Hit();
        bullets1 = new Stack<>();
        bullets2 = new Stack<>();
        collisonBoundBullet1 = new Stack<>();
        collisonBoundBullet2 = new Stack<>();
    }
    public Bullets(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void paintBullets(Graphics g){
        int w = (int) this.w;
        int h = (int) this.h;
        for(int i=0; i<bullets1.size(); i++){
            int x1 = (int) (bullets1.get(i).getX()+143/6-this.w/2);
            int y1 = (int) (bullets1.get(i).getY()+77/6);
            g.drawImage(image, x1, y1 ,w, h, null);
            collisonBoundBullet1.get(i).setLocation(x1, y1);
            bulletMove1(i);
        }
        for(int i=0; i<bullets2.size(); i++){
            int x2 = (int) (bullets2.get(i).getX()+446/6-this.w/2);
            int y2 = (int) (bullets2.get(i).getY()+77/6);
            g.drawImage(image, x2, y2, w,h,  null);
            collisonBoundBullet2.get(i).setLocation(x2, y2);
            bulletMove2(i);
        }
        hit.paintHit(g);
    }
    public boolean haveCollision1(Rectangle collision){
       for(int i=0; i<collisonBoundBullet1.size(); i++){
           if(collisonBoundBullet1.get(i).intersects(collision)){
               double x = collisonBoundBullet1.get(i).getX();
               double y = collisonBoundBullet1.get(i).getY();
               hit.hitBullet(new Hit(x, y));
               collisonBoundBullet1.remove(i);
               bullets1.remove(i);
               return true;
           }
       }
        return false;
    }
    public boolean haveCollision2(Rectangle collision){
        for(int i=0; i<collisonBoundBullet2.size(); i++){
            if(collisonBoundBullet2.get(i).intersects(collision)){
                double x = collisonBoundBullet2.get(i).getX();
                double y = collisonBoundBullet2.get(i).getY();
                hit.hitBullet(new Hit(x, y));
                collisonBoundBullet2.remove(i);
                bullets2.remove(i);
                return true;
            }
        }
        return false;
    }
    public void getBullets(double x, double y){
        bullets1.push(new Bullets(x, y));
        bullets2.push(new Bullets(x, y));
        collisonBoundBullet1.push(new Rectangle((int) x, (int) y, (int) this.w, (int) this.h));
        collisonBoundBullet2.push(new Rectangle((int) x, (int) y, (int) this.w, (int) this.h));
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }
    public void resetGame(){
        collisonBoundBullet1.clear();
        collisonBoundBullet2.clear();
        bullets1.clear();
        bullets2.clear();
    }
    public void bulletMove1(int index){
        if(PauseGame.isPause == false){
            Bullets bullet1 = bullets1.get(index);
            bullet1.setY(bullet1.y-speed);
            if(bullet1.getY() < 0){
                bullets1.remove(index);
                collisonBoundBullet1.remove(index);
            }
        }
    }
    public void bulletMove2(int index){
        if(PauseGame.isPause == false){
            Bullets bullet2 = bullets2.get(index);
            bullet2.setY(bullet2.y-speed);
            if(bullet2.getY() < 0){
                bullets2.remove(index);
                collisonBoundBullet2.remove(index);
            }
        }
    }

    public void importImage() throws IOException {
        String path = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\source\\bullet.png";
        image = ImageIO.read(new File(path));
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setW(double w) {
        this.w = w;
    }

    public void setH(double h) {
        this.h = h;
    }

}
