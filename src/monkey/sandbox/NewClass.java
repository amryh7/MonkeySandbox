

package monkey.sandbox;

// Create coin object

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Use assets/GCoin.gif
public class NewClass {
//public class AssetsBananaLabels {
    
    public static JLabel banana = new JLabel();
    
        private final static String bananaOFile = "src/assets/sprites/banana1s.png";
    final static Icon bananaDownO = new ImageIcon(bananaOFile);
        private final static String bananaTFile = "src/assets/sprites/banana2s.png";
    final static Icon bananaDownT = new ImageIcon(bananaTFile);
        
    private int bananaBoundsX = 800;
    private int bananaBoundsY = 550;
    public final int bananaBoundsW = 35;
    public final int bananaBoundsH = 35;
    
    public NewClass() {
    //public AssetsBananaLabels() {
        AssetsLevelParams alp = new AssetsLevelParams();
        init();
    }

    private void init() {
        
        banana.setIcon(bananaDownO);
        banana.setBounds(bananaBoundsX, bananaBoundsY, bananaBoundsW, bananaBoundsH);
    }
    
    public JLabel getBanana() {
        return banana;
    }
    
    public static void bananaBlinkStep() {

        if (banana.getIcon() == bananaDownO || banana.getIcon() == bananaDownT){
            if (banana.getIcon() == bananaDownO){
                banana.setIcon(bananaDownT);
                } else {
                banana.setIcon(bananaDownO);
            }
        }
    }

    public int getBananaBoundsX() {
        return bananaBoundsX;
    }

    public void setBananaBoundsX(int bananaBoundsX) {
        this.bananaBoundsX = bananaBoundsX;
    }

    public int getBananaBoundsY() {
        return bananaBoundsY;
    }

    public void setBananaBoundsY(int bananaBoundsY) {
        this.bananaBoundsY = bananaBoundsY;
    }

    void setIcon(Icon icon) {
        banana.setIcon(icon);
    }
}