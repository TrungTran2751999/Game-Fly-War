package objectgame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Enemy2 extends Enemys{
    private BufferedImage enemy2Img;
    private Rectangle[] enemyCollions;
    private Bullets bullets;
    private BulletEnemy2 bulletEnemy2;
    private double widthHeathBar = this.getHeathBar();
    private int a;
    public Enemy2(double x, double y, double w, double h, double speedX, double speedY, boolean isDeath, int heath, double heathBar) throws IOException {
        super(x, y, w, h, speedX, speedY, isDeath, heath, heathBar);
        bullets = new Bullets();
        bulletEnemy2 = new BulletEnemy2();
    }
    @Override
    public BufferedImage importImage() throws IOException {
        String path = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\source\\enemy2.png";
        enemy2Img = ImageIO.read(new File(path));
        return enemy2Img;
    }

    @Override
    public void enemyFire(double x, double y) {
        bulletEnemy2.fireBullet(x, y);
    }

    @Override
    public Rectangle[] updateColission() {
        Rectangle collsion1 = new Rectangle((int) (92+getX()), (int) (63+getY()), (int) (68), (int) (39));
        Rectangle collsion2 = new Rectangle((int) (45+getX()), (int)(8+getY()), (int)(70), (int)(32));
        Rectangle collsion3 = new Rectangle((int) (72+getX()), (int)(4+getY()), (int)(20), (int)(121));
        Rectangle collsion4 = new Rectangle((int) (4+getX()), (int)(64+getY()), (int)(66), (int)(35));
        enemyCollions = new Rectangle[]{collsion1, collsion2, collsion3, collsion4};
        return enemyCollions;
    }
    public void paintCollision(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(50, 10, (int) this.getHeathBar(), 20);
        g.setColor(Color.BLACK);
        g.drawRect(50, 10, (int) widthHeathBar, 20);

        bulletEnemy2.paintBullet(g);
        if(a % 100 == 0){
            enemyFire(getX(), getY());
        }
        if(a > 100){
            a = 0;
        }
        a++;
    }
    public boolean haveCollsionBullets1() {
        if(isDeath() == false){
            Rectangle[] collssions = updateColission();
            for(int i=0; i<collssions.length; i++){
                if(bullets.haveCollision1(collssions[i])){
                    playSound();
                    this.setHeathBar(this.getHeath()*4);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean haveCollsionBullets2() {
        if(isDeath() == false){
            Rectangle[] collssions = updateColission();
            for(int i=0; i<collssions.length; i++){
                if(bullets.haveCollision2(collssions[i])){
                    playSound();
                    this.setHeathBar(this.getHeath()*4);
                    return true;
                }
            }
        }
        return false;
    }

}

