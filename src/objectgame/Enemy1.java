package objectgame;

import mainGame.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Enemy1 extends Enemys{
    private BufferedImage enemy1Img;
    private Rectangle[] enemyCollions;
    private Bullets bullets;
    private BulletEnemy1 bulletEnemy1;
    private double widthHeathBar = this.getHeathBar();
    private int a;

    public Enemy1(double x, double y, double w, double h, double speedX, double speedY, boolean isDeath, int heath, double heathBar) throws IOException {
        super(x, y, w, h, speedX, speedY, isDeath, heath, heathBar);
        bullets = new Bullets();
        bulletEnemy1 = new BulletEnemy1();
    }
    @Override
    public BufferedImage importImage() throws IOException {
        String path = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\source\\enemy1.png";
        enemy1Img = ImageIO.read(new File(path));
        return enemy1Img;
    }
    @Override
    public Rectangle[] updateColission() {
        Rectangle collsion1 = new Rectangle((int) (101+getX()), (int) (58+getY()), (int) (85), (int) (34));
        Rectangle collsion2 = new Rectangle((int) (57+getX()), (int)(7+getY()), (int)(72), (int)(22));
        Rectangle collsion3 = new Rectangle((int) (83+getX()), (int)(3+getY()), (int)(20), (int)(122));
        Rectangle collsion4 = new Rectangle((int) (3+getX()), (int)(63+getY()), (int)(80), (int)(37));
        enemyCollions = new Rectangle[]{collsion1, collsion2, collsion3, collsion4};
        return enemyCollions;
    }
    @Override
    public void enemyFire(double x, double y){
        bulletEnemy1.fireBullet(x,y);
    }
    @Override
    public void paintCollision(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(50, 10, (int) this.getHeathBar(), 20);
        g.setColor(Color.BLACK);
        g.drawRect(50, 10, (int) widthHeathBar, 20);
        bulletEnemy1.paintBullet(g);
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
                    super.playSound();

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
                    super.playSound();
                    this.setHeathBar(this.getHeath()*4);
                    return true;
                }
            }
        return false;
    }

}
