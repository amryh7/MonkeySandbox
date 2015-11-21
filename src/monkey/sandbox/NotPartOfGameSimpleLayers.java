
package monkey.sandbox;

/*
Java Swing, 2nd Edition
By Marc Loy, Robert Eckstein, Dave Wood, James Elliott, Brian Cole
ISBN: 0-596-00408-7
Publisher: O'Reilly 
*/
// SimpleLayers.java
//A demonstration of the JLayeredPane class.
//

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class NotPartOfGameSimpleLayers extends JFrame {
    
  public NotPartOfGameSimpleLayers() {
      
    super("LayeredPane Demonstration");
    setSize(200, 150);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JLayeredPane lp = getLayeredPane();

    // Create 3 buttons
    // Place the buttons in different layers
    JButton top = new JButton();
        top.setBackground(Color.white);
        top.setBounds(20, 20, 50, 50);
            lp.add(top, new Integer(3));
    JButton middle = new JButton();
        middle.setBackground(Color.gray);
        middle.setBounds(40, 40, 50, 50);
            lp.add(middle, new Integer(2));
    JButton bottom = new JButton();
        bottom.setBackground(Color.black);
        bottom.setBounds(60, 60, 50, 50);
            lp.add(bottom, new Integer(1));

  }

  public static void main(String[] args) {
    NotPartOfGameSimpleLayers sl = new NotPartOfGameSimpleLayers();
    sl.setVisible(true);
  }
}