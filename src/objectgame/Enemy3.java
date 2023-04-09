package objectgame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Enemy3 extends Enemys{
    private BufferedImage enemy3Img;
    private Rectangle[] enemyCollions;
    private Bullets bullets;
    private BulletEnemy3 bulletEnemy3;

    private int a;
    private double widthHeathBar = this.getHeathBar();
    public Enemy3(double x, double y, double w, double h, double speedX, double speedY, boolean isDeath, int heath, double heathBar) throws IOException {
        super(x, y, w, h, speedX, speedY, isDeath, heath, heathBar);
        bullets = new Bullets();
        bulletEnemy3 = new BulletEnemy3();
    }
    @Override
    public BufferedImage importImage() throws IOException {
        String path = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\source\\enemy3.png";
        enemy3Img = ImageIO.read(new File(path));
        return enemy3Img;
    }
    @Override
    public Rectangle[] updateColission() {
        Rectangle collsion1 = new Rectangle((int) (85+getX()), (int) (49+getY()), 73, (int) (30));
        Rectangle collsion2 = new Rectangle((int) (51+getX()), (int)(0+getY()), 58, 48);
        Rectangle collsion3 = new Rectangle((int) (69+getX()), (int)(30+getY()), 20, 81);
        Rectangle collsion4 = new Rectangle((int) (0+getX()), (int)(54+getY()), 69, 24);
        enemyCollions = new Rectangle[]{collsion1, collsion2, collsion3, collsion4};
        return enemyCollions;
    }
    @Override
    public void enemyFire(double x, double y){
        bulletEnemy3.fireBullet(x,y);
    }
    @Override
    public void paintCollision(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(50, 10, (int) this.getHeathBar(), 20);
        g.setColor(Color.BLACK);
        g.drawRect(50, 10, (int) widthHeathBar, 20);
        bulletEnemy3.paintBullet(g);
        if(a % 100==0){
            enemyFire(getX(), getY());
        }
        if(a > 100){
            a=0;
        }
        a++;
    }
    @Override
    public boolean haveCollsionBullets1() {
        Rectangle[] collssions = updateColission();
        for(int i=0; i<collssions.length; i++){
            if(bullets.haveCollision1(collssions[i])){
                playSound();
                this.setHeathBar(this.getHeath()*4);
                return true;
            }
        }
        return false;
    }
    public boolean haveCollsionBullets2() {
        Rectangle[] collssions = updateColission();
        for(int i=0; i<collssions.length; i++){
            if(bullets.haveCollision2(collssions[i])){
                playSound();
                this.setHeathBar(this.getHeath()*4);
                return true;
            }
        }
        return false;
    }

}
