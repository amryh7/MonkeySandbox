
package monkey.sandbox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

// Simple swing game that presents:
// (1) Grafical rendering,
// (2) Object interaction, and
// (3) Object properties updating.

public class RunTitle {
    
    public static JFrame sandbox; // create main Window(JFrame)
    static JLayeredPane layeredPane; // create JLayeredPane
    static AssetsTransitionPanel titlePanel = new AssetsTransitionPanel( "src/assets/title.png" ); // create JPanel with title image
    public static AssetsGameLabels gameLabels = new AssetsGameLabels(); // create game labels
    static boolean yes = true; // create while test value
    
    
    
    
    // method to handle everything that needs to happen during RunTitle
    public static void main( String[] args ) throws InterruptedException {
        sandbox = new JFrame( "Monkey Sandbox" ); // creating main app window
            // set standard defaults for JFrame
            sandbox.setUndecorated(true); // removing Window default  system border
            sandbox.setLayout(null); // setting layout manager to null so componets can be placed anywhere on the screen
            sandbox.setSize( titlePanel.getImageWidth() , titlePanel.getImageHeight() ); // set JFrame size to title image width/height
                // calculating screen center
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                Point middle = new Point( screenSize.width / 2 , screenSize.height / 2 );
                Point newLocation = new Point( middle.x - ( sandbox.getWidth() / 2 ) , middle.y - ( sandbox.getHeight() / 2 ) );
            sandbox.setLocation(newLocation); // setting JFrame location to center of screen
            sandbox.setLocationRelativeTo(null); // setting window to display in center of screen
            sandbox.setResizable(false); // setting window to not allow resizing
            sandbox.setDefaultCloseOperation(EXIT_ON_CLOSE) ; // setting close button to exit application
            sandbox.setVisible(true); // setting window to be rendered
                        
//        AssetsSounds sounds = new AssetsSounds(); // create game sounds
//            Clip mainClip = sounds.getMainClip(); //getting sound for main game song
//            mainClip.start(); // staring main game song play
                        
                
        layeredPane = sandbox.getLayeredPane(); // getting JLayeredPane to draw JComponents on top of each other
        
            titlePanel.setBounds( 0 , 0 , titlePanel.getImageWidth() , titlePanel.getImageHeight() ); // .setBounds( int x , int y , int width , int height )
            layeredPane.add( titlePanel , new Integer (1) ); // add titlePanel
                
            
//        Thread.sleep(1000); // thread sleep before going forward; added for UX

        JLabel enterLabel = gameLabels.getEnterGameLabel();
        layeredPane.add( enterLabel, new Integer(2) ); // add 'Enter Game' JLabel
        JLabel exitLabel = gameLabels.getExitGameLabel();
        layeredPane.add( exitLabel, new Integer(3) ); // add 'Exit' JLabel
        
        // start title loop
        while(isYes()){
            
            Thread.sleep(1000); // thread sleep before going forward; added for UX
            
            // creating blinking text(JLabel) with changing color
            if(enterLabel.getForeground() == Color.blue){
                enterLabel.setForeground(Color.red);  // setting !!! font color !!!; foreground is font
            } else {
                enterLabel.setForeground(Color.blue); // setting !!! font color !!!; foreground is font
            }
        }
        
        layeredPane.remove(titlePanel); // removing (JPanel)titlePanle from (JLayeredPane)layeredPane
        layeredPane.remove(enterLabel); // removing (JLabel)enterLabel from (JLayeredPane)layeredPane
        layeredPane.remove(exitLabel); // removing (JLabel)exitLabel from (JLayeredPane)layeredPane
        
        RunGamePlay playGame = new RunGamePlay(); // create RunGame class
            playGame.playGame(); // running RunGame
        
    }

    public static boolean isYes() {
        return yes;
    }

    public static void setYes(boolean aYes) {
        yes = aYes;
    }
}
