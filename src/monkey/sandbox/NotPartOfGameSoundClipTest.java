
package monkey.sandbox;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
   
// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class NotPartOfGameSoundClipTest extends JFrame {
   
   // Constructor
   public NotPartOfGameSoundClipTest(String file) {
       
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("Test Sound Clip");
      this.setSize(300, 200);
      this.setVisible(true);
   
      try {
         // Open an audio input stream.
         URL url = this.getClass().getClassLoader().getResource(file);
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
      }
   }
   
   public static void main(String[] args) {
       NotPartOfGameSoundClipTest soundClipTest = new NotPartOfGameSoundClipTest("assets/MainSong.wav");
   }
}