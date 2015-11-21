package monkey.sandbox;

import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AssetsSprite {
    
    public static JLabel sprite = new JLabel();
    
        private final static String spriteDownOFile = "src/assets/sprites/down1.png";
    final static Icon spriteDownO = new ImageIcon(spriteDownOFile);
        private final static String spriteDownTFile = "src/assets/sprites/down2.png";
    final static Icon spriteDownT = new ImageIcon(spriteDownTFile);
        private final static String spriteUpOFile = "src/assets/sprites/up1.png";
    final static Icon spriteUpO = new ImageIcon(spriteUpOFile);
        private final static String spriteUpTFile = "src/assets/sprites/up2.png";
    final static Icon spriteUpT = new ImageIcon(spriteUpTFile);
        private final static String spriteLeftOFile = "src/assets/sprites/left1.png";
    final static Icon spriteLeftO = new ImageIcon(spriteLeftOFile);
        private final static String spriteLeftTFile = "src/assets/sprites/left2.png";
    final static Icon spriteLeftT = new ImageIcon(spriteLeftTFile);
        private final static String spriteRightOFile = "src/assets/sprites/right1.png";
    final static Icon spriteRightO = new ImageIcon(spriteRightOFile);
        private final static String spriteRightTFile = "src/assets/sprites/right2.png";
    final static Icon spriteRightT = new ImageIcon(spriteRightTFile);
    
    private BufferedImage image;
    private ImageIcon icon;
        
    private int spriteBoundsX = 800;
    private int spriteBoundsY = 550;
    public final int spriteBoundsW = 35;
    public final int spriteBoundsH = 35;

    public AssetsSprite() {
        init();
    }

    private void init() {
        
        sprite.setIcon(spriteDownO);
        sprite.setBounds(spriteBoundsX, spriteBoundsY, spriteBoundsW, spriteBoundsH);
    }
    
    public void setBounds(int changeY, int changeX){
        spriteBoundsX += changeX;
        spriteBoundsY += changeY;
        sprite.setBounds(spriteBoundsX, spriteBoundsY, spriteBoundsW, spriteBoundsH);
    }
    
    public JLabel getSprite() {
        return sprite;
    }
    
    public static void spriteBlinkStep() {

        if (sprite.getIcon() == spriteDownO || sprite.getIcon() == spriteDownT){
            if (sprite.getIcon() == spriteDownO){
                sprite.setIcon(spriteDownT);
                } else {
                sprite.setIcon(spriteDownO);
            }
        }
        else if (sprite.getIcon() == spriteUpO || sprite.getIcon() == spriteUpT){
            if (sprite.getIcon() == spriteUpO){
                sprite.setIcon(spriteUpT);
                } else {
                sprite.setIcon(spriteUpO);
            }
        }
        else if (sprite.getIcon() == spriteLeftO || sprite.getIcon() == spriteLeftT){
            if (sprite.getIcon() == spriteLeftO){
                sprite.setIcon(spriteLeftT);
                } else {
                sprite.setIcon(spriteLeftO);
            }
        }
        else if (sprite.getIcon() == spriteRightO || sprite.getIcon() == spriteRightT){
            if (sprite.getIcon() == spriteRightO){
                sprite.setIcon(spriteRightT);
                } else {
                sprite.setIcon(spriteRightO);
            }
        }
    }

    public int getSpriteBoundsX() {
        return spriteBoundsX;
    }

    public void setSpriteBoundsX(int spriteBoundsX) {
        this.spriteBoundsX = spriteBoundsX;
    }

    public int getSpriteBoundsY() {
        return spriteBoundsY;
    }

    public void setSpriteBoundsY(int spriteBoundsY) {
        this.spriteBoundsY = spriteBoundsY;
    }

    void setIcon(Icon icon) {
        sprite.setIcon(icon);
    }
}
