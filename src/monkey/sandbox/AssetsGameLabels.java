package monkey.sandbox;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import static monkey.sandbox.RunTitle.titlePanel;

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
    
    private JLabel escapeLabel = new JLabel("'ESC' - exit"); // create JLabel for 'Exit' text
    Font escapeLabelFontPlain = new Font("Courier", Font.PLAIN, 10); // create new BOLD font for state of JLabel
    
    final JLabel bananasLabel = new JLabel("Banana's Collected"); // create JLabel for 'Exit' text
    Font bananasFontBold = new Font("Courier", Font.BOLD, 30); // create new BOLD font for state of JLabel
    
    final JLabel bananasCountLabel = new JLabel("0"); // create JLabel for 'Exit' text
    Font bananasCountFontBold = new Font("Courier", Font.BOLD, 30); // create new BOLD font for state of JLabel
    
    private JLabel clockLabel = new JLabel("Time Passed "); // create JLabel for 'Exit' text
    Font clockLabelFontBold = new Font("Courier", Font.BOLD, 30); // create new BOLD font for state of JLabel
    
    private JLabel clockCountLabel = new JLabel("0"); // create JLabel for 'Exit' text
    Font clockCountLabelFontBold = new Font("Courier", Font.BOLD, 30); // create new BOLD font for state of JLabel
    
    private final JLabel exitLabelO = new JLabel("Congragulation!!"); // create JLabel for 'Exit' text
    private final JLabel exitLabelT = new JLabel("You Collected"); // create JLabel for 'Exit' text
    private final JLabel exitLabelH = new JLabel(); // create JLabel for 'Exit' text
    private final JLabel exitLabelF = new JLabel(); // create JLabel for 'Exit' text
    Font exitLabelFontBold = new Font("Courier", Font.BOLD, 78); // create new BOLD font for state of JLabel
    
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
        // setting up bananasLabel
        bananasLabel.setFont(bananasFontBold); // setting to font from above
        bananasLabel.setForeground(Color.CYAN); // setting !!! font color !!!; foreground is font
        bananasLabel.setBounds(350, 5  , 300, 25); // .setBounds( int x , int y , int width , int height )
        // setting up bananasCountLabel
        bananasCountLabel.setFont(bananasCountFontBold); // setting to font from above
        bananasCountLabel.setForeground(Color.CYAN); // setting !!! font color !!!; foreground is font
        bananasCountLabel.setBounds(650, 5  , 75, 25); // .setBounds( int x , int y , int width , int height )
        // setting up clockLabel
        clockLabel.setFont(clockLabelFontBold); // setting to font from above
        clockLabel.setForeground(Color.CYAN); // setting !!! font color !!!; foreground is font
        clockLabel.setBounds(370, 665  , 300, 25); // .setBounds( int x , int y , int width , int height )
        // setting up clockCountLabel
        clockCountLabel.setFont(clockCountLabelFontBold); // setting to font from above
        clockCountLabel.setForeground(Color.CYAN); // setting !!! font color !!!; foreground is font
        clockCountLabel.setBounds(565, 665  , 75, 25); // .setBounds( int x , int y , int width , int height )
        // setting up escapeLabel
        escapeLabel.setFont(escapeLabelFontPlain); // setting to font from above
        escapeLabel.setForeground(Color.red); // setting !!! font color !!!; foreground is font
        escapeLabel.setBounds(900, 665  , 75, 25); // .setBounds( int x , int y , int width , int height )
        // setting up exitLabelO
        exitLabelO.setFont(exitLabelFontBold); // setting to font from above
        exitLabelO.setForeground(Color.red); // setting !!! font color !!!; foreground is font
        exitLabelO.setBounds( 100 , 20 , titlePanel.getImageWidth(), titlePanel.getImageHeight() / 4); // .setBounds( int x , int y , int width , int height )
        // setting up exitLabelT
        exitLabelT.setFont(exitLabelFontBold); // setting to font from above
        exitLabelT.setForeground(Color.red); // setting !!! font color !!!; foreground is font
        exitLabelT.setBounds( 100 , 150 , titlePanel.getImageWidth(), titlePanel.getImageHeight() / 4); // .setBounds( int x , int y , int width , int height )
        // setting up exitLabelH
        exitLabelH.setFont(exitLabelFontBold); // setting to font from above
        exitLabelH.setForeground(Color.red); // setting !!! font color !!!; foreground is font
        exitLabelH.setBounds( 100 , 280 , titlePanel.getImageWidth(), titlePanel.getImageHeight() / 4); // .setBounds( int x , int y , int width , int height )
        // setting up exitLabelF
        exitLabelF.setFont(exitLabelFontBold); // setting to font from above
        exitLabelF.setForeground(Color.red); // setting !!! font color !!!; foreground is font
        exitLabelF.setBounds( 100 , 410 , titlePanel.getImageWidth(), titlePanel.getImageHeight() / 4); // .setBounds( int x , int y , int width , int height )
        
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
    
    public JLabel getBananasLabel() {
        return bananasLabel;
    }
    
    public JLabel getBananasCountLabel() {
        return bananasCountLabel;
    }

    public JLabel getExitLabelO() {
        return exitLabelO;
    }

    public JLabel getExitLabelT() {
        return exitLabelT;
    }

    public JLabel getExitLabelH() {
        return exitLabelH;
    }

    public JLabel getExitLabelF() {
        return exitLabelF;
    }

    public JLabel getClockLabel() {
        return clockLabel;
    }

    public JLabel getClockCountLabel() {
        return clockCountLabel;
    }

    public JLabel getEscapeLabel() {
        return escapeLabel;
    }
}
