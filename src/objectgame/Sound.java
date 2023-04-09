package objectgame;

import javax.sound.sampled.*;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Sound {
    private Scanner scanner;
    public Sound(){
        scanner = new Scanner(System.in);
    }
    public void playSound(String path){
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void playSoundFireOfPlayer(){
        playSound("C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\sound\\gun1.wav");
    }
    public void playSoundBulletImpact(){playSound("C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\sound\\bulletImpact.wav");}
    public void playSoundCoin(){playSound("C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\sound\\coin.wav");}
    public void playSoundgameOver(){playSound("C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\sound\\gameOver.wav");}
    public void playSoundgameClear(){playSound("C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\sound\\gameClear.wav");}
    public void playSoundExplosion(){playSound("C:\\Users\\Admin\\Desktop\\All-Case\\Module-2\\Fly-War\\RealGame\\sound\\explosion.wav");}
}
