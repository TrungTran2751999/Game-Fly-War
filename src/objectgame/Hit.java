package objectgame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Hit {
    private double x;
    private double y;
    private double w = 177/3;
    private double h = 92/3;
    private BufferedImage image;
    public static ArrayList<Hit> listHit;
    private int count;
    public Hit(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Hit() throws IOException {
        importImage();
        listHit =new ArrayList<>();
    }
    public void paintHit(Graphics g){
        count++;
        for(int i=0; i<listHit.size(); i++){
            int x = (int) listHit.get(i).getX();
            int y = (int) listHit.get(i).getY();
            int w = (int) listHit.get(i).getW();
            int h = (int) listHit.get(i).getH();
            g.drawImage(image, x, y, w, h,null);
            if(count % 15 == 0){
                listHit.remove(i);
                count=0;
            }
        }
    }
    public void importImage() throws IOException {
        String path = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\source\\hit.png";
        image = ImageIO.read(new File(path));
    }
    public void hitBullet(Hit hit){
        listHit.add(hit);
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
}
