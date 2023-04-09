package objectgame;

import mainGame.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player {
    private double x = 200;
    private double y = 500;
    private double w = 589/6;
    private double h = 424/6;
    private double speedX = 5;
    private double speedY = 5;
    private double speedXFake = 5;
    private double speedYFake = 5;
    private boolean isMoveUp;
    private boolean isMoveDown;
    private boolean isMoveRight;
    private boolean isMoveLeft;
    private boolean playerMove = true;
    private BufferedImage playerImg;
    private Bullets bullets;
    public static Rectangle[] collisionPlayer;
    public static boolean isDeath;
    private double heath = 100;
    public static double damage = 1;
    private double heathBar = this.heath*4;
    private double widthHeath = this.heathBar;
    private BackGround backGround;
    private Sound sound;
    private Explosion explosion;

    public Player() throws IOException {
        bullets = new Bullets();
        collisionPlayer = new Rectangle[8];
        backGround = new BackGround();
        sound = new Sound();
        importImage();
        explosion = new Explosion();
    }
    public void paintPlayer(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(backGround.getX()+50, backGround.getY()+660, (int) heathBar, 20);
        g.setColor(Color.BLACK);
        g.drawRect(backGround.getX()+50, backGround.getY()+660, (int) widthHeath, 20);
        if(isDeath== false){
            g.drawImage(playerImg, (int) this.x, (int) this.y, (int) this.w, (int) this.h,null);
            zoneLimit();
            collsionPlayer();
            collisionBulletEnemy();
            playerDeath();
        }
    }
    private void importImage() throws IOException {
        String path = "C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\source\\player.png";
        playerImg = ImageIO.read(new File(path));
    }
    public void fire(){
        if(!Player.isDeath){
            bullets.getBullets(this.x, this.y);
        }
    }
    public void collsionPlayer(){
        collisionPlayer = new Rectangle[8];
        collisionPlayer[0] = new Rectangle((int) (x+329/6), (int) (y+134/6), 129/6, 38/6);
        collisionPlayer[1] = new Rectangle((int) (x+460/6), (int) (y+144/6), 70/6, 43/6);
        collisionPlayer[2] = new Rectangle((int) (x+537/6), (int) (y+151/6), 45/6, 44/6);
        collisionPlayer[3] = new Rectangle((int) (x+169/6), (int) (y+136/6), 91/6, 36/6);
        collisionPlayer[4] = new Rectangle((int) (x+86/6), (int) (y+138/6), 81/6, 30/6);
        collisionPlayer[5] = new Rectangle((int) (x+6/6), (int) (y+156/6), 78/6, 24/6);
        collisionPlayer[6] = new Rectangle((int) (x+243/6), (int) (y+45/6), 101/6, 62/6);
        collisionPlayer[7] = new Rectangle((int) (x+215/6), (int) (y+15/6), 162/6, 20/6);
    }
    public void resetGame(){
        x = 200;
        y = 500;
        heath = 100;
        heathBar = 400;
        isDeath = false;
    }
    public void zoneLimit(){
        double xScreen = backGround.getPosX1();
        double yScreen = backGround.getPosY1();
        double wScreen = backGround.getWidth();
        double hScreen = backGround.getHeight();
        if((this.x + this.w >= xScreen + wScreen && isMoveRight) || (this.x <= xScreen && isMoveLeft)){
            this.speedX = 0;
        }else{
            this.speedX = this.speedXFake;
        }
        if((this.y + this.h >= yScreen + hScreen - 400 && isMoveDown) || (this.y <= yScreen && isMoveUp)){
            this.speedY = 0;
        }else{
            this.speedY = this.speedYFake;
        }
    }
    public void playerDeath(){
        if(heath <= 0){
            sound.playSoundgameOver();
            explosion.addListExplosion(new Explosion(x, y, h, w));
            isDeath = true;
            GamePanel.gameEnd = true;
            GamePanel.gameRun = false;
            GamePanel.gameStart = false;
            PanelOver.showPanelOver = true;
        }
    }
    public void playerMove(){
        if(this.isMoveUp && this.playerMove) this.y-=speedY;
        if(this.isMoveDown && this.playerMove) this.y+=speedY;
        if(this.isMoveLeft && this.playerMove) this.x-=speedX;
        if(this.isMoveRight && this.playerMove) this.x+=speedX;
    }
    public void collisionBulletEnemy(){
        ArrayList[] collisionBoundEnemy1 = BulletEnemy1.collisionBounds;
        ArrayList[] collisionBoundEnemy2 = BulletEnemy2.collisionBounds;
        ArrayList[] collisionBoundEnemy3 = BulletEnemy3.collisionBounds;
        for(int i=0; i<collisionPlayer.length; i++){
            for(int j=0; j<collisionBoundEnemy1.length;j++){
                for(int g=0; g<collisionBoundEnemy1[j].size(); g++){
                    if(collisionPlayer[i].intersects((Rectangle) collisionBoundEnemy1[j].get(g))){
                        sound.playSoundBulletImpact();
                        heath-=BulletEnemy1.damage;
                        heathBar = this.heath*4;
                        BulletEnemy1.bulletsBounds[j].remove(g);
                        collisionBoundEnemy1[j].remove(g);
                    }
                }
            }
            for(int j=0; j<collisionBoundEnemy2.length;j++){
                for(int g=0; g<collisionBoundEnemy2[j].size(); g++){
                    if(collisionPlayer[i].intersects((Rectangle) collisionBoundEnemy2[j].get(g))){
                        sound.playSoundBulletImpact();
                        heath-=BulletEnemy2.damage;
                        heathBar = this.heath*4;
                        BulletEnemy2.bulletsBounds[j].remove(g);
                        collisionBoundEnemy2[j].remove(g);
                    }
                }
            }
            for(int j=0; j<collisionBoundEnemy3.length;j++){
                for(int g=0; g<collisionBoundEnemy3[j].size(); g++){
                    if(collisionPlayer[i].intersects((Rectangle) collisionBoundEnemy3[j].get(g))){
                        sound.playSoundBulletImpact();
                        heath-=BulletEnemy3.damage;
                        heath-=BulletEnemy3.damage;
                        heathBar = this.heath*4;
                        BulletEnemy3.bulletsBounds[j].remove(g);
                        collisionBoundEnemy3[j].remove(g);
                    }
                }
            }
        }
    }
    public void keyPressed(KeyEvent e){
        if(PauseGame.isPause == false){
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:{
                    setMoveLeft(true);
                    break;
                }
                case KeyEvent.VK_RIGHT:{
                    setMoveRight(true);
                    break;
                }
                case KeyEvent.VK_UP:{
                    setMoveUp(true);
                    break;
                }
                case KeyEvent.VK_DOWN:{
                    setMoveDown(true);
                    break;
                }
            }
        }
    }
    public void keyReleased(KeyEvent e){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT: {
                    setMoveLeft(false);
                    break;
                }
                case KeyEvent.VK_RIGHT: {
                    setMoveRight(false);
                    break;
                }
                case KeyEvent.VK_UP: {
                    setMoveUp(false);
                    break;
                }
                case KeyEvent.VK_DOWN: {
                    setMoveDown(false);
                    break;
                }
                case KeyEvent.VK_SPACE: {
                    if(PauseGame.isPause == false) {
                        sound.playSoundFireOfPlayer();
                        fire();
                    }
                }
            }
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

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public boolean isMoveUp() {
        return isMoveUp;
    }

    public boolean isMoveDown() {
        return isMoveDown;
    }

    public boolean isMoveRight() {
        return isMoveRight;
    }

    public boolean isMoveLeft() {
        return isMoveLeft;
    }

    public boolean isPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(boolean playerMove) {
        this.playerMove = playerMove;
    }

    public void setMoveUp(boolean moveUp) {
        isMoveUp = moveUp;
    }

    public void setMoveDown(boolean moveDown) {
        isMoveDown = moveDown;
    }

    public void setMoveRight(boolean moveRight) {
        isMoveRight = moveRight;
    }

    public void setMoveLeft(boolean moveLeft) {
        isMoveLeft = moveLeft;
    }

    public double getHeath() {
        return heath;
    }

}
