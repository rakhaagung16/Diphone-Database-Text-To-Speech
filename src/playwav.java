
import java.nio.file.Paths;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rakha Agung trimanda
 */
public class playwav{
    public static void main(String [] args) throws InterruptedException{
        JFXPanel fxPanel = new JFXPanel();
        Media m1 = new Media(Paths.get("src/jar/w001.wav").toUri().toString());
        Media m2 = new Media(Paths.get("src/jar/w063.wav").toUri().toString());
        Media m3 = new Media(Paths.get("src/jar/w333.wav").toUri().toString());
        Media m4 = new Media(Paths.get("src/jar/w047.wav").toUri().toString());

        MediaPlayer mp1 = new MediaPlayer(m1);
        MediaPlayer mp2 = new MediaPlayer(m2);
        MediaPlayer mp3 = new MediaPlayer(m3);
        MediaPlayer mp4 = new MediaPlayer(m4);
        
        //_ A
        mp1.setStartTime(Duration.seconds(0.1));
        mp1.setStopTime(Duration.seconds(0.6));
//        mp1.play();
        
        //AK
        mp2.setStartTime(Duration.seconds(0.0));
        mp2.setStopTime(Duration.seconds(0.07));
        mp2.play();
        Thread.sleep(100);
        //KU
        mp3.setStartTime(Duration.seconds(0.0));
        mp3.setStopTime(Duration.seconds(0.09));
        mp3.play();
        
        //U_
        mp4.setStartTime(Duration.seconds(0.2));
        mp4.setStopTime(Duration.seconds(0.21));
//        mp4.play();
        
    }
}