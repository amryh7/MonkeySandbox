package monkey.sandbox;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import static monkey.sandbox.AssetsSprite.spriteDownO;
import static monkey.sandbox.AssetsSprite.spriteLeftO;
import static monkey.sandbox.AssetsSprite.spriteRightO;
import static monkey.sandbox.AssetsSprite.spriteUpO;
import static monkey.sandbox.RunTitle.layeredPane;
import static monkey.sandbox.RunTitle.sandbox;
import static monkey.sandbox.RunTitle.titlePanel;
import static monkey.sandbox.RunTitle.yes;

public class RunGamePlay {
    
    AssetsTransitionPanel backgroundPlayPanel = new AssetsTransitionPanel( "src/assets/sandBox.png" ) ; // create JPanel with background image
    
    // method to handle everything that needs to happen during RunGamePlay
    public void playGame() throws InterruptedException {
        
        backgroundPlayPanel.setBounds( 0 , 0 , titlePanel.getImageWidth() , titlePanel.getImageHeight() ) ; // .setBounds( int x , int y , int width , int height )
                layeredPane.add( backgroundPlayPanel , new Integer ( 1 ) ) ; // add backgroundPlayPanel
        
        final AssetsSprite sprites = new AssetsSprite(); // create AssetsSprite class
        final JLabel sprite = sprites.getSprite(); // creating JLabel from AssetsSprite getSprite() method
        
        layeredPane.add(sprite, new Integer ( 2 ) ) ; // add backgroundPlayPanel
        
        // revalidate/repaint so changes in sandbox layout will be sent to screen 
        sandbox.revalidate(); // revalidate for redraw
        sandbox.repaint(); // redraw screen

        // Setup KeyListener for up/right/down/left keyPressed
        sandbox.addKeyListener(new KeyListener(){
                @Override // not implemented
            public void keyTyped(KeyEvent e) {}
                @Override // setting LOGIC for keypressing
            public void keyPressed(KeyEvent e) {
                    int key = e.getKeyCode();

                    if (key == KeyEvent.VK_LEFT) {
                        System.out.println("Left"); // test to print KeyEvent.KeyPressed in console log
                        sprites.setIcon(spriteLeftO); // set image to 'left' to create movement; added for UX
                        sprites.setBounds( 0, -35); // reset bounds to move sprite(JLabel) left on screen
                        System.out.println(sprite.getBounds()); // test to print sprite's current bounds in console log; used to get sprite's restricted bounds
                    }

                    if (key == KeyEvent.VK_RIGHT) {
                        System.out.println("Right"); // test to print KeyEvent.KeyPressed in console log
                        sprites.setIcon(spriteRightO); // set image to 'right' to create movement; added for UX
                        sprites.setBounds( 0, 35); // reset bounds to move sprite(JLabel) right on screen
                        System.out.println(sprite.getBounds()); // test to print sprite's current bounds in console log; used to get sprite's restricted bounds
                    }

                    if (key == KeyEvent.VK_UP) {
                        System.out.println("Up"); // test to print KeyEvent.KeyPressed in console log
                        sprites.setIcon(spriteUpO); // set image to 'up' to create movement; added for UX
                        sprites.setBounds( -35, 0); // reset bounds to move sprite(JLabel) up on screen
                        System.out.println(sprite.getBounds()); // test to print sprite's current bounds in console log; used to get sprite's restricted bounds
                    }

                    if (key == KeyEvent.VK_DOWN) {
                        System.out.println("Down"); // test to print KeyEvent.KeyPressed in console log
                        sprites.setIcon(spriteDownO); // set image to 'down' to create movement; added for UX
                        sprites.setBounds( 35, 0); // reset bounds to move sprite(JLabel) down on screen
                        System.out.println(sprite.getBounds()); // test to print sprite's current bounds in console log; used to get sprite's restricted bounds
                    }
                }
                @Override // not implemented
            public void keyReleased(KeyEvent e) {}});
        
        RunTitle.setYes(true); // set while test value 'yes' to true
        
        // start main game loop
        while(yes){
            
            Thread.sleep(300); // sleep for 3/10 of a second; added for UX
                                //System.out.println(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner()); // test to print KeyEvent.KeyPressed

            AssetsSprite.spriteBlinkStep(); // changes sprite image from left foot to righe foot to create movement; added for UX

            // revalidate/repaint so changes in spriteBlinkStep() will be sent to screen 
            sandbox.revalidate(); // revalidate for redraw
            sandbox.repaint(); // redraw screen
        } 
    }
}
