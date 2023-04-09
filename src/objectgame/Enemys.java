package objectgame;

import mainGame.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Enemys {
    private double x;
    private double y;
    private double w;
    private double h;
    private double speedX;
    private double speedY;
    private boolean isDeath;
    private Rectangle[] colission;
    private Enemys[] enemys;
    private BufferedImage[] enemyImgs;
    private BufferedImage fakeImg;
    private BackGround backGround;
    private ArrayList<Enemys> enemys1;
    private ArrayList<BufferedImage>enemys1Img;
    private double heath;
    private Medal medal;
    private int a;
    private int i;
    private double heathBar;
    private Sound sound;
    private Explosion explosion;
    public Enemys(double x, double y, double w, double h, double speedX, double speedY, boolean isDeath, int heath, double heathBar) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.speedX =speedX;
        this.speedY = speedY;
        this.isDeath = isDeath;
        this.heath = heath;
        this.heathBar = heathBar;
        backGround = new BackGround(true);
        sound = new Sound();
    }
    public Enemys() throws IOException {
        enemys = new Enemys[]{new Enemy2(1, -127 ,159, 127, 2, 2, false, 100, 400),
                              new Enemy1(1, -131, 186, 131, 2, 2, false, 100, 400),
                              new Enemy3(1, -112, 158, 112, 2, 2, false, 100, 400),
                              };
        enemyImgs = new BufferedImage[]{enemys[0].importImage(), enemys[1].importImage(), enemys[2].importImage()};
        enemys1 = new ArrayList<>();
        enemys1Img = new ArrayList<>();
        medal = new Medal();
        backGround = new BackGround(true);
        sound = new Sound();
        explosion = new Explosion();
    }
    public void paintEnemy(Graphics g){
        a++;
        if(a > 500){
            a=0;
        }
        if(i == 3){
            PanelClear.isClearGame = true;
            PanelClear.showPanelClear = true;
            sound.playSoundgameClear();
            i++;
        }
        if(i < 3){
            if(a % 500 == 0){
                if(enemys1.size() == 0){
                    enemys1.add(enemys[i]);
                    enemys1Img.add(enemyImgs[i]);
                }
            }
            if(enemys1.size() > 0){
                g.drawImage(enemys1Img.get(i-i), (int) enemys1.get(i-i).getX(), (int) enemys1.get(i-i).getY(), (int) enemys1.get(i-i).getW(), (int) enemys1.get(i-i).getH(), null);
                enemys1.get(i-i).enemyMove();
                if(medal.havevCollsionPlayer()){
                    double widthVisible = backGround.getX() + backGround.getWidth() - 150;
                    double xBackground = backGround.getX();
                    double x = Math.floor(Math.random()*(widthVisible-xBackground)+xBackground);
                    medal = new Medal(x);
                }else{
                    medal.paintMedal(g);
                }
                enemys1.get(i-i).paintCollision(g);
                if(enemys1.get(i-i).haveCollsionBullets1() || enemys1.get(i-i).haveCollsionBullets2()){
                    enemys1.get(i-i).setHeath(enemys1.get(i-i).getHeath()-Player.damage);
//                    System.out.println("Enemy "+ this.i + ": "+ enemys1.get(i-i).getHeath());
                }
                enemyIsDeath(i-i);
            }
        }
    }
    public BufferedImage importImage() throws IOException {
        return fakeImg;
    };
    public void enemyMove(){
        if(PauseGame.isPause == false){
            if(this.y < 30){
                this.y+=1;
            }else{
                if(this.x+this.w >= backGround.getPosX1() + backGround.getWidth() || this.x<= backGround.getPosX1()){
                    this.speedX = -this.speedX;
                }
                this.x+=this.speedX;
            }
        }
    }
    public void resetGame(){
        for(int i=0; i<enemys.length; i++){
            enemys[i].setDeath(false);
            enemys[i].setHeath(100);
            enemys[i].setHeathBar(400);
        }
        enemys[0].setX(1); enemys[0].setY(-131);
        enemys[1].setX(1); enemys[1].setY(-127);
        enemys[2].setX(1); enemys[2].setY(-112);
        enemys1.clear();
        enemys1Img.clear();
        this.i=0;
    }
    public void enemyFire(double x, double y){};
    public void paintCollision(Graphics g){

    }
    public void enemyIsDeath(int i){
       if(enemys1.get(i).getHeath() <= 0){
           enemys1.get(i).setDeath(true);
           double x = enemys1.get(i).getX();
           double y = enemys1.get(i).getY();
           double w = enemys1.get(i).getW();
           double h = enemys1.get(i).getH();
           explosion.addListExplosion(new Explosion(x, y, w, h));
           enemys1.remove(i);
           enemys1Img.remove(i);
           this.i++;
       }
    }
    public boolean haveCollsionBullets1(){
        return false;
    }
    public boolean haveCollsionBullets2(){
        return false;
    }
    public void playSound(){
        sound.playSoundBulletImpact();
    }
    public Rectangle[] updateColission() {
        return colission;
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

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public boolean isDeath() {
        return isDeath;
    }

    public void setDeath(boolean death) {
        isDeath = death;
    }

    public double getHeath() {
        return heath;
    }

    public void setHeath(double heath) {
        this.heath = heath;
    }

    public double getHeathBar() {
        return heathBar;
    }

    public void setHeathBar(double heathBar) {
        this.heathBar = heathBar;
    }

    public Explosion getExplosion() {
        return explosion;
    }

    public void setExplosion(Explosion explosion) {
        this.explosion = explosion;
    }
}
