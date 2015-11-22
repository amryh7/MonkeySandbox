

package monkey.sandbox;

// Create coin object

import java.awt.Point;
import java.util.Arrays;
import javax.swing.JLabel;

// Use assets/GCoin.gif

public class AssetsBananaLabels {
    
    static JLabel[] bananas = new JLabel[0];

    public JLabel banana;

    public AssetsBananaLabels(int levelSelect) {
        
        // !!!!!!!! IMPORTANT !!!!!!!!
        // you are passing the level as type in 
        AssetsLevelParams alp = new AssetsLevelParams();
        Point[] levelBananaCords = alp.Switch(levelSelect);
        init(levelBananaCords);
    }

    private void init(Point[] levelBananaCords) {
        int al;
        for (Point p : levelBananaCords){
            
            banana = new AssetsBananaLabelTemplate(p);
            
            al = AssetsBananaLabels.bananas.length;
            AssetsBananaLabels.bananas = Arrays.copyOf(getBananas(), getBananas().length + 1);
            AssetsBananaLabels.bananas[al] = banana;
        }
    }
    
    protected static JLabel[] getBananas() {
        return bananas;
    }
}