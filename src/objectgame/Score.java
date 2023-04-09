package objectgame;

import java.awt.*;

public class Score {
    private Font fontScore;
    public static int scoreCount;
    public Score(int scoreCount){
        this.scoreCount = scoreCount;
        fontScore = new Font("Courier New", 1, 20);
    }
    public Score(){};
    public void paintScore(Graphics g){
        g.setFont(fontScore);
        g.setColor(Color.RED);
        g.drawString("Score: "+(this.scoreCount), 350, 600);
    }
    public void resetGame(){
        scoreCount=0;
    }
}
