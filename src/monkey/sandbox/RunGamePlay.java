package monkey.sandbox;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.Timer;
import static monkey.sandbox.AssetsSprite.spriteDownO;
import static monkey.sandbox.AssetsSprite.spriteLeftO;
import static monkey.sandbox.AssetsSprite.spriteRightO;
import static monkey.sandbox.AssetsSprite.spriteUpO;
import static monkey.sandbox.RunTitle.gameLabels;
import static monkey.sandbox.RunTitle.layeredPane;
import static monkey.sandbox.RunTitle.sandbox;
import static monkey.sandbox.RunTitle.titlePanel;
import static monkey.sandbox.RunTitle.yes;

public class RunGamePlay {
    
    AssetsTransitionPanel backgroundPlayPanel = new AssetsTransitionPanel( "src/assets/sandBox.png" ) ; // create JPanel with background image
    int x, y;
    Point spriteCords;
    String s;
    long timeStart;
    long timeChange;
    double elapsedSeconds;
    
    // method to handle everything that needs to happen during RunGamePlay
    public void playGame() throws InterruptedException {
        
        backgroundPlayPanel.setBounds( 0 , 0 , titlePanel.getImageWidth() , titlePanel.getImageHeight() ) ; // .setBounds( int x , int y , int width , int height )
                layeredPane.add( backgroundPlayPanel , new Integer(1) ) ; // add backgroundPlayPanel
        
        final AssetsSprite sprites = new AssetsSprite(); // create AssetsSprite class
        final JLabel sprite = sprites.getSprite(); // creating JLabel from AssetsSprite getSprite() method
        layeredPane.add(sprite, new Integer(2) ) ; // add backgroundPlayPanel
        
        final AssetsBananaLabels ABL = new AssetsBananaLabels(3);
        final JLabel[] bananasLabels = ABL.getBananas();
        for (JLabel j : bananasLabels){
            layeredPane.add(j, new Integer(3) ) ; // add backgroundPlayPanel
        }
        
        layeredPane.add(gameLabels.getBananasLabel(), new Integer(4) );
        layeredPane.add(gameLabels.getBananasCountLabel(), new Integer(4) );
        layeredPane.add(gameLabels.getClockLabel(), new Integer(4) );
        layeredPane.add(gameLabels.getClockCountLabel(), new Integer(4) );
        layeredPane.add(gameLabels.getEscapeLabel(), new Integer(4) );
        
        
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
//                        System.out.println("Left"); // test to print KeyEvent.KeyPressed in console log
                        sprites.setIcon(spriteLeftO); // set image to 'left' to create movement; added for UX
//                        System.out.println("left: x: " + sprite.getLocation().x); System.out.println("left: y: " + sprite.getLocation().y); // test to print sprite's current X, Y in console log; used to set sprite's restricted bounds
                        x = sprite.getLocation().x; y = sprite.getLocation().y; // setting x, y to current sprite's x, y cord
                        
                        // checking if moveing sprite will cause sprite to leafe sandbox background
                        // if it does not then move sprite else dont move sprite
                        if ( (x - 35) >= 65 ){
                            sprites.setBounds( 0, -35); // reset bounds to move sprite(JLabel) left on screen
                            for (Component c : layeredPane.getComponentsInLayer(3)){
                                if (c.getLocation().x == sprite.getLocation().x && c.getLocation().y == sprite.getLocation().y){
//                                    System.out.println("match");
                                    layeredPane.remove(c);
                                    s = String.valueOf(Integer.parseInt(gameLabels.getBananasCountLabel().getText()) + 1);
                                    gameLabels.getBananasCountLabel().setText(s);
                                    if (layeredPane.getComponentCountInLayer(3) == 0){
                                        RunTitle.setYes(false);
                                    }
                                }
                            }
//                                    System.out.println(sprite.getLocation());
                        }
                        
//                        System.out.println(sprite.getBounds()); // test to print sprite's current bounds in console log; used to get sprite's restricted bounds
                    }
                    if (key == KeyEvent.VK_RIGHT) {
//                        System.out.println("Right"); // test to print KeyEvent.KeyPressed in console log
                        sprites.setIcon(spriteRightO); // set image to 'right' to create movement; added for UX
//                        System.out.println("right: x: " + sprite.getLocation().x); System.out.println("right: y: " + sprite.getLocation().y); // test to print sprite's current X, Y in console log; used to set sprite's restricted bounds
                        x = sprite.getLocation().x; y = sprite.getLocation().y; // setting x, y to current sprite's x, y cord
                        
                        // checking if moveing sprite will cause sprite to leafe sandbox background
                        // if it does not then move sprite else dont move sprite
                        if ( (x + 35) <= 905 ){
                        sprites.setBounds( 0, 35); // reset bounds to move sprite(JLabel) right on screen
                            for (Component c : layeredPane.getComponentsInLayer(3)){
                                if (c.getLocation().x == sprite.getLocation().x && c.getLocation().y == sprite.getLocation().y){
//                                    System.out.println("match");
                                    layeredPane.remove(c);
                                    s = String.valueOf(Integer.parseInt(gameLabels.getBananasCountLabel().getText()) + 1);
                                    gameLabels.getBananasCountLabel().setText(s);
                                    if (layeredPane.getComponentCountInLayer(3) == 0){
                                        RunTitle.setYes(false);
                                    }
                                }
                            }
//                                    System.out.println(sprite.getLocation());
                        }
//                        System.out.println(sprite.getBounds()); // test to print sprite's current bounds in console log; used to get sprite's restricted bounds
                    }
                    if (key == KeyEvent.VK_UP) {
//                        System.out.println("Up"); // test to print KeyEvent.KeyPressed in console log
                        sprites.setIcon(spriteUpO); // set image to 'up' to create movement; added for UX
//                        System.out.println("up: x: " + sprite.getLocation().x); System.out.println("up: y: " + sprite.getLocation().y); // test to print sprite's current X, Y in console log; used to set sprite's restricted bounds
                        x = sprite.getLocation().x; y = sprite.getLocation().y; // setting x, y to current sprite's x, y cord
                        
                        // checking if moveing sprite will cause sprite to leafe sandbox background
                        // if it does not then move sprite else dont move sprite
                        if ( (y - 35) >= 60 ){
                        sprites.setBounds( -35, 0); // reset bounds to move sprite(JLabel) up on screen
                            for (Component c : layeredPane.getComponentsInLayer(3)){
                                if (c.getLocation().x == sprite.getLocation().x && c.getLocation().y == sprite.getLocation().y){
//                                    System.out.println("match");
                                    layeredPane.remove(c);
                                    s = String.valueOf(Integer.parseInt(gameLabels.getBananasCountLabel().getText()) + 1);
                                    gameLabels.getBananasCountLabel().setText(s);
                                    if (layeredPane.getComponentCountInLayer(3) == 0){
                                        RunTitle.setYes(false);
                                    }
                                }
                            }
//                                    System.out.println(sprite.getLocation());
                        }
//                        System.out.println(sprite.getBounds()); // test to print sprite's current bounds in console log; used to get sprite's restricted bounds
                    }
                    if (key == KeyEvent.VK_DOWN) {
//                        System.out.println("Down"); // test to print KeyEvent.KeyPressed in console log
                        sprites.setIcon(spriteDownO); // set image to 'down' to create movement; added for UX
//                        System.out.println("down: x: " + sprite.getLocation().x); System.out.println("down: y: " + sprite.getLocation().y); // test to print sprite's current X, Y in console log; used to set sprite's restricted bounds
                        x = sprite.getLocation().x; y = sprite.getLocation().y; // setting x, y to current sprite's x, y cord
                        
                        // checking if moveing sprite will cause sprite to leafe sandbox background
                        // if it does not then move sprite else dont move sprite
                        if ( (y + 35) <= 585 ){
                        sprites.setBounds( 35, 0); // reset bounds to move sprite(JLabel) down on screen
                            for (Component c : layeredPane.getComponentsInLayer(3)){
                                if (c.getLocation().x == sprite.getLocation().x && c.getLocation().y == sprite.getLocation().y){
//                                    System.out.println("match");
                                    layeredPane.remove(c);
                                    s = String.valueOf(Integer.parseInt(gameLabels.getBananasCountLabel().getText()) + 1);
                                    gameLabels.getBananasCountLabel().setText(s);
                                    if (layeredPane.getComponentCountInLayer(3) == 0){
                                        RunTitle.setYes(false);
                                    }
                                }
                            }
//                                    System.out.println(sprite.getLocation());
                        }
//                        System.out.println(sprite.getBounds()); // test to print sprite's current bounds in console log; used to get sprite's restricted bounds
                    }
                    if (key == KeyEvent.VK_ESCAPE){
                        System.exit(0);
                    }
                    // !!!!!!!! IMPORTANT !!!!!!!!
                    // !!!!!!!! IMPORTANT !!!!!!!!
                    // !!!!!!!! IMPORTANT !!!!!!!!
                    // !!!!!!!! IMPORTANT !!!!!!!!
                    // this "Q" key press function is set up to print out to the console log
                    // it will print "new Point(%x, %y)," where %x is sprite's current x cord and
                    // %y is sprite's current y cord
                    // what you end up with is a print out of all the places you have pressed the "Q" key.
                    // Why is this important... When you want to create a pateren of bananas for a 'level'
                    // you turn this function on and walk your sprite around pressing "Q" every place you want
                    // to place a banana. Then you can just copy the points from the console and past them
                    // into --> AssetsLevelParams.levelOneBananaPointCords points[] array.
                    // it will look like this:
                    //    protected final Point[] levelOneBananaPointCords = {
                    //        new Point(65, 60),
                    //        new Point(65, 130),
                    //        new Point(65, 200),
                    //        new Point(65, 270),
                    //        new Point(65, 340), <<<--- don't forget to delete the last comma
                    //        };
//                    if (key == KeyEvent.VK_Q){
//                        System.out.println("new Point(" + sprite.getLocation().x + ", " + sprite.getLocation().y + "),");
//                    }
                }
                @Override // not implemented
            public void keyReleased(KeyEvent e) {}});
        
        RunTitle.setYes(true); // set while test value 'yes' to true
        timeStart = System.currentTimeMillis();
        // start main game loop
        while(yes){
            Thread.sleep(300); // sleep for 3/10 of a second; added for UX
                                //System.out.println(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner()); // test to print KeyEvent.KeyPressed

            AssetsSprite.spriteBlinkStep(); // changes sprite image from left foot to righe foot to create movement; added for UX
            
            timeChange = System.currentTimeMillis() - timeStart;
            elapsedSeconds = timeChange / 1000;
            gameLabels.getClockCountLabel().setText(String.valueOf(elapsedSeconds));
            
            // revalidate/repaint so changes in spriteBlinkStep() will be sent to screen 
            sandbox.revalidate(); // revalidate for redraw
            sandbox.repaint(); // redraw screen
        }
        
        RunExit runExit = new RunExit();
    }
}
