package monkey.sandbox;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class AssetsBananaLabelTemplate extends JLabel{
    
            private final static String bananaOFile = "src/assets/sprites/banana1s.png";
    final static Icon bananaO = new ImageIcon(bananaOFile);
    
        private final static String bananaTFile = "src/assets/sprites/banana2s.png";
    final static Icon bananaT = new ImageIcon(bananaTFile);
    
    private int bananaBoundsX;
    private int bananaBoundsY;
    public final int bananaBoundsW = 35;
    public final int bananaBoundsH = 35;
    
    public AssetsBananaLabelTemplate(Point p){
        super();
        
        setIcon(bananaO);
        
        bananaBoundsX = p.x;
        bananaBoundsY = p.y;
        
        setBounds(bananaBoundsX, bananaBoundsY, bananaBoundsW, bananaBoundsH);
    }
    
    public JLabel getBanana() {
        return this;
    }
        
    public void bananaBlinkStep() {

        if (this.getIcon() == bananaO || this.getIcon() == bananaT){
            if (this.getIcon() == bananaO){
                this.setIcon(bananaT);
                } else {
                this.setIcon(bananaO);
            }
        }
    }
}
