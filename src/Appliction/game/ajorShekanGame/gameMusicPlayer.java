package Appliction.game.ajorShekanGame;

import Appliction.LogInState.Setting.setting;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class gameMusicPlayer {
    private AdvancedPlayer player;
    private FileInputStream myMusic;
    private String musicPath;
    private Clip clip;
    private AudioInputStream audioInputStream;
    private FloatControl gainControl;

    public gameMusicPlayer(String musicPath) {
        if (setting.volume != 0) {
            this.musicPath = musicPath;
            try {
                // بارگذاری فایل صوتی
                audioInputStream = AudioSystem.getAudioInputStream(new File(musicPath));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                FixVolume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void play() {
        if (setting.volume!=0){
        clip.start();}
    }

    public void Stop() {
        if (setting.volume!=0){
        clip.stop();}
    }

    public void close() {
        if(setting.volume!=0){
        try {
            audioInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }}
    }

    // Method to set volume
    private void FixVolume() {
        gainControl.setValue(0F);

        // gainControl.setValue((float) (((gainControl.getMaximum()-gainControl.getMinimum()) * setting.volume) / 100)-gainControl.getMaximum());
    }
}
