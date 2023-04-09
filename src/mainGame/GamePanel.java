package mainGame;

import CacheLoader.*;
import inputmanage.AdapterGame;
import inputmanage.InputManage;
import inputmanage.MouseAdapter;
import objectgame.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GamePanel extends JPanel implements ActionListener{
    public BackGround backGround;
    public Player player;
    private CacheLoader cacheLoader;
    private InputManage inputManage;
    private Bullets bullets;
    private Enemys enemyss;
    private Score score;
    private StartPanel startPanel;
    private PauseGame pauseGamePanel;
    private PanelOver panelOver;
    private PanelClear panelClear;
    private DataHistory dataHistory;
    public static boolean pauseGame = true;
    public static boolean gameStart = true;
    public static boolean gameRun;
    public static boolean gameEnd;
    private Explosion explosion;

    public GamePanel()  throws IOException {
        inputManage = new InputManage();
        player = new Player();
        startPanel = new StartPanel(true);
        pauseGamePanel = new PauseGame();
        panelOver = new PanelOver();
        panelClear = new PanelClear();
        AdapterGame adapterGame = new AdapterGame(player, pauseGamePanel);
        MouseAdapter adapterMouse = new MouseAdapter(startPanel, pauseGamePanel, panelOver, panelClear);
        addMouseListener(adapterMouse);
        addKeyListener(adapterGame);
        cacheLoader = new CacheLoader();
        backGround =new BackGround();
        bullets = new Bullets();
        enemyss = new Enemys();
        score = new Score(0);
        startPanel = new StartPanel(true);
        dataHistory = new DataHistory();
        explosion = new Explosion();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(pauseGame == false){
            backGround.paintBackGround(g);
            player.paintPlayer(g);
            enemyss.paintEnemy(g);
            bullets.paintBullets(g);
            score.paintScore(g);
            explosion.paintExplosion(g);
            if(PauseGame.isPause && PauseGame.showPausePanel){
                pauseGamePanel.paintPausePanel(g);
            }
            if(gameEnd){
                panelOver.paintPanelOver(g);
            }
            if(PanelClear.showPanelClear){
                panelClear.paintPanelOver(g);
            }
            if(PanelOver.gameOver || PanelClear.gameClear){
                player.resetGame();
                score.resetGame();
                enemyss.resetGame();
                bullets.resetGame();
                PanelOver.gameOver = false;
                PanelClear.gameClear = false;
            }
        }else{
            if(gameStart){
                startPanel.paintPanel(g);
                player.resetGame();
                score.resetGame();
                enemyss.resetGame();
                bullets.resetGame();
            }
        }
        dataHistory.updateDataHistory();
    }
    public void runGame(){
        if(pauseGame == false){
            backGround.backgroundMove();
            player.playerMove();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

