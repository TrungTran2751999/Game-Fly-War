package objectgame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Medal {
    private double x;
    private double y = -this.w;
    private double w = 30;
    private double h =30;
    public static Rectangle collisionMedal;
    private double speed = 2;
    private int a;
    private int i;
    private BackGround backGround;

    private BufferedImage[] coin;
    public static BufferedImage image;
    private Sound sound;

    public Medal(double x){
        this.x = x;
        backGround = new BackGround(true);
        collisionMedal = new Rectangle((int) this.x, (int) this.y, (int) this.w, (int) this.h);
        sound = new Sound();
        resetCoin();
    }
    public Medal() throws IOException {
        importImage();
        backGround = new BackGround();
        collisionMedal = new Rectangle((int) this.x, (int) this.y, (int) this.w, (int) this.h);
        sound = new Sound();
        resetCoin();
    }
    public void paintMedal(Graphics g){
        if(havevCollsionPlayer() == false){
            if(i > 8){
                i=0;
            }
            a++;
            g.drawImage(coin[i], (int) x, (int) y, (int) w, (int) h, null);
            if(a % 20 == 0){
                i++;
            }
            if(a > 20) a=0;
            medalMove();
        }else{
            a=0;
        }
    }
    public boolean haveCollisionBound(){
        if(this.y > 600){
            return true;
        }else{
            return false;
        }
    }
    public boolean havevCollsionPlayer(){
        Rectangle[] listCollsionPlayer = Player.collisionPlayer;
        for(Rectangle colPlayer: listCollsionPlayer){
            if(collisionMedal.intersects(colPlayer)){
                sound.playSoundCoin();
                if(!Player.isDeath) Score.scoreCount++;
                return true;
            }
            if(haveCollisionBound()){
                return true;
            }
        }
        return  false;
    }
    public void medalMove(){
        if(PauseGame.isPause==false){
            this.y+= speed;
            collisionMedal.y+=speed;
        }
    }
    public void importImage() throws IOException {
        String path = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\source\\coin.png";
        image = ImageIO.read(new File(path));
    }
    public void resetCoin(){
        coin = new BufferedImage[9];
        coin[0] = image.getSubimage(23, 25, 145, 147);
        coin[1] = image.getSubimage(183, 23, 156, 150);
        coin[2] = image.getSubimage(352, 22, 145, 150);
        coin[3] = image.getSubimage(482, 22, 144, 152);
        coin[4] = image.getSubimage(591, 20, 121, 156);
        coin[5] = image.getSubimage(684, 18, 137, 158);
        coin[6] = image.getSubimage(796, 15, 173, 159);
        coin[7] = image.getSubimage(945, 14, 189, 160);
        coin[8] = image.getSubimage(1121, 15, 168, 159);
    }
}
