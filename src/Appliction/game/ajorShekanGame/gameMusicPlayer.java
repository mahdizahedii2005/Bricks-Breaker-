package Appliction.game.ajorShekanGame;

import Appliction.LogInState.Setting.setting;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.io.FileInputStream;

public class gameMusicPlayer {
    private AdvancedPlayer player;
    private FileInputStream myMusic;
    private String musicPath;
    private Clip clip;
    private AudioInputStream audioInputStream;
    private FloatControl gainControl;

    public gameMusicPlayer(String musicPath) {
        this.musicPath = musicPath;
        try {
            // بارگذاری فایل صوتی
            audioInputStream = AudioSystem.getAudioInputStream(new File(musicPath));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            FixVolume();
//            while (!clip.isRunning()) {
//                Thread.sleep(10);
//            }
//            while (clip.isRunning()) {
//                Thread.sleep(10);
//            }

            // بستن Clip و AudioInputStream
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.start();
    }

    public void Stop() {
        clip.close();
    }

    // Method to set volume
    private  void FixVolume() {
        gainControl.setValue((float) ((6.0206*setting.volume)/100));
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }

}
