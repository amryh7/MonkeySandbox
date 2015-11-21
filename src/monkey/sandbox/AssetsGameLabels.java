package monkey.sandbox;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

// Create game lables object
// (1) coins count label
// (2) coins collected count
// (3) "Enter Game" title screen label

public class AssetsGameLabels {
    
    Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR); // create arrow cursor
    Cursor pointerCursor = new Cursor(Cursor.HAND_CURSOR); // create pointer cursor
    
    final JLabel enterGameLabel = new JLabel("Enter Game"); // create JLabel for 'Enter Game' text
    Font enterGameFontPlain = new Font("Courier", Font.PLAIN, 48); // create new PLAIN font for non-hover state of JLabel
    Font enterGameFontBold = new Font("Courier", Font.BOLD, 48); // create new BOLD font for hover state of JLabel
    
    final JLabel exitGameLabel = new JLabel("Exit X"); // create JLabel for 'Exit' text
    Font exitGameFontPlain = new Font("Courier", Font.PLAIN, 20); // create new PLAIN font for non-hover state of JLabel
    Font exitGameFontBold = new Font("Courier", Font.BOLD, 20); // create new BOLD font for hover state of JLabel
    
    public AssetsGameLabels(){
        init(); // set up states of class.properties created above 
    }

    // set up states of class.properties created above 
    private void init() {
        // setting up enterGameLabel
        enterGameLabel.setFont(enterGameFontPlain); // setting to non-hover font from above
        enterGameLabel.setForeground(Color.blue); // setting !!! font color !!!; foreground is font
        enterGameLabel.setBounds(600, 500, 300, 100); // .setBounds( int x , int y , int width , int height )
            enterGameLabelAction(); // setting mouseClicked/mouseEntered/mouseExited actions for JLabel
        // setting up exitGameLabel
        exitGameLabel.setFont(exitGameFontPlain); // setting to non-hover font from above
        exitGameLabel.setForeground(Color.red); // setting !!! font color !!!; foreground is font
        exitGameLabel.setBounds(900, 0  , 300, 100); // .setBounds( int x , int y , int width , int height )
            exitGameLabelAction(); // setting mouseClicked/mouseEntered/mouseExited actions for JLabel
        
    }

    // setting actions for enterGameLabel JLabel
    private void enterGameLabelAction() {
        enterGameLabel.addMouseListener(new MouseListener(){
                @Override // setting function to enter game
            public void mouseClicked(MouseEvent e) {
                        System.out.println("enterGameLabel: Clicked"); // test to print 'Clicked" in console log
                        RunTitle.setYes(false); } // setting RunTitle while loop test 'yes' to false so loop will exit and continue class
                @Override // not implemented
            public void mousePressed(MouseEvent e) {}
                @Override // not implemented
            public void mouseReleased(MouseEvent e) {}
                @Override // setting mouse hover effect
            public void mouseEntered(MouseEvent e) {
                        enterGameLabel.setFont(enterGameFontBold); // set font to hovering BOLD font
                        enterGameLabel.setCursor(pointerCursor); } // setting courset pointer
                @Override // setting mouse un-hover effect
            public void mouseExited(MouseEvent e) {
                        enterGameLabel.setFont(enterGameFontPlain); // set font to non-hovering PLAIN font
                        enterGameLabel.setCursor(defaultCursor); } // setting courset arrow
        });
    }
    
    public JLabel getEnterGameLabel() {
        return enterGameLabel;
    }
    
    // setting actions for exitGameLabel JLabel
    private void exitGameLabelAction() {
        exitGameLabel.addMouseListener(new MouseListener(){
                @Override // setting function to enter game
            public void mouseClicked(MouseEvent e) {
                        System.out.println("exitGameLabel: Clicked"); // test to print 'Clicked" in console log
                        System.exit(0); } // exiting and shuting down application
                @Override // not implemented
            public void mousePressed(MouseEvent e) {}
                @Override // not implemented
            public void mouseReleased(MouseEvent e) {}
                @Override // setting mouse hover effect
            public void mouseEntered(MouseEvent e) {
                        exitGameLabel.setFont(exitGameFontBold); // set font to hovering BOLD font
                        exitGameLabel.setCursor(pointerCursor); } // setting courset pointer
                @Override // setting mouse un-hover effect
            public void mouseExited(MouseEvent e) {
                        exitGameLabel.setFont(exitGameFontPlain); // set font to non-hovering PLAIN font
                        exitGameLabel.setCursor(defaultCursor); } // setting courset arrow
        });
    }
    
    public JLabel getExitGameLabel() {
        return exitGameLabel;
    }

    
}
