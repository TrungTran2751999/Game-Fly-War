package objectgame;

import javax.swing.*;
import java.awt.*;

public class Panel {
    private BackGround backGround;
    private double x;
    private double y;
    private double w;
    private double h;
    private boolean status;
    public Panel(boolean status){
        backGround = new BackGround(true);
        this.x = backGround.getX();
        this.y = backGround.getY();
        this.w = backGround.getWidth();
        this.status = status;
        this.h = 1000;
    }
    public Panel(){}
    public void paintPanel(Graphics g){
        g.fillRect((int) this.x, (int) this.y, (int) this.w, (int) this.h);
    }
    public boolean clickButton(int x, int y, Rectangle button){
        int buttonX = button.x;
        int buttonY = button.y;
        int buttonW = button.width+buttonX;
        int buttonH = button.height+buttonY;
        if(x > buttonX && x < buttonW && y > buttonY && y < buttonH){
            return true;
        }
        return false;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
       this.status = status;
    }

    public double getPanelX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getPanelY() {
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
