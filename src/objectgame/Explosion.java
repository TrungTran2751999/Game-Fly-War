package objectgame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Explosion {
    private double x;
    private double y;
    private double w;
    private double h;
    private BufferedImage image;
    private static BufferedImage[] listSubimage;
    private static ArrayList<Explosion> listExplosion;
    private int count;
    private static int iFrame;
    private Sound sound;
    public Explosion(double x, double y, double w, double h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public Explosion() throws IOException {
        importSubimage();
        listExplosion = new ArrayList<>();
        sound = new Sound();
    }
    public void importImage() throws IOException {
        String path = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\source\\explosion.png";
        image = ImageIO.read(new File(path));
    }
    public void paintExplosion(Graphics g){
        if(listExplosion.size() > 0){
            if(count == 0) sound.playSoundExplosion();
            double x = listExplosion.get(0).getX();
            double y = listExplosion.get(0).getY();
            double w = listExplosion.get(0).getW();
            g.drawImage(listSubimage[iFrame], (int) x, (int) y, (int) w, (int) w, null);
            if(count % 15 == 0){
                System.out.println(iFrame);
                iFrame++;
            }
            count++;
        }
        if(iFrame >= 9){
            listExplosion.remove(0);
            iFrame=0;
            count=0;
        }
    }
    public void addListExplosion(Explosion explosion){
        listExplosion.add(explosion);
    }
    public void importSubimage() throws IOException {
        importImage();
        listSubimage = new BufferedImage[9];
        listSubimage[0] = image.getSubimage(47, 37, 206, 206);
        listSubimage[1] = image.getSubimage(285, 38, 206, 206);
        listSubimage[2] = image.getSubimage(522, 38, 206, 206);
        listSubimage[3] = image.getSubimage(759, 37, 206, 206);
        listSubimage[4] = image.getSubimage(997, 37, 206, 206);
        listSubimage[5] = image.getSubimage(46, 272, 206, 206);
        listSubimage[6] = image.getSubimage(284, 274, 206, 206);
        listSubimage[7] = image.getSubimage(522, 273, 206,  206);
        listSubimage[8] = image.getSubimage(997, 272, 206, 206);
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
