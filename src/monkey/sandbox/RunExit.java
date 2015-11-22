
package monkey.sandbox;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import static monkey.sandbox.RunTitle.gameLabels;
import static monkey.sandbox.RunTitle.layeredPane;
import static monkey.sandbox.RunTitle.sandbox;
import static monkey.sandbox.RunTitle.titlePanel;

public class RunExit {
    
    static JLabel exitPanel;
    
    public RunExit(){
        System.out.println("Running Exit");
        
        layeredPane.add(gameLabels.getExitLabelO(), new Integer(4));
        layeredPane.add(gameLabels.getExitLabelT(), new Integer(4));
        gameLabels.getExitLabelH().setText(gameLabels.getBananasCountLabel().getText() + " Bananas!!");
        layeredPane.add(gameLabels.getExitLabelH(), new Integer(4));
        gameLabels.getExitLabelF().setText("In " + gameLabels.getClockCountLabel().getText() + " Seconds!!");
        layeredPane.add(gameLabels.getExitLabelF(), new Integer(4));
        
        
        
        // revalidate/repaint so changes in spriteBlinkStep() will be sent to screen 
        sandbox.revalidate(); // revalidate for redraw
        sandbox.repaint(); // redraw screen
    }
}
