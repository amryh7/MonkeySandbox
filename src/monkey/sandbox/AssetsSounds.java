package monkey.sandbox;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// Create game sound object
// (1) Intro sound
// (2) gameplay sound // re-record for better sound
// (3) banana grab sound
// (4) banana count addition sound
// (5) movement sound
// (6) finish game sound
// (7) exit sound
// (8) repaly sound

public class AssetsSounds {
    
    private static Clip mainClip;
    public static String gamePlaysoundfile = "assets/MainSong.wav";

    
    public AssetsSounds () {
        init ();
    }
    
    private void init () {
        
        try { // try to load sound for main game play
            URL url = this.getClass().getClassLoader().getResource(gamePlaysoundfile); // Open an audio input stream.
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            mainClip = AudioSystem.getClip(); // Get a sound clip resource.
            getMainClip().open(audioIn); // Open audio clip and load samples from the audio input stream.
            //mainClip.start(); // used to start clip play, calling in main
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {}
        }
    
    public static Clip getMainClip() {
        return mainClip;
    }
    
    // class main for testing sounds
    // How To Use: replace the String file location and run class main
    // 
    public static void main(String[] args) {
       String fileToBeTested = "assets/MainSong.wav";
       NotPartOfGameSoundClipTest soundClipTest = new NotPartOfGameSoundClipTest(fileToBeTested);
    }
}
